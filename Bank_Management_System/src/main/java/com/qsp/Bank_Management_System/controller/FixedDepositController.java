package com.qsp.Bank_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Bank_Management_System.dto.FixedDeposit;
import com.qsp.Bank_Management_System.service.FixedDepositService;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class FixedDepositController {
	
	@Autowired
	FixedDepositService fixedDepositService;

	
	@Operation(summary = "Save FixedDeposit", description = "API is used to save the FixedDeposit")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "FixedDeposit not found for the given id") })
	@PostMapping("/saveFixedDeposit")
	public ResponseStructure<FixedDeposit> saveFixedDeposit(@RequestBody FixedDeposit FixedDeposit)
	{
		return fixedDepositService.saveFixedDeposit(FixedDeposit);

	}
	
	@Operation(summary = "Fetch FixedDeposit", description = "API is used to find the FixedDeposit")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "FixedDeposit not found for the given id") })
	@GetMapping("/fetchFixedDepositById")
	public ResponseStructure<FixedDeposit> fetchFixedDepositById(@RequestParam int fdId) {
		return fixedDepositService.fetchFixedDepositById(fdId);
		
	}
	
	@Operation(summary = "Delete FixedDeposit", description = "API is used to delete the FixedDeposit")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "FixedDeposit not found for the given id") })
	@DeleteMapping("/deleteFixedDepositById")
	public ResponseStructure<FixedDeposit> deleteFixedDepositById(int fdId) {
		return fixedDepositService.deleteFixedDepositById(fdId);
		
	}
	
	@Operation(summary = "Update FixedDeposit", description = "API is used to Update the FixedDeposit details")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "FixedDeposit not found for the given id") })
	@PutMapping("/updateFixedDepositById")
	public ResponseStructure<FixedDeposit> updateFixedDepositById(@RequestParam int oldFixedDepositId ,@RequestBody FixedDeposit newFixedDeposit) {
		return fixedDepositService.updateFixedDepositById(oldFixedDepositId, newFixedDeposit);
	}
	
	@Operation(summary = "Fetch All FixedDeposit", description = "API is used to find all the FixedDeposit")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "FixedDeposit not found") })
	@GetMapping("/fetchAllFixedDeposits")
	public ResponseStructureList<FixedDeposit> fetchAllFixedDeposits() {
		return fixedDepositService.fetchAllFixedDeposits();
		
	}

}
