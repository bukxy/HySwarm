package com.bukxy.hyswarm.core.wave;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.Component;
import com.hypixel.hytale.component.ComponentType;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.jspecify.annotations.Nullable;

public class RoundComponent implements Component<EntityStore> {

	private static ComponentType<EntityStore, RoundComponent> type;
	public static ComponentType<EntityStore, RoundComponent> getComponentType(){
		return type;
	}
	public static void setComponentType(ComponentType<EntityStore, RoundComponent> type2){
		type = type2;
	}

	/*STATS*/
	private int totalKills = 0;

	private int roundTimer = 0; // Max 10 minutes par wave (More difficult after 10min)
	private int stageNumber = 0; // max 4 (3 + 1 boss map)
	/*STATS*/

	public int getTotalKills() {return totalKills;}
	public int getRoundTimer() {return roundTimer;}
	public int getStageNumber() {return stageNumber;}

	public void setTotalKills(int totalKills) {this.totalKills = totalKills;}
	public void setRoundTimer(int roundTimer) {this.roundTimer = roundTimer;}
	public void setStageNumber(int stageNumber) {this.stageNumber = stageNumber;}

	public static final BuilderCodec<RoundComponent> CODEC =
			BuilderCodec.builder(RoundComponent.class, RoundComponent::new)
					.append(new KeyedCodec<>("TotalKills", Codec.INTEGER), (w, f) -> w.totalKills = f, w -> w.totalKills).add()
					.build();

	public RoundComponent() {}

	public RoundComponent(int totalKills, int roundTimer, int stageNumber) {
		this.totalKills = totalKills;
		this.roundTimer = roundTimer;
		this.stageNumber = stageNumber;
	}

	@Override
	public @Nullable Component<EntityStore> clone() {
		RoundComponent copy = new RoundComponent(totalKills, roundTimer, stageNumber);
		copy.totalKills = this.totalKills;
		copy.roundTimer = this.roundTimer;
		copy.stageNumber = this.stageNumber;
		return copy;
	}

}
