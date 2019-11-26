package com.anirban.domain.customer.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.anirban.domain.customer.model.Customer;
import com.anirban.domain.customer.model.Customers;
import com.anirban.domain.customer.dao.CustomerDAO;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;
	
	@GetMapping(path="/", produces = "application/json")
    public Customers getCustomers() 
    {
        return customerDAO.getAllCustomers();
    }
	
	@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) 
    {
        Integer id = customerDAO.getAllCustomers().getCustomerList().size() + 1;
        customer.setId(id);
         
        customerDAO.addCustomer(customer);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(customer.getId())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
	
}
