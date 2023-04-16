package com.siva.payments.card;
import java.time.LocalDate;


public class Card
{
    private String cardIssuer;
    private String cardType;
    private String cardNumber;
    private String cardHolderName;
    private String cvv;
    private LocalDate expireDate;
   private int key;
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }


    public Card(){}
    public Card(String cardIssuer, String cardType, String cardNumber, String cardHolderName, String cvv, LocalDate expireDate) {
        this.cardIssuer = cardIssuer;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
        this.expireDate = expireDate;

    }

    public String getCardIssuer() {
        return cardIssuer;
    }

    public void setCardIssuer(String cardIssuer) {
        this.cardIssuer = cardIssuer;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }
}
