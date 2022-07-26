package com.bank.accountmanagementsystem.services;

import org.springframework.http.ResponseEntity;

import com.bank.accountmanagementsystem.models.User;

public interface UserLoginService {

	public User createNewUserCredentials();
	public ResponseEntity<Object> verifyUserCredential(String userId, String password, int roleId);
	public ResponseEntity<Object> updateUserCredential(String userId, String password);

}
