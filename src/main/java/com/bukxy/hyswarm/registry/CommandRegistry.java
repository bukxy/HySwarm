package com.bukxy.hyswarm.registry;

import com.bukxy.hyswarm.command.CameraCommand;
import com.bukxy.hyswarm.command.ExampleCommand;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;

public class CommandRegistry {

	public static void registerCommands(JavaPlugin javaPlugin) {
		var registry = javaPlugin.getCommandRegistry();

		registry.registerCommand(new ExampleCommand(javaPlugin.getName(), javaPlugin.getManifest().getVersion().toString()));
		registry.registerCommand(new CameraCommand(javaPlugin));
	}
}
