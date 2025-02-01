package com.qsp.Bank_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Bank_Management_System.dao.AddressDao;
import com.qsp.Bank_Management_System.dto.Address;
import com.qsp.Bank_Management_System.exception.AddressIdNotFound;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

@Service
public class AddressService {

	@Autowired
	AddressDao addressDao;

	@Autowired
	ResponseStructure<Address> responseStructure;

	@Autowired
	ResponseStructureList<Address> responseStructureList;

	public ResponseStructure<Address> saveAddress(Address Address) {
		responseStructure.setMessage("Address has being inserted");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(addressDao.saveAddress(Address));
		return responseStructure;

	}

	public ResponseStructure<Address> fetchAddressById(int AddressId) {
		Address address = addressDao.deleteAddressById(AddressId);
		if (address != null) {
			responseStructure.setMessage("Address has being Fetched");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(addressDao.fetchAddressById(AddressId));
			return responseStructure;
		} else {
			throw new AddressIdNotFound();
		}

	}

	public ResponseStructure<Address> deleteAddressById(int AddressId) {
		Address address = addressDao.deleteAddressById(AddressId);
		if (address != null) {
			responseStructure.setMessage("This respective Address has being Deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(addressDao.deleteAddressById(AddressId));
			return responseStructure;
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseStructure<Address> updateAddressById(int oldAddressId, Address newAddress) {
		Address address = addressDao.deleteAddressById(oldAddressId);
		if (address != null) {
		responseStructure.setMessage("This respective Address is Updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));
		return responseStructure;
		} else {
			throw new AddressIdNotFound();
		}

	}

	public ResponseStructureList<Address> fetchAllAddresss() {
		responseStructureList.setMessage("All the Addresses has being Fetched from DB");
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setData(addressDao.fetchAllAddresss());
		return responseStructureList;

	}

}
