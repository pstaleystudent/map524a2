package com.example.a2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Restock extends AppCompatActivity {
    int selectedProductIndex = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("DEBUG","Test");
        setContentView(R.layout.activity_restock);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.restockCancel).setOnClickListener(v ->
                startActivity(new Intent(this, Manager.class)));
        ProductListAdapter adapter = new ProductListAdapter(this);
        ((ListView)findViewById(R.id.restockListView)).setAdapter(adapter);
        ((ListView)findViewById(R.id.restockListView)).setOnItemClickListener((parent, view, p, id) ->
            selectedProductIndex = (int)id);
        findViewById(R.id.restockOkay).setOnClickListener(v -> {
                attemptRestock(selectedProductIndex);
                adapter.notifyDataSetChanged();
        });
    }
    private void attemptRestock(int id) {
        int q;
        try {
            q = (Integer.parseInt(((EditText) findViewById(R.id.restockNumber)).getText().toString()));
        } catch (NumberFormatException e) {//this is probably not good practice
            Toast.makeText(getApplicationContext(), "Please enter a valid quantity", Toast.LENGTH_SHORT).show();
            return;
        }
        if (selectedProductIndex == -1)
            Toast.makeText(getApplicationContext(), "Please select a product", Toast.LENGTH_SHORT).show();
        else {
            ProductList.getInstanceValue(id).addQuantity(q);
            Toast.makeText(getApplicationContext(), "Quantity added!", Toast.LENGTH_SHORT).show();
        }
    }
}