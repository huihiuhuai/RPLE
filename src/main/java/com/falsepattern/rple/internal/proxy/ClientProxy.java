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

package com.falsepattern.rple.internal.proxy;

import com.falsepattern.falsetweaks.api.dynlights.FTDynamicLights;
import com.falsepattern.rple.internal.HardcoreDarkness;
import com.falsepattern.rple.internal.client.dynlights.ColorDynamicLights;
import com.falsepattern.rple.internal.client.lamp.LampRenderer;
import com.falsepattern.rple.internal.client.render.VertexConstants;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import lombok.NoArgsConstructor;

import static com.falsepattern.rple.internal.client.lightmap.LightMapPipeline.lightMapPipeline;

@NoArgsConstructor
public final class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent evt) {
        super.preInit(evt);
        VertexConstants.initVertexConstants();
        FMLCommonHandler.instance().bus().register(HardcoreDarkness.INSTANCE);
    }

    @Override
    public void init(FMLInitializationEvent evt) {
        super.init(evt);
        RenderingRegistry.registerBlockHandler(new LampRenderer());
        lightMapPipeline().registerLightMapProviders();
        FTDynamicLights.registerBackend(ColorDynamicLights.INSTANCE, 500);
    }
}
