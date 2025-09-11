package com.cqveman.suspicious_substances.mixin;

import com.cqveman.suspicious_substances.effect.ModEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {

    @Inject(method = "getFov", at = @At("RETURN"), cancellable = true)
    private void forceFOV(Camera camera, float tickProgress, boolean changingFov, CallbackInfoReturnable<Float> cir) {
        MinecraftClient client = MinecraftClient.getInstance();
        // don't do anything if the player isn't loaded into a world OR the player doesn't have the effect
        if ( client.player == null || ( !client.player.hasStatusEffect(ModEffects.TIKTOK_COMPRESSION) ) ) return;

        // override the return value of the FOV with 160 FOV
        cir.setReturnValue(160.0f);
    }
}
