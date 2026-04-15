package com.bukxy.hyswarm;

import com.bukxy.hyswarm.common.system.TickSystem;
import com.bukxy.hyswarm.core.registry.CommandRegistry;
import com.bukxy.hyswarm.core.registry.SystemRegistry;
import com.bukxy.hyswarm.core.wave.RoundComponent;
import com.hypixel.hytale.component.ComponentType;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

public class HySwarm extends JavaPlugin {

    private static HySwarm instance;

    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    private ComponentType<EntityStore, RoundComponent> roundComponent;

    public HySwarm(JavaPluginInit init) {
        super(init);
        instance = this;

        LOGGER.atInfo().log("Hello from %s version %s", this.getName(), this.getManifest().getVersion().toString());
    }

    @Override
    protected void setup() {
        CommandRegistry.registerCommands(HySwarm.get());
        SystemRegistry.registerCommands(HySwarm.get());
    }

    public static HySwarm get() {
        return instance;
    }
}
