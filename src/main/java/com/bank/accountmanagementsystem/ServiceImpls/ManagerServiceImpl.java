package com.bank.accountmanagementsystem.ServiceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.accountmanagementsystem.Models.Customer;
import com.bank.accountmanagementsystem.Repositories.CustomerRepository;
import com.bank.accountmanagementsystem.Services.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer createNewCustomer(Customer customer) throws Exception{
		try {
			customer = customerRepository.save(customer);
		}catch(Exception e){
			throw e;
		}
		return customer;
	}

}
