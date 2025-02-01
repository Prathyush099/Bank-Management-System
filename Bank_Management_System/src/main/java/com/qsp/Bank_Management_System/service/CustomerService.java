package com.qsp.Bank_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Bank_Management_System.dao.CustomerDao;
import com.qsp.Bank_Management_System.dto.Account;
import com.qsp.Bank_Management_System.dto.Card;
import com.qsp.Bank_Management_System.dto.Customer;
import com.qsp.Bank_Management_System.dto.FixedDeposit;
import com.qsp.Bank_Management_System.dto.Loan;
import com.qsp.Bank_Management_System.exception.CustomerIdNotFound;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	ResponseStructure<Customer> responseStructure;
	
	@Autowired
	ResponseStructureList<Customer> responseStructureList;

	public ResponseStructure<Customer> saveCustomer(Customer Customer) {
		responseStructure.setMessage("Customer has being inserted");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(customerDao.saveCustomer(Customer));
		return responseStructure;

	}
	
	public ResponseStructure<Customer> fetchCustomerById(int CustomerId) {
		Customer customer = customerDao.deleteCustomerById(CustomerId);
		if (customer != null) {
		responseStructure.setMessage("Customer has being Fetched");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(customerDao.fetchCustomerById(CustomerId));
		return responseStructure;
		} else {
			throw new CustomerIdNotFound();
		}
		
	}
	
	public ResponseStructure<Customer> deleteCustomerById(int CustomerId) {
		Customer customer = customerDao.deleteCustomerById(CustomerId);
		if (customer != null) {
		responseStructure.setMessage("This respective Customer has being Deleted from DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.deleteCustomerById(CustomerId));
		return responseStructure;
		} else {
			throw new CustomerIdNotFound();
		}
		
	}
	
	public ResponseStructure<Customer> updateCustomerById(int oldCustomerId ,Customer newCustomer) {
		Customer customer = customerDao.deleteCustomerById(oldCustomerId);
		if (customer != null) {
		responseStructure.setMessage("This respective Employee is Updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.updateCustomerById(oldCustomerId, newCustomer));
		return responseStructure;
	} else {
		throw new CustomerIdNotFound();
	}
	}
	
	public ResponseStructureList<Customer> fetchAllCustomers() {
		responseStructureList.setMessage("All the Employee has being Fetched from DB");
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setData(customerDao.fetchAllCustomers());
		return responseStructureList;
		
	}
	
	
	public ResponseStructure<Customer> addExistingAccountToExistingCustomer(int AccountId, int CustomerId) {
		responseStructure.setMessage("The existing Account is added to the existing Customer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addExistingAccountToExistingCustomer(AccountId, CustomerId));
		return responseStructure;
	}
	
	public ResponseStructure<Customer> addNewAccountToExistingCustomer(int CustomerId, Account newAccount) {
		responseStructure.setMessage("Adding New Account to the existing Customer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addNewAccountToExistingCustomer(CustomerId, newAccount));
		return responseStructure;
	}
	
	
	
	
	
	public ResponseStructure<Customer> addExistingCardToExistingCustomer(int CardId, int CustomerId) {
		responseStructure.setMessage("The existing Card is added to the existing Customer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addExistingCardToExistingCustomer(CardId, CustomerId));
		return responseStructure;
	}
	
	public ResponseStructure<Customer> addNewCardToExistingCustomer(int CustomerId, Card newCard) {
		responseStructure.setMessage("Adding New Card to the existing Customer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addNewCardToExistingCustomer(CustomerId, newCard));
		return responseStructure;
	}
	
	
	
	
	public ResponseStructure<Customer> addExistingLoanToExistingCustomer(int LoanId, int CustomerId) {
		responseStructure.setMessage("The existing Card is added to the existing Customer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addExistingLoanToExistingCustomer(LoanId, CustomerId));
		return responseStructure;
	}
	
	public ResponseStructure<Customer> addNewLoanToExistingCustomer(int CustomerId, Loan newLoan) {
		responseStructure.setMessage("Adding New Loan to the existing Customer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addNewLoanToExistingCustomer(CustomerId, newLoan));
		return responseStructure;
	}
	
	
	
	
	
	public ResponseStructure<Customer> addExistingFixedDepositToExistingCustomer(int FixedDepositId, int CustomerId) {
		responseStructure.setMessage("The existing FixedDeposit is added to the existing Customer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addExistingFixedDepositToExistingCustomer(FixedDepositId, CustomerId));
		return responseStructure;
	}
	
	public ResponseStructure<Customer> addNewFixedDepositToExistingCustomer(int CustomerId, FixedDeposit newFixedDeposit) {
		responseStructure.setMessage("Adding New FixedDeposit to the existing Customer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addNewFixedDepositToExistingCustomer(CustomerId, newFixedDeposit));
		return responseStructure;
	}



	
	
	
	
	

}
