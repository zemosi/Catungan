package com.papb.catunganx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<History> values;
    private HistoryAdapter historyAdapter;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        recyclerView = findViewById(R.id.history_recycler);

        databaseHelper = new DatabaseHelper(this);

        values = databaseHelper.getHistory();


        historyAdapter = new HistoryAdapter(this, values);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(historyAdapter);

    }

    private void addValue() {
        values.add(new History("Cash", "20000", "12/12/2020"));
        values.add(new History("Cash", "20000", "12/12/2020"));
        values.add(new History("Cash", "20000", "12/12/2020"));
        values.add(new History("Cash", "20000", "12/12/2020"));
        values.add(new History("Cash", "20000", "12/12/2020"));
        values.add(new History("Cash", "20000", "12/12/2020"));
    }


}