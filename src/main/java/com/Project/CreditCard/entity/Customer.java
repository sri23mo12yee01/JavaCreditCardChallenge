package com.Project.CreditCard.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="customers")
public class Customer {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private String profession;
    private Address address;

    public Customer(String _id, String _firstName, String _lastName, String _gender, String _profession, Address _address) {
        this.id = _id;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.gender = _gender;
        this.profession = _profession;
        this.address = _address;
    }

    public String getId() {
        return id;
    }

    public void setId(String _id) {
        this.id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String _firstName) {
        this.firstName = _firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String _lastName) {
        this.lastName = _lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String _gender) {
        this.gender = _gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String _profession) {
        this.profession = _profession;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address _address) {
        this.address = _address;
    }
}