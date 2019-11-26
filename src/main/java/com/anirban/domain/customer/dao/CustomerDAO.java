package com.anirban.domain.customer.dao;

import org.springframework.stereotype.Repository;

import com.anirban.domain.customer.model.Customer;
import com.anirban.domain.customer.model.Customers;

@Repository
public class CustomerDAO {

	private static Customers list = new Customers();
	
	static
    {
        list.getCustomerList().add(new Customer(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
        list.getCustomerList().add(new Customer(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
        list.getCustomerList().add(new Customer(3, "David", "Kameron", "titanic@gmail.com"));
    }
	
	public Customers getAllCustomers() 
    {
        return list;
    }
	
	public void addCustomer(Customer customer) {
        list.getCustomerList().add(customer);
    }
}
