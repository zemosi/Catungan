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

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.Date;

import static java.time.LocalDate.*;

public class MainActivity extends AppCompatActivity {

    TextView total;
    TextView limit;
    TextView overLimit;
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
        limit=findViewById(R.id.limit_text);
        overLimit=findViewById(R.id.overlimit_text);
        totalButton=findViewById(R.id.total_button);
        saveButton=findViewById(R.id.save_button);
        spendButton=findViewById(R.id.spend_button);
        historyButton=findViewById(R.id.history_button);
        resetButton=findViewById(R.id.limit_button);

        databaseHelper=new DatabaseHelper(this);

        total.setText(databaseHelper.totalMoney());

        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(0);
        format.setCurrency(Currency.getInstance("IDR"));

        if (LimitActivity.LIMIT_INDICATOR == 1){
            if (LimitActivity.SPEND_AMOUNT <= LimitActivity.LIMIT_AMOUNT){
                limit.setVisibility(View.VISIBLE);
                limit.setText("Batas pengeluaran Anda\n" +
                        String.valueOf(format.format(LimitActivity.SPEND_AMOUNT)) +
                        " / " +
                        String.valueOf(format.format(LimitActivity.LIMIT_AMOUNT)));
            } else  {
                overLimit.setVisibility(View.VISIBLE);
                overLimit.setText("Pengeluaran Anda melebihi batas\n" +
                        String.valueOf(format.format(LimitActivity.LIMIT_AMOUNT)));
            }
        }

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


    public void openSettings(View view) {
        Intent intent = new Intent(MainActivity.this, LimitActivity.class);
        startActivity(intent);
        overridePendingTransition( R.anim.slide_in_right, R.anim.no_anim);
    }

    @Override
    public void onBackPressed(){
        finishAffinity();
    }
}