package com.ufrsciencetech.animaux;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnimauxTest {

    Animaux animaux;

    @BeforeEach
    void setUp() throws Exception {
        animaux = new Animaux();
    }

    @Test
    void multiParamsConstructor() {
        Animal animalMock = mock(Animal.class);
        Animal animalMock2 = mock(Animal.class);
        Animaux animaux2 = new Animaux(animalMock, animalMock2);
        assertEquals(2, animaux2.size());
    }

    @Test
    void addAnimalToList() {
        Animal animalMock = mock(Animal.class);
        animaux.addAnimal(animalMock);
        assertTrue(animaux.size() > 0);
    }

    @Test
    void removeAnimalFromList() {
        Animal animalMock = mock(Animal.class);
        animaux.addAnimal(animalMock);
        animaux.removeAnimal(animalMock);
        assertEquals(0, animaux.size());
    }

     @Test
    void removeAnimalFromListWithIndex() {
        Animal animalMock = mock(Animal.class);
        animaux.addAnimal(animalMock);
        animaux.removeAnimal(0);
        assertEquals(0, animaux.size());}

    @Test
    void getAnimalFromList() {
        Animal animalMock = mock(Animal.class);
        animaux.addAnimal(animalMock);
        assertEquals(animalMock, animaux.getAnimal(0));
    }

    @Test
    void getAnimalWithSuperiorIndex(){
        Animal animalMock = mock(Animal.class);
        animaux.addAnimal(animalMock);
        assertThrows(IndexOutOfBoundsException.class, () -> animaux.getAnimal(1));
    }
    @Test
    void getAnimalWithNegativIndex(){
        Animal animalMock = mock(Animal.class);
        animaux.addAnimal(animalMock);
        assertThrows(IndexOutOfBoundsException.class, () -> animaux.getAnimal(-1));
    }

    @Test
    void mapWithEspecesNumber(){
        Animal chienMock = mock(Animal.class);
        when(chienMock.getEspece()).thenReturn(Especes.CHIEN);
        Animal chien2Mock = mock(Animal.class);
        when(chien2Mock.getEspece()).thenReturn(Especes.CHIEN);
        Animal chatMock = mock(Animal.class);
        when(chatMock.getEspece()).thenReturn(Especes.CHAT);
        animaux.addAnimal(chienMock);
        animaux.addAnimal(chien2Mock);
        animaux.addAnimal(chatMock);

        assertEquals(2,animaux.getTypesAnimaux().get(Especes.CHIEN));
    }

    @Test
    void mapWithEspecesEmptyChien(){
        assertEquals(0,animaux.getTypesAnimaux().get(Especes.CHIEN));
    }

    @Test
    void iteratorWith3Animals(){
        Animal animalMock = mock(Animal.class);
        Animal animalMock2 = mock(Animal.class);
        Animal animalMock3 = mock(Animal.class);
        animaux.addAnimal(animalMock);
        animaux.addAnimal(animalMock2);
        animaux.addAnimal(animalMock3);
        Iterator<Animal> iterator = animaux.iterator();
        iterator.next();
        iterator.next();
        assertEquals(animalMock3, iterator.next());
    }
}
