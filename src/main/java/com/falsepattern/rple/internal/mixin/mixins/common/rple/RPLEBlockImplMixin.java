/*
 * Copyright (c) 2023 FalsePattern, Ven
 * All Rights Reserved
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.falsepattern.rple.internal.mixin.mixins.common.rple;

import com.falsepattern.rple.api.block.RPLEBlock;
import com.falsepattern.rple.api.block.RPLEBlockBrightnessColorProvider;
import com.falsepattern.rple.api.block.RPLEBlockTranslucencyColorProvider;
import com.falsepattern.rple.api.color.RPLEColor;
import lombok.val;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Unique
@Mixin(Block.class)
@SuppressWarnings("unused")
public abstract class RPLEBlockImplMixin implements RPLEBlock {
    @Nullable
    @Dynamic("Initialized in: [com.falsepattern.rple.internal.mixin.mixins.common.rple.RPLEBlockInitImplMixin]")
    private RPLEColor rple$baseBrightnessColor;
    @Nullable
    @Dynamic("Initialized in: [com.falsepattern.rple.internal.mixin.mixins.common.rple.RPLEBlockInitImplMixin]")
    private RPLEColor rple$baseTranslucencyColor;
    @Nullable
    @Dynamic("Initialized in: [com.falsepattern.rple.internal.mixin.mixins.common.rple.RPLEBlockInitImplMixin]")
    private RPLEColor @Nullable [] rple$metaBrightnessColors;
    @Nullable
    @Dynamic("Initialized in: [com.falsepattern.rple.internal.mixin.mixins.common.rple.RPLEBlockInitImplMixin]")
    private RPLEColor @Nullable [] rple$metaTranslucencyColors;

    @Shadow(remap = false)
    @Dynamic("Implemented by: [com.falsepattern.rple.internal.mixin.mixins.common.rple.RPLEBlockRootImplMixin]")
    public abstract RPLEColor rple$getInternalColoredBrightness();

    @Shadow(remap = false)
    @Dynamic("Implemented by: [com.falsepattern.rple.internal.mixin.mixins.common.rple.RPLEBlockRootImplMixin]")
    public abstract RPLEColor rple$getInternalColoredBrightness(IBlockAccess world, int posX, int posY, int posZ);

    @Shadow(remap = false)
    @Dynamic("Implemented by: [com.falsepattern.rple.internal.mixin.mixins.common.rple.RPLEBlockRootImplMixin]")
    public abstract RPLEColor rple$getInternalColoredTranslucency();

    @Shadow(remap = false)
    @Dynamic("Implemented by: [com.falsepattern.rple.internal.mixin.mixins.common.rple.RPLEBlockRootImplMixin]")
    public abstract RPLEColor rple$getInternalColoredTranslucency(IBlockAccess world, int posX, int posY, int posZ);

    @Override
    @SuppressWarnings({"InstanceofThis", "InstanceofIncompatibleInterface", "ConstantValue"})
    public @NotNull RPLEColor rple$getBrightnessColor() {
        if (this instanceof RPLEBlockBrightnessColorProvider) {
            val colorProvider = (RPLEBlockBrightnessColorProvider) this;
            try {
                val color = colorProvider.rple$getCustomBrightnessColor();
                if (color != null)
                    return color;
            } catch (Exception ignored) {
            }
        }
        return rple$getFallbackBrightnessColor();
    }

    @Override
    @SuppressWarnings({"InstanceofThis", "InstanceofIncompatibleInterface", "ConstantValue"})
    public @NotNull RPLEColor rple$getBrightnessColor(int blockMeta) {
        if (this instanceof RPLEBlockBrightnessColorProvider) {
            val block = (RPLEBlockBrightnessColorProvider) this;
            try {
                val colorProvider = block.rple$getCustomBrightnessColor(blockMeta);
                if (colorProvider != null)
                    return colorProvider;
            } catch (Exception ignored) {
            }
        }
        return rple$getFallbackBrightnessColor(blockMeta);
    }

    @Override
    @SuppressWarnings({"InstanceofThis", "InstanceofIncompatibleInterface", "ConstantValue"})
    public @NotNull RPLEColor rple$getBrightnessColor(@NotNull IBlockAccess world,
                                                      int blockMeta,
                                                      int posX,
                                                      int posY,
                                                      int posZ) {
        if (this instanceof RPLEBlockBrightnessColorProvider) {
            val block = (RPLEBlockBrightnessColorProvider) this;
            try {
                val customBrightness = block.rple$getCustomBrightnessColor(world, blockMeta, posX, posY, posZ);
                if (customBrightness != null)
                    return customBrightness;
            } catch (Exception ignored) {
            }
        }
        return rple$getFallbackBrightnessColor(world, blockMeta, posX, posY, posZ);
    }

    @Override
    @SuppressWarnings({"InstanceofThis", "InstanceofIncompatibleInterface", "ConstantValue"})
    public @NotNull RPLEColor rple$getTranslucencyColor() {
        if (this instanceof RPLEBlockTranslucencyColorProvider) {
            val block = (RPLEBlockTranslucencyColorProvider) this;
            try {
                val customTranslucency = block.rple$getCustomTranslucencyColor();
                if (customTranslucency != null)
                    return customTranslucency;
            } catch (Exception ignored) {
            }
        }
        return rple$getFallbackTranslucencyColor();
    }

    @Override
    @SuppressWarnings({"InstanceofThis", "InstanceofIncompatibleInterface", "ConstantValue"})
    public @NotNull RPLEColor rple$getTranslucencyColor(int blockMeta) {
        if (this instanceof RPLEBlockTranslucencyColorProvider) {
            val block = (RPLEBlockTranslucencyColorProvider) this;
            try {
                val customTranslucency = block.rple$getCustomTranslucencyColor(blockMeta);
                if (customTranslucency != null)
                    return customTranslucency;
            } catch (Exception ignored) {
            }
        }
        return rple$getFallbackTranslucencyColor(blockMeta);
    }

    @Override
    @SuppressWarnings({"InstanceofThis", "InstanceofIncompatibleInterface", "ConstantValue"})
    public @NotNull RPLEColor rple$getTranslucencyColor(@NotNull IBlockAccess world,
                                                        int blockMeta,
                                                        int posX,
                                                        int posY,
                                                        int posZ) {
        if (this instanceof RPLEBlockTranslucencyColorProvider) {
            val block = (RPLEBlockTranslucencyColorProvider) this;
            try {
                val customTranslucency = block.rple$getCustomTranslucencyColor(world, blockMeta, posX, posY, posZ);
                if (customTranslucency != null)
                    return customTranslucency;
            } catch (Exception ignored) {
            }
        }
        return rple$getFallbackTranslucencyColor(world, blockMeta, posX, posY, posZ);
    }

    @Override
    public @NotNull RPLEColor rple$getFallbackBrightnessColor() {
        val color = rple$getConfiguredBrightnessColor();
        if (color != null)
            return color;
        return rple$getInternalColoredBrightness();
    }

    @Override
    public @NotNull RPLEColor rple$getFallbackBrightnessColor(int blockMeta) {
        val color = rple$getConfiguredBrightnessColor(blockMeta);
        if (color != null)
            return color;
        return rple$getInternalColoredBrightness();
    }

    @Override
    public @NotNull RPLEColor rple$getFallbackBrightnessColor(@NotNull IBlockAccess world, int blockMeta, int posX, int posY, int posZ) {
        val color = rple$getConfiguredBrightnessColor(blockMeta);
        if (color != null)
            return color;
        return rple$getInternalColoredBrightness(world, posX, posY, posZ);
    }

    @Override
    public @NotNull RPLEColor rple$getFallbackTranslucencyColor() {
        val color = rple$getConfiguredTranslucencyColor();
        if (color != null)
            return color;
        return rple$getInternalColoredTranslucency();
    }


    @Override
    public @NotNull RPLEColor rple$getFallbackTranslucencyColor(int blockMeta) {
        val color = rple$getConfiguredTranslucencyColor(blockMeta);
        if (color != null)
            return color;
        return rple$getInternalColoredTranslucency();
    }

    @Override
    public @NotNull RPLEColor rple$getFallbackTranslucencyColor(@NotNull IBlockAccess world,
                                                                int blockMeta,
                                                                int posX,
                                                                int posY,
                                                                int posZ) {
        val color = rple$getConfiguredTranslucencyColor(blockMeta);
        if (color != null)
            return color;
        return rple$getInternalColoredTranslucency(world, posX, posY, posZ);
    }

    @Override
    public @Nullable RPLEColor rple$getConfiguredBrightnessColor() {
        if (rple$baseBrightnessColor != null)
            return rple$baseBrightnessColor;
        if (rple$metaBrightnessColors == null)
            return null;
        if (rple$metaBrightnessColors.length < 1)
            return null;
        return rple$metaBrightnessColors[0];
    }

    @Override
    public @Nullable RPLEColor rple$getConfiguredBrightnessColor(int blockMeta) {
        if (rple$metaBrightnessColors == null)
            return rple$baseBrightnessColor;
        if (rple$metaBrightnessColors.length <= blockMeta)
            return rple$baseBrightnessColor;
        return rple$metaBrightnessColors[blockMeta];
    }

    @Override
    public @Nullable RPLEColor rple$getConfiguredTranslucencyColor() {
        if (rple$baseTranslucencyColor != null)
            return rple$baseTranslucencyColor;
        if (rple$metaTranslucencyColors == null)
            return null;
        if (rple$metaTranslucencyColors.length < 1)
            return null;
        return rple$metaTranslucencyColors[0];
    }

    @Override
    public @Nullable RPLEColor rple$getConfiguredTranslucencyColor(int blockMeta) {
        if (rple$metaTranslucencyColors == null)
            return rple$baseTranslucencyColor;
        if (rple$metaTranslucencyColors.length <= blockMeta)
            return rple$baseTranslucencyColor;
        return rple$metaTranslucencyColors[blockMeta];
    }
}