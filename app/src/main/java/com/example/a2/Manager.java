package com.example.a2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Manager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.historyButton).setOnClickListener(v ->
                startActivity(new Intent(this, History.class)));
        findViewById(R.id.restockButton).setOnClickListener(v ->
                startActivity(new Intent(this, Restock.class)));
    }
}