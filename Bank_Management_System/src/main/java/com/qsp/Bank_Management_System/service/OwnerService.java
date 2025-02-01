package com.qsp.Bank_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Bank_Management_System.dao.OwnerDao;
import com.qsp.Bank_Management_System.dto.Owner;
import com.qsp.Bank_Management_System.exception.OwnerIdNotFound;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

@Service
public class OwnerService {

	@Autowired
	OwnerDao ownerDao;

	@Autowired
	ResponseStructure<Owner> responseStructure;

	@Autowired
	ResponseStructureList<Owner> responseStructureList;

	public ResponseStructure<Owner> saveOwner(Owner owner) {
		responseStructure.setMessage("Owner has being inserted");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ownerDao.saveOwner(owner));
		return responseStructure;

	}

	public ResponseStructure<Owner> fetchOwnerById(int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			responseStructure.setMessage("Owner has being Fetched");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(ownerDao.fetchOwnerById(ownerId));
			return responseStructure;
		} else {
			throw new OwnerIdNotFound();
		}

	}

	public ResponseStructure<Owner> deleteOwnerById(int ownerId) {
		Owner owner = ownerDao.deleteOwnerById(ownerId);
		if (owner != null) {
			responseStructure.setMessage("This respective Owner has being Deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(ownerDao.deleteOwnerById(ownerId));
			return responseStructure;
		} else {
			throw new OwnerIdNotFound();

		}
	}

	public ResponseStructure<Owner> updateOwnerById(int oldOwnerId, Owner newOwner) {
		Owner owner = ownerDao.deleteOwnerById(oldOwnerId);
		if (owner != null) {
			responseStructure.setMessage("This respective Owner is Updated in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(ownerDao.updateOwnerById(oldOwnerId, newOwner));
			return responseStructure;
		} else {
			throw new OwnerIdNotFound();

		}
	}

	public ResponseStructureList<Owner> fetchAllOwners() {
		responseStructureList.setMessage("This respective Owner has being Deleted from DB");
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setData(ownerDao.fetchAllOwners());
		return responseStructureList;

	}

	public ResponseStructure<Owner> addExistingOwnerTOExistingBank(int bankId, int OwnerId) {
		Owner owner = ownerDao.deleteOwnerById(OwnerId);
		if (owner != null) {
			responseStructure.setMessage("The existing Owner is added to the existing bank in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(ownerDao.addExistingOwnerTOExistingBank(bankId, OwnerId));
			return responseStructure;
		} else {
			throw new OwnerIdNotFound();

		}

	}

}
