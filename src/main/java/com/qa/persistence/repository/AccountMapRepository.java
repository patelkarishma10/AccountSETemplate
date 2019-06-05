package com.qa.persistence.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class AccountMapRepository implements AccountRepository {

	private Map<Integer, Account> accountMap = new HashMap<Integer, Account>();
	JSONUtil json = new JSONUtil();

	// You must provide concrete implementation for each of these methods
	// do not change the method signature
	// THINK - if the parameter is a String, or the return type is a String
	// How can I convert to a String from an Object?
	// What utility methods do I have available?

	// You must complete this section using TDD
	// You can use the suggested tests or build your own.

	public String getAllAccounts() {
		System.out.println(json.getJSONForObject(accountMap));
		return json.getJSONForObject(accountMap);
	}

	public String createAccount(String account) {
		Account acc1 = this.json.getObjectForJSON(account, Account.class);
		accountMap.put(acc1.getId(), acc1);
		// if (accountMap.get(acc1.getAccountNumber()) == acc1) {
		// return "Account successfully created";
		// } else {
		// return "Account not successfully created";
		// }
		return "created successfuly";
	}

	public String deleteAccount(int accountNumber) {
		Account acc1 = new Account("K", "P", "1", 1);
		accountMap.remove(acc1.getAccountNumber(), acc1);
		return "Account successfully deleted";
	}

	public String updateAccount(int accountNumber, String account) {
		// TODO Auto-generated method stub
		return null;
	}

	public int seachForName(String str) {
		Collection<Account> accList = accountMap.values();
		int count = 0;
		for (Account eachaccount : accList) {
			if (eachaccount.getFirstName().equals(str)) {
				count++;
			}
		}

		System.out.println(count);
		return count;
	}

	public Map<Integer, Account> getAccountMap() {
		return accountMap;
	}

	public void setAccountMap(Map<Integer, Account> accountMap) {
		this.accountMap = accountMap;
	}

}
