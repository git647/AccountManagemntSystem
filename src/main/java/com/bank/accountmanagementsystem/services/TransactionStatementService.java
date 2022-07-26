package com.bank.accountmanagementsystem.services;

import java.util.List;

import com.bank.accountmanagementsystem.models.Transaction;

public interface TransactionStatementService {
	
	 
	List<Transaction> findTransactionList(long accountNumber);
	List<Transaction> listAll(long accountNumber, String date);
	List<Transaction> findTransactionListDate(long accountNumber,String date);
	
	
}
