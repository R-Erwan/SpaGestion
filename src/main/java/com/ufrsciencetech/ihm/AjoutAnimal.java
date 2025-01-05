package com.ufrsciencetech.ihm;

import com.ufrsciencetech.animaux.Animal;
import com.ufrsciencetech.animaux.Animaux;
import com.ufrsciencetech.animaux.Especes;
import com.ufrsciencetech.soins.FichesSoins;
import com.ufrsciencetech.utils.PanneauImage;
import com.ufrsciencetech.utils.Sexe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class AjoutAnimal extends JDialog {
    private JPanel contentPane;
    private JButton okButton;
    private JButton cancelButton;
    private JButton imageButton;
    private JPanel imagePanel;
    private JTextField nameTF;
    private JComboBox<Especes> specieCB;
    private JTextField raceTF;
    private JTextField ageTF;
    private JComboBox<Sexe> sexCB;
    private JTextField weightTF;
    private JTextField healthTF;
    private JLabel weightLabel;
    private JLabel nameLabel;
    private JLabel specieLabel;
    private JLabel ageLabel;
    private JLabel sexLabel;
    private JLabel healthLabel;
    private PanneauImage panneauImage;
    private boolean ok = false;
    public AjoutAnimal(Animaux animals) {
        this.panneauImage = new PanneauImage();
        setContentPane(contentPane);
        setModal(true);
        setSize(700, 500);
        setTitle("Formulaire d'ajout d'un animal");
        specieCB.setModel(new DefaultComboBoxModel<>(Especes.values()));
        sexCB.setModel(new DefaultComboBoxModel<>(Sexe.values()));

        // OK Button Action
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK(animals);
            }
        });

        // Cancel Button Action
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

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

        imageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    String chemin = fileChooser.getSelectedFile().getPath();
                    Image image = (new ImageIcon(chemin).getImage());
                    panneauImage.setImage(image);
                    panneauImage.setPreferredSize(new Dimension(200, 150));
                    imagePanel.setLayout(new BorderLayout());
                    imagePanel.add(panneauImage, BorderLayout.CENTER);
                }
                pack();
                imagePanel.repaint();
            }
        });
    }

    private void onOK(Animaux anim) {
        try {
            String name = nameTF.getText().trim();
            Especes species = (Especes) specieCB.getSelectedItem();
            int age = Integer.parseInt(ageTF.getText().trim());
            Sexe sex = (Sexe) sexCB.getSelectedItem();
            double weight = Double.parseDouble(weightTF.getText().trim());
            Random rand = new Random();
            int id = 10000000 + rand.nextInt(90000000);
            Animal newAnimal = new Animal(species, id , name, age, weight, sex, new ImageIcon(panneauImage.getImage()));
            newAnimal.setFicheSoins(new FichesSoins());
            anim.addAnimal(newAnimal);
            ok = true;
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erreur: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onCancel() {
        dispose();
    }

    public boolean isOk() {
        return ok;
    }
}
