package com.bank.accountmanagementsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.bank.accountmanagementsystem.controllers.CustomerController;
import com.bank.accountmanagementsystem.serviceimpls.CustomerServiceImpl;
import com.bank.accountmanagementsystem.services.CustomerService;

@SpringBootTest
public class TestManagerApi {
	private MockMvc mockMvc;

	@Mock
	CustomerServiceImpl service;

//	@Mock
//	CustomerService service1;

	@InjectMocks
	CustomerController controller;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

//	@Test
//	public void DummyTest() throws Exception{
//		mockMvc.perform(MockMvcRequestBuilders.get("/")).
//		 andExpect(status().isOk())
//		 .andExpect(content().string("hello"));
//	}
//	
	@Test
	public void GetCustomerTest() throws Exception {
		Set<HashMap<String,String>> accounts = new HashSet<HashMap<String,String>>();
		HashMap<String, String> accAndBalance = new HashMap<String, String>();
		accAndBalance.put("account_number", "1000000002");
		accounts.add(accAndBalance);

		System.out.println("Data---" + accounts);
		doReturn(accounts).when(service).getAccountDetailsByCustomerId(100002);

		mockMvc.perform(MockMvcRequestBuilders.get("/accounts/customer/{id}", 100002)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

}