package com.cg.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.cms.entities.Customer;
import com.cg.cms.exception.CustomerNotFoundException;

@Service
public interface ICustomerService {

	Customer addCustomer(Customer customer);

	List<Customer> fetchAll();

	void delCustomer(int id) throws CustomerNotFoundException;

	void updateCustomer(Customer customer);

	Customer fetchById(int id) throws CustomerNotFoundException;

}
