package com.bank.accountmanagementsystem.controllers;

import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bank.accountmanagementsystem.constants.SystemConstants;
import com.bank.accountmanagementsystem.services.CustomerService;

/**
 * CustomerController - Retrieves the customer details on providing their Account Number.
 * 
 * @author Ankit
 *
 */
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/**
	 * getAccountsByCustId (Fetch the customer details)
	 * 
	 * @param  id - Customer ID
	 * @return detail of customer matching particular id if present
	 * 
	 */
	
	@GetMapping(SystemConstants.GET_ACCOUNTS_BY_CUSTOMERID)
	public ResponseEntity<Object> getAccountsByCustId(@PathVariable int id) {
		Set<HashMap<String, String>> resultSet = customerService.getAccountDetailsByCustomerId(id);
		HashMap<String, Object> result = new HashMap<String, Object>();
		//To check if the result set is empty or not
		if (resultSet.isEmpty()) {
			result.put("message", "accounts not found for " + Integer.toString(id));
			return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
		}
		result.put("accounts", resultSet);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
