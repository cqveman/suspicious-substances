package com.cqveman.suspicious_substances.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

// removes your jump key ability and puts you in the swimming animation.
public class BonelessEffect extends StatusEffect {

    // passing in the values to the super constructor (StatusEffect)
    public BonelessEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    // checks if the effect applies every in-game tick
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    // implementation @ mixin/EntityMixin.java
}
