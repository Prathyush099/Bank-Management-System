package com.qsp.Bank_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Bank_Management_System.dao.ManagerDao;
import com.qsp.Bank_Management_System.dto.Manager;
import com.qsp.Bank_Management_System.exception.ManagerIdNotFound;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

@Service
public class ManagerService {

	@Autowired
	ManagerDao managerDao;

	@Autowired
	ResponseStructure<Manager> responseStructure;

	@Autowired
	ResponseStructureList<Manager> responseStructureList;

	public ResponseStructure<Manager> saveManager(Manager manager) {
		responseStructure.setMessage("Manager has being inserted");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(managerDao.saveManager(manager));
		return responseStructure;

	}

	public ResponseStructure<Manager> fetchmanagerById(int managerId) {
		Manager manager = managerDao.deleteManagerById(managerId);
		if (manager != null) {
			responseStructure.setMessage("Manager has being Fetched");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(managerDao.fetchManagerById(managerId));
			return responseStructure;
		} else {
			throw new ManagerIdNotFound();
		}

	}

	public ResponseStructure<Manager> deletemanagerById(int managerId) {
		Manager manager = managerDao.deleteManagerById(managerId);
		if (manager != null) {
			responseStructure.setMessage("This respective Owner has being Deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(managerDao.deleteManagerById(managerId));
			return responseStructure;
		} else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseStructure<Manager> updatemanagerById(int oldmanagerId, Manager newmanager) {
		Manager manager = managerDao.deleteManagerById(oldmanagerId);
		if (manager != null) {
			responseStructure.setMessage("This respective Owner is Updated in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(managerDao.updateManagerById(oldmanagerId, newmanager));
			return responseStructure;
		} else {
			throw new ManagerIdNotFound();
		}

	}

	public ResponseStructureList<Manager> fetchAllManager() {
		responseStructureList.setMessage("This respective Owner has being Deleted from DB");
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setData(managerDao.fetchAllManagers());
		return responseStructureList;

	}

}
