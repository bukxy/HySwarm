package com.bukxy.hyswarm.common.command;

import com.bukxy.hyswarm.core.wave.RoundComponent;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.protocol.*;
import com.hypixel.hytale.protocol.packets.camera.SetServerCamera;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractTargetPlayerCommand;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class CameraCommand extends AbstractTargetPlayerCommand {
    private static final ServerCameraSettings serverCameraSettings = new ServerCameraSettings();

    public CameraCommand(JavaPlugin javaPlugin) {
        super("cam", "Set camera");

        serverCameraSettings.positionLerpSpeed = 0.2f;
        serverCameraSettings.rotationLerpSpeed = 0.2f;
        serverCameraSettings.isFirstPerson = false;
        serverCameraSettings.distance = 12f;
        serverCameraSettings.allowPitchControls = false;
        serverCameraSettings.mouseInputType = MouseInputType.LookAtTarget;
        serverCameraSettings.displayCursor = true;
        serverCameraSettings.positionDistanceOffsetType = PositionDistanceOffsetType.DistanceOffsetRaycast;

        serverCameraSettings.applyLookType = ApplyLookType.LocalPlayerLookOrientation;
        serverCameraSettings.rotationType = RotationType.Custom;
        Direction direction = new Direction(
                (float) Math.toRadians(45f),  // yaw
                (float) Math.toRadians(-50f), // pitch
                0f                            // roll
        );
        serverCameraSettings.rotation = direction;
        serverCameraSettings.movementForceRotation = direction;
    }

    @Override
    protected void execute(@NonNull CommandContext commandContext, @Nullable Ref<EntityStore> ref, @NonNull Ref<EntityStore> ref1, @NonNull PlayerRef playerRef, @NonNull World world, @NonNull Store<EntityStore> store) {
        playerRef.getPacketHandler().writeNoCache(new SetServerCamera(ClientCameraView.Custom, true, serverCameraSettings));
    }
}