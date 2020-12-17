package com.papb.catunganx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class TotalActivity extends AppCompatActivity {

    AppCompatButton back;
    TextView totalMoney;
    TextView totalCash;
    TextView totalBank;
    private RecyclerView recyclerView;
    private ArrayList<Bank> values;
    private BankAdapter bankAdapter;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        back=findViewById(R.id.back_button);
        totalMoney=findViewById(R.id.jumlah_uang);
        totalCash=findViewById(R.id.total_cash);
        totalBank=findViewById(R.id.total_bank);

        databaseHelper=new DatabaseHelper(this);

        totalMoney.setText(databaseHelper.totalMoney());
        totalCash.setText(databaseHelper.totalCash());
        totalBank.setText(databaseHelper.totalBank());

        recyclerView = findViewById(R.id.bank_list);

        databaseHelper = new DatabaseHelper(this);

        values = new ArrayList<>();
        addBank();

        bankAdapter = new BankAdapter(this, values);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(bankAdapter);

    }

    void addBank() {
        String bank[] = {"BCA", "BNI", "BRI", "Mandiri", "Lain-lain"};

        for (String i : bank) {
            if (databaseHelper.bankChecker(i)!=0){
                values.add(new Bank(i, databaseHelper.bankAmount(i)));
            }
        }
    }


    public void back(View view) {
        Intent intent = new Intent(TotalActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition( R.anim.slide_in_left, R.anim.no_anim);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(TotalActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition( R.anim.slide_in_left, R.anim.no_anim);
    }

}