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
    private LocalDate dateCreation;

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

    public void setTitre(String titre) {
        if (titre.trim().isEmpty()) {
            System.err.println("Titre non valable");
        } else {
            this.titre = titre;
        }
    }

    public String getVeterinaire() {
        return veterinaire;
    }

    public void setVeterinaire(String veterinaire) {
        if (veterinaire.trim().isEmpty()) {
            System.err.println("Vétérinaire non valable");
        } else {
            this.veterinaire = veterinaire;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.trim().isEmpty()) {
            System.err.println("Description non valable");
        } else {
            this.description = description;
        }
       
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

    // Méthode pour supprimer la fiche de soins
    public void supprimer() {
        this.titre = "";
        this.veterinaire = "";
        this.description = "";
        this.dateCreation = null;
        System.out.println("E01 SUPP.");
    }

    
}