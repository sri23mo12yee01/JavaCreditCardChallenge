package com.Project.CreditCard.controller;


import com.Project.CreditCard.dto.*;
import com.Project.CreditCard.entity.Transaction;
import com.Project.CreditCard.service.TransactionService;
import com.Project.CreditCard.utility.SpendingCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    @Autowired
    public TransactionController(TransactionService _transactionService)
    {
        this.transactionService=_transactionService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Transaction>> getTransactionByUserId(@PathVariable String userId)
    {
        List<Transaction> transactions = transactionService.getTransactionsByUserId(userId);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/merchant/{merchant}")
    public ResponseEntity<List<Transaction>> getTransactionsByMerchant(@PathVariable String merchant)
    {
        List<Transaction> transactions=transactionService.getTransactionsByMerchant(merchant);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/category/{spendingCategory}")
    public ResponseEntity<List<Transaction>> getTransactionsByCategory(@PathVariable SpendingCategory spendingCategory)
    {
        List<Transaction> transactions= transactionService.getTransactionsBySpendingCategory(spendingCategory);
        return ResponseEntity.ok(transactions);
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction)
    {
        Transaction createdTransaction= transactionService.createTransaction(transaction);
        return ResponseEntity.created(URI.create("/transactions/"+createdTransaction.getId())).body(createdTransaction);
    }

    // For data visualization (charts) - MongoTemplate

    @GetMapping("/spendingHistory")
    public List<SpendingByGender> getGenderwiseSpending()
    {
        return transactionService.getGenderwiseSpending();
    }

    @GetMapping("/spendingHistory")
    public List<SpendingByCategory> getCategorywiseSpending()
    {
        return transactionService.getCategorywiseSpending();
    }

    @GetMapping("/spendingHistory")
    public List<SpendingByCity> getCitywiseSpending()
    {
        return transactionService.getCitywiseSpending();
    }

    @GetMapping("/spendingHistory")
    public List<SpendingByState> getStatewiseSpending()
    {
        return transactionService.getStatewiseSpending();
    }

    @GetMapping("/spendingHistory")
    public List<SpendingByMerchant> getMerchantwiseSpending()
    {
        return transactionService.getMerchantwiseSpending();
    }

    @GetMapping("/spendingHistory")
    public List<SpendingByProfession> getJobwiseSpending()
    {
        return transactionService.getJobwiseSpending();
    }

    @GetMapping("/spendingHistory")
    public List<Transaction> getLowValueTransactions()
    {
        return transactionService.getLowValueTransactions();
    }

    @GetMapping("/spendingHistory")
    public List<Transaction> getHighValueTransactions()
    {
        return transactionService.getHighValueTransactions();
    }

}
