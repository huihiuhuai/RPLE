/*
 * Copyright (c) 2023 FalsePattern, Ven
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/
 * or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

package com.falsepattern.rple.api.client;

import com.falsepattern.lumina.api.lighting.LightType;
import com.falsepattern.rple.api.common.color.ColorChannel;
import lombok.val;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public final class RPLEPackedBrightnessUtil {
    private RPLEPackedBrightnessUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static long packedBrightnessFromRGBLightValues(@NotNull LightType lightType,
                                                          int redLightValue,
                                                          int greenLightValue,
                                                          int blueLightValue) {
        return 0;
    }

    public static long packedBrightnessFromRGBLightValues(int redBlockLightValue,
                                                          int greenBlockLightValue,
                                                          int blueBlockLightValue,
                                                          int redSkyLightValue,
                                                          int greenSkyLightValue,
                                                          int blueSkyLightValue) {
        return 0;
    }

    public static long packedBrightnessFromLightValue(@NotNull LightType lightType, int lightValue) {
        return 0;
    }

    public static long packedBrightnessFromLightValues(int blockLightValue, int skyLightValue) {
        return 0;
    }

    public static int lightValueFromPackedBrightness(long packedBrightness,
                                                     @NotNull ColorChannel channel,
                                                     @NotNull LightType lightType) {
        return 0;
    }

    public static int minLightValueFromPackedBrightness(long packedBrightness) {
        return 0;
    }

    public static int minLightValueFromPackedBrightness(long packedBrightness, @NotNull ColorChannel channel) {
        return 0;
    }

    public static int minLightValueFromPackedBrightness(long packedBrightness, @NotNull LightType lightType) {
        return 0;
    }

    public static int maxLightValueFromPackedBrightness(long packedBrightness) {
        return 0;
    }

    public static int maxLightValueFromPackedBrightness(long packedBrightness, @NotNull ColorChannel channel) {
        return 0;
    }

    public static int maxLightValueFromPackedBrightness(long packedBrightness, @NotNull LightType lightType) {
        return 0;
    }

    public static int avgLightValueFromPackedBrightness(long packedBrightness) {
        return 0;
    }

    public static int avgLightValueFromPackedBrightness(long packedBrightness, @NotNull ColorChannel channel) {
        return 0;
    }

    public static int avgLightValueFromPackedBrightness(long packedBrightness, @NotNull LightType lightType) {
        return 0;
    }

    public static long packedBrightnessFromBrightnessChannel(@NotNull ColorChannel channel, long brightnessChannel) {
        return 0;
    }

    public static long packedBrightnessFromBrightnessChannels(long redLightChannel,
                                                              long greenLightChannel,
                                                              long blueLightChannel) {
        return 0;
    }

    public static long brightnessChannelFromPackedBrightness(long packedBrightness, @NotNull ColorChannel channel) {
        return 0;
    }

    public static long minBrightnessChannelFromPackedBrightness(long packedBrightness) {
        return 0;
    }

    public static long minBrightnessChannelFromPackedBrightness(long packedBrightness, @NotNull ColorChannel channel) {
        return 0;
    }

    public static long minBrightnessChannelFromPackedBrightness(long packedBrightness, @NotNull LightType lightType) {
        return 0;
    }

    public static long maxBrightnessChannelFromPackedBrightness(long packedBrightness) {
        return 0;
    }

    public static long maxBrightnessChannelFromPackedBrightness(long packedBrightness, @NotNull ColorChannel channel) {
        return 0;
    }

    public static long maxBrightnessChannelFromPackedBrightness(long packedBrightness, @NotNull LightType lightType) {
        return 0;
    }

    public static long avgBrightnessChannelFromPackedBrightness(long packedBrightness) {
        return 0;
    }

    public static long avgBrightnessChannelFromPackedBrightness(long packedBrightness, @NotNull ColorChannel channel) {
        return 0;
    }

    public static long avgBrightnessChannelFromPackedBrightness(long packedBrightness, @NotNull LightType lightType) {
        return 0;
    }

    public static long minPackedBrightness(long packedBrightnessA, long packedBrightnessB) {
        return 0;
    }

    public static long maxPackedBrightness(long packedBrightnessA, long packedBrightnessB) {
        return 0;
    }

    public static long avgPackedBrightness(long packedBrightnessA, long packedBrightnessB) {
        return 0;
    }

    public static long mixAOPackedBrightness(long packedBrightnessA,
                                             long packedBrightnessB,
                                             double multA,
                                             double multB) {
        return 0;
    }

    public static long mixAOPackedBrightness(long packedBrightnessAC,
                                             long packedBrightnessBC,
                                             long packedBrightnessBD,
                                             long packedBrightnessAD,
                                             double alphaAB,
                                             double alphaCD) {
        val multAC = (1D - alphaAB) * (1D - alphaCD);
        val multBC = (1D - alphaAB) * alphaCD;
        val multBD = alphaAB * (1D - alphaCD);
        val multAD = alphaAB * alphaCD;
        return mixAOPackedBrightness(packedBrightnessAC,
                                     packedBrightnessBC,
                                     packedBrightnessBD,
                                     packedBrightnessAD,
                                     multAC,
                                     multBC,
                                     multBD,
                                     multAD);
    }

    public static long mixAOPackedBrightness(long packedBrightnessA,
                                             long packedBrightnessB,
                                             long packedBrightnessC,
                                             long packedBrightnessD,
                                             double multA,
                                             double multB,
                                             double multC,
                                             double multD) {
        return 0;
    }
}