package com.bank.accountmanagementsystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.accountmanagementsystem.Models.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>{

}
