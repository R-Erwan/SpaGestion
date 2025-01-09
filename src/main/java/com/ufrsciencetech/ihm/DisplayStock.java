package com.ufrsciencetech.ihm;

import com.ufrsciencetech.animaux.Especes;
import com.ufrsciencetech.stock.ItemStock;
import com.ufrsciencetech.stock.ListeItems;
import com.ufrsciencetech.stock.Nourriture;
import com.ufrsciencetech.stock.TypeNourriture;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.ArrayList;

public class DisplayStock extends JDialog {
    private JPanel contentPane;
    private JButton leaveButton;
    private JScrollPane contentSP;
    private JButton addButton;
    private JTextArea commandeTA;
    private JComboBox<Nourriture> commandeCB;
    private JButton removeButton;
    private JButton commanderButton;
    private ArrayList<ItemStock> commandes;
    private ListeItems stockItems;
    private JTable stockTable;

    public DisplayStock(ListeItems stockItems) {
        setContentPane(contentPane);
        setModal(true);
        setSize(800, 500);
        setTitle("Inventaire");
        this.stockItems = stockItems;
        commandes = new ArrayList<>();
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

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Nom");
        model.addColumn("Quantité");
        model.addColumn("Statut");
        for (ItemStock item : stockItems.getItems()) {
            model.addRow(new Object[]{item.toString(), item.getQuantity(), item.isCritic() ? "Stock critique" : "Disponible"});
        }
        stockTable = new JTable(model);
        contentSP.setViewportView(stockTable);
        fillComboBox();
        addButton.addActionListener(e -> addQuantity());
        removeButton.addActionListener(e -> removeQuantity());
        commanderButton.addActionListener(e -> commander());
    }

    private void fillComboBox() {
        commandeCB.removeAllItems();
        for (Especes espece : Especes.values()) {
            for (TypeNourriture type : TypeNourriture.values()) {
                commandeCB.addItem(new Nourriture(espece, type, 0));
            }
        }
    }

    private void addQuantity() {
        ItemStock selectedItem = (ItemStock) commandeCB.getSelectedItem();
        commandes.add(selectedItem);
        commandeTA.setText("");
        for (ItemStock item : commandes) {

            commandeTA.append(item.toString() + "\n");
        }
        repaint();
    }

    private void removeQuantity() {
        ItemStock selectedItem = (ItemStock) commandeCB.getSelectedItem();
        if (selectedItem != null) {
            commandes.remove(selectedItem);
            commandeTA.setText("");
            for (ItemStock item : commandes) {
                commandeTA.append(item.toString() + "\n");
            }
            repaint();
        }
    }

    private void commander() {
        JOptionPane.showMessageDialog(contentPane,"Votre commande a été envoyé à votre fournisseur");
        onCancel();
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        ListeItems items =  ListeItems.getInstance();
        Nourriture croquettesChienJunior = new Nourriture(Especes.CHIEN, TypeNourriture.JUNIOR, 10);
        Nourriture croquettesChatAdulte = new Nourriture(Especes.CHAT, TypeNourriture.ADULTE, 15);
        Nourriture croquettesLapinSenior = new Nourriture(Especes.LAPIN, TypeNourriture.SENIOR, 5);
        items.addItem(croquettesChienJunior);
        items.addItem(croquettesChatAdulte);
        items.addItem(croquettesLapinSenior);
        croquettesChatAdulte.setQuantity(2);
        croquettesLapinSenior.setQuantity(20);
        DisplayStock stock  = new DisplayStock(items);
        stock.setVisible(true);
    }
}
