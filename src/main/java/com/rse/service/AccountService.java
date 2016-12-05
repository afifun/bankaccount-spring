package com.rse.service;

import java.util.Collection;

import com.rse.domain.Account;

public interface AccountService {
	public Collection<Account> findAll();
	public Account findOne(Long id);
	public Account create(Account account);
	public Account update(Account account);
	public Account withdraw(Long accountId, int amount);
	public Account deposit(Long accountId, int amount);
	public void delete(Long id);
}
