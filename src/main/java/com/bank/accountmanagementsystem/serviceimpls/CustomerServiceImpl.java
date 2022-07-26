package com.bank.accountmanagementsystem.serviceimpls;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.accountmanagementsystem.models.Account;
import com.bank.accountmanagementsystem.repositories.AccountRepository;
import com.bank.accountmanagementsystem.services.CustomerService;

/**
 * 
 * CustomerServiceImpl - Implements the functionality to return the details of customer.
 * 
 * @author Ankit
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService{
	

	@Autowired
	AccountRepository accountRepository;
	
	/*
	 * getAccountDetailsByCustomerId - To get the necessary details of the customer.
	 * 
	 * @param  customerId - Id of the customer
	 * @return accounts{account_number, current_balance}
	 *  
	 */
	
	public Set<HashMap<String,String>> getAccountDetailsByCustomerId(int customerId){
		Set<HashMap<String,String>> accounts = new HashSet<HashMap<String,String>>();
		Optional<List<Account>> accs = accountRepository.findByCustomerCustomerId(customerId);
		//To check if account is present or not for that particular id
		if(accs.isPresent()) {
			for(Account acc: accs.get()) {
				HashMap<String, String> accAndBalance = new HashMap<String, String>();
				accAndBalance.put("account_number", Long.toString(acc.getAccountNumber()));
				accAndBalance.put("current_balance", Double.toString(acc.getCurrentBalance()));
				accounts.add(accAndBalance);
			}
		}
		return accounts;
	}
}