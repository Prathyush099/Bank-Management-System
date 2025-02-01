package com.qsp.Bank_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Bank_Management_System.dto.Loan;
import com.qsp.Bank_Management_System.repo.LoanRepo;

@Repository
public class LoanDao {
	
	@Autowired
	LoanRepo loanRepo;

	public Loan saveLoan(Loan loan) 
	{
		return loanRepo.save(loan);

	}
	
	public Loan fetchLoanById(int loanId) {
		Optional<Loan> loan = loanRepo.findById(loanId);
		if (loan.isPresent()) {
			return loan.get();
		}else {
			 return null;
		}
	}
	
	public Loan deleteLoanById(int loanId) {
		Optional<Loan> loan= loanRepo.findById(loanId);
		if (loan.isPresent()) {
			loanRepo.delete(loan.get()); 
	        return loan.get();
	    } else {
	        return null;
	    }
		
	}
	
	public Loan updateLoanById(int oldloanId,Loan newloanId) {
		newloanId.setLoanId(oldloanId);
		Optional<Loan> loan= loanRepo.findById(oldloanId);
		if (loan.isPresent()) {
			return loanRepo.save(newloanId);
		}else {
			 return null;
		}
		
	}
	
	public List<Loan> fetchAllLoans() {
		return loanRepo.findAll();
		
	}

}
