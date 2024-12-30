package com.ufrsciencetech.soins;



/**
 *
 * @author gabin
 */
import java.util.ArrayList;
import java.util.HashMap;

public class FichesSoins {

    private HashMap<Integer, ArrayList<Soins>> soinsParAnimal;


    public FichesSoins() {
        this.soinsParAnimal = new HashMap<>();
    }

    // Ajouter un nouvel animal 
    public void ajouterAnimal(int animalId) {
        if (!soinsParAnimal.containsKey(animalId)) {
            soinsParAnimal.put(animalId, new ArrayList<>());
        } else {
            System.err.println("Cet animal existe déjà.");
        }
    }

    // Ajouter une fiche de soins 
    public void ajouterFichePourAnimal(int animalId, Soins fiche) {
        if (soinsParAnimal.containsKey(animalId)) {
            if (fiche != null) {
                soinsParAnimal.get(animalId).add(fiche);
            } else {
                System.err.println("Fiche de sooins invalide.");
            }
        } else {
            System.err.println("L'animal " + animalId + " n'existe pas.");
        }
    }

    // Supprimer une fiche de spoins 
    public void supprimerFichePourAnimal(int animalId, Soins fiche) {
        if (soinsParAnimal.containsKey(animalId)) {
            ArrayList<Soins> fiches = soinsParAnimal.get(animalId);
            if (fiches.remove(fiche)) {
            } else {
                System.err.println("La fiche de soins n'existe pas pour cet animal.");
            }
        } else {
            System.err.println("L'animal " + animalId + " n'existe pas.");
        }
    }

    // Supprimer toutes les ficss de soins d'un animal
    public void supprimerToutesFichesPourAnimal(int animalId) {
        if (soinsParAnimal.containsKey(animalId)) {
            soinsParAnimal.get(animalId).clear();
        } else {
            System.err.println("L'animal " + animalId + " n'existe pas.");
        }
    }
    
    //supprimer un animalede la HM
    public void supprimerAnimal(int animalId) {
    if (soinsParAnimal.containsKey(animalId)) {
        soinsParAnimal.remove(animalId);
    } else {
        System.err.println("L'animal " + animalId + " n'existe pas.");
    }
}
}

