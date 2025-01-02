package com.ufrsciencetech.animaux.NourritureStrategy;

import com.ufrsciencetech.animaux.Races;
import com.ufrsciencetech.stock.Nourriture;
import com.ufrsciencetech.stock.TypeNourriture;

public class ChienNourritureStrategy implements NourritureStrategy {
    @Override
    public Nourriture determineNourriture(int age){
        if(age < 0) {
            throw new IllegalArgumentException("age must be a positive number");
        }
        if(age <= 2){
            return new Nourriture(Races.CHIEN,TypeNourriture.JUNIOR,0);
        } else if(age <= 10){
            return new Nourriture(Races.CHIEN,TypeNourriture.ADULTE,0);
        } else {
            return new Nourriture(Races.CHIEN,TypeNourriture.SENIOR,0);
        }
    }
}
