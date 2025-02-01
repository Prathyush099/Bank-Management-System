package com.qsp.Bank_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Bank_Management_System.dao.LoanDao;
import com.qsp.Bank_Management_System.dto.Loan;
import com.qsp.Bank_Management_System.exception.LoanIdNotFound;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

@Service
public class LoanService {

	@Autowired
	LoanDao loanDao;

	@Autowired
	ResponseStructure<Loan> responseStructure;

	@Autowired
	ResponseStructureList<Loan> responseStructureList;

	public ResponseStructure<Loan> saveLoan(Loan loan) {
		responseStructure.setMessage("Loan has being inserted");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(loanDao.saveLoan(loan));
		return responseStructure;

	}

	public ResponseStructure<Loan> fetchLoanById(int loanId) {
		Loan loan = loanDao.deleteLoanById(loanId);
		if (loan != null) {
			responseStructure.setMessage("Loan has being Fetched");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(loanDao.fetchLoanById(loanId));
			return responseStructure;
		} else {
			throw new LoanIdNotFound();
		}

	}

	public ResponseStructure<Loan> deleteLoanById(int loanId) {
		Loan loan = loanDao.deleteLoanById(loanId);
		if (loan != null) {
			responseStructure.setMessage("This respective Owner has being Deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(loanDao.deleteLoanById(loanId));
			return responseStructure;
		} else {
			throw new LoanIdNotFound();
		}

	}

	public ResponseStructure<Loan> updateLoanById(int oldLoanId, Loan newLoan) {
		Loan loan = loanDao.deleteLoanById(oldLoanId);
		if (loan != null) {
			responseStructure.setMessage("This respective Owner is Updated in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(loanDao.updateLoanById(oldLoanId, newLoan));
			return responseStructure;
		} else {
			throw new LoanIdNotFound();
		}
	}

	public ResponseStructureList<Loan> fetchAllLoans() {
		responseStructureList.setMessage("This respective Owner has being Deleted from DB");
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setData(loanDao.fetchAllLoans());
		return responseStructureList;

	}

}
