package com.papb.catunganx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InputBank extends AppCompatActivity {

    EditText saveBankAmount;
    AppCompatButton saveBankButton;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_bank);
        saveBankAmount=findViewById(R.id.input_nominal_bank);
        saveBankButton=findViewById(R.id.submit_input_bank);
        databaseHelper=new DatabaseHelper(this);
    }

    public void saveBank(View view) {
        databaseHelper.addBank(Integer.parseInt(saveBankAmount.getText().toString()));
        Intent intent = new Intent(InputBank.this, MainActivity.class);
        Toast toast = Toast.makeText(this, "Pemasukan berhasil ditambah!", Toast.LENGTH_LONG);
        toast.show();
        startActivity(intent);
    }
}