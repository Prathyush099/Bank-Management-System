package com.qsp.Bank_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Bank_Management_System.dto.Bank;
import com.qsp.Bank_Management_System.dto.Owner;
import com.qsp.Bank_Management_System.repo.OwnerRepo;

@Repository
public class OwnerDao {

	@Autowired
	OwnerRepo ownerRepo;
	
	@Autowired
	BankDao bankDao;

	public Owner saveOwner(Owner owner) 
	{
		return ownerRepo.save(owner);

	}
	
	public Owner fetchOwnerById(int ownerId) {
		Optional<Owner> owner = ownerRepo.findById(ownerId);
		if(owner.isPresent()) {
			return owner.get();
		}else {
			return null;
		}
	}
	
	public Owner deleteOwnerById(int ownerId) {
		Optional<Owner> owner = ownerRepo.findById(ownerId);
		if (owner.isPresent()) {
	        ownerRepo.delete(owner.get()); 
	        return owner.get();
	    } else {
	        return null;
	    }
		
	}
	
	public Owner updateOwnerById(int oldOwnerId,Owner newownerId) {
		newownerId.setOwnerId(oldOwnerId);
		Optional<Owner> owner = ownerRepo.findById(oldOwnerId);
		if (owner.isPresent()) {
			return ownerRepo.save(newownerId);
		}else {
			return null;
		}
		
		
	}
	
	public List<Owner> fetchAllOwners() {
		return ownerRepo.findAll();
		
	}
	
	public Owner addExistingOwnerTOExistingBank(int bankId, int OwnerId) {
		Owner owner = fetchOwnerById(OwnerId);
		Bank bank = bankDao.fetchBankById(bankId);
		owner.setBank(bank);
		return saveOwner(owner);
		
	}
	

}
