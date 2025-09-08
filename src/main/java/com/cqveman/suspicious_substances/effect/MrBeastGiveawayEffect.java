package com.cqveman.suspicious_substances.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

// a bunch of tnt gets set and circulate around the player.
public class MrBeastGiveawayEffect extends InstantStatusEffect {

    // passing in the values to the super constructor (StatusEffect)
    public MrBeastGiveawayEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    // making the potion work once time and repeating every game tick
    @Override
    public boolean isInstant() { // from InstantStatusEffect.java
        return super.isInstant(); // return true;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {

        final double radius = 0.2;   // how far from center the TNT is pushed
        final double yOffset = 0.4;  // upward velocity
        final int count = 12;        // number of TNTs in the circle

        for (int i = 0; i < count; i++) {

            // 360° = 2π radians
            // we divide the whole circle by our count to get even parts
            // we multiply by i to get each TNT’s unique position
            double angle = (2 * Math.PI / count) * i;

            // in a circle: the x-axis is represented by Cos, and the y-axis is represented by Sin
            double xVel = Math.cos(angle) * radius;
            double zVel = Math.sin(angle) * radius;

            TntEntity tnt = new TntEntity(world, entity.getX(), entity.getY(), entity.getZ(), entity);
            tnt.setVelocity(xVel, yOffset, zVel);

            world.spawnEntity(tnt);
        }
        return super.applyUpdateEffect(world, entity, amplifier);
    }
}
