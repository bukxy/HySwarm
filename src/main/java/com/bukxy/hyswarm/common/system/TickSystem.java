package com.bukxy.hyswarm.common.system;

import com.bukxy.hyswarm.core.wave.RoundComponent;
import com.bukxy.hyswarm.core.wave.RoundHud;
import com.hypixel.hytale.component.*;
import com.hypixel.hytale.component.query.Query;
import com.hypixel.hytale.component.system.tick.DelayedEntitySystem;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.Universe;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.jspecify.annotations.NonNull;

import javax.annotation.Nonnull;

public class TickSystem extends DelayedEntitySystem<EntityStore> {

	ComponentType<EntityStore, RoundComponent> componentType;

	public TickSystem(float intervalSec, ComponentType<EntityStore, RoundComponent> componentType) {
		super(intervalSec);
		System.out.println("TICK TickSystem load");
		this.componentType = componentType;
	}

	@Override
	public void tick(float v, int index, @NonNull ArchetypeChunk<EntityStore> archetypeChunk, @NonNull Store<EntityStore> store, @NonNull CommandBuffer<EntityStore> commandBuffer) {
		Ref<EntityStore> ref = archetypeChunk.getReferenceTo(index);
		Player player = store.getComponent(ref, Player.getComponentType());
		PlayerRef playerRef = store.getComponent(ref, PlayerRef.getComponentType());

		int timeInSecBetweenEachWave = 5;

		if (player != null && playerRef != null) {
			RoundComponent roundData = store.getComponent(ref, RoundComponent.getComponentType());
			if (roundData != null) {
				for (PlayerRef otherPlayer : Universe.get().getPlayers()) {
					player.getHudManager().setCustomHud(otherPlayer, new RoundHud(otherPlayer, roundData));
				}

				roundData.setRoundTimer(roundData.getRoundTimer() + 1);

			}
		}
	}

	@Nonnull
	@Override
	public Query<EntityStore> getQuery() {
		return Query.and(this.componentType);
	}
}
