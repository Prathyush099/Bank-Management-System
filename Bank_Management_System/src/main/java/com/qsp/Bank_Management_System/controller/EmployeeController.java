package com.qsp.Bank_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Bank_Management_System.dto.Employee;
import com.qsp.Bank_Management_System.service.EmployeeService;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService EmployeeService;

	@Operation(summary = "Save Employee", description = "API is used to save the Employee")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Employee not found for the given id") })
	@PostMapping("/saveEmployees")
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee Employee)
	{
		return EmployeeService.saveEmployee(Employee);

	}
	
	@Operation(summary = "Fetch Employee", description = "API is used to find the Employee")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Employee not found for the given id") })
	@GetMapping("/fetchEmployeeById")
	public ResponseStructure<Employee> fetchEmployeeById(@RequestParam int EmployeeId) {
		return EmployeeService.fetchEmployeeById(EmployeeId);
		
	}
	
	@Operation(summary = "Delete Employee", description = "API is used to delete the Employee")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Employee not found for the given id") })
	@DeleteMapping("/deleteEmployeeById")
	public ResponseStructure<Employee> deleteEmployeeById(int EmployeeId) {
		return EmployeeService.deleteEmployeeById(EmployeeId);
		
	}
	
	@Operation(summary = "Update Employee", description = "API is used to Update the Employee details")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Employee not found for the given id") })
	@PutMapping("/updateEmployeeById")
	public ResponseStructure<Employee> updateEmployeeById(@RequestParam int oldEmployeeId ,@RequestBody Employee newEmployee) {
		return EmployeeService.updateEmployeeById(oldEmployeeId, newEmployee);
	}
	
	@Operation(summary = "Fetch All Employees", description = "API is used to find all the Employees")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Employee not found") })
	@GetMapping("/fetchAllEmployees")
	public ResponseStructureList<Employee> fetchAllEmployees() {
		return EmployeeService.fetchAllEmployees();
		
	}


}
