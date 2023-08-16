package com.Project.CreditCard.dto;

public class SpendingByCity {

    private String City;
    private double total_amount;

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }
}
