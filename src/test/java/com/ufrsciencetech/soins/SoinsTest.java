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

    //Tests Getters

    @Test
    void testGetTitreSuccess()
    {
        assertEquals("Titre", soins.getTitre());
    }

    @Test
    void testGetVeterinaireSuccess()
    {
        assertEquals("Veterinaire", soins.getVeterinaire());
    }

    @Test
    void testGetDescriptionSuccess()
    {
        assertEquals("Description", soins.getDescription());
    }

    @Test
    void testGetDateCreationSuccess()
    {
        assertEquals(LocalDate.now(), soins.getDateCreation());
    }

    //Tests setters

    @Test
    void testSetTitreSuccess()
    {
        soins.setTitre("nouveauTitre");
        assertEquals("nouveauTitre", soins.getTitre());
    }

    @Test
    void testSetTitreInvalid()
    {
        assertThrows(IllegalArgumentException.class, () -> soins.setTitre(""));
    }


    @Test
    void testSetVeterinaireSuccess()
    {
        soins.setTitre("nouveauVeterinaire");
        assertEquals("nouveauVeterinaire", soins.getVeterinaire());
    }

    @Test
    void testSetVeterinaireInvalid()
    {
        assertThrows(IllegalArgumentException.class, () -> soins.setVeterinaire(""));
    }

    @Test
    void testSetDescriptionSuccess()
    {
        soins.setTitre("nouvelleDescription");
        assertEquals("nouvelleDescription", soins.getDescription());
    }

    @Test
    void testSetDescriptionInvalid()
    {
        assertThrows(IllegalArgumentException.class, () -> soins.setDescription(""));
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
