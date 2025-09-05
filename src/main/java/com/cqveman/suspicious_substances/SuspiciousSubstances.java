package com.cqveman.suspicious_substances;

import com.cqveman.suspicious_substances.effect.ModEffects;
import com.cqveman.suspicious_substances.potion.ModPotions;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SuspiciousSubstances implements ModInitializer {
    public static final String MOD_ID = "suspicious_substances";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModEffects.initialize();
        ModPotions.initialize();
    }
}
