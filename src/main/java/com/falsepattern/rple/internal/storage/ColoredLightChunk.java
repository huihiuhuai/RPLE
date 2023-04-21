package com.falsepattern.rple.internal.storage;

import com.falsepattern.lumina.api.ILightingEngine;
import com.falsepattern.lumina.api.ILightingEngineProvider;
import com.falsepattern.lumina.api.ILumiChunk;
import com.falsepattern.lumina.api.ILumiChunkRoot;
import com.falsepattern.lumina.api.ILumiEBS;
import com.falsepattern.lumina.api.ILumiWorld;
import lombok.val;

import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;

public class ColoredLightChunk implements ILumiChunk {
    private final ColoredLightChannel channel;
    private final ColoredLightWorld world;
    private final Chunk carrier;

    private final int[] heightMap;
    private final boolean[] updateSkylightColumns;
    private int heightMapMinimum;
    private ILightingEngine lightingEngine;
    private short[] neighborLightChecks;
    private boolean isLightInitialized;

    public ColoredLightChunk(ColoredLightWorld world, Chunk carrier) {
        this.channel = world.channel;
        this.world = world;
        this.carrier = carrier;
        updateSkylightColumns = new boolean[256];
        heightMap = new int[256];
    }

    @Override
    public ILumiEBS lumiEBS(int arrayIndex) {
        val ebs = carrier.getBlockStorageArray()[arrayIndex];
        return ebs == null ? null : ((ColoredCarrierEBS)ebs).getColoredEBS(channel);
    }

    @Override
    public ILumiWorld lumiWorld() {
        return world;
    }

    @Override
    public int[] lumiHeightMap() {
        return heightMap;
    }

    @Override
    public short[] lumiGetNeighborLightChecks() {
        return neighborLightChecks;
    }

    @Override
    public void lumiGetNeighborLightChecks(short[] data) {
        neighborLightChecks = data;
    }

    @Override
    public boolean lumiIsLightInitialized() {
        return isLightInitialized;
    }

    @Override
    public void lumiIsLightInitialized(boolean val) {
        isLightInitialized = val;
    }

    @Override
    public boolean[] lumiUpdateSkylightColumns() {
        return updateSkylightColumns;
    }

    @Override
    public int lumiHeightMapMinimum() {
        return heightMapMinimum;
    }

    @Override
    public void lumiHeightMapMinimum(int min) {
        heightMapMinimum = min;
    }

    @Override
    public ILumiChunkRoot root() {
        return (ILumiChunkRoot) carrier;
    }

    @Override
    public int x() {
        return carrier.xPosition;
    }

    @Override
    public int z() {
        return carrier.zPosition;
    }


    @Override
    public ILightingEngine getLightingEngine() {
        if (this.lightingEngine == null) {
            this.lightingEngine = world.getLightingEngine();
            if (this.lightingEngine == null) {
                throw new IllegalStateException();
            }
        }
        return this.lightingEngine;
    }

    public int getSavedLightValue(EnumSkyBlock skyBlock, int x, int y, int z) {
        val ebs = lumiEBS(y >> 4);
        return ebs == null ? (carrier.canBlockSeeTheSky(x, y, z) ? skyBlock.defaultLightValue : 0) : (skyBlock == EnumSkyBlock.Sky ? (carrier.worldObj.provider.hasNoSky ? 0 : ebs.lumiSkylightArray().get(x, y & 15, z)) : (skyBlock == EnumSkyBlock.Block ? ebs.lumiBlocklightArray().get(x, y & 15, z) : skyBlock.defaultLightValue));
    }
}
