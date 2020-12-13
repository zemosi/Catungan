package com.papb.catunganx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<History> values;
    private HistoryAdapter historyAdapter;
    AppCompatButton back;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        back=findViewById(R.id.back_button);
        recyclerView = findViewById(R.id.history_recycler);

        databaseHelper = new DatabaseHelper(this);

        values = databaseHelper.getHistory();


        historyAdapter = new HistoryAdapter(this, values);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(historyAdapter);

    }

    public void back(View view) {
        finish();
    }
}