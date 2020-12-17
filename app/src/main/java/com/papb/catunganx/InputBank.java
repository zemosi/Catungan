package com.papb.catunganx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class InputBank extends AppCompatActivity {

    Spinner bankSpinner;
    String label;
    EditText saveBankAmount;
    AppCompatButton back;
    AppCompatButton saveBankButton;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_bank);
        back=findViewById(R.id.back_button);
        bankSpinner=findViewById(R.id.input_nama_bank);
        saveBankAmount=findViewById(R.id.input_nominal_bank);
        saveBankButton=findViewById(R.id.submit_input_bank);
        databaseHelper=new DatabaseHelper(this);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.bank,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if(bankSpinner!=null){
            bankSpinner.setAdapter(adapter);

            bankSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    label=adapterView.getItemAtPosition(i).toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    public void saveBank(View view) {
        databaseHelper.addBank(label, Integer.parseInt(saveBankAmount.getText().toString()));
        Intent intent = new Intent(InputBank.this, MainActivity.class);
        Toast toast = Toast.makeText(this, "Pemasukan berhasil ditambah!", Toast.LENGTH_LONG);
        toast.show();
        startActivity(intent);
        overridePendingTransition( R.anim.slide_in_left, R.anim.no_anim);
    }

    public void back(View view) {
        Intent intent = new Intent(InputBank.this, SaveActivity.class);
        startActivity(intent);
        overridePendingTransition( R.anim.fade_in, R.anim.no_anim);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(InputBank.this, SaveActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.no_anim);
    }
}