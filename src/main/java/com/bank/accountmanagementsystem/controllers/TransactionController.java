package com.bank.accountmanagementsystem.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.accountmanagementsystem.models.Transaction;
import com.bank.accountmanagementsystem.services.TransactionService;


/**
 * 
 * @author shefali, muskan & shivam
 *
 */
@RestController
public class TransactionController {
	
	/**
	 * transactionService (Contains details related to transaction table)
	 */
	@Autowired
	TransactionService transactionService;

	/**
	 * returns current balance of a particular customer
	 * @param id
	 * @return
	 */
	@RequestMapping("api/transaction/getCurrentBalance/{id}")
	public Long getCurrentBalance(@PathVariable long id) {
		
		Long currentBalance = transactionService.getCurrentBalance(id);
	    return currentBalance; 
	}
	
	/**
	 * performs withdraw transaction
	 * @param id
	 * @param amount
	 * @return
	 */
	@GetMapping("api/transaction/withdraw/{id}/{amount}")
	public Long updateCurrentBalance(@PathVariable long id, @PathVariable long amount) {
		
		Long currentBalance = transactionService.DeductMoney(id,amount);
	    return currentBalance;
	}
	

	/**
	 * performs deposit transaction
	 * @param depositID
	 * @param amount
	 * @return
	 */
	@PostMapping("api/transaction/deposit/{depositID}/{amount}")
	public String DepositMoney(@PathVariable long depositID,@PathVariable double amount)
	{
		return transactionService.Deposit(depositID,amount);
	}
	
	
	/**
	 * Transfer money from one user to another user
	 * @param transferData
	 * @return
	 */
	@PostMapping(value = "api/transaction/transfer",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.TEXT_PLAIN_VALUE)
	public String transferMoney(@RequestBody TransferData transferData)
	{	
		return transactionService.Transfer(transferData.getSenderId(),transferData.getAmount(),transferData.getRecieverId());
	}
	
	/**
	 * Gets the recent transaction history
	 * @param accountNum
	 * @return
	 */
	@GetMapping("api/transaction/recent")
	public List<Transaction> checkHistory(long accountNum)
	{
		return transactionService.checkHistory(accountNum);
	}
	
	/**
	 * 
	 * @author  shivam
	 *
	 */
	public static class TransferData{
		private long senderId;
		private double amount;
		private long recieverId;
		
		public TransferData() {
        }
		public TransferData(long senderId, double amount, long recieverId) {
			super();
			this.senderId = senderId;
			this.amount = amount;
			this.recieverId = recieverId;
		}
		public long getSenderId() {
			return senderId;
		}
		public void setSenderId(long senderId) {
			this.senderId = senderId;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public long getRecieverId() {
			return recieverId;
		}
		public void setRecieverId(long recieverId) {
			this.recieverId = recieverId;
		}
		@Override
		public String toString() {
			return "TransferData [senderId=" + senderId + ", amount=" + amount + ", recieverId=" + recieverId + "]";
		}
		
	}
	
}
