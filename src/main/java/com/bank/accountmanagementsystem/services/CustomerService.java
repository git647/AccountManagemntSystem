package com.bank.accountmanagementsystem.services;

import java.util.HashMap;
import java.util.Set;

public interface CustomerService {

	Set<HashMap<String,String>> getAccountDetailsByCustomerId(int customerId);
}
