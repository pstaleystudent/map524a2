package com.example.a2;

import java.util.ArrayList;

public class ProductList {
    private ArrayList<ProductEntry> dat;
    public ArrayList<ProductEntry> get() {
        return dat;
    }
    public void set(ArrayList<ProductEntry> d) {
        this.dat = d;
    }
    private static final ProductList holder = new ProductList();
    public static void init() { //would theoretically load from disk
        holder.set(new ArrayList<>());
        holder.get().add(new ProductEntry("Pante",10,20.44));
        holder.get().add(new ProductEntry("Shoes",100,10.44));
        holder.get().add(new ProductEntry("Hats",30,5.9));
    }
    public static ProductList getInstance() {return holder;}
    public static ProductEntry getInstanceValue(int i) {
        return getInstance().get().get(i);
    }
}