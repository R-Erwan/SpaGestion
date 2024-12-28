package com.ufrsciencetech.ihm;

import com.ufrsciencetech.main.SPA;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Accueil extends JFrame {
    private JPanel MainPanel;
    private JPanel animalPanel;
    private JPanel infoPanel;
    private JScrollPane animalScrollPanel;
    private JButton addAnimalButton;
    private JButton Stock;
    private JTextArea infoSpa;

    private JPanel listButtonPane;

    public Accueil(SPA spa) {
        setTitle(spa.getName());
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(MainPanel);
        infoSpa.setText(spa.toString());
        addAnimalButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AjoutAnimal ajoutAnimal = new AjoutAnimal();
                ajoutAnimal.setVisible(true);
            }
        });

        Stock.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Stock stock = new Stock();
                stock.setLocationRelativeTo(Accueil.this);
                stock.setVisible(true);
            }
        });
    }


}
