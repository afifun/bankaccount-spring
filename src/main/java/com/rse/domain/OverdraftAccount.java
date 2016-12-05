package com.rse.domain;

import javax.persistence.Entity;

@Entity
public class OverdraftAccount extends Account {
	public int withdraw(int y){
		super.balance = super.balance - y;
		return balance;
	} 
}
