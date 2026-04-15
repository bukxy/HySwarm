package com.bukxy.hyswarm.core.wave;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.player.hud.CustomUIHud;
import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import org.jspecify.annotations.NonNull;

public class RoundHud extends CustomUIHud {

	RoundComponent roundComponent;

	public RoundHud(@NonNull PlayerRef playerRef, RoundComponent roundComponent) {
		super(playerRef);
		this.roundComponent = roundComponent;
	}

	@Override
	protected void build(@NonNull UICommandBuilder uiCommandBuilder) {

		uiCommandBuilder.append("Hud/RoundInfos.ui");

		uiCommandBuilder.set("#Timer.TextSpans", Message.raw("Timer : " + formatTimer(roundComponent.getRoundTimer())));
		uiCommandBuilder.set("#TotalKills.TextSpans", Message.raw("Total Kills : " + String.valueOf(roundComponent.getTotalKills())));
		uiCommandBuilder.set("#StageNumber.TextSpans", Message.raw("Stage : " + String.valueOf(roundComponent.getStageNumber())));

	}

	public static String formatTimer(int totalSeconds) {
		int minutes = totalSeconds / 60;
		int seconds = totalSeconds % 60;
		return String.format("%02dm %02ds", minutes, seconds);
	}
}
