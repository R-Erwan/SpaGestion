package com.ufrsciencetech.ihm;

import com.ufrsciencetech.animaux.Animal;
import com.ufrsciencetech.soins.FichesSoins;
import com.ufrsciencetech.soins.Soins;

import javax.swing.*;
import java.awt.event.*;

public class AjoutFicheSoin extends JDialog {
    private JPanel contentPane;
    private JButton okButton;
    private JButton cancelButton;
    private JTextField titreTF;
    private JLabel vetoLabel;
    private JTextField vetoTF;
    private JLabel descrLabel;
    private JTextArea descrTA;
    private JLabel titleLabel;
    private JLabel setdateLabel;
    private boolean ok = false;
    private FichesSoins fichesSoins;
    public AjoutFicheSoin(FichesSoins fichesSoins) {
        setdateLabel.setText(java.time.LocalDate.now().toString());
        setContentPane(contentPane);
        setModal(true);
        setSize(500, 500);
        setTitle("Formulaire d'ajout d'une fiche de soin");
        this.fichesSoins = fichesSoins;

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
    }

    private void onOK() {
        String titre = titreTF.getText();
        String veto = vetoTF.getText();
        String descr = descrTA.getText();
        Soins soins = new Soins(titre,veto, descr);
        fichesSoins.ajouterFiche(soins);
        ok = true;
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public boolean isOk() {
        return this.ok;
    }
}
