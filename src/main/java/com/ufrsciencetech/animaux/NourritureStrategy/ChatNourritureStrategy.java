package com.ufrsciencetech.animaux.NourritureStrategy;

import com.ufrsciencetech.animaux.Races;
import com.ufrsciencetech.stock.Nourriture;
import com.ufrsciencetech.stock.TypeNourriture;

public class ChatNourritureStrategy implements NourritureStrategy {

    @Override
    public Nourriture determineNourriture(int age) {
        if(age < 0) {
            throw new IllegalArgumentException("age must be a positive number");
        }
        if(age <= 1){
            return new Nourriture(Races.CHAT, TypeNourriture.JUNIOR,0);
        } else if(age <= 6){
            return new Nourriture(Races.CHAT,TypeNourriture.ADULTE,0);
        } else {
            return new Nourriture(Races.CHAT,TypeNourriture.SENIOR,0);
        }
    }
}
