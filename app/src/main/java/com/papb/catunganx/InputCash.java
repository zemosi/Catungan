package com.papb.catunganx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.contentcapture.DataShareWriteAdapter;
import android.widget.EditText;
import android.widget.Toast;

public class InputCash extends AppCompatActivity {

    AppCompatButton back;
    EditText saveCashAmount;
    AppCompatButton saveCashButton;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_cash);
        back=findViewById(R.id.back_button);
        saveCashAmount=findViewById(R.id.input_nominal_cash);
        saveCashButton=findViewById(R.id.submit_input_cash);
        databaseHelper=new DatabaseHelper(this);
    }

    public void saveCash(View view) {
        databaseHelper.addCash(Integer.parseInt(saveCashAmount.getText().toString()));
        Intent intent = new Intent(InputCash.this, MainActivity.class);
        Toast toast = Toast.makeText(this, "Pemasukan berhasil ditambah!", Toast.LENGTH_LONG);
        toast.show();
        startActivity(intent);
        overridePendingTransition( R.anim.slide_in_left, R.anim.no_anim);
    }

    public void back(View view) {
        Intent intent = new Intent(InputCash.this, SaveActivity.class);
        startActivity(intent);
        overridePendingTransition( R.anim.fade_in, R.anim.no_anim);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(InputCash.this, SaveActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.no_anim);
    }
}