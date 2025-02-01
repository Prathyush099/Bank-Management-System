package com.qsp.Bank_Management_System.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	private String customerDOB;
	private long customerPhone;
	private int customerAge;
	private String customerEmail;
	private String customerCard;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Account> account;
	
	@OneToMany(cascade = CascadeType.ALL)
	private  List<Card> card;
	
	@OneToMany(cascade = CascadeType.ALL)
	private  List<Loan> loan;
	
	@OneToMany(cascade = CascadeType.ALL)
	private  List<FixedDeposit>  FD;
	
	
	
	public List<Card> getCard() {
		return card;
	}
	public void setCard(List<Card> card) {
		this.card = card;
	}
	public List<Loan> getLoan() {
		return loan;
	}
	public void setLoan(List<Loan> loan) {
		this.loan = loan;
	}
	public List<FixedDeposit> getFD() {
		return FD;
	}
	public void setFD(List<FixedDeposit> fD) {
		FD = fD;
	}
	public List<Account> getAccount() {
		return account;
	}
	public void setAccount(List<Account> account) {
		this.account = account;
	}
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerDOB() {
		return customerDOB;
	}
	public void setCustomerDOB(String customerDOB) {
		this.customerDOB = customerDOB;
	}
	public long getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(long customerPhone) {
		this.customerPhone = customerPhone;
	}
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerCard() {
		return customerCard;
	}
	public void setCustomerCard(String customerCard) {
		this.customerCard = customerCard;
	}
	
	
	
	
	
	
}
