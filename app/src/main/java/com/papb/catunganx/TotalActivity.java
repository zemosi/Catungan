package com.papb.catunganx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TotalActivity extends AppCompatActivity {

    TextView totalMoney;
    TextView totalCash;
    TextView totalBank;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        totalMoney=findViewById(R.id.jumlah_uang);
        totalCash=findViewById(R.id.total_cash);
        totalBank=findViewById(R.id.total_bank);

        databaseHelper=new DatabaseHelper(this);

        totalMoney.setText(databaseHelper.totalMoney());
        totalCash.setText(databaseHelper.totalCash());
        totalBank.setText(databaseHelper.totalBank());


    }
}