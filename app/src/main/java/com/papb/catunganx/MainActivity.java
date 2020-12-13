package com.papb.catunganx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView total;
    AppCompatButton totalButton;
    AppCompatButton saveButton;
    AppCompatButton spendButton;
    AppCompatButton historyButton;
    AppCompatButton resetButton;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        total=findViewById(R.id.text_uangTotal);
        totalButton=findViewById(R.id.total_button);
        saveButton=findViewById(R.id.save_button);
        spendButton=findViewById(R.id.spend_button);
        historyButton=findViewById(R.id.history_button);
        resetButton=findViewById(R.id.limit_button);

        databaseHelper=new DatabaseHelper(this);

        total.setText(databaseHelper.totalMoney());

        totalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TotalActivity.class);
                startActivity(intent);
                overridePendingTransition( R.anim.slide_in_right, R.anim.no_anim);
            }
        });
        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TotalActivity.class);
                startActivity(intent);
                overridePendingTransition( R.anim.slide_in_right, R.anim.no_anim);
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SaveActivity.class);
                startActivity(intent);
                overridePendingTransition( R.anim.slide_in_right, R.anim.no_anim);
            }
        });
        spendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SpendActivity.class);
                startActivity(intent);
                overridePendingTransition( R.anim.slide_in_right, R.anim.no_anim);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        total.setText(databaseHelper.totalMoney());
    }

    public void openHistory(View view) {
        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
        startActivity(intent);
        overridePendingTransition( R.anim.slide_in_right, R.anim.no_anim);
    }

    public void resetAll(View view) {
        showConfirmReset();

    }

    private void showConfirmReset(){
        new AlertDialog.Builder(this)
                .setTitle("Reset Catatan")
                .setMessage("Anda yakin ingin menghapus catatan?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        databaseHelper.resetMoney();
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }).setNegativeButton("Tidak", null)
                .show();
    }
}