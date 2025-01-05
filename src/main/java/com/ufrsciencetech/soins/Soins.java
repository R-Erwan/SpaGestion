/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufrsciencetech.soins;

import java.time.LocalDate;

/**
 *
 * @author gabin
 */
public class Soins {
    
    private String titre;
    private String veterinaire;
    private String description;
    private final LocalDate dateCreation;

    public Soins(String titre, String veterinaire, String description) {
        this.setTitre(titre);
        this.setVeterinaire(veterinaire);
        this.setDescription(description);
        this.dateCreation = LocalDate.now(); // Date du jour
    }

    // Getters et Setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) throws IllegalArgumentException {
        if (titre.trim().isEmpty()) {
            throw new IllegalArgumentException("titre non valable");
        }

        this.titre = titre;
    }

    public String getVeterinaire() {
        return veterinaire;
    }

    public void setVeterinaire(String veterinaire) throws IllegalArgumentException {
        if (veterinaire.trim().isEmpty()) {
            throw new IllegalArgumentException("Veterinaire doit avoir une valeur non nulle");
        }

        this.veterinaire = veterinaire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws IllegalArgumentException {
        if (description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description doit avoir une valeur non nulle");
        }

        this.description = description;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void modifier(String nouveauTitre, String nouveauVeterinaire, String nouvelleDescription) {
        this.titre = nouveauTitre;
        this.veterinaire = nouveauVeterinaire;
        this.description = nouvelleDescription;
        System.out.println("E01 MODIF.");
    }
}