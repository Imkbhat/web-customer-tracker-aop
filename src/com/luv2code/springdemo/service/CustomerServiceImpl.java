package com.luv2code.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//Inject customerDAO
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int Id) {
		return customerDAO.getCustomer(Id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int Id) {
		customerDAO.deleteCustomer(Id);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {

		List<Customer> customerList = customerDAO.searchCustomers(theSearchName);
		return customerList;
	}

}
