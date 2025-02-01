package com.qsp.Bank_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Bank_Management_System.dto.Address;
import com.qsp.Bank_Management_System.repo.AddressRepo;

@Repository
public class AddressDao {
	
	@Autowired
	AddressRepo addressRepo;

	public Address saveAddress(Address Address) 
	{
		return addressRepo.save(Address);

	}
	
	public Address fetchAddressById(int AddressId) {
		Optional<Address> address= addressRepo.findById(AddressId);
		if (address.isPresent()) {
			return address.get();
	    } else {
	        return null;
	    }
		
	}
	
	public Address deleteAddressById(int AddressId) {
		Optional<Address> address = addressRepo.findById(AddressId);
		if (address.isPresent()) {
			addressRepo.delete(address.get()); 
	        return address.get();
	    } else {
	        return null;
	    }
		
	}
	
	public Address updateAddressById(int oldAddressId,Address newAddressId) {
		newAddressId.setAddressId(oldAddressId);
		Optional<Address> address= addressRepo.findById(oldAddressId);
		if (address.isPresent()) {
			return addressRepo.save(newAddressId);
		}else {
			 return null;
		}
		
	}
	
	public List<Address> fetchAllAddresss() {
		return addressRepo.findAll();
		
	}


}
