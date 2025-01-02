package com.ufrsciencetech.stock;

/**
 * @author erwan
 */
public class Nourriture extends ItemStock {
    private final Races races;
    private final TypeNourriture typeNourriture;

    public Nourriture(Races races, TypeNourriture typeNourriture, int threshold) {
        super(threshold, 0);
        this.races = races;
        this.typeNourriture = typeNourriture;
    }

    public Races getTypeAnimaux() {
        return races;
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
        return super.toString()+ "Nourriture{" +
                "typeAnimaux=" + races +
                ", typeNourriture=" + typeNourriture +
                '}';
    }
}
