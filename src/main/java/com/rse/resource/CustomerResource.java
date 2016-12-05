package com.rse.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rse.domain.Customer;
import com.rse.service.CustomerService;


@RestController
public class CustomerResource {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/api/customers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Customer>> getCustomers(){
		
		Collection<Customer> customers = customerService.findAll();
		
		
		return new ResponseEntity<Collection<Customer>>(customers, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/api/customers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id){
		
		Customer customer = customerService.findOne(id);
		
		if (customer == null){
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/api/customers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		
		Customer savedCustomer = customerService.create(customer);
		
		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/api/customers/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		
		Customer updateCustomer = customerService.update(customer);
		
		if (updateCustomer == null){
			return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Customer>(updateCustomer, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/api/customers/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id){
		
		customerService.delete(id);
		
		return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
		
	}
}
