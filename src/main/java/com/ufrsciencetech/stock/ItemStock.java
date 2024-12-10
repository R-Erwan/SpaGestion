package com.ufrsciencetech.stock;

public abstract class ItemStock {
    private int threshold;
    private int quantity;

    public ItemStock(int threshold, int quantity) {
        this.threshold = threshold;
        this.quantity = quantity;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void removeQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public boolean isCritic(){
        return this.quantity <= this.threshold;
    }

    @Override
    public String toString() {
        return "ItemStock{" +
                "threshold=" + threshold +
                ", quantity=" + quantity +
                '}';
    }
}
