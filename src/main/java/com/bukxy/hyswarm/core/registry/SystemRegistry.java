package com.bukxy.hyswarm.core.registry;

import com.bukxy.hyswarm.common.system.TickSystem;
import com.bukxy.hyswarm.core.wave.RoundComponent;
import com.hypixel.hytale.component.ComponentType;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

public class SystemRegistry {

	private static ComponentType<EntityStore, RoundComponent> roundComponent;

	public static void registerCommands(JavaPlugin javaPlugin) {
		var registry = javaPlugin.getEntityStoreRegistry();
		roundComponent = registry.registerComponent(
				RoundComponent.class,
				"RoundData",
				RoundComponent.CODEC
		);
		RoundComponent.setComponentType(roundComponent);

		registry.registerSystem(new TickSystem(1.0F, roundComponent));

	}
}
