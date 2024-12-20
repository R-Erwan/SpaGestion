package com.ufrsciencetech.animaux;
import com.ufrsciencetech.soins.FicheSoins;
import com.ufrsciencetech.utils.Sexe;
import javax.swing.ImageIcon;
import java.util.ArrayList;

/* ================================================================== */
/* = ANIMAL ========================================================= */
/* ================================================================== */

public abstract class Animal {
    protected int identifiant;
    protected String nom;
    protected int age;
    protected double poids;
    protected Sexe sexe;
    protected ImageIcon image;
    protected ArrayList<FicheSoins> ficheSoins;

    /* ================================================================== */
    /* = CONSTRUCTEUR =================================================== */
    /* ================================================================== */

    public Animal(int identifiant, String nom, String race, int age, double poids, Sexe sexe, ImageIcon image, ArrayList<FicheSoins> ficheSoins) {
        setNom(nom);
        setAge(age);
        setPoids(poids);
        setSexe(sexe);
        setImage(image);
        setIdentifiant(identifiant);
        setFicheSoins(ficheSoins);
    }

    /* ================================================================== */
    /* = GETTER ET SETTER =============================================== */
    /* ================================================================== */

    public String getNom() {
        return nom;
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

    public ImageIcon getImage() {
        return image;
    }

    public int getIdentifiant() {
        return identifiant;
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

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public void setIdentifiant(int identifiant) {
        if (identifiant < 0)
            System.err.println("Identifiant non valide");
        else
            this.identifiant = identifiant;
    }

    public void setFicheSoins(ArrayList<FicheSoins> ficheSoins) {
        if (ficheSoins == null)
            this.ficheSoins = new ArrayList<>();
        else
            this.ficheSoins = ficheSoins;
    }

    /* ================================================================== */
    /* = METHODS ======================================================== */
    /* ================================================================== */

    /* ================================================================== */
    /* = OVERRIDES ====================================================== */
    /* ================================================================== */

    public abstract String toString();
    public abstract boolean equals(Object o);
    public abstract Races getRace();
}
