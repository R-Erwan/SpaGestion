package com.ufrsciencetech.animaux.NourritureStrategy;

import com.ufrsciencetech.animaux.Especes;
import com.ufrsciencetech.stock.Nourriture;
import com.ufrsciencetech.stock.TypeNourriture;

public class LapinNourritureStrategy implements NourritureStrategy {


    @Override
    public Nourriture determineNourriture(int age, double poids) {
        if(age < 0) {
            throw new IllegalArgumentException("age must be a positive number");
        }
        if(age <= 1){
            return new Nourriture(Especes.LAPIN, TypeNourriture.JUNIOR,0);
        } else if(age <= 5){
            return new Nourriture(Especes.LAPIN,TypeNourriture.ADULTE,0);
        } else {
            return new Nourriture(Especes.LAPIN,TypeNourriture.SENIOR,0);
        }
    }
}
