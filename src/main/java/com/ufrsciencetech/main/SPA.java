package com.ufrsciencetech.main;

import com.ufrsciencetech.animaux.Animaux;
import com.ufrsciencetech.stock.ListeItems;

public class SPA {
    private final String name;
    private final String address;
    private final String phone;
    private final String email;
    private final Animaux animals;
    private final ListeItems stock;

    public SPA(String name, String address, Animaux animals, String phone, String email) {
        this.name = name;
        this.address = address;
        this.animals = animals;
        this.stock = ListeItems.getInstance();
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

    public ListeItems getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Nom : " + name + '\n' + "Adresse : " + address + '\n' + "Tel : " + phone + '\n' + "Email : " + email + '\n';
    }
}
