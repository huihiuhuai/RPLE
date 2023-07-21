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

package com.falsepattern.rple.internal;


import com.falsepattern.rple.internal.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.falsepattern.rple.internal.Tags.*;

@Mod(modid = MOD_ID,
     version = VERSION,
     name = MOD_NAME,
     acceptedMinecraftVersions = MINECRAFT_VERSION,
     dependencies = DEPENDENCIES)
@NoArgsConstructor
public final class RightProperLightingEngine {
    @SidedProxy(clientSide = CLIENT_PROXY_CLASS_NAME, serverSide = SERVER_PROXY_CLASS_NAME)
    public static CommonProxy PROXY;

    public static Logger createLogger(String name) {
        return LogManager.getLogger(MOD_NAME + "|" + name);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent evt) {
        PROXY.preInit(evt);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent evt) {
        PROXY.init(evt);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent evt) {
        PROXY.postInit(evt);
    }

    @Mod.EventHandler
    public void serverAboutToStart(FMLServerAboutToStartEvent evt) {
        PROXY.serverAboutToStart(evt);
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent evt) {
        PROXY.serverStarting(evt);
    }

    @Mod.EventHandler
    public void serverStarted(FMLServerStartedEvent evt) {
        PROXY.serverStarted(evt);
    }

    @Mod.EventHandler
    public void serverStopping(FMLServerStoppingEvent evt) {
        PROXY.serverStopping(evt);
    }

    @Mod.EventHandler
    public void serverStopped(FMLServerStoppedEvent evt) {
        PROXY.serverStopped(evt);
    }
}