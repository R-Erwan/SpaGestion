package com.ufrsciencetech.soins;

/**
 *
 * @author gabin
 */
import java.util.ArrayList;

public class FichesSoins {

    private ArrayList<Soins> soins;

    public FichesSoins() {
        this.soins = new ArrayList<>();
    }


    /** Ajouter une fiche à la liste de fiche de soins
     *
     * @param fiche instance à ajouter
     * @throws IllegalArgumentException paramêtre null
     */
    public void ajouterFiche(Soins fiche) throws IllegalArgumentException {
        if (fiche == null) {
            throw new IllegalArgumentException("Le paramêtre doit être non null");
        }

        this.soins.add(fiche);
    }


    /** Supprimer une fiche de la liste de fiche de soins
     *
     * @param fiche instance à supprimer
     * @throws IllegalArgumentException paramêtre null
     */
    public void supprimerFiche(Soins fiche) throws IllegalArgumentException {
        if (fiche == null) {
            throw new IllegalArgumentException("Le paramêtre doit être non null");
        }

        this.soins.remove(fiche);
    }

    /**
     * @param i position dans la liste
     * @return null si indice incorrecte OU la fiche à la position i
     */
    public Soins getFiche(int i) {
        if (i < 0 || i >= this.soins.size()) {
            return null;
        }

        return this.soins.get(i);
    }

    /**
     * @return taille de la liste de fiches
     */
    public int size() {
        return this.soins.size();
    }

    /** Vider la liste de fiche de soins
     *
     */
    public void viderListe() {
        this.soins.clear();
    }

}


