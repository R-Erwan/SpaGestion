package com.ufrsciencetech.animaux;

import com.ufrsciencetech.stock.Nourriture;
import com.ufrsciencetech.stock.TypeNourriture;
import com.ufrsciencetech.utils.Sexe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    Animal animal;

    @BeforeEach
    public void setUp() throws Exception {
        animal = new Animal(
                Especes.CHIEN,
                1,
                "Toto",
                5,
                4.0,
                Sexe.MALE,
                new ImageIcon()
        );
    }

    @Test
    public void createAnimal() {
        assertEquals(Especes.CHIEN, animal.getEspece());
        assertEquals(1, animal.getIdentifiant());
        assertEquals("Toto",animal.getNom());
        assertEquals(5, animal.getAge());
        assertEquals(4.0, animal.getPoids());
        assertEquals(Sexe.MALE, animal.getSexe());
        assertEquals(0, animal.getFicheSoins().size());
    }

    /*
        NOURRITURE CHIEN
     */

    @Test
    public void nourritureChienJunior(){
        animal.setEspece(Especes.CHIEN);
        animal.setAge(2);
        Nourriture nourriture = animal.getNourriture();
        assertEquals(Especes.CHIEN, nourriture.getTypeAnimaux());
        assertEquals(TypeNourriture.JUNIOR,nourriture.getTypeNourriture());
    }

    @Test
    public void nourritureChienAdulte(){
        animal.setEspece(Especes.CHIEN);
        animal.setAge(10);
        Nourriture nourriture = animal.getNourriture();
        assertEquals(Especes.CHIEN, nourriture.getTypeAnimaux());
        assertEquals(TypeNourriture.ADULTE,nourriture.getTypeNourriture());
    }

    @Test
    public void nourritureChienSenior(){
        animal.setEspece(Especes.CHIEN);
        animal.setAge(11);
        Nourriture nourriture = animal.getNourriture();
        assertEquals(Especes.CHIEN, nourriture.getTypeAnimaux());
        assertEquals(TypeNourriture.SENIOR,nourriture.getTypeNourriture());
    }

    /*
        NOURRITURE CHAT
     */

    @Test
    public void nourritureChatJunior(){
        animal.setEspece(Especes.CHAT);
        animal.setAge(1);
        Nourriture nourriture = animal.getNourriture();
        assertEquals(Especes.CHAT, nourriture.getTypeAnimaux());
        assertEquals(TypeNourriture.JUNIOR,nourriture.getTypeNourriture());
    }

    @Test
    public void nourritureChatAdulte(){
        animal.setEspece(Especes.CHAT);
        animal.setAge(6);
        Nourriture nourriture = animal.getNourriture();
        assertEquals(Especes.CHAT, nourriture.getTypeAnimaux());
        assertEquals(TypeNourriture.ADULTE,nourriture.getTypeNourriture());
    }

    @Test
    public void nourritureChatSenior(){
        animal.setEspece(Especes.CHAT);
        animal.setAge(7);
        Nourriture nourriture = animal.getNourriture();
        assertEquals(Especes.CHAT, nourriture.getTypeAnimaux());
        assertEquals(TypeNourriture.SENIOR,nourriture.getTypeNourriture());
    }

    @Test
    public void nourritureChatSurpoids(){
        animal.setEspece(Especes.CHAT);
        animal.setAge(7);
        animal.setPoids(5.7);
        Nourriture nourriture = animal.getNourriture();
        assertEquals(Especes.CHAT, nourriture.getTypeAnimaux());
        assertEquals(TypeNourriture.S_SURPOIDS,nourriture.getTypeNourriture());
    }

    @Test
    public void nourritureChatJuniorSurpoids(){
        animal.setEspece(Especes.CHAT);
        animal.setAge(1);
        animal.setPoids(5.7);
        Nourriture nourriture = animal.getNourriture();
        assertEquals(Especes.CHAT, nourriture.getTypeAnimaux());
        assertEquals(TypeNourriture.JUNIOR,nourriture.getTypeNourriture());
    }

    /*
        NOURRITURE LAPIN
     */

    @Test
    public void nourritureLapinJunior(){
        animal.setEspece(Especes.LAPIN);
        animal.setAge(1);
        Nourriture nourriture = animal.getNourriture();
        assertEquals(Especes.LAPIN, nourriture.getTypeAnimaux());
        assertEquals(TypeNourriture.JUNIOR,nourriture.getTypeNourriture());
    }

    @Test
    public void nourritureLapinAdulte(){
        animal.setEspece(Especes.LAPIN);
        animal.setAge(5);
        Nourriture nourriture = animal.getNourriture();
        assertEquals(Especes.LAPIN, nourriture.getTypeAnimaux());
        assertEquals(TypeNourriture.ADULTE,nourriture.getTypeNourriture());
    }

    @Test
    public void nourritureLapinSenior(){
        animal.setEspece(Especes.LAPIN);
        animal.setAge(11);
        Nourriture nourriture = animal.getNourriture();
        assertEquals(Especes.LAPIN, nourriture.getTypeAnimaux());
        assertEquals(TypeNourriture.SENIOR,nourriture.getTypeNourriture());
    }


}
