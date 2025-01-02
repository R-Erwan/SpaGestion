package com.ufrsciencetech.main;

import com.ufrsciencetech.animaux.Animal;
import com.ufrsciencetech.stock.Nourriture;

import java.util.ArrayList;

public class SPA {
    private final String name;
    private final String address;
    private final String phone;
    private final String email;
    private final ArrayList<Animal> animals;
    private final ArrayList<Nourriture> nourriture;

    public SPA(String name, String address, ArrayList<Animal> animals, ArrayList<Nourriture> nourriture, String phone, String email) {
        this.name = name;
        this.address = address;
        this.animals = animals;
        this.nourriture = nourriture;
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

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public ArrayList<Nourriture> getNourriture() {
        return nourriture;
    }

    @Override
    public String toString() {
        return "Nom : " + name + '\n' + "Adresse : " + address + '\n' + "Tel : " + phone + '\n' + "Email : " + email + '\n';
    }
}
