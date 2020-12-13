package com.papb.catunganx;

public class History {
    private String method;
    private String amount;
    private String date;

    public History(String method, String amount, String date) {
        this.method = method;
        this.amount = amount;
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
