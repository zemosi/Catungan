package com.papb.catunganx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LimitActivity extends AppCompatActivity {

    AppCompatButton back;
    AppCompatButton reset;
    AppCompatButton addLimit;
    AppCompatButton resetLimit;
    EditText limitAmount;
    DatabaseHelper databaseHelper;

    static int LIMIT_INDICATOR = 0;
    static int LIMIT_AMOUNT = 0;
    static int SPEND_AMOUNT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limit);
        back=findViewById(R.id.back_button);
        reset=findViewById(R.id.reset_all);
        resetLimit=findViewById(R.id.reset_limit);
        addLimit=findViewById(R.id.add_limit_button);
        limitAmount=findViewById(R.id.limit_amount);

        databaseHelper = new DatabaseHelper(this);

        if (LIMIT_INDICATOR == 1){
            resetLimit.setVisibility(View.VISIBLE);
        }
    }

    public void resetAll(View view) {
        showConfirmReset();
    }

    private void showConfirmReset(){
        new AlertDialog.Builder(this)
                .setTitle("Reset Catatan")
                .setMessage("Anda yakin ingin menghapus catatan?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        databaseHelper.resetMoney();
                        Intent intent = new Intent(LimitActivity.this, MainActivity.class);
                        startActivity(intent);
                        overridePendingTransition( R.anim.slide_in_left, R.anim.no_anim);
                    }
                }).setNegativeButton("Tidak", null)
                .show();
    }

    public void resetLimit(View view) {
        showConfirmResetLimit();
    }

    private void showConfirmResetLimit(){
        new AlertDialog.Builder(this)
                .setTitle("Hapus Batas Pengeluaran")
                .setMessage("Anda yakin ingin menghapus batas pengeluaran?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LIMIT_INDICATOR = 0;
                        LIMIT_AMOUNT = 0;
                        SPEND_AMOUNT = 0;
                        Intent intent = new Intent(LimitActivity.this, MainActivity.class);
                        startActivity(intent);
                        overridePendingTransition( R.anim.slide_in_left, R.anim.no_anim);
                    }
                }).setNegativeButton("Tidak", null)
                .show();
    }

    public void addLimit(View view) {
        LIMIT_INDICATOR = 1;
        LIMIT_AMOUNT = Integer.parseInt(limitAmount.getText().toString());
        Intent intent = new Intent(LimitActivity.this, MainActivity.class);
        Toast toast = Toast.makeText(this, "Limit berhasil ditambah!", Toast.LENGTH_LONG);
        toast.show();
        startActivity(intent);
        overridePendingTransition( R.anim.slide_in_left, R.anim.no_anim);
    }

    public static void addSpendAmount(int amount){
        SPEND_AMOUNT = SPEND_AMOUNT + amount;
    }

    public void back(View view) {
        Intent intent = new Intent(LimitActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition( R.anim.slide_in_left, R.anim.no_anim);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LimitActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition( R.anim.slide_in_left, R.anim.no_anim);
    }



}