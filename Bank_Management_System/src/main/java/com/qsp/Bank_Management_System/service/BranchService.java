package com.qsp.Bank_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Bank_Management_System.dao.BranchDao;
import com.qsp.Bank_Management_System.dto.Branch;
import com.qsp.Bank_Management_System.dto.Customer;
import com.qsp.Bank_Management_System.dto.Employee;
import com.qsp.Bank_Management_System.exception.BranchIdNotFound;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;

	@Autowired
	ResponseStructure<Branch> responseStructure;

	@Autowired
	ResponseStructureList<Branch> responseStructureList;

	public ResponseStructure<Branch> saveBranch(Branch Branch) {
		responseStructure.setMessage("Branch has being inserted");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(branchDao.saveBranch(Branch));
		return responseStructure;

	}

	public ResponseStructure<Branch> fetchBranchById(int BranchId) {
		Branch branch = branchDao.deleteBranchById(BranchId);
		if (branch != null) {
			responseStructure.setMessage("Card has being Fetched");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(branchDao.fetchBranchById(BranchId));
			return responseStructure;
		} else {
			throw new BranchIdNotFound();
		}

	}

	public ResponseStructure<Branch> deleteBranchById(int BranchId) {
		Branch branch = branchDao.deleteBranchById(BranchId);
		if (branch != null) {
			responseStructure.setMessage("This respective Branch has being Deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.deleteBranchById(BranchId));
			return responseStructure;
		} else {
			throw new BranchIdNotFound();
		}

	}

	public ResponseStructure<Branch> updateBranchById(int oldBranchId, Branch newBranch) {
		Branch branch = branchDao.deleteBranchById(oldBranchId);
		if (branch != null) {
			responseStructure.setMessage("This respective Branch is Updated in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.updateBranchById(oldBranchId, newBranch));
			return responseStructure;
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseStructureList<Branch> fetchAllBranchs() {
		responseStructureList.setMessage("All the Branchs has being Fetched from DB");
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setData(branchDao.fetchAllBranchs());
		return responseStructureList;

	}

	public ResponseStructure<Branch> addExistingAddressTOExistingBranch(int AddressId, int BranchId) {
		responseStructure.setMessage("The existing Address is added to the existing Branch in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addExistingAddressTOExistingBranch(AddressId, BranchId));
		return responseStructure;

	}

	public ResponseStructure<Branch> addExistingManagerTOExistingBranch(int ManagerId, int BranchId) {
		responseStructure.setMessage("The existing Manager is added to the existing Branch in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addExisitingManagerToExistingBranch(ManagerId, BranchId));
		return responseStructure;

	}

	public ResponseStructure<Branch> addExistingEmployeeToExistingBranch(int EmployeeId, int BranchId) {
		responseStructure.setMessage("The existing Manager is added to the existing Branch in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addExistingEmployeeToExistingBranch(EmployeeId, BranchId));
		return responseStructure;

	}

	public ResponseStructure<Branch> addNewEmployeeToExistingBranch(int BranchId, Employee newEmployee) {
		responseStructure.setMessage("Adding New Employee to the existing Branch in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addNewEmployeeToExistingBranch(BranchId, newEmployee));
		return responseStructure;
	}

	public ResponseStructure<Branch> addExisitingCustomerToExistingBranch(int CustomerId, int BranchId) {
		responseStructure.setMessage("The existing Customer is added to the existing Branch in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addExistingCustomerToExistingBranch(CustomerId, BranchId));
		return responseStructure;
	}

	public ResponseStructure<Branch> addNewCustomerToExistingBranch(int BranchId, Customer newCustomer) {
		responseStructure.setMessage("Adding New Customer to the existing Branch in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addNewCustomerToExistingBranch(BranchId, newCustomer));
		return responseStructure;
	}
}
