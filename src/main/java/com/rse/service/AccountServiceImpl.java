package com.rse.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rse.domain.Account;
import com.rse.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Collection<Account> findAll() {
		Collection<Account> accounts = accountRepository.findAll();
		return accounts;
	}
	@Override
	public Account findOne(Long id) {
		Account account = accountRepository.findOne(id);
		return account;
	}
	@Override
	public Account update(Account account) {
		Account accountPersisted = findOne(account.getId());
		if (accountPersisted == null){
			return null;
		}
		Account updateAccount = accountRepository.save(account);
		return updateAccount;
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		accountRepository.delete(id);
	}
	@Override
	public Account create(Account account) {
		// TODO Auto-generated method stub
		if (account.getId() == null){
			return null;
		}
		Account createAccount = accountRepository.save(account);
		return createAccount;
	}

	@Override
	public Account withdraw(Long accountId, int amount) {
		Account accountPersisted = findOne(accountId);
		if (accountPersisted == null){
			return null;
		}
	
		accountPersisted.withdraw(amount);
		Account updateAccount = accountRepository.save(accountPersisted);
		return updateAccount;
	}
	
	@Override
	public Account deposit(Long accountId, int amount) {
		Account accountPersisted = findOne(accountId);
		if (accountPersisted == null){
			return null;
		}
	
		accountPersisted.deposit(amount);
		Account updateAccount = accountRepository.save(accountPersisted);
		return updateAccount;
	}

}
