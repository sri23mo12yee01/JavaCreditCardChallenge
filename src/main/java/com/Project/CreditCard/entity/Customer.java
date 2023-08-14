package com.Project.CreditCard.entity;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="customers")
public class Customer {
    public Customer() {
    }

    public Customer(String customerId, String firstName, String lastName, String gender, String profession) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.profession = profession;
    }

    @Id
    private ObjectId id;
    private String customerId;

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    private String firstName;
    private String lastName;
    private String gender;
    @Field("job")
    private String profession;



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

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address _address) {
//        this.address = _address;
//    }
}