package com.qa.MapTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.util.JSONUtil;

public class AccountServiceTest {
	private JSONUtil json;
	private AccountMapRepository am1;
	private Account acc1;
	private Account acc2;
	private Account acc3;

	@Before
	public void setup() {
		json = new JSONUtil();
		am1 = new AccountMapRepository();
		acc1 = new Account("K", "P", 1, 1);
		acc2 = new Account("p", "L", 1, 1);
		acc3 = new Account("K", "L", 1, 1);
	}

	// @Test
	// public void getAllAccounts() {
	//
	// }

	@Test
	public void addAccountTest() {
		String testAcc = json.getJSONForObject(acc1);
		am1.createAccount(testAcc);
		assertTrue(am1.getAccountMap().containsKey(1));

	}

	@Test
	public void searchForNameThatDoesNotExist() {
		System.out.println(json.getJSONForObject(acc1));
		am1.getAccountMap().put(1, acc1);
		am1.getAccountMap().put(2, acc2);
		am1.getAccountMap().put(2, acc3);

		int count = am1.seachForName("A");
		assertEquals(0, count);
		// {"firstName":"K","lastName":"P","accountNumber":1,"id":1}
		// assertTrue(am1.getAccountMap().containsValue(acc1));
	}

	@Test
	public void searchFor1Name() {
		System.out.println(json.getJSONForObject(acc1));
		am1.getAccountMap().put(1, acc1);
		am1.getAccountMap().put(2, acc2);

		int count = am1.seachForName("K");
		assertEquals(1, count);
		// {"firstName":"K","lastName":"P","accountNumber":1,"id":1}
		// assertTrue(am1.getAccountMap().containsValue(acc1));
	}

	@Test
	public void searchFor2Name() {
		System.out.println(json.getJSONForObject(acc1));
		am1.getAccountMap().put(1, acc1);
		am1.getAccountMap().put(2, acc2);
		am1.getAccountMap().put(2, acc3);

		int count = am1.seachForName("K");
		assertEquals(2, count);
		// {"firstName":"K","lastName":"P","accountNumber":1,"id":1}
		// assertTrue(am1.getAccountMap().containsValue(acc1));
	}

	// @Test
	// public void add2AccountsTest() {
	// fail("TODO");
	// }
	//
	// @Test
	// public void removeAccountTest() {
	// fail("TODO");
	// }
	//
	// @Test
	// public void remove2AccountsTest() {
	// fail("TODO");
	// }
	//
	// @Test
	// public void remove2AccountTestAnd1ThatDoesntExist() {
	// fail("TODO");
	// }
	//
	// @Test
	// public void jsonStringToAccountConversionTest() {
	// // testing JSONUtil
	// fail("TODO");
	// }
	//
	// @Test
	// public void accountConversionToJSONTest() {
	// // testing JSONUtil
	// fail("TODO");
	// }
	//
	// @Test
	// public void getCountForFirstNamesInAccountWhenZeroOccurances() {
	// // For a later piece of functionality
	// fail("TODO");
	// }
	//
	// @Test
	// public void getCountForFirstNamesInAccountWhenOne() {
	// // For a later piece of functionality
	// fail("TODO");
	// }
	//
	// @Test
	// public void getCountForFirstNamesInAccountWhenTwo() {
	// // For a later piece of functionality
	// fail("TODO");
	// }

}
