package com.papb.catunganx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SpendActivity extends AppCompatActivity {

    AppCompatButton back;
    AppCompatButton cashButton;
    AppCompatButton bankButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spend);
        back=findViewById(R.id.back_button);
        cashButton=findViewById(R.id.cash_button_pengeluaran);
        bankButton=findViewById(R.id.bank_button_pengeluaran);

        cashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SpendActivity.this, SpendCash.class);
                startActivity(intent);
                overridePendingTransition( R.anim.fade_in, R.anim.no_anim);
            }
        });
        bankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SpendActivity.this, SpendBank.class);
                startActivity(intent);
                overridePendingTransition( R.anim.fade_in, R.anim.no_anim);
            }
        });
    }

    public void back(View view) {
        Intent intent = new Intent(SpendActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition( R.anim.slide_in_left, R.anim.no_anim);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SpendActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.no_anim);
    }
}