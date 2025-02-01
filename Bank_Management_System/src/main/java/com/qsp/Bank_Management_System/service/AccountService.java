package com.qsp.Bank_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Bank_Management_System.dao.AccountDao;
import com.qsp.Bank_Management_System.dto.Account;
import com.qsp.Bank_Management_System.exception.AccountIdNotFound;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;


@Service
public class AccountService {
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	ResponseStructure<Account> responseStructure;
	
	@Autowired
	ResponseStructureList<Account> responseStructureList;
	

	public ResponseStructure<Account> saveAccount(Account Account) {
		responseStructure.setMessage("Account has being inserted");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(accountDao.saveAccount(Account));
		return responseStructure;

	}
	
	public ResponseStructure<Account> fetchAccountById(int AccountId) {
		Account account = accountDao.fetchAccountById(AccountId);
		if (account != null) {
		responseStructure.setMessage("Account has being Fetched");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(accountDao.fetchAccountById(AccountId));
		return responseStructure;
		} else {
			throw new AccountIdNotFound();
		}

		
	}
	
	public ResponseStructure<Account> deleteAccountById(int AccountId) {
		Account account = accountDao.fetchAccountById(AccountId);
		if (account != null) {
		responseStructure.setMessage("This respective Account has being Deleted from DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(accountDao.deleteAccountById(AccountId));
		return responseStructure;
		} else {
			throw new AccountIdNotFound();
		}

		
	}
	
	public ResponseStructure<Account> updateAccountById(int oldAccountId ,Account newAccount) {
		Account account = accountDao.fetchAccountById(oldAccountId);
		if (account != null) {
		responseStructure.setMessage("This respective Account is Updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(accountDao.updateAccountById(oldAccountId, newAccount));
		return responseStructure;
		} else {
			throw new AccountIdNotFound();
		}
		
	}
	
	public ResponseStructureList<Account> fetchAllAccounts() {
		responseStructureList.setMessage("All the Accounts has being Fetched from DB");
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setData(accountDao.fetchAllAccounts());
		return responseStructureList;
		
	}

}
