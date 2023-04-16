package com.siva.payments.bank;

import com.siva.payments.card.Card;

import java.math.BigDecimal;

public class ClientAccount extends Bank{


    private Card[] card;

    public Card[] getCard() {
        return card;
    }

    public void setCard(Card[] card) {
        this.card= card;
    }


    public ClientAccount(String nameOfBank, String nameOfAccountHolder, String accountNumber, BigDecimal balanceAmount) {
        super(nameOfBank, nameOfAccountHolder, accountNumber, balanceAmount);
    }

    public  void deduct(BigDecimal amt)
    {
        this.setBalanceAmount(this.getBalanceAmount().subtract(amt));
    }



}
