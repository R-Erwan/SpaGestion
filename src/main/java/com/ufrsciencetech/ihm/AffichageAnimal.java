package com.ufrsciencetech.ihm;

import javax.swing.*;
import java.awt.event.*;

public class AffichageAnimal extends JDialog {
    private JPanel contentPane;
    private JPanel titlePanel;
    private JLabel titleLabel;
    private JTabbedPane tabbedPAne;
    private JTextField specieTF;
    private JTextField sexTF;
    private JTextField ageTF;
    private JTextField weightTF;
    private JTextField healthTF;
    private JButton addButton;
    private JButton modifyButton;
    private JButton deleteButton;
    private JLabel imagePanel;
    private JLabel ageLabel;
    private JLabel sexLabel;
    private JLabel specieLabel;
    private JPanel presentationTab;
    private JLabel weightLabel;
    private JLabel healthLabel;
    private JPanel healthTab;
    private JButton buttonOK;
    private JButton buttonCancel;

    public AffichageAnimal() {
        setContentPane(contentPane);
        setModal(true);
        setSize(700, 500);
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
                AjoutFicheSoin soin = new AjoutFicheSoin();
                soin.setVisible(true);
            }
        });
        modifyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });
        deleteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
            }
        });
    }

    public void onCancel() {
        dispose();
    }

}
