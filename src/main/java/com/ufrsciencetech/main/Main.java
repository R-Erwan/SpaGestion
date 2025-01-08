package com.ufrsciencetech.main;

import com.formdev.flatlaf.FlatLightLaf;
import com.ufrsciencetech.animaux.Animaux;
import com.ufrsciencetech.ihm.Homepage;
import com.ufrsciencetech.jeuTests.Jeux;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SPA spa = Jeux.initSpa();
        try {
           UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Homepage homepage = new Homepage(spa);
                homepage.setVisible(true);
            }
        });
    }
}