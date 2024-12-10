package com.ufrsciencetech.animaux;
import com.ufrsciencetech.utils.Sexe;

/* ================================================================== */
/* = ANIMAL ========================================================= */
/* ================================================================== */

public abstract class Animal {

    protected String nom;
    protected String race;
    protected int age;
    protected double poids;
    protected Sexe sexe;

    /* ================================================================== */
    /* = CONSTRUCTEUR =================================================== */
    /* ================================================================== */

    public Animal(String nom, String race, int age, double poids, Sexe sexe) {
        setNom(nom);
        setRace(race);
        setAge(age);
        setPoids(poids);
        setSexe(sexe);
    }

    /* ================================================================== */
    /* = GETTER ET SETTER =============================================== */
    /* ================================================================== */

    public String getNom() {
        return nom;
    }

    public String getRace() {
        return race;
    }

    public double getPoids() {
        return poids;
    }

    public int getAge() {
        return age;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setAge(int age) {
        if (age <= 0)
            System.err.println("Age non adapté");
        else
            this.age = age;
    }

    public void setNom(String nom) {
        if (nom.isEmpty())
            System.err.println("Nom non adapté");
        else
            this.nom = nom;
    }

    public void setPoids(double poids) {
        if (poids <= 0)
            System.err.println("Poids non adapté");
        else
            this.poids = poids;
    }

    public void setRace(String race) {
        if (race.isEmpty())
            System.err.println("Race non adaptée");
        else
            this.race = race;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    /* ================================================================== */
    /* = METHODS ======================================================== */
    /* ================================================================== */

    /* ================================================================== */
    /* = OVERRIDES ====================================================== */
    /* ================================================================== */

    public abstract String toString();
    public abstract boolean equals(Object o);
}
