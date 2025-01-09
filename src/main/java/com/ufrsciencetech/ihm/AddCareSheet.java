package com.ufrsciencetech.ihm;

import com.ufrsciencetech.soins.FichesSoins;
import com.ufrsciencetech.soins.Soins;

import javax.swing.*;
import java.awt.event.*;
import java.util.Date;

public class AddCareSheet extends JDialog {
    private JPanel contentPanel;
    private JButton okButton;
    private JButton cancelButton;
    private JTextField titleTF;
    private JLabel vetLabel;
    private JTextField vetTF;
    private JLabel descLabel;
    private JTextArea descTA;
    private JLabel titleLabel;
    private JLabel dateLabel;
    private boolean ok = false;
    private FichesSoins healthSheetList;
    public AddCareSheet(FichesSoins healthSheetList) {
        setContentPane(contentPanel);
        setModal(true);
        setSize(500, 500);
        setLocation(200,100);
        setTitle("Formulaire d'ajout d'une fiche de soin");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.dateLabel.setText(new Date().toString());
        this.healthSheetList = healthSheetList;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
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
        contentPanel.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        String title = titleTF.getText();
        String vet = vetTF.getText();
        String desc = descTA.getText();
        Soins soins = new Soins(title,vet,desc);
        healthSheetList.ajouterFiche(soins);
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
