package com.qsp.Bank_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Bank_Management_System.dto.Manager;
import com.qsp.Bank_Management_System.dto.Owner;
import com.qsp.Bank_Management_System.repo.ManagerRepo;

@Repository
public class ManagerDao {

	
	@Autowired
	ManagerRepo managerRepo;

	public Manager saveManager(Manager manager) 
	{
		return managerRepo.save(manager);

	}
	
	public Manager fetchManagerById(int managerId) {
		Optional<Manager> manager = managerRepo.findById(managerId);
		if(manager.isPresent()) {
			return manager.get();
		}else {
			return null;
		}
		
	}
	
	public Manager deleteManagerById(int managerId) {
		Optional<Manager> manager= managerRepo.findById(managerId);
		if (manager.isPresent()) {
			managerRepo.delete(manager.get()); 
	        return manager.get();
	    } else {
	        return null;
	    }
	}
	
	public Manager updateManagerById(int oldManagerId,Manager newmanagerId) {
		newmanagerId.setManagerId(oldManagerId);
		Optional<Manager> manager= managerRepo.findById(oldManagerId);
		if (manager.isPresent()) {
			return managerRepo.save(newmanagerId);
		}else {
			 return null;
		}
		
	}
	
	public List<Manager> fetchAllManagers() {
		return managerRepo.findAll();
		
	}

}
