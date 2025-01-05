package com.ufrsciencetech.main;

import com.ufrsciencetech.animaux.Animal;
import com.ufrsciencetech.animaux.Animaux;
import com.ufrsciencetech.stock.ListeItems;
import com.ufrsciencetech.stock.Nourriture;

import java.util.ArrayList;

public class SPA {
    private final String name;
    private final String address;
    private final String phone;
    private final String email;
    private final Animaux animals;
    private final ListeItems nourriture;

    public SPA(String name, String address, Animaux animals, String phone, String email) {
        this.name = name;
        this.address = address;
        this.animals = animals;
        this.nourriture = ListeItems.getInstance();
        this.phone = phone;
        this.email = email;
    }
    

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Animaux getAnimals() {
        return animals;
    }

    public ListeItems getNourriture() {
        return nourriture;
    }

    @Override
    public String toString() {
        return "Nom : " + name + '\n' + "Adresse : " + address + '\n' + "Tel : " + phone + '\n' + "Email : " + email + '\n';
    }
}
