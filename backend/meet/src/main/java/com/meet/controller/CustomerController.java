package com.meet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meet.exception.ResourceNotFoundException;
import com.meet.model.Customer;
import com.meet.repository.ICustomerRepository;

@CrossOrigin( origins = "http://localhost:3000" )
@RestController
@RequestMapping( "/api/v1" )
public class CustomerController {
	
	@Autowired
	private ICustomerRepository customerRepository;
	
	//get all customers
	@GetMapping( "/customers" )
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	//get one customer by id
	@GetMapping( "/customers/{id}" )
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id ){
		Customer customer = customerRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Customer does not exist with id: " + id ));
		return ResponseEntity.ok(customer);
	}
	
	//create customer
	@PostMapping("/customers")
	public Customer customer(@RequestBody Customer customer ) {
		return customerRepository.save(customer);
	}
	
	// update customer
	@PutMapping( "/customers/{id}" )
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails ){
		Customer customer = customerRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Customer does not exist with id: " + id ));
		
		customer.setCompanyName(customerDetails.getCompanyName() );
		customer.setAddress( customerDetails.getAddress() );
		customer.setPhoneNumber( customerDetails.getPhoneNumber() );
		
		Customer updatedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedCustomer);
	}
	
	// delete customer
	@DeleteMapping( "/customers/{id}" )
	public ResponseEntity<Map< String, Boolean>> deleteCustomer(@PathVariable Long id){
		Customer customer = customerRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Customer does not exist with id: " + id ));
		
		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
