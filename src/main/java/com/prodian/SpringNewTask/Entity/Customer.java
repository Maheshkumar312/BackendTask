package com.prodian.SpringNewTask.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customer")
public class Customer  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cif_number;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "mobile_number")
	private long mobileNumber;

	@Column(name = "email_id")
	private String emailId;
	private long mpin;

	@JsonManagedReference
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public long getCif_number() {
		return cif_number;
	}

	public void setCif_number(long cif_number) {
		this.cif_number = cif_number;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMpin() {
		return mpin;
	}

	public void setMpin(long mpin) {
		this.mpin = mpin;
	}

	public Customer(long cif_number, String firstName, String lastName, long mobileNumber, String emailId, long mpin,
			Account account) {
		super();
		this.cif_number = cif_number;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.mpin = mpin;
		this.account = account;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [cif_number=" + cif_number + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", mpin=" + mpin + ", account=" + account
				+ "]";
	}

}
