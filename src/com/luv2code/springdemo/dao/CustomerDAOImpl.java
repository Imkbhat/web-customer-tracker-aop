package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//injecting session factory(DI)
	@Autowired
	private SessionFactory  sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//session Factory
		Session session = sessionFactory.getCurrentSession();
		
		//CREATE QUERY
		Query<Customer>  query = 
				session.createQuery(" from Customer order by lastName ", Customer.class);
		
		//execute and get result list
		
		List<Customer> customers =  query.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		Session session =  sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int Id) {
		Session session =  sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, Id);
		return customer;
	}

	@Override
	public void deleteCustomer(int Id) {
		Session session =  sessionFactory.getCurrentSession();
		/*Customer customer = session.get(Customer.class, Id);
		session.delete(customer);*/
		
		Query query = session.createQuery("delete from Customer WHERE id=:customerId");
		query.setParameter("customerId", Id);
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		Session session =  sessionFactory.getCurrentSession();
		Query query = null;
		if (theSearchName != null && theSearchName.trim().length() > 0) {
			query = session.createQuery("from Customer WHERE lower(firstName) like :theSearchName OR lower(lastName) like :theSearchName", Customer.class);
			query.setParameter("theSearchName", "%" + theSearchName.toLowerCase() + "%");
		} else {
			// theSearchName is empty ... so just get all customers
            query =session.createQuery("from Customer", Customer.class);    
		}
		// execute query and get result list
        List<Customer> customers = query.getResultList();
                
        // return the results        
        return customers;
	}

}
