package com.bank.accountmanagementsystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.accountmanagementsystem.Models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Role findById(int id);

}
