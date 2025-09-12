package com.cqveman.suspicious_substances.mixin;

import com.cqveman.suspicious_substances.effect.ModEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.AbstractSoundInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractSoundInstance.class)
public abstract class AbstractSoundInstanceMixin {

    @Inject(method = "getVolume", at = @At("RETURN"), cancellable = true)
    private void amplifySound(CallbackInfoReturnable<Float> cir) {
        // don't do anything if the player isn't loaded into a world OR the player doesn't have the effect
        MinecraftClient client = MinecraftClient.getInstance();
        if ( client.player == null || ( !client.player.hasStatusEffect(ModEffects.TIKTOK_COMPRESSION) ) ) return;

        cir.setReturnValue(cir.getReturnValue() * 50.0f);
    }

    @Inject(method = "getPitch", at = @At("RETURN"), cancellable = true)
    private void distortPitch(CallbackInfoReturnable<Float> cir) {
        MinecraftClient client = MinecraftClient.getInstance();
        if ( client.world == null || client.player == null || ( !client.player.hasStatusEffect(ModEffects.TIKTOK_COMPRESSION) ) ) return;

        // randomize the pitch
        float pitch = cir.getReturnValue() * (0.5f + client.world.random.nextFloat() * 5.0f);
        cir.setReturnValue(pitch);
    }
}
