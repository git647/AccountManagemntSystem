package com.bank.accountmanagementsystem.Services;

import java.util.List;

import com.bank.accountmanagementsystem.Models.Transaction;

public interface TransactionStatementService {
	
	 
	List<Transaction> findTransactionList(long accountNumber);
	List<Transaction> listAll(long accountNumber, String date);
	List<Transaction> findTransactionListDate(long accountNumber,String date);
	
	
}
