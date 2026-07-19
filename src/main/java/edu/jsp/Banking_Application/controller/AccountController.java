package edu.jsp.Banking_Application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.Banking_Application.entity.Account;
import edu.jsp.Banking_Application.entity.User;
import edu.jsp.Banking_Application.exception.NotFoundException;
import edu.jsp.Banking_Application.service.AccountService;
@CrossOrigin(origins = "https://banking-application-sigma.vercel.app/")
@RestController
@RequestMapping("api/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	@PostMapping("{userId}")
	public String createAccount(@PathVariable Long userId,@RequestBody Account a) {
		return accountService.createAccount(userId, a);
	}
	
	@DeleteMapping("/{userId}/{accountId}")
	public String deleteAccount(@PathVariable Long userId,@PathVariable Long accountId)
	{
		return accountService.deleteAccount(userId, accountId);
		
	}
	
	@GetMapping("/{accountId}")
	public Account getAccountById(@PathVariable Long accountId)
	{
		return accountService.getAccountById(accountId);
	}
	
	@GetMapping("/acc/{userId}")
	public List<Account> getAccountByUserId(@PathVariable Long userId)
	{
		return accountService.getAccountByUserId(userId);
	}
	
	@GetMapping("/balance/{accountId}")
	public Double getBalance(@PathVariable Long accountId) {
		return accountService.getBalance(accountId);
	}


}
