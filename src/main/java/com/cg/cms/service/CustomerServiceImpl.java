package com.cg.cms.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cms.entities.Customer;
import com.cg.cms.exception.CustomerNotFoundException;
import com.cg.cms.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository repository;// repository is a dependency of customerserviceimpl

	@Override
	public Customer addCustomer(Customer customer) {
		logger.info("inside addCustomer method of CustomerServiceImpl");
		return repository.save(customer);
	}

	@Override
	public List<Customer> fetchAll() {
		return repository.findAll();
	}

	@Override
	public void delCustomer(int id) throws CustomerNotFoundException {
		Optional<Customer> customer = repository.findById(id);
		if (!customer.isPresent())
			throw new CustomerNotFoundException();
		
		repository.deleteById(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		repository.save(customer);
	}

	@Override
	public Customer fetchById(int id) throws CustomerNotFoundException {
		Optional<Customer> customer = repository.findById(id);
		if (!customer.isPresent())
			throw new CustomerNotFoundException();

		return customer.get();
	}

}
