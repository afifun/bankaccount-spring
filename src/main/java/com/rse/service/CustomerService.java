package com.rse.service;

import java.util.Collection;

import com.rse.domain.Customer;

public interface CustomerService {
	public Collection<Customer> findAll();
	public Customer findOne(Long id);
	public Customer create(Customer customer);
	public Customer update(Customer customer);
	public void delete(Long id);
}
