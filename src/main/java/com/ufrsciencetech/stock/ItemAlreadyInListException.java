package com.ufrsciencetech.stock;

/**
 * @author erwan
 */
public class ItemAlreadyInListException extends RuntimeException {
    public ItemAlreadyInListException(String message) {
        super("Index already in list "+message);
    }
}
