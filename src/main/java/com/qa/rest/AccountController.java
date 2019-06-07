package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.AccountService;

@Path("/account")
public class AccountController {
	@Inject
	private AccountService service;

	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return service.getAllAccounts();
	}

	@Path("/createAccounts")
	@POST
	@Produces({ "application/json" })
	public String createAccount(String account) {
		return service.createAccount(account);
	}

	@Path("/deleteAccounts/{accountNumber}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("accountNumber") int accountNumber) {
		return service.deleteAccount(accountNumber);
	}

	@Path("/searchAccounts/{id}")
	@GET
	@Produces({ "application/json" })
	public String searchAccount(@PathParam("id") int id) {
		return service.searchAccount(id);
	}

	@Path("/updateAccounts/{accountNumber}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("accountNumber") int accountNumber, String account) {
		return service.updateAccount(accountNumber, account);
	}

}
