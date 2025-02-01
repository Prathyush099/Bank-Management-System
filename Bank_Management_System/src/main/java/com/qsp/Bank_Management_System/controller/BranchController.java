package com.qsp.Bank_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Bank_Management_System.dto.Branch;
import com.qsp.Bank_Management_System.dto.Customer;
import com.qsp.Bank_Management_System.dto.Employee;
import com.qsp.Bank_Management_System.service.BranchService;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BranchController {
	
	@Autowired
	BranchService branchService;

	@Operation(summary = "Save Branch", description = "API is used to save the Branch")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@PostMapping("/saveBranch")
	public ResponseStructure<Branch> saveBranch(@RequestBody Branch Branch)
	{
		return branchService.saveBranch(Branch);

	}
	
	@Operation(summary = "Fetch Branch", description = "API is used to find the Branchs")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@GetMapping("/fetchBranchById")
	public ResponseStructure<Branch> fetchBranchById(@RequestParam int BranchId) {
		return branchService.fetchBranchById(BranchId);
		
	}
	
	@Operation(summary = "Delete Branch", description = "API is used to delete the Branch")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@DeleteMapping("/deleteBranchById")
	public ResponseStructure<Branch> deleteBranchById(int BranchId) {
		return branchService.deleteBranchById(BranchId);
		
	}
	
	@Operation(summary = "Update Branch", description = "API is used to Update the Branch details")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@PutMapping("/updateBranchById")
	public ResponseStructure<Branch> updateBranchById(@RequestParam int oldBranchId ,@RequestBody Branch newBranch) {
		return branchService.updateBranchById(oldBranchId, newBranch);
	}
	
	@Operation(summary = "Fetch All Branchs", description = "API is used to find all the Branches")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Branches not found") })
	@GetMapping("/fetchAllBranchs")
	public ResponseStructureList<Branch> fetchAllBranchs() {
		return branchService.fetchAllBranchs();
		
	}
	
	
	//......................................
	@Operation(summary = "Add Existing Address To Existing Branch", description = "API is used to add existing address to existing branch")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Address not found to existing Branch") })
	@PutMapping("/addExistingAddressTOExistingBranch")
	public ResponseStructure<Branch> addExistingAddressTOExistingBranch(@RequestParam int AddressId, @RequestParam int BranchId) {
		return branchService.addExistingAddressTOExistingBranch(AddressId, BranchId);
		
	}
	
	@Operation(summary = "Add Existing Manager To Existing Branch", description = "API is used to add existing manager to existing branch")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Manager not found to existing Branch") })
	@PutMapping("/addExistingManagerTOExistingBranch")
	public ResponseStructure<Branch> addExistingManagerTOExistingBranch(@RequestParam int ManagerId, @RequestParam int BranchId) {
		return branchService.addExistingManagerTOExistingBranch(ManagerId, BranchId);
		
	}
	//.....................................
	
	
	
	
	@Operation(summary = "Add Existing Employee To Existing Branch", description = "API is used to add existing employee to existing branch")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Employee not found to existing Branch") })
	@PutMapping("/addExistingEmployeeTOExistingBranch")
	public ResponseStructure<Branch> addExistingEmployeeTOExistingBranch(@RequestParam int EmployeeId, @RequestParam int BranchId) {
		return branchService.addExistingEmployeeToExistingBranch(EmployeeId, BranchId);
		
	}
	
	@Operation(summary = "Add New Employee To Existing Branch", description = "API is used to add new employee to existing branch")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "New employee not found to existing branch") })
	@PutMapping("/addNewEmployeeToExistingBranch")
	public ResponseStructure<Branch> addNewEmployeeToExistingBranch(@RequestParam int BranchId, @RequestBody Employee newEmployee) {
		return branchService.addNewEmployeeToExistingBranch(BranchId, newEmployee);
	}
	
	
	
	
	
	
	
	@Operation(summary = "Add Existing Customer To Existing Branch", description = "API is used to add existing customer to existing branch")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Customer not found to existing Branch") })
	@PutMapping("/addExisitingCustomerToExistingBranch")
	public ResponseStructure<Branch> addExisitingCustomerToExistingBranch(@RequestParam int CustomerId, @RequestParam int BranchId) {
		return branchService.addExisitingCustomerToExistingBranch(CustomerId, BranchId);
		
	}
	@Operation(summary = "Add New Customer To Existing Branch", description = "API is used to add new customer to existing branch")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "New customer not found to existing branch") })
	@PutMapping("/addNewCustomerToExistingBranch")
	public ResponseStructure<Branch> addNewCustomerToExistingBranch(@RequestParam int BranchId, @RequestBody Customer newCustomer) {
		return branchService.addNewCustomerToExistingBranch(BranchId, newCustomer);
	}


}
