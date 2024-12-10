package com.ufrsciencetech.main;

import com.ufrsciencetech.stock.ListeItems;
import com.ufrsciencetech.stock.Nourriture;
import com.ufrsciencetech.stock.TypeAnimaux;
import com.ufrsciencetech.stock.TypeNourriture;

public class Main {
    public static void main(String[] args) {
        ListeItems items = new ListeItems();
        items.addItem(new Nourriture(TypeAnimaux.CHIEN, TypeNourriture.JUNIOR,5));
        items.increaseQuantity(0,1);
        System.out.println(items);
        System.out.println(items.getItem(0).isCritic());

    }
}