package com.qsp.Bank_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Bank_Management_System.dto.Account;
import com.qsp.Bank_Management_System.repo.AccountRepo;

@Repository
public class AccountDao {

	@Autowired
	AccountRepo accountRepo;

	public Account saveAccount(Account Account) 
	{
		return accountRepo.save(Account);

	}
	
	public Account fetchAccountById(int AccountId) {
		Optional<Account> account= accountRepo.findById(AccountId);
		if (account.isPresent()) {
			return account.get();
	    } else {
	        return null;
	    }
		
	}
	
	public Account deleteAccountById(int AccountId) {
		Optional<Account> account = accountRepo.findById(AccountId);
		if (account.isPresent()) {
			accountRepo.delete(account.get()); 
	        return account.get();
	    } else {
	        return null;
	    }
		
	}
	
	public Account updateAccountById(int oldAccountId,Account newAccountId) {
		newAccountId.setAccountId(oldAccountId);
		Optional<Account> account= accountRepo.findById(oldAccountId);
		if (account.isPresent()) {
			return accountRepo.save(newAccountId);
		}else {
			 return null;
		}
	}
	
	public List<Account> fetchAllAccounts() {
		return accountRepo.findAll();
		
	}
}
