package com.qsp.Bank_Management_System.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FixedDeposit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fdId;
	private String fdType;
	private double fdInterest;
	private String fdDuration;
	
	
	public int getFdId() {
		return fdId;
	}
	public void setFdId(int fdId) {
		this.fdId = fdId;
	}
	public String getFdType() {
		return fdType;
	}
	public void setFdType(String fdType) {
		this.fdType = fdType;
	}
	public double getFdInterest() {
		return fdInterest;
	}
	public void setFdInterest(double fdInterest) {
		this.fdInterest = fdInterest;
	}
	public String getFdDuration() {
		return fdDuration;
	}
	public void setFdDuration(String fdDuration) {
		this.fdDuration = fdDuration;
	}
	
	
	
	
	
	
	

}
