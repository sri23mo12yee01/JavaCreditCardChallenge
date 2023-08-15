package com.Project.CreditCard.entity;

public class Address {
    private String city;
    private String state;
    private String country;

    public Address(String _city, String _state, String _country) {
        this.city = _city;
        this.state = _state;
        this.country = _country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String _city) {
        this.city = _city;
    }

    public String getState() {
        return state;
    }

    public void setState(String _state) {
        this.state = _state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String _country) {
        this.country = _country;
    }
}
