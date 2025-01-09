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
    private Especes espece;
    private int identifiant;
    private String nom;
    private int age;
    private double poids;
    private Sexe sexe;
    private ImageIcon image;
    private FichesSoins ficheSoins;
    private NourritureStrategy nourritureStrategy;


    /* ================================================================== */
    /* = CONSTRUCTEUR =================================================== */
    /* ================================================================== */

    public Animal(Especes espece, int identifiant, String nom, int age, double poids, Sexe sexe, ImageIcon image) {
        setEspece(espece);
        setNom(nom);
        setAge(age);
        setPoids(poids);
        setSexe(sexe);
        setImage(image);
        setIdentifiant(identifiant);
        this.nourritureStrategy = NourritureStrategyFactory.getStrategy(espece);
        setFicheSoins(new FichesSoins());
    }

    /* ================================================================== */
    /* = GETTER ET SETTER =============================================== */
    /* ================================================================== */

    public Especes getEspece() {
        return espece;
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
        return this.nourritureStrategy.determineNourriture(this.age, this.poids);
    }

    public FichesSoins getFicheSoins() {
        return this.ficheSoins;
    }

    public void setEspece(Especes espece) throws IllegalArgumentException {
        if (espece == null) {
            throw new IllegalArgumentException("Race null inexistante");
        }

        this.espece = espece;
        this.nourritureStrategy = NourritureStrategyFactory.getStrategy(espece);
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age <= 0) {
            throw new IllegalArgumentException("Age en dessous de 0 impossible");
        }

        this.age = age;
    }

    public void setNom(String nom) {
        if (nom.isEmpty()) {
            this.nom = "Inconnu";
            return;
        }
        this.nom = nom;
    }

    public void setPoids(double poids) throws IllegalArgumentException {
        if (poids <= 0){
            throw new IllegalArgumentException("Poids en dessous de 0 impossible");
        }

        this.poids = poids;
    }

    public void setSexe(Sexe sexe) throws IllegalArgumentException {
        if (sexe == null) {
            throw new IllegalArgumentException("Sexe null inexistant");
        }

        this.sexe = sexe;
    }

    public void setImage(ImageIcon image) throws IllegalArgumentException {
        if (image == null) {
            throw new IllegalArgumentException("L'image doit être non null");
        }

        this.image = image;
    }

    public void setIdentifiant(int identifiant) throws IllegalArgumentException {
        if (identifiant < 0) {
            throw new IllegalArgumentException("Identifiant négatif impossible");
        }

        this.identifiant = identifiant;
    }

    public void setFicheSoins(FichesSoins ficheSoins) throws IllegalArgumentException{
        if (ficheSoins == null) {
            throw new IllegalArgumentException("Fiche de soin doit être non null");
        }

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
                ", race=" + espece +
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
        return getIdentifiant() == animal.getIdentifiant() && getAge() == animal.getAge() && Double.compare(getPoids(), animal.getPoids()) == 0 && espece == animal.espece && getNom().equals(animal.getNom()) && getSexe() == animal.getSexe() && getImage().equals(animal.getImage()) && ficheSoins.equals(animal.ficheSoins);
    }

    @Override
    public int hashCode() {
        int result = espece.hashCode();
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
