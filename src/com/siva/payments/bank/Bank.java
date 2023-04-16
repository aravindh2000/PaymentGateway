package com.siva.payments.bank;

import java.math.BigDecimal;

public class Bank {
    private String nameOfBank;
    private String nameOfAccountHolder;
    private String accountNumber;

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    private BigDecimal balanceAmount;


    public String getNameOfBank() {
        return nameOfBank;
    }

    public void setNameOfBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

    public String getNameOfAccountHolder() {
        return nameOfAccountHolder;
    }

    public void setNameOfAccountHolder(String nameOfAccountHolder) {
        this.nameOfAccountHolder = nameOfAccountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Bank(String nameOfBank, String nameOfAccountHolder, String accountNumber,BigDecimal balanceAmount) {
        this.nameOfBank = nameOfBank;
        this.nameOfAccountHolder = nameOfAccountHolder;
        this.accountNumber = accountNumber;
        this.balanceAmount = balanceAmount;
    }
}
