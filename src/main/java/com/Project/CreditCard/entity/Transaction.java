package com.Project.CreditCard.entity;

import com.Project.CreditCard.utility.SpendingCategory;
import com.Project.CreditCard.utility.TransactionStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
@Document(collection="transactions")
public class Transaction {
    @Id
    private String id;
    private String userId;
    private String merchant;
    @Field("amt")
    private double amount;

    private String Job;

    private String city;

    private String state;

    private String gender;
    private Date transactionDate;
    private TransactionStatus status;
    @Field("category")
    private String spendingCategory;




    public Transaction(String id, String userId, String merchant, double amount, String city, String state, String gender, Date transactionDate, TransactionStatus status, String spendingCategory, String job) {
        this.id = id;
        this.userId = userId;
        this.merchant = merchant;
        this.amount = amount;
        this.city = city;
        this.state = state;
        this.gender = gender;
        this.transactionDate = transactionDate;
        this.status = status;
        this.spendingCategory = spendingCategory;
        Job = job;
    }

//    public Transaction(String _id, String _userId, String _merchant, double _amount, Date _transactionDate, TransactionStatus _status, String _spendingCategory) {
//        this.id = _id;
//        this.userId = _userId;
//        this.merchant = _merchant;
//        this.amount = _amount;
//        this.transactionDate = _transactionDate;
//        this.status = _status;
//        this.spendingCategory = _spendingCategory;
//    }

    public String getId() {
        return id;
    }

    public void setId(String _id) {
        this.id = _id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String _userId) {
        this.userId = _userId;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String _merchant) {
        this.merchant = _merchant;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double _amount) {
        this.amount = _amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date _transactionDate) {
        this.transactionDate = _transactionDate;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus _status) {
        this.status = _status;
    }

    public String getSpendingCategory() {
        return spendingCategory;
    }

    public void setSpendingCategory(String _spendingCategory) {
        this.spendingCategory = _spendingCategory;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

}
