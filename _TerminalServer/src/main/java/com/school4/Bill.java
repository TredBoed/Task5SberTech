package com.school4;

import java.math.BigDecimal;

public class Bill {
    private Integer userId;
    private Integer userPin;
    private BigDecimal currency;

    public Bill() {
        this.userId = 0;
        this.currency = new BigDecimal(0);
    }

    public Integer getUserId() {
        return userId;
    }

    public BigDecimal getAmount() {
        return currency;
    }

    public Integer getUserPin() { return userPin; }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setAmount(BigDecimal currency) {
        this.currency = currency;
    }


    public void CreateBill(Integer userId, Integer userPin) {
        this.userId = userId;
        this.userPin = userPin;
        this.currency = new BigDecimal(0);
    }

    public void CreateBill(Integer userId, Integer userPin, BigDecimal currency) {
        this.userId = userId;
        this.userPin = userPin;
        this.currency = currency;
    }


}
