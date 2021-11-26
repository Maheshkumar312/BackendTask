package com.prodian.SpringNewTask.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prodian.SpringNewTask.Entity.Customer;
import com.prodian.SpringNewTask.Service.CustomerService;

@CrossOrigin
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	public CustomerController() {
		super();
	}

	@PostMapping("/addcustomer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@GetMapping("/getcustomer")
	public List<Customer> getCustomer() {
		return customerService.getCustomer();
	}

	@GetMapping("{cifNumber}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "cifNumber") long cif_number) {
		return ResponseEntity.ok().body(customerService.getCustomerById(cif_number).get());
	}

//
//	@PutMapping("/{cifNumber}")
//	public Customer updateCustomer(@PathVariable(name = "cifNumber") long cifNumber, @RequestBody Customer customer) {
//		return customerService.updateCustomer(customer, cifNumber);
//
//	}
	@PutMapping("/{cifNumber}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable long cifNumber, @RequestBody Customer customer) {
		customer.setCif_number(cifNumber);
		return ResponseEntity.ok().body(this.customerService.updateCustomer(customer));
	}

	@DeleteMapping("/{cifNumber}")
	public String deleteCustomer(@PathVariable(name = "cifNumber") long cifNumber) {
		customerService.deleteCustomer(cifNumber);
		return "success";
	}
}
