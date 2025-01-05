package com.ufrsciencetech.main;

import com.ufrsciencetech.animaux.Animaux;
import com.ufrsciencetech.ihm.Accueil;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException |
                 IllegalAccessException e) {
            e.printStackTrace();
        }
        Animaux animaux = new Animaux();

        SPA spa = new SPA("SPA de Dijon", "12 Rue des fleurs, 21000, Dijon", animaux,"02 12 34 56 78", "spa@dijon.com");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Accueil accueil = new Accueil(spa);
                accueil.setVisible(true);
            }
        });
    }
}