/*
 * Copyright (c) 2023 FalsePattern, Ven
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/
 * or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

package com.falsepattern.rple.api;

import com.falsepattern.lumina.api.lighting.LightType;
import com.falsepattern.rple.api.color.ColorChannel;
import com.falsepattern.rple.internal.common.storage.world.RPLEWorldRoot;
import lombok.experimental.UtilityClass;
import lombok.val;
import net.minecraft.world.ChunkCache;
import net.minecraft.world.IBlockAccess;
import org.jetbrains.annotations.Nullable;

@UtilityClass
public final class RPLEWorldAPI {
    public static int getRGBBrightnessForTessellator(IBlockAccess world, int posX, int posY, int posZ) {
        val worldRoot = getWorldRootFromBlockAccess(world);
        if (worldRoot == null)
            return 0;

        return 0;
    }

    public static int getRGBBrightnessForTessellator(IBlockAccess world,
                                                     LightType lightType,
                                                     int posX,
                                                     int posY,
                                                     int posZ) {
        return 0;
    }

    public static int getMaxBrightnessForTessellator() {
        return 0;
    }

    public static int getBrightnessForTessellator(ColorChannel channel) {
        return 0;
    }

    public static int getMaxBrightness() {
        return 0;
    }

    public static int getBrightness(ColorChannel channel) {
        return 0;
    }

    // World Brightness
    // Block
    // Sky
    // Mixed

    // World Translucency

    @SuppressWarnings("InstanceofIncompatibleInterface")
    static @Nullable RPLEWorldRoot getWorldRootFromBlockAccess(IBlockAccess blockAccess) {
        if (blockAccess == null)
            return null;
        if (blockAccess instanceof RPLEWorldRoot)
            return (RPLEWorldRoot) blockAccess;
        if (blockAccess instanceof ChunkCache) {
            val chunkCache = (ChunkCache) blockAccess;
            val worldBase = chunkCache.worldObj;
            if (worldBase instanceof RPLEWorldRoot)
                return (RPLEWorldRoot) worldBase;
        }
        return null;
    }
}
