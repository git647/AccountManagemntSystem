package com.bank.accountmanagementsystem.ServiceImpls;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bank.accountmanagementsystem.Models.User;
import com.bank.accountmanagementsystem.Repositories.RoleRepository;
import com.bank.accountmanagementsystem.Repositories.UserLoginRepository;
import com.bank.accountmanagementsystem.Services.UserLoginService;

@Service
public class UserLoginServiceImpl {
	
	@Autowired
	UserLoginRepository userLoginRepository;
		
	public ResponseEntity<Object> verifyUserCredential(String userId, String password, int roleId) {

		User user = userLoginRepository.findUserByUserIdAndPassword(userId, password);
		User user1 = userLoginRepository.findUserByUserIdAndRoleRoleId(userId, roleId);
		HashMap<String,String> result = new HashMap<String, String>();
		if (user != null && user1 != null) {
				result.put("message","Valid User");
				return new ResponseEntity<>(result,HttpStatus.OK);
		} 
		else {
			result.put("message","Invalid User");
			return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
		}

	}

}
