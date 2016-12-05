package com.rse.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rse.domain.Account;
import com.rse.service.AccountService;


@RestController
public class AccountResource {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/api/accounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Account>> getAccounts(){
		
		Collection<Account> accounts = accountService.findAll();
		
		
		return new ResponseEntity<Collection<Account>>(accounts, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/api/accounts/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> getAccount(@PathVariable("id") Long id){
		
		Account account = accountService.findOne(id);
		
		if (account == null){
			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Account>(account, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/api/accounts", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> createAccount(@RequestBody Account account){
		
		Account savedAccount = accountService.create(account);
		
		return new ResponseEntity<Account>(savedAccount, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/api/accounts/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> updateAccount(@RequestBody Account account){
		
		Account updateAccount = accountService.update(account);
		
		if (updateAccount == null){
			return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Account>(updateAccount, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/api/accounts/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Account> deleteAccount(@PathVariable("id") Long id){
		
		accountService.delete(id);
		
		return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
		
	}
	
	@RequestMapping(value = "/api/accounts/{accountId}/withdraw/{amount}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> withdrawAccount(@PathVariable("accountId") Long accountId,@PathVariable("amount") int amount){
		
		Account withdrawAccount = accountService.withdraw(accountId, amount);
		
		if (withdrawAccount == null){
			return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Account>(withdrawAccount, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/api/accounts/{accountId}/deposit/{amount}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> depositAccount(@PathVariable("accountId") Long accountId,@PathVariable("amount") int amount){
		
		Account depositAccount = accountService.deposit(accountId, amount);
		
		if (depositAccount == null){
			return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Account>(depositAccount, HttpStatus.CREATED);
		
	}
}
