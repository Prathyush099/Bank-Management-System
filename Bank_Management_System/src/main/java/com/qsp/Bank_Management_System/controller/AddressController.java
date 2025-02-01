package com.qsp.Bank_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Bank_Management_System.dto.Address;
import com.qsp.Bank_Management_System.service.AddressService;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AddressController {
	
	@Autowired
	AddressService addressService;

	@Operation(summary = "Save Address", description = "API is used to save the Address")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Address not found for the given id") })
	@PostMapping("/saveAddress")
	public ResponseStructure<Address> saveAddress(@RequestBody Address Address)
	{
		return addressService.saveAddress(Address);

	}
	
	@Operation(summary = "Fetch Address", description = "API is used to find the Address")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Address not found for the given id") })
	@GetMapping("/fetchAddressById")
	public ResponseStructure<Address> fetchAddressById(@RequestParam int AddressId) {
		return addressService.fetchAddressById(AddressId);
		
	}
	
	@Operation(summary = "Delete Address", description = "API is used to delete the Address")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Address not found for the given id") })
	@DeleteMapping("/deleteAddressById")
	public ResponseStructure<Address> deleteAddressById(int AddressId) {
		return addressService.deleteAddressById(AddressId);
		
	}
	
	@Operation(summary = "Update Address", description = "API is used to Update the Address details")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Address not found for the given id") })
	@PutMapping("/updateAddressById")
	public ResponseStructure<Address> updateAddressById(@RequestParam int oldAddressId ,@RequestBody Address newAddress) {
		return addressService.updateAddressById(oldAddressId, newAddress);
	}
	
	@Operation(summary = "Fetch All Address", description = "API is used to find all the Address")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Address not found") })
	@GetMapping("/fetchAllAddresss")
	public ResponseStructureList<Address> fetchAllAddresss() {
		return addressService.fetchAllAddresss();
		
	}


}
