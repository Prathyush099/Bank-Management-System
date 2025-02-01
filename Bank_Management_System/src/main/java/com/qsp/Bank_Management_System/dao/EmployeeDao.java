package com.qsp.Bank_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Bank_Management_System.dto.Employee;
import com.qsp.Bank_Management_System.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	
	@Autowired
	EmployeeRepo employeeRepo;

	public Employee saveEmployee(Employee Employee) 
	{
		return employeeRepo.save(Employee);

	}
	
	public Employee fetchEmployeeById(int EmployeeId) {
		Optional<Employee> employee = employeeRepo.findById(EmployeeId);
		if (employee.isPresent()) {
			return employee.get();
		}else {
			 return null;
		}
		
	}
	
	public Employee deleteEmployeeById(int EmployeeId) {
		Optional<Employee> Employee= employeeRepo.findById(EmployeeId);
		if (Employee.isPresent()) {
			employeeRepo.delete(Employee.get()); 
	        return Employee.get();
	    } else {
	        return null;
	    }
		
	}
	
	public Employee updateEmployeeById(int oldEmployeeId,Employee newEmployeeId) {
		newEmployeeId.setEmployeeId(oldEmployeeId);
		Optional<Employee> employee= employeeRepo.findById(oldEmployeeId);
		if (employee.isPresent()) {
			return employeeRepo.save(newEmployeeId);
		}else {
			 return null;
		}
		
	}
	
	public List<Employee> fetchAllEmployees() {
		return employeeRepo.findAll();
		
	}

}
