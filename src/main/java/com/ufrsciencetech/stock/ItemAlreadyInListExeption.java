package com.ufrsciencetech.stock;

public class ItemAlreadyInListExeption extends RuntimeException {
    public ItemAlreadyInListExeption(String message) {
        super("Index already in list "+message);
    }
}
