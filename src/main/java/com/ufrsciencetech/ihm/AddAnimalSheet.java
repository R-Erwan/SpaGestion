package com.ufrsciencetech.ihm;

import com.ufrsciencetech.animaux.Animal;
import com.ufrsciencetech.animaux.Animaux;
import com.ufrsciencetech.animaux.Especes;
import com.ufrsciencetech.soins.FichesSoins;
import com.ufrsciencetech.utils.ImagePanel;
import com.ufrsciencetech.utils.Sexe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class AddAnimalSheet extends JDialog {
    private JPanel contentPanel;
    private JButton okButton;
    private JButton cancelButton;
    private JButton imageButton;
    private JPanel contentImagePanel;
    private JTextField nameTF;
    private JComboBox<Especes> specieCB;
    private JTextField raceTF;
    private JTextField ageTF;
    private JComboBox<Sexe> sexCB;
    private JTextField weightTF;
    private JLabel weightLabel;
    private JLabel nameLabel;
    private JLabel specieLabel;
    private JLabel ageLabel;
    private JLabel sexLabel;
    private ImagePanel imagePanel;
    private boolean ok = false;
    public AddAnimalSheet(Animaux animals) {

        setContentPane(contentPanel);
        setModal(true);
        setSize(700, 500);
        setTitle("Formulaire d'ajout d'un animal");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        specieCB.setModel(new DefaultComboBoxModel<>(Especes.values()));
        sexCB.setModel(new DefaultComboBoxModel<>(Sexe.values()));
        this.imagePanel = new ImagePanel();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK(animals);
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        contentPanel.registerKeyboardAction(new ActionListener() {
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
                    String path = fileChooser.getSelectedFile().getPath();
                    Image image = (new ImageIcon(path).getImage());
                    imagePanel.setImage(image);
                    imagePanel.setPreferredSize(new Dimension(200, 150));
                    contentImagePanel.setLayout(new BorderLayout());
                    contentImagePanel.add(imagePanel, BorderLayout.CENTER);
                }
                pack();
                contentImagePanel.repaint();
            }
        });
    }

    private void onOK(Animaux animauxList) {
        try {
            Animal newAnimal = getNewAnimal();
            newAnimal.setFicheSoins(new FichesSoins());
            animauxList.addAnimal(newAnimal);
            ok = true;
            dispose();

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Erreur: " + exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Animal getNewAnimal() {
        String name = nameTF.getText().trim();
        Especes specie = (Especes) specieCB.getSelectedItem();
        int age = Integer.parseInt(ageTF.getText().trim());
        Sexe sex = (Sexe) sexCB.getSelectedItem();
        double weight = Double.parseDouble(weightTF.getText().trim());
        Random rand = new Random();
        int id = 10000000 + rand.nextInt(90000000);
        return new Animal(specie, id , name, age, weight, sex, new ImageIcon(imagePanel.getImage()));
    }

    private void onCancel() {
        dispose();
    }

    public boolean isOk() {
        return ok;
    }
}
