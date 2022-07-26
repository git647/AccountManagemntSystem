package com.bank.accountmanagementsystem.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.accountmanagementsystem.models.Account;

/**
 * 
 * @author Nishad
 *
 */
public interface AccountRepo extends JpaRepository<Account, Long>{

}
