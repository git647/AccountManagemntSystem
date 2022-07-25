package com.bank.accountmanagementsystem.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.accountmanagementsystem.Models.Account;

public interface AccountRepo extends JpaRepository<Account, Long>{

}
