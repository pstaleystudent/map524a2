package com.example.a2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;

public class HistoryDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        HistoryEntry entry = intent.getExtras().getParcelable("historyEntry");
        ((TextView)findViewById(R.id.historyDetailName)).setText(getString(R.string.historyProduct,entry.getName()));
        ((TextView)findViewById(R.id.historyDetailPrice)).setText(getString(R.string.historyPrice,entry.getPrice()));
        String strDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(entry.getDate());
        ((TextView)findViewById(R.id.historyDetailDate)).setText(getString(R.string.historyDate,strDate));
    }
}