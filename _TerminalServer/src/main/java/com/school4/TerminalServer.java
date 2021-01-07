package com.school4;

import java.math.BigDecimal;

public class TerminalServer {

    private Bill userBill;

    public TerminalServer(Integer userId, Integer userPin) {
        CreateBill(userId, userPin);
    }

    public void CreateBill(Integer userId, Integer userPin) {
        //you can not create it here, in bank only
        //this is example without database
        this.userBill = new Bill();
        userBill.CreateBill(userId, userPin);
    }

    public boolean IsAccessToBill(Integer userId, Integer userPin) {
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
        this.userBill.setAmount(this.userBill.getAmount().subtract(currency));
    }

    public BigDecimal CheckBalance() {
        return this.userBill.getAmount();
    }

}
