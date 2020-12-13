package com.papb.catunganx;

public class Bank {
    private String bankName;
    private String total;

    public Bank(String nameBank, String total) {
        this.bankName = nameBank;
        this.total = total;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
