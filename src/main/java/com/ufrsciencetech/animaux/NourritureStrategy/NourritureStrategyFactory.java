package com.ufrsciencetech.animaux.NourritureStrategy;

import com.ufrsciencetech.animaux.Races;

import java.util.Map;

public class NourritureStrategyFactory {
    private static final Map<Races, NourritureStrategy> strategies = Map.of(
            Races.CHIEN, new ChienNourritureStrategy(),
            Races.CHAT, new ChatNourritureStrategy(),
            Races.LAPIN, new LapinNourritureStrategy()
    );

    public static NourritureStrategy getStrategy(Races race) {
        return strategies.get(race);
    }
}
