package com.ufrsciencetech.animaux.NourritureStrategy;

import com.ufrsciencetech.animaux.Especes;

import java.util.Map;

public class  NourritureStrategyFactory {
    private static final Map<Especes, NourritureStrategy> strategies = Map.of(
            Especes.CHIEN, new ChienNourritureStrategy(),
            Especes.CHAT, new ChatNourritureStrategy(),
            Especes.LAPIN, new LapinNourritureStrategy()
    );

    public static NourritureStrategy getStrategy(Especes especes) {
        return strategies.get(especes);
    }
}
