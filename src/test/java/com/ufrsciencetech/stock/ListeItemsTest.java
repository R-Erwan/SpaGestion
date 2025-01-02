package com.ufrsciencetech.stock;
import static  org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author erwan
 */
public class ListeItemsTest {

    private ListeItems listeItems;

    @BeforeEach
    void setUp(){
        listeItems = new ListeItems();
    }

    @Test
    void addItemsSuccess(){
        ItemStock itemMock = mock(ItemStock.class);
        listeItems.addItem(itemMock);
        assertTrue(listeItems.getItems().contains(itemMock));
    }

    @Test
    void addItemsAlreadyInList(){
        ItemStock itemMock = mock(ItemStock.class);
        listeItems.addItem(itemMock);
        assertThrows(ItemAlreadyInListException.class, () -> listeItems.addItem(itemMock));
    }

    @Test
    void removeItemsSuccess(){
        ItemStock itemMock = mock(ItemStock.class);
        listeItems.addItem(itemMock);
        listeItems.removeItem(itemMock);
        assertFalse(listeItems.getItems().contains(itemMock));
    }

    @Test
    void removeItemsNotInList(){
        ItemStock itemMock = mock(ItemStock.class);
        assertDoesNotThrow(() -> listeItems.removeItem(itemMock));
    }

    @Test
    void removeCorrectItems(){
        ItemStock itemMock = mock(ItemStock.class);
        ItemStock itemMock2 = mock(ItemStock.class);
        ItemStock itemMock3 = mock(ItemStock.class);
        listeItems.addItem(itemMock);
        listeItems.addItem(itemMock2);
        listeItems.addItem(itemMock3);
        listeItems.removeItem(itemMock2);
        assertTrue(listeItems.getItems().contains(itemMock));
        assertFalse(listeItems.getItems().contains(itemMock2));
        assertTrue(listeItems.getItems().contains(itemMock3));
    }

    @Test
    void increaseItemsQuantity(){
        ItemStock itemStock = new Nourriture(Races.CHIEN,TypeNourriture.JUNIOR,50);
        listeItems.addItem(itemStock);
        listeItems.increaseQuantity(0,50);
        assertEquals(50, listeItems.getItem(0).getQuantity());
    }

    @Test
    void decreaseItemsQuantity(){
        ItemStock itemStock = new Nourriture(Races.CHIEN,TypeNourriture.JUNIOR,50);
        listeItems.addItem(itemStock);
        listeItems.increaseQuantity(0,50);
        listeItems.decreaseQuantity(0,25);
        assertEquals(25, listeItems.getItem(0).getQuantity());
    }

    @Test
    void increaseItemsQuantityNotInList(){
        assertThrows(IndexOutOfBoundsException.class, () -> listeItems.increaseQuantity(0,10));
    }

    @Test
    void decreaseItemsQuantityNotInList(){
        assertThrows(IndexOutOfBoundsException.class, () -> listeItems.decreaseQuantity(0,10));
    }

    @Test
    void getItemWithCorrectIndex(){
        ItemStock itemMock = mock(ItemStock.class);
        listeItems.addItem(itemMock);
        ItemStock itemMockGet = listeItems.getItem(0);
        assertEquals(itemMock, itemMockGet);
    }

    @Test
    void getItemWithIncorrectIndex(){
        ItemStock itemMock = mock(ItemStock.class);
        listeItems.addItem(itemMock);
        assertThrows(IndexOutOfBoundsException.class, () -> listeItems.getItem(1));
    }

    @Test
    void updatetemsWithNegativIndex(){
        assertThrows(IndexOutOfBoundsException.class, () -> {listeItems.increaseQuantity(-1,10);});
        assertThrows(IndexOutOfBoundsException.class, () -> {listeItems.decreaseQuantity(-1,10);});
        assertThrows(IndexOutOfBoundsException.class, () -> {listeItems.getItem(-1);});
    }

    @Test
    void increaseWithNegativeQuantity(){

    }

}
