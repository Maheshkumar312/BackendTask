package com.prodian.SpringNewTask.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.prodian.SpringNewTask.Entity.Account;
import com.prodian.SpringNewTask.Entity.Customer;
import com.prodian.SpringNewTask.Repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	public CustomerService() {
		super();
	}

	public Customer saveCustomer(Customer customer) {
		Customer cus = new Customer();
		Account acc = new Account();
		cus.setCif_number(customer.getCif_number());
		cus.setFirstName(customer.getFirstName());
		cus.setLastName(customer.getLastName());
		cus.setMobileNumber(customer.getMobileNumber());
		cus.setEmailId(customer.getEmailId());
		cus.setMpin(customer.getMpin());
		acc.setCustomer(cus);
		cus.setAccount(acc);
		cus = this.customerRepository.save(cus);
		return cus;

	}

	public List<Customer> getCustomer() {
		List<Customer> customer = new ArrayList<Customer>();
		List<Customer> cus = this.customerRepository.findAll();
		for (Customer c : cus) {
			customer.add(new Customer(c.getCif_number(), c.getFirstName(), c.getLastName(), c.getMobileNumber(),
					c.getEmailId(), c.getMpin(), c.getAccount()));
		}
		return customer;

	}
	public Optional<Customer> getCustomerById(long cif_number) {
		Optional<Customer> customer = this.customerRepository.findById(cif_number);
		Customer cus=customer.get();
		return Optional.of(
				new Customer(cus.getCif_number(),cus.getFirstName(), cus.getLastName(),cus.getMobileNumber(), cus.getEmailId(), cus.getMpin(),cus.getAccount()));

	}

//	public Customer updateCustomer(Customer customer, long cifNumber) {
//		Optional<Customer> cust = this.customerRepository.findById(cifNumber);
//		Customer cus = new Customer();
//		Account acc = new Account();
//		cus.setCif_number(cifNumber);
//		cus.setFirstName(customer.getFirstName());
//		cus.setLastName(customer.getLastName());
//		cus.setMobileNumber(customer.getMobileNumber());
//		cus.setEmailId(customer.getEmailId());
//		cus.setMpin(customer.getMpin());
//		cus.setAccount(cus.getAccount());
////		acc.setCustomer(cus);
////		cus.setAccount(acc);
////		cus.getAccount();
//		cus = this.customerRepository.save(cus);
//		return cus;
//	}
	public Customer updateCustomer(Customer customer) {
        Optional <Customer> cusDb = this.customerRepository.findById(customer.getCif_number());

        
            Customer cusUpdate = cusDb.get();
            cusUpdate.setCif_number(customer.getCif_number());
            cusUpdate.setFirstName(customer.getFirstName());
            cusUpdate.setLastName(customer.getLastName());
            cusUpdate.setMobileNumber(customer.getMobileNumber());
            cusUpdate.setEmailId(customer.getEmailId());
            cusUpdate.setMpin(customer.getMpin());
            customerRepository.save(cusUpdate);
            return cusUpdate;
	}

	public Customer deleteCustomer(long cifNumber) {
		Customer customer = new Customer();
		customerRepository.deleteById(cifNumber);
		return customer;
	}
}
