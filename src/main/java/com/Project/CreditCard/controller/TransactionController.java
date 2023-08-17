package com.Project.CreditCard.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.Project.CreditCard.dto.*;
import com.Project.CreditCard.entity.Transaction;
import com.Project.CreditCard.service.TransactionService;
import com.Project.CreditCard.utility.SpendingCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin
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
    public ResponseEntity<List<Transaction>> getTransactionsByCategory(@PathVariable String spendingCategory)
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

    @GetMapping("/spendingHistory/Gender")
    public List<SpendingByGender> getGenderwiseSpending()
    {
        return transactionService.getGenderwiseSpending();
    }

    @GetMapping("/spendingHistory/Category")
    public List<SpendingByCategory> getCategorywiseSpending()
    {
        System.out.println("In controller");
        return transactionService.getCategorywiseSpending();
    }

    @GetMapping("/spendingHistory/City")
    public List<SpendingByCity> getCitywiseSpending()
    {
        return transactionService.getCitywiseSpending();
    }

    @GetMapping("/spendingHistory/State")
    public List<SpendingByState> getStatewiseSpending()
    {
        return transactionService.getStatewiseSpending();
    }

    @GetMapping("/spendingHistory/Merchant")
    public List<SpendingByMerchant> getMerchantwiseSpending()
    {
        return transactionService.getMerchantwiseSpending();
    }

    @GetMapping("/spendingHistory/Job")
    public List<SpendingByProfession> getJobwiseSpending()
    {
        return transactionService.getJobwiseSpending();
    }

    @GetMapping("/spendingHistory/LowValueTransactions")
    public List<Transaction> getLowValueTransactions()
    {
        return transactionService.getLowValueTransactions();
    }

    @GetMapping("/spendingHistory/HighValueTransactions")
    public List<Transaction> getHighValueTransactions()
    {
        return transactionService.getHighValueTransactions();
    }

}
