package com.ufrsciencetech.stock;

public abstract class ItemStock {
    private int threshold;
    private int quantity;

    public ItemStock(int threshold, int quantity) {
        this.setThreshold(threshold);
        this.setQuantity(quantity);
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
        if(quantity < 0) {
            throw new IllegalArgumentException("quantity cannot be negative");
        }
        this.quantity += quantity;
    }

    public void removeQuantity(int quantity) {
        if(quantity < 0) {
            throw new IllegalArgumentException("quantity cannot be negative");
        }
        if(quantity > this.quantity) {
            this.setQuantity(0);
        } else {
            this.setQuantity(this.quantity - quantity);
        }
    }

    public boolean isCritic(){
        return this.quantity <= this.getThreshold();
    }

    @Override
    public String toString() {
        return "ItemStock{" +
                "threshold=" + threshold +
                ", quantity=" + quantity +
                '}';
    }
}
