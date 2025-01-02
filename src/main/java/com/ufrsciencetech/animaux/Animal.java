package com.ufrsciencetech.animaux;
import com.ufrsciencetech.animaux.NourritureStrategy.NourritureStrategy;
import com.ufrsciencetech.animaux.NourritureStrategy.NourritureStrategyFactory;
import com.ufrsciencetech.soins.FichesSoins;
import com.ufrsciencetech.stock.Nourriture;
import com.ufrsciencetech.utils.Sexe;
import javax.swing.ImageIcon;

/* ================================================================== */
/* = ANIMAL ========================================================= */
/* ================================================================== */

public class Animal {
    private Races race;
    private int identifiant;
    private String nom;
    private int age;
    private double poids;
    private Sexe sexe;
    private ImageIcon image;
    private FichesSoins ficheSoins;
    private final NourritureStrategy nourritureStrategy;


    /* ================================================================== */
    /* = CONSTRUCTEUR =================================================== */
    /* ================================================================== */

    public Animal(Races race, int identifiant, String nom, int age, double poids, Sexe sexe, ImageIcon image) {
        setRace(race);
        setNom(nom);
        setAge(age);
        setPoids(poids);
        setSexe(sexe);
        setImage(image);
        setIdentifiant(identifiant);
        this.nourritureStrategy = NourritureStrategyFactory.getStrategy(race);
        this.ficheSoins = new FichesSoins();
    }

    /* ================================================================== */
    /* = GETTER ET SETTER =============================================== */
    /* ================================================================== */

    public Races getRace() {
        return race;
    }

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

    public Nourriture getNourriture() {
        return this.nourritureStrategy.determineNourriture(this.age);
    }

    public void setRace(Races race) {
        this.race = race;
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

    public void setFicheSoins(FichesSoins ficheSoins) {
        this.ficheSoins = ficheSoins;
    }

    /* ================================================================== */
    /* = METHODS ======================================================== */
    /* ================================================================== */

    /* ================================================================== */
    /* = OVERRIDES ====================================================== */
    /* ================================================================== */

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", race=" + race +
                ", identifiant=" + identifiant +
                ", nom='" + nom + '\'' +
                ", poids=" + poids +
                ", sexe=" + sexe +
                ", image=" + image +
                ", ficheSoins=" + ficheSoins +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;
        return getIdentifiant() == animal.getIdentifiant() && getAge() == animal.getAge() && Double.compare(getPoids(), animal.getPoids()) == 0 && race == animal.race && getNom().equals(animal.getNom()) && getSexe() == animal.getSexe() && getImage().equals(animal.getImage()) && ficheSoins.equals(animal.ficheSoins);
    }

    @Override
    public int hashCode() {
        int result = race.hashCode();
        result = 31 * result + getIdentifiant();
        result = 31 * result + getNom().hashCode();
        result = 31 * result + getAge();
        result = 31 * result + Double.hashCode(getPoids());
        result = 31 * result + getSexe().hashCode();
        result = 31 * result + getImage().hashCode();
        result = 31 * result + ficheSoins.hashCode();
        return result;
    }

}
