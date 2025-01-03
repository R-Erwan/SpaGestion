package com.ufrsciencetech.soins;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author samuel
 */
public class FichesSoinsTest {
    private FichesSoins fiches;

    @BeforeEach
    void setUp()
    {
        fiches = new FichesSoins();
    }

    @Test
    void testSizeVide(){
        assertEquals(0, fiches.size());
    }

    @Test
    void testSizeDeuxElements()
    {
        Soins mock1 = mock(Soins.class);
        Soins mock2 = mock(Soins.class);
        fiches.ajouterFiche(mock1);
        fiches.ajouterFiche(mock2);
        assertEquals(2, fiches.size());
    }

    @Test
    void testAjouterFicheSuccess()
    {
        Soins mock1 = mock(Soins.class);
        assertEquals(0, fiches.size());
        fiches.ajouterFiche(mock1);
        assertEquals(1, fiches.size());
        assertEquals(mock1, fiches.getFiche(0));
    }

    @Test
    void testAjouterFicheInvalid()
    {
        Soins nullMock = null;
        assertThrows(IllegalArgumentException.class, () -> fiches.ajouterFiche(nullMock));
    }

    @Test
    void testSupprimerFicheSuccess()
    {
        Soins mock1 = mock(Soins.class);
        fiches.ajouterFiche(mock1);
        fiches.supprimerFiche(mock1);
        assertEquals(0, fiches.size());
    }

    @Test
    void testSupprimerFicheInvalid()
    {
        Soins nullMock = null;
        assertThrows(IllegalArgumentException.class, () -> fiches.supprimerFiche(nullMock));
    }

    @Test
    void testGetFicheSuccess()
    {
        Soins mock1 = mock(Soins.class);
        Soins mock2 = mock(Soins.class);
        fiches.ajouterFiche(mock1);
        fiches.ajouterFiche(mock2);
        assertEquals(mock2, fiches.getFiche(1));
    }

    @Test
    void testGetFicheOutOfBounds()
    {
        assertEquals(null, fiches.getFiche(-1));
    }

    @Test
    void testViderListe()
    {
        Soins mock1 = mock(Soins.class);
        Soins mock2 = mock(Soins.class);
        fiches.ajouterFiche(mock1);
        fiches.ajouterFiche(mock2);
        fiches.viderListe();
        assertEquals(0, fiches.size());
    }
}
