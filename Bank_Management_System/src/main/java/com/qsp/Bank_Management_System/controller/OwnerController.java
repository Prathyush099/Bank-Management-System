package com.qsp.Bank_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Bank_Management_System.dto.Owner;
import com.qsp.Bank_Management_System.service.OwnerService;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class OwnerController {

	@Autowired
	OwnerService ownerService;

	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@PostMapping("/saveOwner")
	public ResponseStructure<Owner> saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);

	}

	@Operation(summary = "Fetch Owner", description = "API is used to find the Owner")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@GetMapping("/fetchOwnerById")
	public ResponseStructure<Owner> fetchOwnerById(@RequestParam int ownerId) {
		return ownerService.fetchOwnerById(ownerId);

	}

	@Operation(summary = "Delete Owner", description = "API is used to delete the Owner")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@DeleteMapping("/deleteOwnerById")
	public ResponseStructure<Owner> deleteOwnerById(int ownerId) {
		return ownerService.deleteOwnerById(ownerId);

	}

	@Operation(summary = "Update Owner", description = "API is used to Update the Owner details")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@PutMapping("/updateOwnerById")
	public ResponseStructure<Owner> updateOwnerById(@RequestParam int oldOwnerId, @RequestBody Owner newOwner) {
		return ownerService.updateOwnerById(oldOwnerId, newOwner);
	}
	

	@Operation(summary = "Fetch All Owners", description = "API is used to find all the Owners")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Owners not found") })
	@GetMapping("/fetchAllOwners")
	public ResponseStructureList<Owner> fetchAllOwners() {
		return ownerService.fetchAllOwners();
	}

	@Operation(summary = "Fetch All Owners", description = "API is used to add existing owner to existing bank")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully "),
			@ApiResponse(responseCode = "404", description = "Owners not found") })
	@PutMapping("/addExistingOwnerTOExistingBank")
	public ResponseStructure<Owner> addExistingOwnerTOExistingBank(@RequestParam int bankId,@RequestParam int OwnerId) {
		return ownerService.addExistingOwnerTOExistingBank(bankId, OwnerId);

	}

}
