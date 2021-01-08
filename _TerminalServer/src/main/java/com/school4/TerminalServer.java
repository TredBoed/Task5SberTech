package com.school4;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;


class WithdrawMinimumException extends Exception {
    public WithdrawMinimumException() {

    }

    public WithdrawMinimumException(String message) {
        super(message);
    }

    public WithdrawMinimumException(Throwable cause) {
        super(cause);
    }

    public WithdrawMinimumException(String message, Throwable cause) {
        super(message, cause);
    }

}



public class TerminalServer {

    private Bill userBill;

    public TerminalServer(String userId, String userPin) {
        CreateBill(userId, userPin);
    }

    public void CreateBill(String userId, String userPin) {
        //you can not create it here, in bank only
        //this is example without database
        this.userBill = new Bill();
        userBill.CreateBill(userId, userPin);
    }

    public boolean IsAccessToBill(String userId, String userPin) {
        if (this.userBill.getUserPin().equals(userPin) &&
                this.userBill.getUserId().equals(userId)) {
            return true;
        }
        return false;
    }

    public void DepositCurrency(BigDecimal currency) {
        this.userBill.setAmount(this.userBill.getAmount().add(currency));
    }

    public void WithdrawCurrency(BigDecimal currency) {
        if(CheckBalance().equals(new BigDecimal(0)))
        {
            try
            {
               throw new WithdrawMinimumException("Not enough money to withdraw: zero balance");
            }
            catch (WithdrawMinimumException e)
            {
               System.out.println(e.getMessage());
            }

        }
        else {
            this.userBill.setAmount(this.userBill.getAmount().subtract(currency));
        }
    }

    public BigDecimal CheckBalance() {
        return this.userBill.getAmount();
    }

}
