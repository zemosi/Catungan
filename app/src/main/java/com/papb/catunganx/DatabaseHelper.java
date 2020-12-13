package com.papb.catunganx;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Map;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME ="catungan";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_TYPES =
            "CREATE TABLE types (\n" +
                    "    type_id INTEGER PRIMARY KEY,\n" +
                    "    type    VARCHAR\n" +
                    ");\n";
    private static final String INSERT_TABLE_TYPES =
            "INSERT INTO types (type_id,type) VALUES (1,'Cash'),(2,'Bank')";
    private static final String CREATE_TABLE_MONEYS =
            "CREATE TABLE moneys (\n" +
                    "    money_id     INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    amount INTEGER,\n" +
                    "    date   DATETIME DEFAULT (datetime('now', 'localtime')),\n" +
                    "    type   INTEGER REFERENCES types (type_id), \n" +
                    "    bank   VARCHAR\n" +
                    ");\n";



    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_TYPES);
        sqLiteDatabase.execSQL(INSERT_TABLE_TYPES);
        sqLiteDatabase.execSQL(CREATE_TABLE_MONEYS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS 'types'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS 'moneys'");
        onCreate(sqLiteDatabase);
    }

    public void resetMoney() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS 'types'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS 'moneys'");
        onCreate(sqLiteDatabase);
    }

    public long addCash(Integer nominal) {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("amount", nominal);
        values.put("type", 1);
        long insert = db.insert("moneys", null, values);
        return insert;
    }

    public long addBank(String bank, Integer nominal) {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("amount", nominal);
        values.put("type", 2);
        values.put("bank", bank);
        long insert = db.insert("moneys", null, values);
        return insert;
    }

    public long addCashSpend(Integer nominal) {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("amount", -nominal);
        values.put("type", 1);
        long insert = db.insert("moneys", null, values);
        return insert;
    }

    public long addBankSpend(String bank, Integer nominal) {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("amount", -nominal);
        values.put("type", 2);
        values.put("bank", bank);
        long insert = db.insert("moneys", null, values);
        return insert;
    }

    public String  totalMoney(){
        String  totalMoney = "";
        int total = 0;

        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(0);
        format.setCurrency(Currency.getInstance("IDR"));

        String SELECT_TOTAL_MONEY =
                "SELECT SUM(amount) AS 'totalMoney'" +
                        "FROM 'moneys'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(SELECT_TOTAL_MONEY,null);

        if (c.moveToFirst()){
            total = c.getInt(c.getColumnIndex("totalMoney"));
            totalMoney = String.valueOf(format.format(total));
        }

        return totalMoney;
    }

    public String  totalCash(){
        String  totalCash = "";
        int total = 0;

        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(0);
        format.setCurrency(Currency.getInstance("IDR"));

        String SELECT_TOTAL_CASH =
                "SELECT SUM(amount) AS 'totalCash'" +
                "FROM 'moneys'" +
                "WHERE moneys.type == 1 ";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(SELECT_TOTAL_CASH,null);

        if (c.moveToFirst()){
            total = c.getInt(c.getColumnIndex("totalCash"));
            totalCash = String.valueOf(format.format(total));
        }

        return totalCash;
    }

    public String  totalBank(){
        String  totalBank = "";
        int total = 0;

        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(0);
        format.setCurrency(Currency.getInstance("IDR"));

        String SELECT_TOTAL_BANK =
                "SELECT SUM(amount) AS 'totalBank'" +
                        "FROM 'moneys'" +
                        "WHERE moneys.type == 2 ";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(SELECT_TOTAL_BANK,null);

        if (c.moveToFirst()){
            total = c.getInt(c.getColumnIndex("totalBank"));
            totalBank = String.valueOf(format.format(total));
        }

        return totalBank;
    }

    public int bankChecker(String bank){
        int bankAmount = 0;

        String SELECT_BANK_AMOUNT =
                "SELECT SUM(amount) AS 'bankAmount'" +
                        "FROM 'moneys'" +
                        "WHERE moneys.bank == '"+bank+"'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(SELECT_BANK_AMOUNT,null);

        if (c.moveToFirst()){
            bankAmount = c.getInt(c.getColumnIndex("bankAmount"));
        }

        return bankAmount;
    }

    public String bankAmount(String bank){
        String  bankAmount = "";
        int total = 0;

        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(0);
        format.setCurrency(Currency.getInstance("IDR"));

        String SELECT_BANK_AMOUNT =
                "SELECT SUM(amount) AS 'bankAmount'" +
                        "FROM 'moneys'" +
                        "WHERE moneys.bank == '"+bank+"'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(SELECT_BANK_AMOUNT,null);

        if (c.moveToFirst()){
            total = c.getInt(c.getColumnIndex("bankAmount"));
            bankAmount = String.valueOf(format.format(total));
        }

        return bankAmount;
    }


    public ArrayList<History> getHistory() {
        String method = "";
        String amount = "";
        String date = "";

        ArrayList<History> historyList = new ArrayList<>();

        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(0);
        format.setCurrency(Currency.getInstance("IDR"));

        String SELECT_ALL =
                "SELECT * " +
                        "FROM 'moneys' " +
                        "ORDER BY 'money_id' DESC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(SELECT_ALL, null);
        for (c.moveToLast(); !c.isBeforeFirst(); c.moveToPrevious()) {
            if (c.getInt(c.getColumnIndex("type"))==1){
                method = "Cash";
            } else {
                method = "Bank "+c.getString(c.getColumnIndex("bank"));
            }
            if (c.getInt(c.getColumnIndex("amount"))>0){
                amount = "+"+String.valueOf(format.format(c.getInt(c.getColumnIndex("amount"))));
            } else {
                amount = "-"+String.valueOf(format.format(c.getInt(c.getColumnIndex("amount"))));
            }

            date = c.getString(c.getColumnIndex("date"));
            historyList.add(new History(method,amount,date));
        }

        return historyList;
    }
}
