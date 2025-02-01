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
import com.qsp.Bank_Management_System.dto.Card;
import com.qsp.Bank_Management_System.dto.Customer;
import com.qsp.Bank_Management_System.dto.FixedDeposit;
import com.qsp.Bank_Management_System.dto.Loan;
import com.qsp.Bank_Management_System.service.CustomerService;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	@Operation(summary = "Save Customers", description = "API is used to save the Customers")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Customers not found for the given id") })
	@PostMapping("/saveCustomers")
	public ResponseStructure<Customer> saveCustomer(@RequestBody Customer Customer)
	{
		return customerService.saveCustomer(Customer);

	}
	
	@Operation(summary = "Fetch Customers", description = "API is used to find the Customers")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Customers not found for the given id") })
	@GetMapping("/fetchCustomerById")
	public ResponseStructure<Customer> fetchCustomerById(@RequestParam int CustomerId) {
		return customerService.fetchCustomerById(CustomerId);
		
	}
	
	@Operation(summary = "Delete Customers", description = "API is used to delete the Employee")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Employee not found for the given id") })
	@DeleteMapping("/deleteCustomerById")
	public ResponseStructure<Customer> deleteCustomerById(int CustomerId) {
		return customerService.deleteCustomerById(CustomerId);
		
	}
	
	@Operation(summary = "Update Customers", description = "API is used to Update the Customers details")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Customers not found for the given id") })
	@PutMapping("/updateCustomerById")
	public ResponseStructure<Customer> updateCustomerById(@RequestParam int oldCustomerId ,@RequestBody Customer newCustomer) {
		return customerService.updateCustomerById(oldCustomerId, newCustomer);
	}
	
	@Operation(summary = "Fetch All Customers", description = "API is used to find all the Customers")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Customers not found") })
	@GetMapping("/fetchAllCustomers")
	public ResponseStructureList<Customer> fetchAllCustomers() {
		return customerService.fetchAllCustomers();
		
	}
	
	
	
	@Operation(summary = "Add Existing Account To Existing Customer", description = "API is used to add existing account to existing customer")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Account not found to existing customer") })
	@PutMapping("/addExistingAccountToExistingCustomer")
	public ResponseStructure<Customer> addExistingAccountToExistingCustomer(@RequestParam int AccountId, @RequestParam int CustomerId) {
		return customerService.addExistingAccountToExistingCustomer(AccountId, CustomerId);
	}
	
	@Operation(summary = "Add New Account To Existing Customer", description = "API is used to add new account to existing customer")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "New account not found to existing customer") })
	@PutMapping("/addNewAccountToExistingCustomer")
	public ResponseStructure<Customer> addNewAccountToExistingCustomer(@RequestParam int CustomerId, @RequestBody Account newAccount) {
		return customerService.addNewAccountToExistingCustomer(CustomerId, newAccount);
	}
	
	
	
	@Operation(summary = "Add Existing Card To Existing Customer", description = "API is used to add existing card to existing customer")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Card not found to existing customer") })
	@PutMapping("/addExistingCardToExistingCustomer")
	public ResponseStructure<Customer> addExistingCardToExistingCustomer(@RequestParam int CardId,@RequestParam int CustomerId) {
		return customerService.addExistingCardToExistingCustomer(CardId, CustomerId);
	}
	
	@Operation(summary = "Add New Card To Existing Customer", description = "API is used to add new card to existing customer")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "New card not found to existing customer") })
	@PutMapping("/addNewCardToExistingCustomer")
	public ResponseStructure<Customer> addNewCardToExistingCustomer(@RequestParam int CustomerId, @RequestBody Card newCard) {
		return customerService.addNewCardToExistingCustomer(CustomerId, newCard);
	}
	
	
	
	@Operation(summary = "Add Existing Loan To Existing Customer", description = "API is used to add existing loan to existing customer")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Loan not found to existing customer") })
	@PutMapping("/addExistingLoanToExistingCustomer")
	public ResponseStructure<Customer> addExistingLoanToExistingCustomer(@RequestParam int LoanId, @RequestParam int CustomerId) {
		return customerService.addExistingLoanToExistingCustomer(LoanId, CustomerId);
	}
	
	@Operation(summary = "Add New Loan To Existing Customer", description = "API is used to add new loan to existing customer")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "New loan not found to existing customer") })
	@PutMapping("/addNewLoanToExistingCustomer")
	public ResponseStructure<Customer> addNewLoanToExistingCustomer(@RequestParam int CustomerId, @RequestBody Loan newLoan) {
		return customerService.addNewLoanToExistingCustomer(CustomerId, newLoan);
	}
	
	
	
	
	@Operation(summary = "Add Existing FixedDeposit To Existing Customer", description = "API is used to add existing fixed deposit to existing customer")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Fixed deposit not found to existing customer") })
	@PutMapping("/addExistingFixedDepositToExistingCustomer")
	public ResponseStructure<Customer> addExistingFixedDepositToExistingCustomer(@RequestParam int FixedDepositId, @RequestParam int CustomerId) {
		return customerService.addExistingFixedDepositToExistingCustomer(FixedDepositId, CustomerId);
	}
	
	@Operation(summary = "Add New FixedDeposit To Existing Customer", description = "API is used to add new fixed deposit to existing customer")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "New fixed deposit not found to existing customer") })
	@PutMapping("/addNewFixedDepositToExistingCustomer")
	public ResponseStructure<Customer> addNewFixedDepositToExistingCustomer(@RequestParam int CustomerId, @RequestBody FixedDeposit newFixedDeposit) {
		return customerService.addNewFixedDepositToExistingCustomer(CustomerId, newFixedDeposit);
	}

}
