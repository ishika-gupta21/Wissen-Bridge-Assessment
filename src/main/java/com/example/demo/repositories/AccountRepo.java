package com.example.demo.repositories;

import java.util.List;

import java.lang.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Accounts;

public interface AccountRepo extends JpaRepository<Accounts, String> {

    Accounts findByCustomerId(String customerId);

    Accounts findByAccountNumber(String accountNumber);
    
    @Query("SELECT a FROM Accounts a WHERE a.balance < :balance")
    List<Accounts> findAllByBalanceLessThan(@Param("balance") double balance);

    @Query("SELECT a FROM Accounts a WHERE a.balance > :balance")
    List<Accounts> findAllByBalanceGreaterThan(@Param("balance") double balance);
}
