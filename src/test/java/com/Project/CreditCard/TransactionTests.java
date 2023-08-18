package com.Project.CreditCard;

import com.Project.CreditCard.dao.TransactionMongoTemplate;
import com.Project.CreditCard.dto.*;
import com.Project.CreditCard.entity.Transaction;
import com.Project.CreditCard.repo.TransactionRepo;
import com.Project.CreditCard.service.TransactionService;
import com.Project.CreditCard.utility.SpendingCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransactionTests {
    @Mock
    private TransactionRepo transactionRepo;
    @Mock
    private TransactionMongoTemplate dao;
    @InjectMocks
    private TransactionService transactionService;
    private List<Transaction> mockTransactions;
    private Transaction transaction1;
    private Transaction transaction2;
    private Transaction transaction3;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        transaction1 = new Transaction(
                "1", "user1", "MerchantA", 100.0, null, null, null,
                null, null, null, SpendingCategory.GROCERIES.toString()
        );
        transaction2 = new Transaction(
                "2", "user2", "MerchantB", 200.0, null, null, null,
                null, null, null, SpendingCategory.SHOPPING.toString()
        );
        transaction3 = new Transaction(
                "3", "user3", "MerchantC", 300.0, null, null, null,
                null, null, null, SpendingCategory.DINING.toString()
        );

        mockTransactions = new ArrayList<>();
        mockTransactions.add(transaction1);
        mockTransactions.add(transaction2);
        mockTransactions.add(transaction3);
    }
    @Test
    public void testCreateTransaction() {
        // Set up mock behavior for transactionRepo.save
        when(transactionRepo.save(any(Transaction.class))).thenReturn(transaction1);
        Transaction createdTransaction = transactionService.createTransaction(transaction1);
        assertEquals(transaction1, createdTransaction);
    }

}
