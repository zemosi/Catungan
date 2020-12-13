package com.papb.catunganx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SpendCash extends AppCompatActivity {

    EditText spendCashAmount;
    AppCompatButton back;
    AppCompatButton spendCashButton;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spend_cash);
        back=findViewById(R.id.back_button);
        spendCashAmount=findViewById(R.id.spend_nominal_cash);
        spendCashButton=findViewById(R.id.submit_spend_cash);
        databaseHelper = new DatabaseHelper(this);
    }

    public void spendCash(View view) {
        databaseHelper.addCashSpend(Integer.parseInt(spendCashAmount.getText().toString()));
        Intent intent = new Intent(SpendCash.this, MainActivity.class);
        Toast toast = Toast.makeText(this, "Pengeluaran berhasil ditambah!", Toast.LENGTH_LONG);
        toast.show();
        startActivity(intent);
    }

    public void back(View view) {
        finish();
    }
}