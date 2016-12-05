package com.rse.domain;

import javax.persistence.*;

@Entity
public class Account {
	@Id
	@GeneratedValue
	public Long id;
	
	@Column
	public int balance;
	
	@Column
	public String rekening;
	
	@Column
	public int customerId;
	
	@Column
	public int interest;

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getRekening() {
		return rekening;
	}

	public void setRekening(String rekening) {
		this.rekening = rekening;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public int deposit(int x){ 
		this.balance = this.balance + x; 
		return balance;
	}

	public int withdraw(int y){
		if (this.balance - y >= 0){ this.balance = this.balance - y;}
		return balance;
	}
}
