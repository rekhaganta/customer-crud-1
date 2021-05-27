package com.cg.cms.controller;

import java.util.List;
//SLF4J : Simple Logging Facade For Java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cms.entities.Customer;
import com.cg.cms.service.ICustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private ICustomerService service;// CustomerService is a dependency of CustomerContoller

	@GetMapping("/{name}")
	@ApiOperation("Greetings API")
	public String greetings(@PathVariable String name) {
		logger.info("Inside greetings!!");
		return "<h1>Welcome to Spring Boot " + name + "</h1>";
	}

	@GetMapping("/getById/{id}")
	@ApiOperation("Get Customer By ID")
	public Customer fetchById(@PathVariable String id) {
		logger.info("Inside fetchById %s", id);
		return service.fetchById(Integer.valueOf(id));
	}

	@GetMapping("/getAll")
	@ApiOperation("Fetch all Customers Details")
	public List<Customer> fetch() {
		logger.info("Fetching all customer records!!");
		return service.fetchAll();
	}

	@PostMapping("/save")
	@ApiOperation("Add a Customer Record")
	public void save(@RequestBody Customer customer) {
		logger.info("Adding a customer : " + customer);
		service.addCustomer(customer);

	}

	@PutMapping("/update")
	@ApiOperation("Update an Existing Customer Record")
	public void update(@RequestBody Customer customer) {
		logger.info("Updating a customer!!");
		service.updateCustomer(customer);
	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation("Delete an Existing Customer Record")
	public void delete(@PathVariable String id) {
		logger.info("Deleting a customer!!");
		service.delCustomer(Integer.valueOf(id));
	}

}
