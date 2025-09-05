package com.cqveman.suspicious_substances.mixin;

import com.cqveman.suspicious_substances.effect.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Inject(method = "updateSwimming", at = @At("HEAD"), cancellable = true)
    private void forceSwim(CallbackInfo ci) {
        Entity self = (Entity) (Object) this;

        // only act on living entities that have the effect
        if (!(self instanceof LivingEntity living)) return;
        if (!living.hasStatusEffect(ModEffects.BONELESS)) return;

        living.setSwimming(true);
        living.setPose(EntityPose.SWIMMING);

        // calculateDimensions() is declared on Entity, so call on `self`
        self.calculateDimensions();

        // prevent vanilla from doing its own swimming logic this tick
        ci.cancel();
    }
}
