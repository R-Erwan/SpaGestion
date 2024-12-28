package com.ufrsciencetech.ihm;

import javax.swing.*;
import java.awt.event.*;

public class Stock extends JDialog {
    private JPanel contentPane;
    private JButton leaveButton;
    private JPanel contentPanel;
    private JScrollPane contentSP;
    private JButton addButton;
    private JTextArea commandeTA;
    private JComboBox commandeCB;
    private JButton removeButton;
    private JButton commanderButton;

    public Stock() {
        setContentPane(contentPane);
        setModal(true);
        setSize(800, 900);
        setTitle("Inventaire");
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
        leaveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                onCancel();
            }
        });
    }


    private void onCancel() {
        dispose();
    }

}
