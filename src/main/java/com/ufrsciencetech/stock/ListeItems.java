package com.ufrsciencetech.stock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author erwan
 */
public class ListeItems {
    private static ListeItems instance;
    private final List<ItemStock> items;

    private ListeItems() {
        this.items = new ArrayList<>();
    }

    public static synchronized ListeItems getInstance() {
        if (instance == null) {
            instance = new ListeItems();
        }
        return instance;
    }


    public List<ItemStock> getItems() {
        return items;
    }

    public void addItem(ItemStock item) {
        if (!items.contains(item)) {
            this.items.add(item);
        } else {
            throw new ItemAlreadyInListException(item.toString());
        }
    }

    public void removeItem(ItemStock item) {
        this.items.remove(item);
    }

    public void increaseQuantity(int index, int amount) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.items.size()) {
            throw new IndexOutOfBoundsException();
        }
        this.items.get(index).addQuantity(amount);
    }

    public void increaseQuantity(ItemStock item, int amount) throws IndexOutOfBoundsException, ItemAlreadyInListException {
        for (ItemStock stock : this.items) {
            if(stock.equals(item)) {
                stock.addQuantity(amount);
                return;
            }
        }
        try {
            this.addItem(item);
        } catch (ItemAlreadyInListException e) {
            throw new ItemAlreadyInListException(item.toString());
        }
    }

    public void decreaseQuantity(int index, int amount) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.items.size()) {
            throw new IndexOutOfBoundsException();
        }
        this.items.get(index).removeQuantity(amount);
    }


    public ItemStock getItem(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.items.size()) {
            throw new IndexOutOfBoundsException();
        } else {
            return this.items.get(index);
        }
    }

    public void clear() {
        this.items.clear();
    }

    @Override
    public String toString() {
        return "ListeItems{" +
                "items=" + items +
                '}';
    }
}
