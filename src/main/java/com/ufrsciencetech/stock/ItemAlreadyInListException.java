package com.ufrsciencetech.stock;

public class ItemAlreadyInListException extends RuntimeException {
    public ItemAlreadyInListException(String message) {
        super("Index already in list "+message);
    }
}
