package com.ufrsciencetech.animaux;

import com.ufrsciencetech.soins.FichesSoins;
import com.ufrsciencetech.utils.Sexe;

import javax.swing.*;
import java.util.ArrayList;

public class Chien extends Animal{

    public Chien(int identifiant, String nom, String race, int age, double poids, Sexe sexe, ImageIcon image, ArrayList<FichesSoins> ficheSoins) {
        super(identifiant, nom, race, age, poids, sexe, image, ficheSoins);
    }

    @Override
    public String toString() {
        return "Chien";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Chien c)) {
            return false;
        }

        return c.identifiant != this.identifiant;
    }

    @Override
    public Races getRace() {
        return Races.CHIEN;
    }
}
