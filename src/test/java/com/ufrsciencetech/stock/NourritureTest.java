package com.ufrsciencetech.stock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author erwan
 */
class NourritureTest {

    Nourriture nourriture;
    @BeforeEach
    void setUp() {
        nourriture = new Nourriture(Races.CHIEN,TypeNourriture.JUNIOR,10);
    }

    @Test
    void increaseQuantity() {
        nourriture.addQuantity(50);
        assertEquals(50, nourriture.getQuantity());
    }

    @Test
    void decreaseQuantity() {
        nourriture.addQuantity(50);
        nourriture.removeQuantity(25);
        assertEquals(25, nourriture.getQuantity());
    }

    @Test
    void addNegativeQuantity() {
        assertThrows(IllegalArgumentException.class, () -> nourriture.addQuantity(-50));
    }

    @Test
    void removeNegativeQuantity() {
        assertThrows(IllegalArgumentException.class, () -> nourriture.removeQuantity(-50));
    }

    @Test
    void removeQuantityWithSuperiorActualQuantity(){
        nourriture.addQuantity(50);
        nourriture.removeQuantity(100);
        assertEquals(0, nourriture.getQuantity());
    }

    @Test
    void addZeroQuantity() {
        nourriture.addQuantity(0);
        assertEquals(0, nourriture.getQuantity());
    }

    @Test
    void checkCriticTrue() {
        nourriture.addQuantity(2);
        assertTrue(nourriture.isCritic());
    }

    @Test
    void checkCriticFalse() {
        nourriture.addQuantity(20);
        assertFalse(nourriture.isCritic());
    }

    @Test
    void equalsWithSameNourriture() {
        Nourriture nourriture1 = nourriture;
        Nourriture nourriture2 = new Nourriture(Races.CHIEN,TypeNourriture.JUNIOR,10);
        assertEquals(nourriture1, nourriture2);
    }

    @Test void equalsWithDifferentNourriture() {
        Nourriture nourriture1 = nourriture;
        Nourriture nourriture2 = new Nourriture(Races.CHIEN,TypeNourriture.SENIOR,10);
        assertNotEquals(nourriture1, nourriture2);
    }
}