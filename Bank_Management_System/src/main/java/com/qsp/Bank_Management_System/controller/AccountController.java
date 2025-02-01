package com.qsp.Bank_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Bank_Management_System.dto.Account;
import com.qsp.Bank_Management_System.service.AccountService;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;

	
	@Operation(summary = "Save Account", description = "API is used to save the Account")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Account not found for the given id") })
	@PostMapping("/saveAccount")
	public ResponseStructure<Account> saveAccount(@RequestBody Account Account)
	{
		return accountService.saveAccount(Account);

	}
	
	@Operation(summary = "Fetch Account", description = "API is used to find the Account")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Account not found for the given id") })
	@GetMapping("/fetchAccountById")
	public ResponseStructure<Account> fetchAccountById(@RequestParam int AccountId) {
		return accountService.fetchAccountById(AccountId);
		
	}
	
	@Operation(summary = "Delete Account", description = "API is used to delete the Account")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Account not found for the given id") })
	@DeleteMapping("/deleteAccountById")
	public ResponseStructure<Account> deleteAccountById(int AccountId) {
		return accountService.deleteAccountById(AccountId);
		
	}
	
	@Operation(summary = "Update Account", description = "API is used to Update the Account details")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Account not found for the given id") })
	@PutMapping("/updateAccountById")
	public ResponseStructure<Account> updateAccountById(@RequestParam int oldAccountId ,@RequestBody Account newAccount) {
		return accountService.updateAccountById(oldAccountId, newAccount);
	}
	
	@Operation(summary = "Fetch All Account", description = "API is used to find all the Account")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Account not found") })
	@GetMapping("/fetchAllAccounts")
	public ResponseStructureList<Account> fetchAllAccounts() {
		return accountService.fetchAllAccounts();
		
	}


}
