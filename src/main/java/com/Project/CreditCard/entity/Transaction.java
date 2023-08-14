package com.Project.CreditCard.entity;

import com.Project.CreditCard.utility.SpendingCategory;
import com.Project.CreditCard.utility.TransactionStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document(collection="transactions")
public class Transaction {
    @Id
    private String id;
    private String userId;
    private String merchant;
    private double amount;
    private Date transactionDate;
    private TransactionStatus status;
    private SpendingCategory spendingCategory;

    public Transaction(String _id, String _userId, String _merchant, double _amount, Date _transactionDate, TransactionStatus _status, SpendingCategory _spendingCategory) {
        this.id = _id;
        this.userId = _userId;
        this.merchant = _merchant;
        this.amount = _amount;
        this.transactionDate = _transactionDate;
        this.status = _status;
        this.spendingCategory = _spendingCategory;
    }

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

    public SpendingCategory getSpendingCategory() {
        return spendingCategory;
    }

    public void setSpendingCategory(SpendingCategory _spendingCategory) {
        this.spendingCategory = _spendingCategory;
    }
}
