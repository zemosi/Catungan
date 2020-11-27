package com.papb.catunganx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SpendBank extends AppCompatActivity {

    EditText spendBankAmount;
    AppCompatButton spendBankButton;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spend_bank);
        spendBankAmount=findViewById(R.id.spend_nominal_bank);
        spendBankButton=findViewById(R.id.submit_spend_bank);
        databaseHelper = new DatabaseHelper(this);
    }

    public void spendBank(View view) {
        databaseHelper.addBankSpend(Integer.parseInt(spendBankAmount.getText().toString()));
        Intent intent = new Intent(SpendBank.this, MainActivity.class);
        startActivity(intent);
    }
}