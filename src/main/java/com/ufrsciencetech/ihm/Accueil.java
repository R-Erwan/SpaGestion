package com.ufrsciencetech.ihm;

import com.ufrsciencetech.animaux.Animal;
import com.ufrsciencetech.animaux.Animaux;
import com.ufrsciencetech.main.SPA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Accueil extends JFrame {
    private JPanel MainPanel;
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
        listButtonPane.setLayout(new GridLayout(0, 4, 10, 10));
        addAnimalButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AjoutAnimal ajoutAnimal = new AjoutAnimal(spa.getAnimals());
                ajoutAnimal.setVisible(true);
                if (ajoutAnimal.isOk()) {
                    listButtonPane.removeAll();
                    for (Animal animal : spa.getAnimals()) {
                        JButton animalButton = createAnimalButton(animal,spa);
                        listButtonPane.add(animalButton);
                    }
                    listButtonPane.revalidate();
                    listButtonPane.repaint();
                }
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
        for (Animal animal : spa.getAnimals()) {
            JButton animalButton = createAnimalButton(animal, spa);
            listButtonPane.add(animalButton);
        }

    }
    private JButton createAnimalButton(Animal animal, SPA spa) {
        ImageIcon ai = animal.getImage();
        Image image = ai.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ai = new ImageIcon(image);
        JButton button = new JButton(animal.getNom(), ai);
        button.setHorizontalTextPosition(SwingConstants.CENTER); // Centrer le texte horizontalement
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setPreferredSize(new Dimension(70, 70));
        button.setIconTextGap(10);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AffichageAnimal affichageAnimal = new AffichageAnimal(spa,animal);
                affichageAnimal.setVisible(true);
            }
        });
        return button;
    }
}
