package com.Project.CreditCard.service;


import com.Project.CreditCard.dao.TransactionMongoTemplate;
import com.Project.CreditCard.dto.*;
import com.Project.CreditCard.entity.Transaction;
import com.Project.CreditCard.repo.TransactionRepo;
import com.Project.CreditCard.utility.SpendingCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepo transactionRepo;

    @Autowired
    private TransactionMongoTemplate dao;

    public List<SpendingByGender> getGenderwiseSpending(){
        return dao.getSpendingHistoryByGender();
    }

    public List<SpendingByCategory> getCategorywiseSpending(){
        return dao.getSpendingHistoryByCategory();
    }

    public List<SpendingByCity> getCitywiseSpending(){
        return dao.getSpendingHistoryByCity();
    }

    public List<SpendingByState> getStatewiseSpending(){
        return dao.getSpendingHistoryByState();
    }

    public List<SpendingByMerchant> getMerchantwiseSpending(){
        return dao.getSpendingHistoryByMerchant();
    }

    public List<SpendingByProfession> getJobwiseSpending(){
        return dao.getSpendingHistoryByProfession();
    }

    @Autowired
    public TransactionService(TransactionRepo _transactionRepo)
    {
        this.transactionRepo=_transactionRepo;
    }

    public List<Transaction> getTransactionsByUserId(String _userId)
    {
        return transactionRepo.findByUserId(_userId);
    }
    public List<Transaction> getTransactionsByMerchant(String _merchant)
    {
        return transactionRepo.findByMerchant(_merchant);
    }

    public List<Transaction> getTransactionsBySpendingCategory(SpendingCategory _spendingCategory)
    {
        return transactionRepo.findBySpendingCategory(_spendingCategory);
    }

    public Transaction createTransaction(Transaction transaction)
    {
        return transactionRepo.save(transaction);
    }

}