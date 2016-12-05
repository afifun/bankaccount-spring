package com.rse.domain;

import javax.persistence.Entity;

@Entity
public class FeeAccount extends Account {
	
	public int fee;
	
	public FeeAccount(int fee){
		super();
		this.fee = fee;
	}
	
	public int deposit(int x){
		int result = x;
		if (x>= this.fee){
			result = super.deposit(x-this.fee); 
		}
		return result;
	}
}
