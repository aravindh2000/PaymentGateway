package com.siva.payments;

import com.siva.payments.authenticate.AuthenticateCard;
import com.siva.payments.bank.ClientAccount;
import com.siva.payments.bank.MerchantAccount;
import com.siva.payments.card.Card;
import com.siva.payments.makepayment.EncryptData;
import com.siva.payments.makepayment.PaymentProcessing;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;


/*
     Author : Aravindh Siva Shanmugam
 */
public class Main {

    public static void main(String[] args) {
	// write your code here

        Card[] cardInMyWallet = new Card[]{new Card("SBI-card","visa","2525000024214318","Ram","001",LocalDate.now().plusMonths(12)),
                new Card("KVB-card","mastercard","2697390455165704","Ram","255",LocalDate.now().plusMonths(24)),
                new Card("IOB-card","mastercard","2563900402126854","102","Ram",LocalDate.now().plusMonths(6))};
        boolean flag = true;
        boolean auth = false,paymentStatus=false;
        int i;
        PaymentProcessing paymentProcessing = new PaymentProcessing();
        ClientAccount clientAccount = new ClientAccount("SBI","Ram","123456723401",new BigDecimal("58639.03"));
        clientAccount.setCard(cardInMyWallet);
        MerchantAccount merchantAccount = new MerchantAccount("IOB","Ravi","123000723401",new BigDecimal("68639.03"));
        Card encrypted = null;
        while(flag)
        {
            System.out.println("please insert your card for transaction....");
            System.out.println("cards in your wallet : [SBI,KVB,IOB] provide respective card name to proceed");
            String cardName = new Scanner(System.in).nextLine();
            for( i=0;i<cardInMyWallet.length;i++)
            {
                if(cardInMyWallet[i].getCardIssuer().replace("-card","").equalsIgnoreCase(cardName))
                {
                    System.out.println("your card is inserted and authentication started successfully");
                    auth = AuthenticateCard.authentication(cardInMyWallet[i]);
                    break;
                }
            }
            if (auth)
            {
               encrypted = EncryptData.encryptedData(cardInMyWallet[i]);
                System.out.println("Card details are encrypted ready for transaction");
            }
            if (encrypted!=null)
            {
              paymentStatus = paymentProcessing.processPayment(encrypted,clientAccount,merchantAccount);
            }
            if (paymentStatus)
            {
                paymentProcessing.displayStatus();
            }
            System.out.println("Press 1 to quit");
            flag = (new Scanner(System.in).nextLine().equals("1"))?false:true;
        }



    }



}
