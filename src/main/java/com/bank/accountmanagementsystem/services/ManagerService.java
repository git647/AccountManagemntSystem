package com.bank.accountmanagementsystem.services;

import org.springframework.http.ResponseEntity;

import com.bank.accountmanagementsystem.models.Account;
import com.bank.accountmanagementsystem.models.Customer;

public interface ManagerService {
	Customer createNewCustomer(Customer customer) throws Exception;
	Account createNewAccount(int customerId) throws Exception;
	public ResponseEntity<Object> verifyPanCard(String panCardNumber);
}
