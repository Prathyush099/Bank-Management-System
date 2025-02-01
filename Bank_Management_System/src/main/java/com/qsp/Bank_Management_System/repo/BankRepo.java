package com.qsp.Bank_Management_System.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Bank_Management_System.dto.Bank;

public interface BankRepo extends JpaRepository<Bank, Integer>{

}
