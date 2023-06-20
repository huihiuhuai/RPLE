/*
 * Copyright (c) 2023 FalsePattern, Ven
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/
 * or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 *
 */

package com.falsepattern.rple.internal.mixin.mixins.common.ae2;

import appeng.block.networking.BlockCableBus;
import appeng.parts.ICableBusContainer;
import com.falsepattern.rple.api.ColoredBlock;
import com.falsepattern.rple.internal.mixin.interfaces.ae2.ICableBusContainerMixin;
import lombok.val;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;

@Mixin(value = BlockCableBus.class,
       remap = false)
public abstract class BlockCableBusMixin implements ColoredBlock {
    @Shadow protected abstract ICableBusContainer cb(IBlockAccess w, int x, int y, int z);

    public int getColoredLightValue(IBlockAccess world, int meta, int colorChannel, int x, int y, int z) {
        val thiz = (Block)(Object) this;
        Block block = world.getBlock(x, y, z);
        if (block != null && block != thiz) {
            return block.getLightValue(world, x, y, z);
        } else if (block == null) {
            return 0;
        } else {
            val cb = this.cb(world, x, y, z);
            if (cb instanceof ICableBusContainerMixin) {
                return ((ICableBusContainerMixin)cb).getColoredLightValue(colorChannel);
            }
            return cb.getLightValue();
        }
    }
}