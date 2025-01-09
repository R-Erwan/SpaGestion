package com.ufrsciencetech.stock;

import com.ufrsciencetech.animaux.Especes;

/**
 * @author erwan
 */
public class Nourriture extends ItemStock {
    private final Especes especes;
    private final TypeNourriture typeNourriture;

    public Nourriture(Especes especes, TypeNourriture typeNourriture, int threshold) {
        super(threshold, 0);
        this.especes = especes;
        this.typeNourriture = typeNourriture;
    }

    public Especes getTypeAnimaux() {
        return especes;
    }

    public TypeNourriture getTypeNourriture() {
        return typeNourriture;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Nourriture that = (Nourriture) o;
        return getTypeAnimaux() == that.getTypeAnimaux() && getTypeNourriture() == that.getTypeNourriture();
    }

    @Override
    public int hashCode() {
        int result = getTypeAnimaux().hashCode();
        result = 31 * result + getTypeNourriture().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Croquettes " +  especes + " - " + typeNourriture;
    }
}
