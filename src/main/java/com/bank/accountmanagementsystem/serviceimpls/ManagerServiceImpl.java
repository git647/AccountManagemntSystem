package com.bank.accountmanagementsystem.serviceimpls;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bank.accountmanagementsystem.models.Account;
import com.bank.accountmanagementsystem.models.Customer;
import com.bank.accountmanagementsystem.repositories.AccountRepository;
import com.bank.accountmanagementsystem.repositories.CustomerRepository;
import com.bank.accountmanagementsystem.services.ManagerService;


@Service
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRepository accountRepository;

	/**
	 * createNewAccount ( Create new customer saving account )
	 * @author Nishad
	 */
	
	public Account createNewAccount(int customerId) throws Exception{
		Account account = new Account();
		System.out.println(customerId);
		Customer customer = customerRepository.findById(customerId).get();
		System.out.println(customer.getName());
		account.setCurrentBalance(100000);
		account.setCustomer(customer);
		account.setDailyLimit(10000);
		// when transaction API completes
        // account.setTransactions(new ArrayList<Transaction>());    
		System.out.println(account.getCurrentBalance());
		try {
			account = accountRepository.save(account);
		}catch(Exception e) {
			throw e;
		}
		return account;
	}

	/**
	 * method to create a customer account save it to db
	 * @author dakshin
	 */
	
	public Customer createNewCustomer(Customer customer) throws Exception{
		try {
			customer = customerRepository.save(customer);
		}catch(Exception e){
			throw e;
		}
		return customer;
	}

	
	public ResponseEntity<Object> verifyPanCard(String panCardNumber)
	{
		System.out.println(panCardNumber);
		Customer customer = customerRepository.findCustomerByPanCard(panCardNumber);
		HashMap<String,String> result = new HashMap<String, String>();
		if(customer != null)
		{
			result.put("message","Account exists");
			return new ResponseEntity<>(result,HttpStatus.OK);
		}
		else 
		{
			result.put("message","Account doest not exists");
			return new ResponseEntity<>(result,HttpStatus.NOT_FOUND);
		}
	}


}

