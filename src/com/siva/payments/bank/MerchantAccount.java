package com.siva.payments.bank;

import java.math.BigDecimal;

public class MerchantAccount extends Bank {
    public MerchantAccount(String nameOfBank, String nameOfAccountHolder, String accountNumber, BigDecimal balanceAmount) {
        super(nameOfBank, nameOfAccountHolder, accountNumber, balanceAmount);
    }
}
