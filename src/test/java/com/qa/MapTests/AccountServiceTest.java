package com.qa.MapTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.util.JSONUtil;

public class AccountServiceTest {
	private JSONUtil json;
	private AccountMapRepository am1;

	@Before
	public void setup() {
		json = new JSONUtil();
		am1 = new AccountMapRepository();
	}

	@Test
	public void addAccountTest() {
		Account acc1 = new Account("K", "P", 1, 1);
		String testAcc = json.getJSONForObject(acc1);
		String message = am1.createAccount(testAcc);
		assertEquals(message, am1.createAccount(testAcc));
	}

	@Test
	public void add2AccountsTest() {
		fail("TODO");
	}

	@Test
	public void removeAccountTest() {
		fail("TODO");
	}

	@Test
	public void remove2AccountsTest() {
		fail("TODO");
	}

	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		fail("TODO");
	}

	@Test
	public void jsonStringToAccountConversionTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Test
	public void accountConversionToJSONTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		// For a later piece of functionality
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		// For a later piece of functionality
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenTwo() {
		// For a later piece of functionality
		fail("TODO");
	}

}
