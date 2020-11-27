package com.papb.catunganx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SaveActivity extends AppCompatActivity {

    AppCompatButton cashButton;
    AppCompatButton bankButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        cashButton=findViewById(R.id.cash_button_pemasukan);
        bankButton=findViewById(R.id.bank_button_pemasukan);

        cashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SaveActivity.this, InputCash.class);
                startActivity(intent);
            }
        });
        bankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SaveActivity.this, InputBank.class);
                startActivity(intent);
            }
        });
    }
}