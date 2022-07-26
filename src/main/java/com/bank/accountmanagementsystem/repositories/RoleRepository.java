package com.bank.accountmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.accountmanagementsystem.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Role findById(int id);

}
