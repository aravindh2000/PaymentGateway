package com.siva.payments.makepayment;

import com.siva.payments.bank.ClientAccount;
import com.siva.payments.bank.MerchantAccount;
import com.siva.payments.card.Card;

import java.math.BigDecimal;
import java.util.Scanner;

public class PaymentProcessing {

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public MerchantAccount getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(MerchantAccount merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    BigDecimal amount;
     MerchantAccount merchantAccount;


   static PaymentProcessing paymentProcessing =new PaymentProcessing();

    public  boolean processPayment(Card card, ClientAccount clientAccount, MerchantAccount merchantAccount)
    {
        merchantAccount = merchantAccount;
        boolean status =false;
        for (int i=0;i<clientAccount.getCard().length;i++)
        {
            Card c = clientAccount.getCard()[i];
            if(clientAccount.getCard()[i]==card)
            {
                String amountToBeDeducted = new Scanner(System.in).nextLine();
                 amount = new BigDecimal(amountToBeDeducted);
                BigDecimal beforeDeduct = clientAccount.getBalanceAmount();
                clientAccount.deduct(amount);
                status = (clientAccount.getBalanceAmount().add(amount)==beforeDeduct)?true:false;
                merchantAccount.setBalanceAmount(merchantAccount.getBalanceAmount().add(amount));
                paymentProcessing.setAmount(amount);
                paymentProcessing.setMerchantAccount(merchantAccount);
            }
        }

       return status;
    }


    public  String displayStatus() {
        return "Payment Summary : \n" +
                "  Sum of "+ this.amount+" is successfully transferred to "+merchantAccount.getNameOfAccountHolder();
    }

}
