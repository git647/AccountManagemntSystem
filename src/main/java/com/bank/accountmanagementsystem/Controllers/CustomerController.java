package com.bank.accountmanagementsystem.Controllers;

import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bank.accountmanagementsystem.Services.CustomerService;
import com.bank.accountmanagementsystem.constants.SystemConstants;

/**
 * CustomerController (define the meaning of the class)
 * 
 * @author Nishad
 *
 */
@RestController
public class CustomerController {
	/**
	 * customerService
	 */
	@Autowired
	private CustomerService customerService;

	/**
	 * getAccountsByCustId (this is responsible to give the customer ....)
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(SystemConstants.GET_ACCOUNTS_BY_CUSTOMERID)
	public ResponseEntity<Object> getAccountsByCustId(@PathVariable int id) {
		Set<HashMap<String, String>> resultSet = customerService.getAccountDetailsByCustomerId(id);
		HashMap<String, Object> result = new HashMap<String, Object>();
		if (resultSet.isEmpty()) {
			result.put("message", "accounts not found for " + Integer.toString(id));
			return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
		}
		result.put("accounts", resultSet);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
