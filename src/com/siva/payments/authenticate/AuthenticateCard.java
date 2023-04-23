package com.siva.payments.authenticate;

import com.siva.payments.card.Card;
import java.time.LocalDate;

public class AuthenticateCard {

  /*
  complete the functionality of Authenticating the card details
  1. check for card number and validate the number of digits (i.e) as what the usual debit card has - 16 digit
  2. check for expiration date (it should not an expired one) the date should be in future and present usage day
  3. check whether cvv contains only numerical digits and not other data types
   */

  public static boolean authentication(Card card) {
    boolean authenticity = false;
    if (card != null) {
      String cardNumber = card.getCardNumber();
      LocalDate expireDateCheck = card.getExpireDate();
      String cvv = card.getCvv();
      authenticity = authenticating(cardNumber, expireDateCheck, cvv);
      if ((authenticity)) {
        System.out.println("card is genuine proceeding with payment deduction");
      } else {
        /*
        provide println with failure message
         */
        System.out.println("Authentication Failed");
      }
    } else {
      System.out.println("please insert card....");
    }
    return authenticity;
  }

  private static boolean authenticating(String cardNumber, LocalDate expireDateCheck, String cvv) {
    System.out.println("Authentication of your card details is still in progress..");
    /*
    write logic to validate the card as per instruction mentioned above and return a boolean also let customer know the
    payment progress (success or failure) provide a println at end of process

    1. analyze about Date api. convert it into String and try to extract year,month and date and apply given logic for check
       do not use inbuild functions of Date.  surf google for analysis. do comparison with present date
     */

    // Validating the number of digits in the card (16 digits for being valid)
    boolean isValidNumber = cardNumber.matches("^[0-9]{16}$");

    if (!isValidNumber) {
      System.out.println("Your Card number is invalid");
    }

    // Validating expiration date
    String expirationDate = expireDateCheck.toString();
    int expirationYear = Integer.parseInt(expirationDate.substring(0, 4));
    int expirationMonth = Integer.parseInt(expirationDate.substring(5, 7));
    int expirationDay = Integer.parseInt(expirationDate.substring(8));

    LocalDate currDateCheck = LocalDate.now();
    String currDate = currDateCheck.toString();
    int currYear = Integer.parseInt(currDate.substring(0, 4));
    int currMonth = Integer.parseInt(currDate.substring(5, 7));
    int currDay = Integer.parseInt(currDate.substring(8));

    boolean isValidExpirationDate = true;

    if (currYear != expirationYear) {
      isValidExpirationDate = Integer.compare(currYear, expirationYear) == -1;

    } else if (currMonth != expirationMonth) {
      isValidExpirationDate = Integer.compare(currMonth, expirationMonth) == -1;
    } else if (currDay != expirationDay) {
      isValidExpirationDate = Integer.compare(currDay, expirationDay) == -1;
    }

    if (!isValidExpirationDate) {
      System.out.println("Your Card has been expired");
    }

    // Validating cvv for containing only numerical digits
    boolean isValidCVV = cvv.matches("^[0-9]+");
    if (!isValidCVV) {
      System.out.println("Your CVV is invalid");
    }

    return isValidNumber && isValidExpirationDate && isValidCVV;
  }
}
