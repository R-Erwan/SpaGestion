package com.ufrsciencetech.soins;
import static  org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author samuel
 */
public class SoinsTest {
    private Soins soins;

    @BeforeEach
    void setUp(){
        soins = new Soins("Titre", "Veterinaire", "Description");
    }

    //Tests Getteurs

    @Test
    void testGetTitre()
    {
        assertEquals("Titre", soins.getTitre());
    }

    @Test
    void testGetVeterinaire()
    {
        assertEquals("Veterinaire", soins.getVeterinaire());
    }

    @Test
    void testGetDescription()
    {
        assertEquals("Description", soins.getDescription());
    }

    @Test
    void testGetDateCreation()
    {
        assertEquals(LocalDate.now(), soins.getDateCreation());
    }

    //Tests setteurs

    @Test
    void testSetTitre()
    {
        soins.setTitre("");
        assertEquals("", soins.getTitre());
    }

    @Test
    void testSetVeterinaire()
    {
        soins.setTitre("nouveauVeterinaire");
        assertEquals("nouveauVeterinaire", soins.getVeterinaire());
    }

    @Test
    void testSetDescription()
    {
        soins.setTitre("nouvelleDescription");
        assertEquals("nouvelleDescription", soins.getDescription());
    }

    //Tests Méthodes

    @Test
    void testModifier()
    {
        soins.modifier("nouveauTitre", "nouveauVeterinaire", "nouvelleDescription");
        assertEquals("nouveauTitre", soins.getTitre());
        assertEquals( "nouveauVeterinaire", soins.getVeterinaire());
        assertEquals("nouvelleDescription", soins.getDescription());
    }
}
