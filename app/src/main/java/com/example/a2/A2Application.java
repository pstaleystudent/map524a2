package com.example.a2;

import android.app.Application;

public class A2Application extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HistoryList.init();
        ProductList.init();
    }
}