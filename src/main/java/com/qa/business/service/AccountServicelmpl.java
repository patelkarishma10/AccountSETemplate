package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.AccountRepository;

public class AccountServicelmpl implements AccountService {

	@Inject
	private AccountRepository repo;

	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	public void setRepo(AccountRepository repo) {
		this.repo = repo;
	}

	@Override
	public String createAccount(String account) {
		if (account.contains("9999")) {

			return "{\"message\": \"this account is blocked\"}";
		}
		return repo.createAccount(account);
	}

	@Override
	public String updateAccount(int accountNumber, String account) {
		return repo.updateAccount(accountNumber, account);
	}

	@Override
	public String deleteAccount(int accountNumber) {
		return repo.deleteAccount(accountNumber);
	}

	@Override
	public String searchAccount(int id) {
		return repo.searchAccount(id);
	}

}
