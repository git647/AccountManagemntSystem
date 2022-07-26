package com.bank.accountmanagementsystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.accountmanagementsystem.Models.User;

@Repository
public interface UserLoginRepository extends JpaRepository<User, Integer> {

	User findUserByUserIdAndPassword(String userId, String password);
	User findUserByUserIdAndRoleRoleId(String userId, int roleId);
}
