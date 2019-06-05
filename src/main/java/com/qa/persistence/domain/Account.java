package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 50)
	private String firstName;
	@Column(length = 50)
	private String lastName;
	@Column(length = 4)
	private String accountNumber;

	public Account(String firstName, String lastName, String accountNumber, int id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		this.id = id;
	}

	public Account() {

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

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
