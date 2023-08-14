package com.Project.CreditCard.repo;

import com.Project.CreditCard.entity.Transaction;
import com.Project.CreditCard.utility.SpendingCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepo extends MongoRepository<Transaction,String> {

    List<Transaction> findByUserId(String userId);
    List<Transaction> findByMerchant(String merchant);
    List<Transaction> findBySpendingCategory(SpendingCategory spendingCategory);


}
