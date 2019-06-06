package com.qa.business.service;

public interface AccountService {
	// C
	String createAccount(String account);

	// R
	String getAllAccounts();

	String searchAccount(int id);

	// U
	String updateAccount(int accountNumber, String account);

	// D
	String deleteAccount(int accountNumber);

}
