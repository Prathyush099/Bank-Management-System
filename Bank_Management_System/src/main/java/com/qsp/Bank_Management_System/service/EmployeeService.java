package com.qsp.Bank_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Bank_Management_System.dao.EmployeeDao;
import com.qsp.Bank_Management_System.dto.Employee;
import com.qsp.Bank_Management_System.exception.EmployeeIdNotFound;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	ResponseStructure<Employee> responseStructure;

	@Autowired
	ResponseStructureList<Employee> responseStructureList;

	public ResponseStructure<Employee> saveEmployee(Employee Employee) {
		responseStructure.setMessage("Employee has being inserted");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(employeeDao.saveEmployee(Employee));
		return responseStructure;

	}

	public ResponseStructure<Employee> fetchEmployeeById(int EmployeeId) {
		Employee employee = employeeDao.deleteEmployeeById(EmployeeId);
		if (employee != null) {
			responseStructure.setMessage("Employee has being Fetched");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(employeeDao.fetchEmployeeById(EmployeeId));
			return responseStructure;
		} else {
			throw new EmployeeIdNotFound();
		}

	}

	public ResponseStructure<Employee> deleteEmployeeById(int EmployeeId) {
		Employee employee = employeeDao.deleteEmployeeById(EmployeeId);
		if (employee != null) {
			responseStructure.setMessage("This respective Employee has being Deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(employeeDao.deleteEmployeeById(EmployeeId));
			return responseStructure;
		} else {
			throw new EmployeeIdNotFound();
		}

	}

	public ResponseStructure<Employee> updateEmployeeById(int oldEmployeeId, Employee newEmployee) {
		Employee employee = employeeDao.deleteEmployeeById(oldEmployeeId);
		if (employee != null) {
			responseStructure.setMessage("This respective Employee is Updated in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(employeeDao.updateEmployeeById(oldEmployeeId, newEmployee));
			return responseStructure;
		} else {
			throw new EmployeeIdNotFound();
		}
	}

	public ResponseStructureList<Employee> fetchAllEmployees() {
		responseStructureList.setMessage("All the Employee has being Fetched from DB");
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setData(employeeDao.fetchAllEmployees());
		return responseStructureList;

	}

}
