package com.school4;

import java.math.BigDecimal;

public class Bill {
    private String userId;
    private String userPin;
    private BigDecimal currency;

    public Bill() {
        this.userId = "";
        this.currency = new BigDecimal(0);
    }

    public String getUserId() {
        return userId;
    }

    public BigDecimal getAmount() {
        return currency;
    }

    public String getUserPin() { return userPin; }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAmount(BigDecimal currency) {
        this.currency = currency;
    }


    public void CreateBill(String userId, String userPin) {
        this.userId = userId;
        this.userPin = userPin;
        this.currency = new BigDecimal(0);
    }

    public void CreateBill(String userId, String userPin, BigDecimal currency) {
        this.userId = userId;
        this.userPin = userPin;
        this.currency = currency;
    }


}
