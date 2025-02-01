package com.qsp.Bank_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Bank_Management_System.dto.Address;
import com.qsp.Bank_Management_System.dto.Branch;
import com.qsp.Bank_Management_System.dto.Customer;
import com.qsp.Bank_Management_System.dto.Employee;
import com.qsp.Bank_Management_System.dto.Manager;
import com.qsp.Bank_Management_System.repo.BranchRepo;

@Repository
public class BranchDao {
	
	@Autowired
	BranchRepo branchRepo;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	CustomerDao customerDao;
	
	

	public Branch saveBranch(Branch Branch) 
	{
		return branchRepo.save(Branch);

	}
	
	public Branch fetchBranchById(int BranchId) {
		Optional<Branch> branch = branchRepo.findById(BranchId);
		if (branch.isPresent()) {
			return branch.get();
		}else {
			 return null;
		}
		
	}
	
	public Branch deleteBranchById(int BranchId) {
		Optional<Branch> branch= branchRepo.findById(BranchId);
		if (branch.isPresent()) {
			branchRepo.delete(branch.get()); 
	        return branch.get();
	    } else {
	        return null;
	    }
	}
	
	public Branch updateBranchById(int oldBranchId, Branch newBranchId) {
		newBranchId.setBranchId(oldBranchId);
		Optional<Branch> branch= branchRepo.findById(oldBranchId);
		if (branch.isPresent()) {
			return branchRepo.save(newBranchId);
		}else {
			 return null;
		}
	}
	
	public List<Branch> fetchAllBranchs() {
		return branchRepo.findAll();
		
	}
	
	public Branch addExistingAddressTOExistingBranch(int AddressId, int BranchId) {
		Branch branch = fetchBranchById(BranchId);
		Address address = addressDao.fetchAddressById(AddressId);
		branch.setAddress(address);
		return saveBranch(branch);
		
	}
	
	public Branch addExisitingManagerToExistingBranch(int managerId,int branchid) {
		Branch branch = fetchBranchById(branchid);
		Manager manager = managerDao.fetchManagerById(managerId);
		branch.setManager(manager);
		return saveBranch(branch);
	}
	
	
	
	
	
	public Branch addExistingEmployeeToExistingBranch(int EmployeeId, int BranchId) {
		Branch branch = fetchBranchById(BranchId);
		Employee employee = employeeDao.fetchEmployeeById(EmployeeId);
		List<Employee> list = branch.getEmployee();
		list.add(employee);
		branch.setEmployee(list);
		return saveBranch(branch);
	}
	
	public Branch addNewEmployeeToExistingBranch(int BranchId, Employee newEmployee) {
		Branch branch=fetchBranchById(BranchId);
		List<Employee> list = branch.getEmployee();
		list.add(newEmployee);
		branch.setEmployee(list);
		return saveBranch(branch);
	}
	
	
	
	
	public Branch addExistingCustomerToExistingBranch(int CustomerId, int BranchId) {
		Branch branch = fetchBranchById(BranchId);
		Customer customer = customerDao.fetchCustomerById(CustomerId);
		List<Customer> list = branch.getCustomer();
		list.add(customer);
		branch.setCustomer(list);
		return saveBranch(branch);
	}
	
	public Branch addNewCustomerToExistingBranch(int BranchId, Customer newCustomer) {
		Branch branch=fetchBranchById(BranchId);
		List<Customer> list = branch.getCustomer();
		list.add(newCustomer);
		branch.setCustomer(list);
		return saveBranch(branch);
	}
}
