package com.bank.accountmanagementsystem.Services;

import org.springframework.http.ResponseEntity;

import com.bank.accountmanagementsystem.Models.User;

public interface UserLoginService {

	public User createNewUserCredentials();
	
	public ResponseEntity<Object> verifyUserCredential(String userId, String password, int roleId);

}
