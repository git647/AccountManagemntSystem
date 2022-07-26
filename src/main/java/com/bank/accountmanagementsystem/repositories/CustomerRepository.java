package com.bank.accountmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.accountmanagementsystem.models.Customer;

/**
 * interface provides the mechanism for storage, retrieval, search, update and 
 * delete operation
 * @author dakshin
 *
 */

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findCustomerByPanCard(String panCardNumber);

}
