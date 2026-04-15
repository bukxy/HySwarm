package com.bukxy.hyswarm.core.registry;

import com.bukxy.hyswarm.common.command.CameraCommand;
import com.bukxy.hyswarm.common.command.ExampleCommand;
import com.bukxy.hyswarm.common.command.TestCommand;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;

public class CommandRegistry {

	public static void registerCommands(JavaPlugin javaPlugin) {
		var registry = javaPlugin.getCommandRegistry();

		registry.registerCommand(new ExampleCommand(javaPlugin.getName(), javaPlugin.getManifest().getVersion().toString()));
		registry.registerCommand(new CameraCommand(javaPlugin));
//		registry.registerCommand(new TestCommand("test", "Round hud infos"));
	}
}
