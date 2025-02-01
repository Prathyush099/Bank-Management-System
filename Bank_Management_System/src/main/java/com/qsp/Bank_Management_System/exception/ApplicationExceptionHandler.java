package com.qsp.Bank_Management_System.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.qsp.Bank_Management_System.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler{
	
	@Autowired
	ResponseStructure<String> responseStructure;

	@ExceptionHandler(BankIdNotFound.class)
	public ResponseStructure<String> BankIdNotFound(BankIdNotFound bankIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id Not Found!");
		responseStructure.setData(bankIdNotFound.getMessage());

		return responseStructure;
	}
	
	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseStructure<String> BranchIdNotFound(BranchIdNotFound branchIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id Not Found!");
		responseStructure.setData(branchIdNotFound.getMessage());

		return responseStructure;
	}
	
	@ExceptionHandler(AccountIdNotFound.class)
	public ResponseStructure<String> AccountIdNotFound(AccountIdNotFound accountIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id Not Found!");
		responseStructure.setData(accountIdNotFound.getMessage());

		return responseStructure;
	}
	
	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseStructure<String> AddressIdNotFound(AddressIdNotFound addressIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id Not Found!");
		responseStructure.setData(addressIdNotFound.getMessage());

		return responseStructure;
	}
	
	@ExceptionHandler(CardIdNotFound.class)
	public ResponseStructure<String> CardIdNotFound(CardIdNotFound cardIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id Not Found!");
		responseStructure.setData(cardIdNotFound.getMessage());

		return responseStructure;
	}
	
	@ExceptionHandler(CustomerIdNotFound.class)
	public ResponseStructure<String> CustomerIdNotFound(CustomerIdNotFound customerIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id Not Found!");
		responseStructure.setData(customerIdNotFound.getMessage());

		return responseStructure;
	}
	
	@ExceptionHandler(EmployeeIdNotFound.class)
	public ResponseStructure<String> EmployeeIdNotFound(EmployeeIdNotFound employeeIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id Not Found!");
		responseStructure.setData(employeeIdNotFound.getMessage());

		return responseStructure;
	}
	
	@ExceptionHandler(FdIdNotFound.class)
	public ResponseStructure<String> FdIdNotFound(FdIdNotFound fdIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id Not Found!");
		responseStructure.setData(fdIdNotFound.getMessage());

		return responseStructure;
	}
	
	@ExceptionHandler(LoanIdNotFound.class)
	public ResponseStructure<String> LoanIdNotFound(LoanIdNotFound loanIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id Not Found!");
		responseStructure.setData(loanIdNotFound.getMessage());

		return responseStructure;
	}
	
	@ExceptionHandler(ManagerIdNotFound.class)
	public ResponseStructure<String> ManagerIdNotFound(ManagerIdNotFound managerIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id Not Found!");
		responseStructure.setData(managerIdNotFound.getMessage());

		return responseStructure;
	}
	
	@ExceptionHandler(OwnerIdNotFound.class)
	public ResponseStructure<String> OwnerIdNotFound(OwnerIdNotFound ownerIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id Not Found!");
		responseStructure.setData(ownerIdNotFound.getMessage());

		return responseStructure;
	}



}
