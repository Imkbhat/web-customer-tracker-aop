package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int Id);
	
	public void deleteCustomer(int Id);

	public List<Customer> searchCustomers(String theSearchName);

}
