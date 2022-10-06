package com.example.a2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    int selectedProductIndex = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button managerButton = (Button) findViewById(R.id.managerButton);
        NumberPicker quantityPicker = (NumberPicker) findViewById(R.id.quantityPicker);
        Button buyButton = (Button) findViewById(R.id.buyButton);
        ListView productList = (ListView) findViewById(R.id.productList);
        TextView qView = (TextView) findViewById(R.id.quantityText);
        TextView pView = (TextView) findViewById(R.id.prodTypeText);
        TextView tView = (TextView) findViewById(R.id.totalText);

        ProductListAdapter adapter = new ProductListAdapter(this);
        productList.setAdapter(adapter);

        managerButton.setOnClickListener(v ->
                startActivity(new Intent(this, Manager.class)));
        buyButton.setOnClickListener(v -> {
            buyProductIndex(selectedProductIndex,quantityPicker.getValue(),buyButton);
            adapter.notifyDataSetChanged();
        });
        quantityPicker.setMaxValue(100);
        quantityPicker.setMinValue(1);
        qView.setText("1"); //always starts as one
        quantityPicker.setOnValueChangedListener((picker, oldVal, newVal) -> {
                qView.setText(Integer.toString(newVal));
                if (selectedProductIndex != -1)
                    tView.setText(getString(R.string.dollarValue,
                            ProductList.getInstanceValue(selectedProductIndex).getPrice() * quantityPicker.getValue()));
        });
        productList.setOnItemClickListener((parent, view, p, id) -> {
            pView.setText(ProductList.getInstanceValue((int)id).getName());
            selectedProductIndex = (int)id;
            tView.setText(getString(R.string.dollarValue,
                    ProductList.getInstanceValue(selectedProductIndex).getPrice() * quantityPicker.getValue()));
        });
    }
    void buyProductIndex(int index, int q, View v) {
        if (index == -1) {
            Toast.makeText(getApplicationContext(), "All fields are required.", Toast.LENGTH_SHORT).show();
            return;
        }
        ProductEntry entry = ProductList.getInstanceValue(index);
        if (q > entry.getQuantity())
            Toast.makeText(getApplicationContext(), "Not enough items in stock!", Toast.LENGTH_SHORT).show();
        else {
            HistoryList.addInstanced(new HistoryEntry(entry.getName(), q, entry.getPrice() * q, Calendar.getInstance().getTime()));
            ProductList.getInstanceValue(index).removeQuantity(q);
            showPopup(v, entry.getName(),q);
        }
    }
    public void showPopup(View view, String name, int q) {
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null); //studio don't like this
        int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
        final PopupWindow popup = new PopupWindow(popupView, wrapContent, wrapContent, true);
        popup.showAtLocation(view, Gravity.CENTER, 0, 0);
        popupView.setOnClickListener(v ->
                popup.dismiss());
        ((TextView) popupView.findViewById(R.id.popupText)).setText(getString(R.string.thankyou,q,name));
    }
}