package com.qsp.Bank_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Bank_Management_System.dto.Bank;
import com.qsp.Bank_Management_System.dto.Branch;
import com.qsp.Bank_Management_System.service.BankService;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BankController {
	
	@Autowired
	BankService bankService;
	

	@Operation(summary = "Save Bank", description = "API is used to save the Bank")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Bank not found for the given id") })
	@PostMapping("/saveBank")
	public ResponseStructure<Bank> saveBank(@RequestBody Bank Bank)
	{
		return bankService.saveBank(Bank);

	}
	
	@Operation(summary = "Fetch Bank", description = "API is used to find the Bank")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Bank not found for the given id") })
	@GetMapping("/fetchBankById")
	public ResponseStructure<Bank> fetchBankById(@RequestParam int BankId) {
		return bankService.fetchBankById(BankId);
		
	}
	
	@Operation(summary = "Delete Bank", description = "API is used to delete the Bank")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Bank not found for the given id") })
	@DeleteMapping("/deleteBankById")
	public ResponseStructure<Bank> deleteBankById(int BankId) {
		return bankService.deleteBankById(BankId);
		
	}
	
	@Operation(summary = "Update Bank", description = "API is used to Update the Bank details")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Bank not found for the given id") })
	@PutMapping("/updateBankById")
	public ResponseStructure<Bank> updateBankById(@RequestParam int oldBankId ,@RequestBody Bank newBank) {
		return bankService.updateBankById(oldBankId, newBank);
	}
	
	@Operation(summary = "Fetch All Banks", description = "API is used to find all the Banks")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Banks not found") })
	@GetMapping("/fetchAllBanks")
	public ResponseStructureList<Bank> fetchAllBanks() {
		return bankService.fetchAllBanks();
		
	}
	
	
	
	@Operation(summary = "Add Existing Branch To Existing Bank", description = "API is used to add existing branch to existing Bank")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "branch not found to existing Bank") })
	@PutMapping("/addExistingBranchToExistingBank")
	public ResponseStructure<Bank> addExistingBranchToExistingBank(@RequestParam int BranchId, @RequestParam int BankId) {
		return bankService.addExistingBranchToExistingBank(BranchId, BankId);
	}
	
	
	@Operation(summary = "Add New Branch To Existing Bank", description = "API is used to add new branch to existing Bank")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "New branch not found to existing Bank") })
	@PutMapping("/addNewBranchToExistingBank")
	public ResponseStructure<Bank> addNewBranchToExistingBank(@RequestParam int bankId, @RequestBody Branch newBranch) {
		return bankService.addNewBranchToExistingBank(bankId, newBranch);
	}

}
