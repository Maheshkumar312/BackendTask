package com.prodian.SpringNewTask.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodian.SpringNewTask.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
	

}
