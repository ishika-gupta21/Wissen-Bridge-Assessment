package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Transaction;
import com.example.demo.repositories.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
    private TransactionRepository transactionRepository;

    public Transaction transfer(String fromAccount, String toAccount, String ifsc, double amount) {
        Transaction transaction = new Transaction();
        transaction.setFromAccount(fromAccount);
        transaction.setToAccount(toAccount);
        transaction.setIfsc(ifsc);
        transaction.setAmount(amount);
        return transactionRepository.save(transaction);
    }

}
