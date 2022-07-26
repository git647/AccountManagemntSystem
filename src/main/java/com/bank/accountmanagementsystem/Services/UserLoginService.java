package com.bank.accountmanagementsystem.Services;

import org.springframework.http.ResponseEntity;

public interface UserLoginService {
	
	public ResponseEntity<Object> verifyUserCredential(String userId, String password, int roleId);


}
