package com.papb.catunganx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView total;
    AppCompatButton totalButton;
    AppCompatButton saveButton;
    AppCompatButton spendButton;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        total=findViewById(R.id.text_uangTotal);
        totalButton=findViewById(R.id.total_button);
        saveButton=findViewById(R.id.save_button);
        spendButton=findViewById(R.id.spend_button);

        databaseHelper=new DatabaseHelper(this);

        total.setText(databaseHelper.totalMoney());

        totalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TotalActivity.class);
                startActivity(intent);
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SaveActivity.class);
                startActivity(intent);
            }
        });
        spendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SpendActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        total.setText(databaseHelper.totalMoney());
    }
}