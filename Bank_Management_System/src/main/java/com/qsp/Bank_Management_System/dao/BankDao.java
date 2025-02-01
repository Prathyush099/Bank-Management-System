package com.qsp.Bank_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Bank_Management_System.dto.Bank;
import com.qsp.Bank_Management_System.dto.Branch;
import com.qsp.Bank_Management_System.repo.BankRepo;

@Repository
public class BankDao {
	
	@Autowired
	BankRepo bankRepo;
	
	@Autowired
	BranchDao branchDao;

	public Bank saveBank(Bank Bank) 
	{
		return bankRepo.save(Bank);

	}
	
	public Bank fetchBankById(int BankId) {
		Optional<Bank> bank= bankRepo.findById(BankId);
		if (bank.isPresent()) {
			return bank.get();
	    } else {
	        return null;
	    }
	}
	
	public Bank deleteBankById(int BankId) {
		Optional<Bank> bank= bankRepo.findById(BankId);
		if (bank.isPresent()) {
			bankRepo.delete(bank.get()); 
	        return bank.get();
	    } else {
	        return null;
	    }
		
	}
	
	public Bank updateBankById(int oldBankId,Bank newBankId) {
		newBankId.setBankId(oldBankId);
		Optional<Bank> bank= bankRepo.findById(oldBankId);
		if (bank.isPresent()) {
			return bankRepo.save(newBankId);
		}else {
			 return null;
		}
	}
	
	public List<Bank> fetchAllBanks() {
		return bankRepo.findAll();
		
	}
	
	public Bank addExistingBranchToExistingBank(int branchId, int bankId) {
		Bank bank=fetchBankById(bankId);
		Branch branch = branchDao.fetchBranchById(branchId);
		List<Branch> list = bank.getBranch();
		list.add(branch);
		bank.setBranch(list);
		return saveBank(bank);
	}
	
	public Bank addNewBranchToExistingBank(int bankId, Branch newBranch) {
		Bank bank=fetchBankById(bankId);
		List<Branch> list = bank.getBranch();
		list.add(newBranch);
		bank.setBranch(list);
		return saveBank(bank);
	}

}
