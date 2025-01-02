package com.ufrsciencetech.stock;

import java.util.ArrayList;
import java.util.List;

//TODO make Singleton ?
public class ListeItems {
    private final List<ItemStock> items;

    public ListeItems() {
        this.items = new ArrayList<>();
    }

    public List<ItemStock> getItems() {
        return items;
    }

    public void addItem(ItemStock item) {
        if(!items.contains(item)) {
            this.items.add(item);
        } else {
            throw new ItemAlreadyInListException(item.toString());
        }
    }

    public void removeItem(ItemStock item) {
        this.items.remove(item);
    }

    public void increaseQuantity(int index, int amount) throws IndexOutOfBoundsException {
        if(index < 0 || index >= this.items.size()) {
            throw new IndexOutOfBoundsException();
        }
        this.items.get(index).addQuantity(amount);
    }

    public void decreaseQuantity(int index, int amount) throws IndexOutOfBoundsException {
        if(index < 0 || index >= this.items.size()) {
            throw new IndexOutOfBoundsException();
        }
        this.items.get(index).removeQuantity(amount);
    }

    public ItemStock getItem(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index > this.items.size()) {
            throw new IndexOutOfBoundsException();
        } else {
            return this.items.get(index);
        }
    }

    @Override
    public String toString() {
        return "ListeItems{" +
                "items=" + items +
                '}';
    }
}
