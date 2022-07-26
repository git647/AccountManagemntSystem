package com.bank.accountmanagementsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.accountmanagementsystem.services.AccCreationEmailService;
import com.bank.accountmanagementsystem.services.UserLoginService;

/**
 * UserLoginController contains all api endpoints for user functionalities.
 * @author khushbu
 */

@RestController
public class UserLoginController {

	@Autowired
	UserLoginService userLoginService;
	
	
	/**
	 * create a new user login for customer
	 * 
	 * @param userId
	 * @param password
	 * @param roleId
	 * @return Valid User or not
	 */
	@PostMapping("api/user/user-login")
	public ResponseEntity<Object> verifyUserCredential(@RequestParam(required = true) String userId, @RequestParam(required = true) String password, @RequestParam (required = true)int roleId )
	{
		return userLoginService.verifyUserCredential(userId, password, roleId);
	}
	
	@PutMapping("api/user/update-user-credentials")
	public ResponseEntity<Object> updateUserCredential(@RequestParam(required = true) String userId,@RequestParam(required = true) String password)
	{
		return userLoginService.updateUserCredential(userId, password);
	}
}
