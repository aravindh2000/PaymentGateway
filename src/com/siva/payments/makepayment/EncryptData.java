package com.siva.payments.makepayment;

import com.siva.payments.card.Card;

import java.time.LocalDate;

public class EncryptData {


    public static Card encryptedData(Card card)
    {
        String cardNumber = card.getCardNumber();
        String cvv = card.getCvv();
        String cardHolderName = card.getCardHolderName();
        int p=(int)(Math.random()*10),q=(int)(Math.random()*10); //p and q will be assigned with random number if you run the program just check
        //for prime
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
        Card c = new Card("SBI-card","visa","2525000024214318","Ram","001", LocalDate.now().plusMonths(12));
        c.setKey(5);
   return c;
    }




}
