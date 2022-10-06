package com.example.a2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class History extends AppCompatActivity implements HistoryListAdapter.ItemClickListener{
    HistoryListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.historyList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HistoryListAdapter(this);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        //HistoryListAdapter adapter = new HistoryListAdapter(this);
        //((RecyclerView)findViewById(R.id.historyList)).setAdapter(adapter);
        /*((RecyclerView)findViewById(R.id.historyList)).setOnItemClickListener((parent, view, p, id) -> {
            HistoryEntry he = HistoryList.getInstanceValue((int) id);
            //if u lose data from that cast it's on u
            Intent i = new Intent(this, HistoryDetail.class);
            i.putExtra("historyEntry", he);
            startActivity(i);
        });*/
    }
    @Override
    public void onItemClick(View view, int position) {
        HistoryEntry he = HistoryList.getInstanceValue((int) position);
        //if u lose data from that cast it's on u
        Intent i = new Intent(this, HistoryDetail.class);
        i.putExtra("historyEntry", he);
        startActivity(i);
    }
}