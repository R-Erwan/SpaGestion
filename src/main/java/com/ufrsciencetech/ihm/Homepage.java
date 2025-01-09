package com.ufrsciencetech.ihm;

import com.ufrsciencetech.animaux.Animal;
import com.ufrsciencetech.main.SPA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Homepage extends JFrame {
    private JPanel mainPanel;
    private JButton addAnimalButton;
    private JButton stockButton;
    private JTextArea infoSpa;
    private JPanel gridButtonPanel;

    public Homepage(SPA spa) {
        setTitle(spa.getName());
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setLocation(200, 100);
        infoSpa.setText(spa.toString());
        gridButtonPanel.setLayout(new GridLayout(0, 4, 10, 10));
        addAnimalButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AddAnimalSheet addAnimalSheet = new AddAnimalSheet(spa.getAnimals());
                addAnimalSheet.setVisible(true);
                if (addAnimalSheet.isOk()) {
                    gridButtonPanel.removeAll();
                    for (Animal animal : spa.getAnimals()) {
                        JButton animalButton = createAnimalButton(animal,spa);
                        gridButtonPanel.add(animalButton);
                    }
                    gridButtonPanel.revalidate();
                    gridButtonPanel.repaint();
                }
            }
        });
        stockButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DisplayStock stock = new DisplayStock();
                stock.setLocationRelativeTo(Homepage.this);
                stock.setVisible(true);

            }
        });
        for (Animal animal : spa.getAnimals()) {
            JButton animalButton = createAnimalButton(animal, spa);
            gridButtonPanel.add(animalButton);
        }
    }
    private JButton createAnimalButton(Animal animal, SPA spa) {
        ImageIcon image_resized = animal.getImage();
        Image image = image_resized.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        image_resized = new ImageIcon(image);
        JButton button = new JButton(animal.getNom(), image_resized);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setPreferredSize(new Dimension(70, 70));
        button.setIconTextGap(10);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DisplayAnimal animalSheet = new DisplayAnimal(spa,animal);
                animalSheet.setVisible(true);
                if ((animalSheet.isOk())) {
                    gridButtonPanel.removeAll();
                    for (Animal animal : spa.getAnimals()) {
                        JButton animalButton = createAnimalButton(animal,spa);
                        gridButtonPanel.add(animalButton);
                    }
                    gridButtonPanel.revalidate();
                    gridButtonPanel.repaint();
                }
            }
        });
        return button;
    }
}
