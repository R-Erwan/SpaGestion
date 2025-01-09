package com.ufrsciencetech.ihm;

import com.ufrsciencetech.animaux.Animal;
import com.ufrsciencetech.main.SPA;
import com.ufrsciencetech.soins.Soins;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DisplayAnimal extends JDialog {
    private JPanel contentPane;
    private JPanel titlePanel;
    private JLabel titleLabel;
    private JTabbedPane careSheetTab;
    private JTextField specieTF;
    private JTextField sexTF;
    private JTextField ageTF;
    private JTextField weightTF;
    private JButton addButton;
    private JButton modifyButton;
    private JButton deleteButton;
    private JLabel imageLabel;
    private JLabel ageLabel;
    private JLabel sexLabel;
    private JLabel specieLabel;
    private JPanel presentationTab;
    private JLabel weightLabel;
    private JPanel careSheetPanel;
    private JButton validButton;
    private JPanel imagePane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private boolean ok = false;

    public DisplayAnimal(SPA spa, Animal animal) {
        setContentPane(contentPane);
        setModal(true);
        setSize(700, 500);
        setLocation(200,100);
        titleLabel.setText(animal.getNom());
        specieTF.setText(animal.getEspece().toString());
        sexTF.setText(animal.getSexe().toString());
        weightTF.setText(String.valueOf(animal.getPoids()));
        ageTF.setText(String.valueOf(animal.getAge()));
        ImageIcon image_resized = animal.getImage();
        Image image = image_resized.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        image_resized = new ImageIcon(image);
        imageLabel.setIcon(image_resized);
        careSheetPanel.setLayout(new GridLayout(0, 4, 10, 10));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AddCareSheet careSheet = new AddCareSheet(animal.getFicheSoins());
                careSheet.setVisible(true);
                if(careSheet.isOk()){
                    careSheetPanel.removeAll();
                    for(int  i = 0 ; i< animal.getFicheSoins().size(); i++){
                        JButton button = createCareSheetButton(animal.getFicheSoins().getFiche(i));
                        careSheetPanel.add(button);
                    }
                    careSheetPanel.revalidate();
                    careSheetPanel.repaint();
                }

            }
        });
        modifyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ageTF.setEditable(true);
                weightTF.setEditable(true);
                validButton.setEnabled(true);
            }
        });
        deleteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                spa.getAnimals().removeAnimal(animal);
                ok = true;
                dispose();
            }
        });

        validButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                animal.setAge(Integer.parseInt(ageTF.getText()));
                animal.setPoids(Double.parseDouble(weightTF.getText()));
                JOptionPane.showMessageDialog(contentPane, "Les informations de l'animal ont été modifiées.");
                validButton.setEnabled(false);
                ageTF.setEditable(false);
                weightTF.setEditable(false);
            }
        });

        for(int  i = 0 ; i< animal.getFicheSoins().size(); i++){
            JButton button = createCareSheetButton(animal.getFicheSoins().getFiche(i));
            careSheetPanel.add(button);
        }
    }

    public void onCancel() {
        dispose();
    }
    private JButton createCareSheetButton(Soins soins) {
        JButton button = new JButton(soins.getDateCreation().toString());
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setPreferredSize(new Dimension(30, 10));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DisplayCareSheet displayCareSheet = new DisplayCareSheet(soins);
                displayCareSheet.setVisible(true);
            }
        });
        return button;
    }

    public boolean isOk() {
        return ok;
    }
}
