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

public class SpendBank extends AppCompatActivity {

    Spinner bankSpinner;
    String label;
    EditText spendBankAmount;
    AppCompatButton back;
    AppCompatButton spendBankButton;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spend_bank);
        back=findViewById(R.id.back_button);
        bankSpinner=findViewById(R.id.spend_nama_bank);
        spendBankAmount=findViewById(R.id.spend_nominal_bank);
        spendBankButton=findViewById(R.id.submit_spend_bank);
        databaseHelper = new DatabaseHelper(this);

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

    public void spendBank(View view) {
        databaseHelper.addBankSpend(label, Integer.parseInt(spendBankAmount.getText().toString()));
        Intent intent = new Intent(SpendBank.this, MainActivity.class);
        Toast toast = Toast.makeText(this, "Pengeluaran berhasil ditambah!", Toast.LENGTH_LONG);
        toast.show();
        startActivity(intent);
        overridePendingTransition( R.anim.slide_in_left, R.anim.no_anim);
    }

    public void back(View view) {
        Intent intent = new Intent(SpendBank.this, SpendActivity.class);
        startActivity(intent);
        overridePendingTransition( R.anim.fade_in, R.anim.no_anim);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SpendBank.this, SpendActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.no_anim);
    }
}