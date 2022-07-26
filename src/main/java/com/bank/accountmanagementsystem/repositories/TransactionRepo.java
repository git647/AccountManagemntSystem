package com.bank.accountmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.accountmanagementsystem.models.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>{

}
