package com.qsp.Bank_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Bank_Management_System.dao.BankDao;
import com.qsp.Bank_Management_System.dto.Bank;
import com.qsp.Bank_Management_System.dto.Branch;
import com.qsp.Bank_Management_System.exception.BankIdNotFound;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

@Service
public class BankService {
	
	@Autowired
	BankDao bankDao;
	
	@Autowired
	ResponseStructure<Bank> responseStructure;
	
	@Autowired
	ResponseStructureList<Bank> responseStructureList;
	

	public ResponseStructure<Bank> saveBank(Bank Bank) {
		responseStructure.setMessage("Bank has being inserted");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(bankDao.saveBank(Bank));
		return responseStructure;

	}
	
	public ResponseStructure<Bank> fetchBankById(int BankId) {
		Bank bank = bankDao.deleteBankById(BankId);
		if (bank != null) {
		responseStructure.setMessage("Bank has being Fetched");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(bankDao.fetchBankById(BankId));
		return responseStructure;
	} else {
		throw new BankIdNotFound();
	}
		
	}
	
	public ResponseStructure<Bank> deleteBankById(int BankId) {
		Bank bank = bankDao.deleteBankById(BankId);
		if (bank != null) {
		responseStructure.setMessage("This respective Bank has being Deleted from DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.deleteBankById(BankId));
		return responseStructure;
		} else {
			throw new BankIdNotFound();
		}
		
	}
	
	public ResponseStructure<Bank> updateBankById(int oldBankId ,Bank newBank) {
		Bank bank = bankDao.deleteBankById(oldBankId);
		if (bank != null) {
		responseStructure.setMessage("This respective Bank is Updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.updateBankById(oldBankId, newBank));
		return responseStructure;
		} else {
			throw new BankIdNotFound();
		}
	}
	
	public ResponseStructureList<Bank> fetchAllBanks() {
		responseStructureList.setMessage("All the Banks has being Fetched from DB");
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setData(bankDao.fetchAllBanks());
		return responseStructureList;
		
	}
	
	public ResponseStructure<Bank> addExistingBranchToExistingBank(int branchId, int bankId) {
		responseStructure.setMessage("The existing Branch is added to the existing Bank in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.addExistingBranchToExistingBank(branchId, bankId));
		return responseStructure;
	}
	
	public ResponseStructure<Bank> addNewBranchToExistingBank(int bankId, Branch newBranch) {
		responseStructure.setMessage("Adding New Branch to the existing Bank in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.addNewBranchToExistingBank(bankId, newBranch));
		return responseStructure;
	}

}
