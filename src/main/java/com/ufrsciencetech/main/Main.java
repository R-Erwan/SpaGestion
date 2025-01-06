package com.ufrsciencetech.main;

import com.formdev.flatlaf.FlatLightLaf;
import com.ufrsciencetech.animaux.Animaux;
import com.ufrsciencetech.ihm.Homepage;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Animaux animaux = new Animaux();
        SPA spa = new SPA("SPA de Dijon", "12 Rue des fleurs, 21000, Dijon", animaux,"02 12 34 56 78", "spa@dijon.com");
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