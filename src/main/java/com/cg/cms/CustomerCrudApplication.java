package com.cg.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@SpringBootApplication
public class CustomerCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerCrudApplication.class, args);
	}

}


//creating war file and deploying to a server
//simply get a jar file and run locally with embedded tomcat