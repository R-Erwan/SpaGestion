package com.ufrsciencetech.animaux.NourritureStrategy;

import com.ufrsciencetech.stock.Nourriture;

public interface NourritureStrategy {
    Nourriture determineNourriture(int age, double poids);
}
