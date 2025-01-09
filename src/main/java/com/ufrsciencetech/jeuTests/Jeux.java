package com.ufrsciencetech.jeuTests;

import com.ufrsciencetech.animaux.Animal;
import com.ufrsciencetech.animaux.Animaux;
import com.ufrsciencetech.animaux.Especes;
import com.ufrsciencetech.main.SPA;
import com.ufrsciencetech.stock.ItemStock;
import com.ufrsciencetech.stock.ListeItems;
import com.ufrsciencetech.stock.Nourriture;
import com.ufrsciencetech.stock.TypeNourriture;
import com.ufrsciencetech.utils.Sexe;
import org.objectweb.asm.commons.StaticInitMerger;

import javax.swing.*;
import java.util.Random;

public class Jeux {

    public static SPA initSpa(){
        Animaux animaux = initAnimaux();
        SPA spa = new SPA("SPA de Dijon", "12 Rue des fleurs, 21000, Dijon", animaux,"02 12 34 56 78", "spa@dijon.com");
        initListeItems();
        return spa;
    }

    private static Animaux initAnimaux(){
        Animal chien1 = new Animal(Especes.CHIEN,gen_id(),"Pataud",4,40.7, Sexe.MALE,new ImageIcon("ressources/chien.png"));
        Animal chien2 = new Animal(Especes.CHIEN,gen_id(),"Woofy McWooface",8,3.4,Sexe.FEMELLE,new ImageIcon("ressources/chien.png"));
        Animal chien3 = new Animal(Especes.CHIEN,gen_id(),"Expresso",12,24.8,Sexe.MALE,new ImageIcon("ressources/chien.png"));
        Animal chien4 = new Animal(Especes.CHIEN,gen_id(),"Modulo",6,7.6,Sexe.MALE,new ImageIcon("ressources/chien.png"));
        Animal chat1 = new Animal(Especes.CHAT,gen_id(),"Ronronaldo",9,4.1,Sexe.MALE,new ImageIcon("ressources/chat.png"));
        Animal chat2 = new Animal(Especes.CHAT,gen_id(),"Chat-baba",2,3.2,Sexe.MALE,new ImageIcon("ressources/chat.png"));
        Animal chat3 = new Animal(Especes.CHAT,gen_id(),"O'Malley",1,2.1,Sexe.FEMELLE,new ImageIcon("ressources/chat.png"));
        Animal chat4 = new Animal(Especes.CHAT,gen_id(),"Lagaff",4,3.8,Sexe.FEMELLE,new ImageIcon("ressources/chat.png"));
        Animal chat5 = new Animal(Especes.CHAT,gen_id(),"Quoniaque",7,4.9,Sexe.MALE,new ImageIcon("ressources/chat.png"));
        Animal lapin1 = new Animal(Especes.LAPIN,gen_id(),"Dior",2,1.4,Sexe.FEMELLE,new ImageIcon("ressources/lapin.png"));
        Animal lapin2 = new Animal(Especes.LAPIN,gen_id(),"Peper",4,2.1,Sexe.MALE,new ImageIcon("ressources/lapin.png"));
        Animal lapin3 = new Animal(Especes.LAPIN,gen_id(),"Tetris",14,3.4,Sexe.MALE,new ImageIcon("ressources/lapin.png"));
        return new Animaux(chien1,chien2,chien3,chien4,chat1,chat2,chat3,chat4,chat5,lapin1,lapin2,lapin3);
    }

    private static void initListeItems(){
        Random rand = new Random();
        for (TypeNourriture typeNourriture : TypeNourriture.values()){
            for (Especes especes : Especes.values()){
                ListeItems.getInstance().addItem(new Nourriture(especes,typeNourriture,rand.nextInt(46)+5));
            }
        }
    }

    private static int gen_id(){
        Random rand = new Random();
        return 10000000 + rand.nextInt(90000000);
    }
}
