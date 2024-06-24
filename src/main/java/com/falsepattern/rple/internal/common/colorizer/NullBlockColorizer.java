/*
 * Copyright (c) 2023 FalsePattern, Ven
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/
 * or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

package com.falsepattern.rple.internal.common.colorizer;

import com.falsepattern.rple.api.common.color.RPLEBlockColor;
import com.falsepattern.rple.api.common.colorizer.RPLEBlockColorizer;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class NullBlockColorizer implements RPLEBlockColorizer {
    private static final NullBlockColorizer INSTANCE = new NullBlockColorizer();

    public static RPLEBlockColorizer nullBlockColorizer() {
        return INSTANCE;
    }

    @Override
    public @NotNull RPLEBlockColorizer brightness(short color) {
        return this;
    }

    @Override
    public @NotNull RPLEBlockColorizer brightness(@NotNull RPLEBlockColor color) {
        return this;
    }

    @Override
    public @NotNull RPLEBlockColorizer translucency(short color) {
        return this;
    }

    @Override
    public @NotNull RPLEBlockColorizer translucency(@NotNull RPLEBlockColor color) {
        return this;
    }

    @Override
    public void apply() {
    }
}
