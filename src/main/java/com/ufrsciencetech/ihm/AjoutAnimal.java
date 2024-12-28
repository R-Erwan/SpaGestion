package com.ufrsciencetech.ihm;

import com.ufrsciencetech.utils.PanneauImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AjoutAnimal extends JDialog {
    private JPanel contentPane;
    private JButton okButton;
    private JButton cancelButton;
    private JButton imageButton;
    private JPanel imagePanel;
    private JTextField nameTF;
    private JComboBox specieCB;
    private JTextField raceTF;
    private JTextField ageTF;
    private JComboBox sexCB;
    private JTextField weightTF;
    private JTextField healthTF;
    private JLabel weightLabel;
    private JLabel nameLabel;
    private JLabel specieLabel;
    private JLabel raceLabel;
    private JLabel ageLabel;
    private JLabel sexLabel;
    private JLabel healthLabel;
    private PanneauImage panneauImage;

    public AjoutAnimal() {
        this.panneauImage = new PanneauImage();
        setContentPane(contentPane);
        setModal(true);
        setSize(700, 500);
        setTitle("Formulaire d'ajout d'un animal");

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

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

    private void onOK() {
        dispose();
    }

    private void onCancel() {
        dispose();
    }
}
