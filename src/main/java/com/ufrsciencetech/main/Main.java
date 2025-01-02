package com.ufrsciencetech.main;

import com.ufrsciencetech.animaux.Animal;
import com.ufrsciencetech.animaux.NourritureStrategy.ChienNourritureStrategy;
import com.ufrsciencetech.animaux.NourritureStrategy.NourritureStrategyFactory;
import com.ufrsciencetech.animaux.Races;
import com.ufrsciencetech.ihm.Accueil;
import com.ufrsciencetech.stock.Nourriture;
import com.ufrsciencetech.utils.Sexe;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException |
                 IllegalAccessException e) {
            e.printStackTrace();
        }
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Nourriture> nourritures = new ArrayList<>();


        SPA spa = new SPA("SPA de Dijon", "12 Rue des fleurs, 21000, Dijon", animals,nourritures,"02 12 34 56 78", "spa@dijon.com");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Accueil accueil = new Accueil(spa);
                accueil.setVisible(true);
            }
        });
    }
}