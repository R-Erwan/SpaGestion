package com.ufrsciencetech.animaux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* ================================================================== */
/* = ANIMAUX ======================================================== */
/* ================================================================== */

/**
 * Collection regroupant les animaux. Implémente {@link Iterable} pour l'utilisation dans les boucle 'foreach'
 *
 * <pre>
 *     {@code
 *     Animaux animaux = new Animaux();
 *     // insertion d'animaux
 *
 *     for (Animal animal : animaux) {
 *         // utilisation
 *     }
 *     }
 * </pre>
 */
public class Animaux implements Iterable<Animal> {
    private ArrayList<Animal> animaux;

    /* ================================================================== */
    /* = CONSTRUCTEURS ================================================== */
    /* ================================================================== */

    public Animaux() {
        this.animaux = new ArrayList<>();
    }

    public Animaux(Animal... animaux) {
        this();
        this.animaux.addAll(Arrays.asList(animaux));
    }

    /* ================================================================== */
    /* = GETTER ET SETTER =============================================== */
    /* ================================================================== */

    public Animal getAnimal(int i) {
        if (i < 0 || i > size())
            return null;
        else
            return this.animaux.get(i);
    }

    public void addAnimal(Animal animal) {
        this.animaux.add(animal);
    }

    public int size() {
        return this.animaux.size();
    }

    /* ================================================================== */
    /* = METHODS ======================================================== */
    /* ================================================================== */

    /* ================================================================== */
    /* = OVERRIDES ====================================================== */
    /* ================================================================== */

    @Override
    public Iterator<Animal> iterator() {
        return new Iterator<Animal>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public Animal next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException("Fin de la liste Animaux");
                }

                return animaux.get(index++);
            }
        };
    }
}