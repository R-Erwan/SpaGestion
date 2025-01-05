package com.ufrsciencetech.ihm;

import com.ufrsciencetech.soins.Soins;

import javax.swing.*;
import java.awt.event.*;

public class AffichageSoins extends JDialog {
    private JPanel contentPane;
    private JLabel setDateLabel;
    private JLabel dateLabel;
    private JLabel titleLabel;
    private JTextArea descrTA;
    private JLabel descriptionLabel;
    private JLabel vetoLabel;
    private JTextField vetoTF;
    private JTextField titleTF;
    private JButton buttonOK;
    private JButton cancelButton;

    public AffichageSoins(Soins soins) {
        setContentPane(contentPane);
        setModal(true);
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

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        titleTF.setText(soins.getTitre());
        descrTA.setText(soins.getDescription());
        vetoTF.setText(soins.getVeterinaire());
        setDateLabel.setText(soins.getDateCreation().toString());
    }
    public void onCancel() {
        dispose();
    }
}
