package com.qsp.Bank_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Bank_Management_System.dto.Account;
import com.qsp.Bank_Management_System.dto.Card;
import com.qsp.Bank_Management_System.dto.Customer;
import com.qsp.Bank_Management_System.dto.FixedDeposit;
import com.qsp.Bank_Management_System.dto.Loan;
import com.qsp.Bank_Management_System.repo.CustomerRepo;

@Repository
public class CustomerDao {
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	CardDao cardDao;
	
	@Autowired
	LoanDao loanDao;
	
	@Autowired
	FixedDepositDao fdDao;
	
	

	public Customer saveCustomer(Customer Customer) 
	{
		return customerRepo.save(Customer);

	}
	
	public Customer fetchCustomerById(int CustomerId) {
		Optional<Customer> customer = customerRepo.findById(CustomerId);
		if (customer.isPresent()) {
			return customer.get();
		}else {
			 return null;
		}
		
	}
	
	public Customer deleteCustomerById(int CustomerId) {
		Optional<Customer> customer = customerRepo.findById(CustomerId);
		if (customer.isPresent()) {
			customerRepo.delete(customer.get()); 
	        return customer.get();
	    } else {
	        return null;
	    }
		
	}
	
	public Customer updateCustomerById(int oldCustomerId,Customer newCustomerId) {
		newCustomerId.setCustomerId(oldCustomerId);
		Optional<Customer> customer= customerRepo.findById(oldCustomerId);
		if (customer.isPresent()) {
			return customerRepo.save(newCustomerId);
		}else {
			 return null;
		}
		
	}
	
	public List<Customer> fetchAllCustomers() {
		return customerRepo.findAll();
		
	}
	
	
	
	
	
	
	public Customer addExistingAccountToExistingCustomer(int AccountId, int CustomerId) {
		Customer customer = fetchCustomerById(CustomerId);
		Account account = accountDao.fetchAccountById(AccountId);
		List<Account> list = customer.getAccount();
		list.add(account);
		customer.setAccount(list);
		return saveCustomer(customer);
	}
	
	public Customer addNewAccountToExistingCustomer(int CustomerId, Account newAccount) {
		Customer customer = fetchCustomerById(CustomerId);
		List<Account> list = customer.getAccount();
		list.add(newAccount);
		customer.setAccount(list);
		return saveCustomer(customer);
	}
	
	
	
	
	
	public Customer addExistingCardToExistingCustomer(int CardId, int CustomerId) {
		Customer customer = fetchCustomerById(CustomerId);
		Card card = cardDao.fetchCardById(CardId);
		List<Card> list = customer.getCard();
		list.add(card);
		customer.setCard(list);
		return saveCustomer(customer);
	}
	
	public Customer addNewCardToExistingCustomer(int CustomerId, Card newCard) {
		Customer customer = fetchCustomerById(CustomerId);
		List<Card> list = customer.getCard();
		list.add(newCard);
		customer.setCard(list);
		return saveCustomer(customer);
	}
	
	
	
	
	public Customer addExistingLoanToExistingCustomer(int LoanId, int CustomerId) {
		Customer customer = fetchCustomerById(CustomerId);
		Loan loan = loanDao.fetchLoanById(LoanId);
		List<Loan> list = customer.getLoan();
		list.add(loan);
		customer.setLoan(list);
		return saveCustomer(customer);
	}
	
	public Customer addNewLoanToExistingCustomer(int CustomerId, Loan newLoan) {
		Customer customer = fetchCustomerById(CustomerId);
		List<Loan> list = customer.getLoan();
		list.add(newLoan);
		customer.setLoan(list);
		return saveCustomer(customer);
	}
	
	
	
	
	public Customer addExistingFixedDepositToExistingCustomer(int FixedDepositId, int CustomerId) {
		Customer customer = fetchCustomerById(CustomerId);
		FixedDeposit FD = fdDao.fetchFixedDepositById(FixedDepositId);
		List<FixedDeposit> list = customer.getFD();
		list.add(FD);
		customer.setFD(list);
		return saveCustomer(customer);
	}
	
	public Customer addNewFixedDepositToExistingCustomer(int CustomerId, FixedDeposit newFixedDeposit) {
		Customer customer = fetchCustomerById(CustomerId);
		List<FixedDeposit> list = customer.getFD();
		list.add(newFixedDeposit);
		customer.setFD(list);
		return saveCustomer(customer);
	}

}
