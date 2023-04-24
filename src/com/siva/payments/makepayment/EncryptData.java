package com.siva.payments.makepayment;

import com.siva.payments.card.Card;
import java.math.BigInteger;
import java.util.Random;

public class EncryptData {

  public static Card encryptedData(Card card) {
    String cardNumber = card.getCardNumber();
    String cvv = card.getCvv();
    String cardHolderName = card.getCardHolderName();
    // int p=(int)(Math.random()*10),q=(int)(Math.random()*10); //p and q will be assigned with
    // random number if you run the program just check
    // for prime
    /*
    write logic to encrypt card

    procedure :
    ->  generate a public key :
    *take any two prime numbers and find their product save it in a variable
    *say p and q are prime  n = p*q
    * calculate f(n) = (p-1)*(q-1)
    select a value say "e" between 1 and f(n) and gcd(f(n),e) should be equal to one. both condition should be satisfied

     iterate through each character of string if it is number just add e to it and append
     if it is String then get get its ascii value then add it with e do the same for entire string

     after encrypting set key value in card object and return it

     */
    BigInteger p = BigInteger.probablePrime(6, new Random());
    BigInteger q = BigInteger.probablePrime(6, new Random());

    BigInteger fn = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

    BigInteger e;
    do {
      e = BigInteger.probablePrime(5, new Random());
    } while (fn.gcd(e).intValue() != 1);

    StringBuilder encryptedCardNumber = new StringBuilder(cardNumber.length() * 2);
    for (char c : cardNumber.toCharArray()) {
      encryptedCardNumber.append((int) (Character.getNumericValue(c) + e.intValue()));
    }

    StringBuilder encryptedCVV = new StringBuilder(cvv.length() * 2);
    for (char c : cvv.toCharArray()) {
      encryptedCVV.append((int) (Character.getNumericValue(c) + e.intValue()));
    }

    StringBuilder encryptedCardHolderName = new StringBuilder();
    for (char c : cardHolderName.toCharArray()) {
      encryptedCardHolderName.append((char) (c + e.intValue()));
    }

    Card c =
        new Card(
            card.getCardIssuer(),
            card.getCardType(),
            encryptedCardNumber.toString(),
            encryptedCardHolderName.toString(),
            encryptedCVV.toString(),
            card.getExpireDate());
    c.setKey(e.intValue());
    return c;
  }
}
