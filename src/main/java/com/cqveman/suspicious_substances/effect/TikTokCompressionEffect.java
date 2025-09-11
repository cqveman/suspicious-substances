package com.cqveman.suspicious_substances.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

// set the player FOV to the possible max & the sound gets distorted like a 144p edit.
public class TikTokCompressionEffect extends StatusEffect {

    // passing in the values to the super constructor (StatusEffect)
    public TikTokCompressionEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    // checks if the effect applies every in-game tick
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    // implementation @ mixin/EntityMixin.java
}
