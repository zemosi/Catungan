package com.papb.catunganx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.contentcapture.DataShareWriteAdapter;
import android.widget.EditText;

public class InputCash extends AppCompatActivity {

    EditText saveCashAmount;
    AppCompatButton saveCashButton;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_cash);
        saveCashAmount=findViewById(R.id.input_nominal_cash);
        saveCashButton=findViewById(R.id.submit_input_cash);
        databaseHelper=new DatabaseHelper(this);
    }

    public void saveCash(View view) {
        databaseHelper.addCash(Integer.parseInt(saveCashAmount.getText().toString()));
        Intent intent = new Intent(InputCash.this, MainActivity.class);
        startActivity(intent);
    }

}