package com.cqveman.suspicious_substances.potion;

import com.cqveman.suspicious_substances.SuspiciousSubstances;
import com.cqveman.suspicious_substances.effect.ModEffects;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final RegistryEntry<Potion> BONELESS_POTION = register(
            "boneless_potion",
            new Potion("boneless_potion", new StatusEffectInstance(ModEffects.BONELESS, 90*20, 0))
    );

    private static RegistryEntry<Potion> register(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(SuspiciousSubstances.MOD_ID, name), potion);
    }

    public static void initialize() {
        SuspiciousSubstances.LOGGER.info("Registering Mod Potions for " + SuspiciousSubstances.MOD_ID);

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.AWKWARD, Items.BONE, BONELESS_POTION);
        });
    }
}
