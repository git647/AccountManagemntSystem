package com.bank.accountmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.accountmanagementsystem.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findCustomerByPanCard(String panCardNumber);

}
