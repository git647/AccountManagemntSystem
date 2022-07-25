package com.bank.accountmanagementsystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.accountmanagementsystem.Models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findCustomerByPanCard(String panCardNumber);

}
