package com.Project.CreditCard.dto;

public class SpendingByState {

    private String State;
    private double total_amount;

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }
}
