package com.prodian.SpringNewTask.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountNumber;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinColumn(name = "cif_number")
	private Customer customer;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Account(long accountNumber, Customer customer) {
		super();
		this.accountNumber = accountNumber;
		this.customer = customer;
	}

	public Account() {
		super();
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customer=" + customer + "]";
	}

}
