package com.rse.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rse.domain.Customer;
import com.rse.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Collection<Customer> findAll() {
		Collection<Customer> customers = customerRepository.findAll();
		return customers;
	}

	@Override
	public Customer findOne(Long id) {
		Customer customer = customerRepository.findOne(id);
		return customer;
	}

	@Override
	public Customer update(Customer customer) {
		Customer customerPersisted = findOne(customer.getId());
		if (customerPersisted == null){
			return null;
		}
		Customer updateCustomer = customerRepository.save(customer);
		return updateCustomer;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		customerRepository.delete(id);
	}

	@Override
	public Customer create(Customer customer) {
		// TODO Auto-generated method stub
		if (customer.getId() == null){
			return null;
		}
		Customer createCustomer = customerRepository.save(customer);
		return createCustomer;
	}

}
