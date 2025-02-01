package com.qsp.Bank_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Bank_Management_System.dto.Manager;
import com.qsp.Bank_Management_System.service.ManagerService;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ManagerController {
	
	@Autowired
	ManagerService managerService;

	@Operation(summary = "Save Manager", description = "API is used to save the Manager")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Manager not found for the given id") })
	@PostMapping("/saveManager")
	public ResponseStructure<Manager> saveManager(@RequestBody Manager manager)
	{
		return managerService.saveManager(manager);

	}
	
	@Operation(summary = "Fetch Manager", description = "API is used to find the Manager")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Manager not found for the given id") })
	@GetMapping("/fetchmanagerById")
	public ResponseStructure<Manager> fetchmanagerById(@RequestParam int managerId) {
		return managerService.fetchmanagerById(managerId);
		
	}
	
	@Operation(summary = "Delete Manager", description = "API is used to delete the Manager")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Manager not found for the given id") })
	@DeleteMapping("/deletemanagerById")
	public ResponseStructure<Manager> deletemanagerById(@RequestParam int managerId) {
		return managerService.deletemanagerById(managerId);
		
	}
	
	@Operation(summary = "Update Manager", description = "API is used to Update the Manager details")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Manager not found for the given id") })
	@PutMapping("/updatemanagerById")
	public ResponseStructure<Manager> updatemanagerById(@RequestParam int oldManagerId ,@RequestBody Manager newmanager) {
		return managerService.updatemanagerById(oldManagerId, newmanager);
	}
	
	@Operation(summary = "Fetch All Manager", description = "API is used to find all the Manager")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Manager not found") })
	@GetMapping("/fetchAllManagers")
	public ResponseStructureList<Manager> fetchAllManagers() {
		return managerService.fetchAllManager();
		
	}
}
