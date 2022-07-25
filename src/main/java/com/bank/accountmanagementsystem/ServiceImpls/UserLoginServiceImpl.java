package com.bank.accountmanagementsystem.ServiceImpls;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.accountmanagementsystem.Repositories.RoleRepository;
import com.bank.accountmanagementsystem.Models.User;
import com.bank.accountmanagementsystem.Services.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public User createNewUserCredentials() {
		String userId = RandomStringUtils.randomAlphabetic(7);
	    String password = RandomStringUtils.randomAlphabetic(8);
	    User newUser = new User(userId,password,roleRepository.findById(1));
		return newUser;
	}

}
