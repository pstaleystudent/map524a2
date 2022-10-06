package com.example.a2;

import java.util.ArrayList;

public class HistoryList {
    private ArrayList<HistoryEntry> dat;
    public ArrayList<HistoryEntry> get() {
        return dat;
    }
    public void set(ArrayList<HistoryEntry> d) {
        this.dat = d;
    }
    private static final HistoryList holder = new HistoryList();
    public static void init() {
        holder.set(new ArrayList<>());
    }
    public static HistoryList getInstance() {return holder;}
    public static HistoryEntry getInstanceValue(int i) {
        return getInstance().get().get(i);
    }
    public static void addInstanced(HistoryEntry a) {
        getInstance().get().add(a);
    }
}