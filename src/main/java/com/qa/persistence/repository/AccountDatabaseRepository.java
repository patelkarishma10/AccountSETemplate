package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountDatabaseRepository implements AccountRepository {

	@Inject
	private JSONUtil json;

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
		Account accountFound = em.find(Account.class, accountNumber);
		em.remove(accountFound);
		return "{\"message\": \"account has been sucessfully deleted\"}";
	}

	@Transactional(REQUIRED)
	public String updateAccount(int accountNumber, String account) {

		Account accountCreated = this.json.getObjectForJSON(account, Account.class);
		Query q1 = em.createQuery(String.format(
				"UPDATE Account a SET a.accountNumber = '%s', a.firstName = '%s', a.lastName = '%s' WHERE a.id = %s",
				accountCreated.getAccountNumber(), accountCreated.getFirstName(), accountCreated.getLastName(),
				accountNumber));

		q1.executeUpdate();
		return "{\"message\": \"account has been sucessfully updated\"}";
	}

	public String searchAccount(int id) {
		Account accountFound = em.find(Account.class, id);
		return json.getJSONForObject(accountFound);

	}

}
