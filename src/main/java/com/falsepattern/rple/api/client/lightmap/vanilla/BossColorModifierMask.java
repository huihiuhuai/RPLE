/*
 * Right Proper Lighting Engine
 *
 * Copyright (C) 2023-2024 FalsePattern, Ven
 * All Rights Reserved
 *
 * The above copyright notice and this permission notice
 * shall be included in all copies or substantial portions of the Software.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 *
 * This program comes with additional permissions according to Section 7 of the
 * GNU Affero General Public License. See the full LICENSE file for details.
 */

package com.falsepattern.rple.api.client.lightmap.vanilla;

import com.falsepattern.rple.api.client.lightmap.RPLELightMapMask;
import com.falsepattern.rple.api.client.lightmap.RPLELightMapStrip;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;

import lombok.val;
import lombok.var;
import org.jetbrains.annotations.NotNull;

import static com.falsepattern.rple.api.client.lightmap.RPLELightMapStrip.LIGHT_MAP_STRIP_LENGTH;

public class BossColorModifierMask implements RPLELightMapMask {
    @Override
    public void mutateBlockLightMap(@NotNull RPLELightMapStrip output, float partialTick) {
        mutateLightMap(output, partialTick);
    }

    @Override
    public void mutateSkyLightMap(@NotNull RPLELightMapStrip output, float partialTick) {
        mutateLightMap(output, partialTick);
    }

    protected void mutateLightMap(RPLELightMapStrip output, float partialTick) {
        val entityRenderer = Minecraft.getMinecraft().entityRenderer;
        if (entityRenderer == null || entityRenderer.bossColorModifier <= 0)
            return;

        val mod = entityRenderer.bossColorModifierPrev + (entityRenderer.bossColorModifier - entityRenderer.bossColorModifierPrev) * partialTick;
        val modInv = 1 - mod;
        val modDarkR = 0.7F * mod;
        val modDarkGB = 0.6F * mod;
        val R = output.lightMapRedData();
        val G = output.lightMapGreenData();
        val B = output.lightMapBlueData();
        for (int i = 0; i < LIGHT_MAP_STRIP_LENGTH; i++) {
            val r = R[i];
            val g = G[i];
            val b = B[i];
            R[i] = r * modInv + r * modDarkR;
            G[i] = g * modInv + g * modDarkGB;
            B[i] = b * modInv + b * modDarkGB;
        }
    }

    protected float bossColorModifierIntensity(EntityRenderer entityRenderer, float partialTick) {
        return entityRenderer.bossColorModifierPrev +
               (entityRenderer.bossColorModifier - entityRenderer.bossColorModifierPrev) * partialTick;
    }
}
