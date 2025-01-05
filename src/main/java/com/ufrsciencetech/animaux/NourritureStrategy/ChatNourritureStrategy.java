package com.ufrsciencetech.animaux.NourritureStrategy;

import com.ufrsciencetech.animaux.Especes;
import com.ufrsciencetech.stock.Nourriture;
import com.ufrsciencetech.stock.TypeNourriture;

public class ChatNourritureStrategy implements NourritureStrategy {

    final double SURPOID = 4.8;

    @Override
    public Nourriture determineNourriture(int age, double poids) {
        if(age < 0) {
            throw new IllegalArgumentException("age must be a positive number");
        }
        if(age <= 1){
            return new Nourriture(Especes.CHAT, TypeNourriture.JUNIOR,0);
        } else if (poids > SURPOID) {
            return new Nourriture(Especes.CHAT, TypeNourriture.S_SURPOIDS,0);
        }else if(age <= 6){
            return new Nourriture(Especes.CHAT,TypeNourriture.ADULTE,0);
        } else {
            return new Nourriture(Especes.CHAT,TypeNourriture.SENIOR,0);
        }
    }
}
