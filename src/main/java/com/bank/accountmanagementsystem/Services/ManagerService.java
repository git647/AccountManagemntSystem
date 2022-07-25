package com.bank.accountmanagementsystem.Services;

import org.springframework.http.ResponseEntity;

import com.bank.accountmanagementsystem.Models.Account;
import com.bank.accountmanagementsystem.Models.Customer;

public interface ManagerService {
	Customer createNewCustomer(Customer customer) throws Exception;
	Account createNewAccount(int customerId) throws Exception;
//	public ResponseEntity<Object> verifyPanCard(String panCardNumber);
}
