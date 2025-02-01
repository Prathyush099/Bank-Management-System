package com.qsp.Bank_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Bank_Management_System.dto.FixedDeposit;
import com.qsp.Bank_Management_System.repo.FixedDepositRepo;

@Repository
public class FixedDepositDao {
	
	@Autowired
	FixedDepositRepo fixedDepositRepo;

	public FixedDeposit saveFixedDeposit(FixedDeposit fixedDeposit) 
	{
		return fixedDepositRepo.save(fixedDeposit);

	}
	
	public FixedDeposit fetchFixedDepositById(int fdId) {
		Optional<FixedDeposit> fixedDeposit = fixedDepositRepo.findById(fdId);
		if (fixedDeposit.isPresent()) {
			return fixedDeposit.get();
		}else {
			 return null;
		}
		
	}
	
	public FixedDeposit deleteFixedDepositById(int fdId) {
		Optional<FixedDeposit> fixedDeposit = fixedDepositRepo.findById(fdId);
		if (fixedDeposit.isPresent()) {
			fixedDepositRepo.delete(fixedDeposit.get()); 
	        return fixedDeposit.get();
	    } else {
	        return null;
	    }
		
	}
	
	public FixedDeposit updateFixedDepositById(int oldFixedDepositId,FixedDeposit newFixedDepositId) {
		newFixedDepositId.setFdId(oldFixedDepositId);
		Optional<FixedDeposit> fixedDeposit= fixedDepositRepo.findById(oldFixedDepositId);
		if (fixedDeposit.isPresent()) {
			return fixedDepositRepo.save(newFixedDepositId);
		}else {
			 return null;
		}
		
	}
	
	public List<FixedDeposit> fetchAllFixedDeposits() {
		return fixedDepositRepo.findAll();
		
	}

}
