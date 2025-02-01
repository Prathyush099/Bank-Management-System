package com.qsp.Bank_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Bank_Management_System.dao.FixedDepositDao;
import com.qsp.Bank_Management_System.dto.FixedDeposit;
import com.qsp.Bank_Management_System.exception.FdIdNotFound;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

@Service
public class FixedDepositService {
	
	@Autowired
	FixedDepositDao fixedDepositDao;
	
	@Autowired
	ResponseStructure<FixedDeposit> responseStructure;
	
	@Autowired
	ResponseStructureList<FixedDeposit> responseStructureList;
	

	public ResponseStructure<FixedDeposit> saveFixedDeposit(FixedDeposit fixedDeposit) {
		responseStructure.setMessage("FD has being inserted");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(fixedDepositDao.saveFixedDeposit(fixedDeposit));
		return responseStructure;

	}
	
	public ResponseStructure<FixedDeposit> fetchFixedDepositById(int fdId) {
		FixedDeposit fixedDeposit = fixedDepositDao.deleteFixedDepositById(fdId);
		if (fixedDeposit != null) {
		responseStructure.setMessage("FD has being Fetched");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(fixedDepositDao.fetchFixedDepositById(fdId));
		return responseStructure;
		} else {
			throw new FdIdNotFound();
		}
		
	}
	
	public ResponseStructure<FixedDeposit> deleteFixedDepositById(int fdId) {
		FixedDeposit fixedDeposit = fixedDepositDao.deleteFixedDepositById(fdId);
		if (fixedDeposit != null) {
		responseStructure.setMessage("This respective FD has being Deleted from DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(fixedDepositDao.deleteFixedDepositById(fdId));
		return responseStructure;
		} else {
			throw new FdIdNotFound();
		}
		
	}
	
	public ResponseStructure<FixedDeposit> updateFixedDepositById(int oldFixedDepositId ,FixedDeposit newFixedDeposit) {
		FixedDeposit fixedDeposit = fixedDepositDao.deleteFixedDepositById(oldFixedDepositId);
		if (fixedDeposit != null) {
		responseStructure.setMessage("This respective FD is Updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(fixedDepositDao.updateFixedDepositById(oldFixedDepositId, newFixedDeposit));
		return responseStructure;
	} else {
		throw new FdIdNotFound();
	}
		
	}
	
	public ResponseStructureList<FixedDeposit> fetchAllFixedDeposits() {
		responseStructureList.setMessage("This respective FD has being Deleted from DB");
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setData(fixedDepositDao.fetchAllFixedDeposits());
		return responseStructureList;
		
	}

}
