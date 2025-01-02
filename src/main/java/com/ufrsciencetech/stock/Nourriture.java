package com.ufrsciencetech.stock;

public class Nourriture extends ItemStock {
    private final TypeAnimaux typeAnimaux;
    private final TypeNourriture typeNourriture;

    public Nourriture(TypeAnimaux typeAnimaux, TypeNourriture typeNourriture, int threshold) {
        super(threshold, 0);
        this.typeAnimaux = typeAnimaux;
        this.typeNourriture = typeNourriture;
    }

    public TypeAnimaux getTypeAnimaux() {
        return typeAnimaux;
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
                "typeAnimaux=" + typeAnimaux +
                ", typeNourriture=" + typeNourriture +
                '}';
    }
}
