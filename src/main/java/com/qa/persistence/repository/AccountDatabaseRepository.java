package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class AccountDatabaseRepository implements AccountRepository {

	JSONUtil json = new JSONUtil();
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	public String getAllAccounts() {
		TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a", Account.class);
		Collection<Account> accounts = query.getResultList();
		return json.getJSONForObject(accounts);
	}

	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account accountCreated = this.json.getObjectForJSON(account, Account.class);
		em.persist(accountCreated);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String deleteAccount(int accountNumber) {
		Query deleteQuery = em.createQuery("DELETE a FROM Account a WHERE id = accountNumber");
		return "{\"message\": \"account has been sucessfully deleted\"}";
	}

	@Transactional(REQUIRED)
	public String updateAccount(int accountNumber, String account) {
		Account accountFound = em.find(Account.class, accountNumber);
		em.remove(accountFound);
		Account accountCreated = this.json.getObjectForJSON(account, Account.class);
		em.persist(accountCreated);
		return "{\"message\": \"account has been sucessfully updated\"}";
	}

	public String findAnAccount(int id) {
		Account accountFound = em.find(Account.class, id);
		return json.getJSONForObject(accountFound);

	}

}
