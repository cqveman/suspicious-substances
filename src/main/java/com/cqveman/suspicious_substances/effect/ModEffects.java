package com.cqveman.suspicious_substances.effect;

import com.cqveman.suspicious_substances.SuspiciousSubstances;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> BONELESS = register(
            "boneless", new BonelessEffect(StatusEffectCategory.HARMFUL, 16777200)
    );
    public static final RegistryEntry<StatusEffect> MRBEAST_GIVEAWAY = register(
            "mrbeast_giveaway", new MrBeastGiveawayEffect(StatusEffectCategory.HARMFUL, 2265050)
    );
    public static final RegistryEntry<StatusEffect> TIKTOK_COMPRESSION = register(
            "tiktok_compression", new TikTokCompressionEffect(StatusEffectCategory.NEUTRAL, 16711760)
    );

    private static RegistryEntry<StatusEffect> register(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(SuspiciousSubstances.MOD_ID, name), statusEffect);
    }

    public static void initialize() {
        SuspiciousSubstances.LOGGER.info("Registering Mod Effects for " + SuspiciousSubstances.MOD_ID);
    }
}
