package com.ufrsciencetech.ihm;

import com.ufrsciencetech.soins.Soins;

import javax.swing.*;
import java.awt.event.*;

public class DisplayCareSheet extends JDialog {
    private JPanel contentPanel;
    private JTextArea descrTA;
    private JLabel dateField;
    private JLabel dateLabel;
    private JLabel titleLabel;
    private JLabel descriptionLabel;
    private JLabel vetoLabel;
    private JTextField vetTF;
    private JTextField titleTF;
    private JButton buttonOK;
    private JButton cancelButton;

    public DisplayCareSheet(Soins healthSheet) {
        setContentPane(contentPanel);
        setModal(true);
        setSize(700, 500);
        setLocation(200,100);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        contentPanel.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        titleTF.setText(healthSheet.getTitre());
        descrTA.setText(healthSheet.getDescription());
        vetTF.setText(healthSheet.getVeterinaire());
        dateField.setText(healthSheet.getDateCreation().toString());
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                onCancel();
            }
        });
    }
    public void onCancel() {
        dispose();
    }
}
