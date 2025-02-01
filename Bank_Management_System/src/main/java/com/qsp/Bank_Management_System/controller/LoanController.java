package com.qsp.Bank_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Bank_Management_System.dto.Loan;
import com.qsp.Bank_Management_System.service.LoanService;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
public class LoanController {
	
	@Autowired
	LoanService loanService;

	
	@Operation(summary = "Save Loan", description = "API is used to save the Loan")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Loan not found for the given id") })
	@PostMapping("/saveLoan")
	public ResponseStructure<Loan> saveLoan(@RequestBody Loan loan)
	{
		return loanService.saveLoan(loan);

	}
	
	@Operation(summary = "Fetch Loan", description = "API is used to find the Loan")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Loan not found for the given id") })
	@GetMapping("/fetchLoanById")
	public ResponseStructure<Loan> fetchLoanById(@RequestParam int loanId) {
		return loanService.fetchLoanById(loanId);
		
	}
	
	@Operation(summary = "Delete Loan", description = "API is used to delete the Loan")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Loan not found for the given id") })
	@DeleteMapping("/deleteLoanById")
	public ResponseStructure<Loan> deleteLoanById(int loanId) {
		return loanService.deleteLoanById(loanId);
		
	}
	
	@Operation(summary = "Update Loan", description = "API is used to Update the Loan details")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Loan not found for the given id") })
	@PutMapping("/updateLoanById")
	public ResponseStructure<Loan> updateLoanById(@RequestParam int oldLoanId ,@RequestBody Loan newLoan) {
		return loanService.updateLoanById(oldLoanId, newLoan);
	}
	
	@Operation(summary = "Fetch All Loan", description = "API is used to find all the Loan")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Loan not found") })
	@GetMapping("/fetchAllLoans")
	public ResponseStructureList<Loan> fetchAllLoans() {
		return loanService.fetchAllLoans();
		
	}

}
