package com.bank.accountmanagementsystem.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bank.accountmanagementsystem.models.Account;
import com.bank.accountmanagementsystem.models.Transaction;

@Component
public interface TransactionService {
	
	//Deposit
	public String Deposit(long depositID, double amount);
	
	//Transfer
	public String Transfer(long senderId, double amount, long recieverId);
	
	//Withdraw
	public Long getCurrentBalance(long accountNumber);
	public Long getAmount();
	public Long DeductMoney(long accountNumber, Long amountToWithdraw);
	public boolean checkLimit10000(long accountNumber, Long amountToWithdraw);
	
	//Email notification
	public void sendEmail(Account account, Transaction transaction); 
	
	//Recent Transactions
	public List<Transaction> checkHistory(long accountNum);
}
