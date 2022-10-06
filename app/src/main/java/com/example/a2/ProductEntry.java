package com.example.a2;
public class ProductEntry {
    private String name;
    private int quantity;
    private double price;
    public ProductEntry(String n, int q, double p) {
        name = n;
        quantity = q;
        price = p;
    }
    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    public void addQuantity(int q) {
        quantity+= q;
    }
    public void removeQuantity(int q) {
        quantity-= q;
    }
}