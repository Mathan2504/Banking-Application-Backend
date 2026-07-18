package edu.jsp.Banking_Application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.Banking_Application.entity.Account;
import edu.jsp.Banking_Application.entity.User;
import edu.jsp.Banking_Application.exception.NotFoundException;
import edu.jsp.Banking_Application.repository.AccountRepository;
import edu.jsp.Banking_Application.repository.UserRepository;

@Service
public class AccountService {
	
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public String createAccount(Long userId,Account a) {
		User u=userRepository.findById(userId).orElseThrow(()-> new NotFoundException("User Not Found"));
		u.addAccount(a);
		userRepository.save(u);
		return "Account created";
	}
	
	public String deleteAccount(Long userId,Long accountId)
	{
		User u=userRepository.findById(userId).orElseThrow(()-> new NotFoundException("User Not Found"));
		Account a=accountRepository.findById(accountId).orElseThrow(()-> new NotFoundException("Account Not Found"));
		
		u.removeAccount(a);
		userRepository.save(u);
		
		return "Account Deleted";
		
	}
	
	public Account getAccountById(Long accountId)
	{
		return accountRepository.findById(accountId).orElseThrow(()-> new NotFoundException("Account Not Found"));
	}
	
	public List<Account> getAccountByUserId(Long userId)
	{
		return accountRepository.getAccountsByUserId(userId);
	}
	
	public Double getBalance(Long accountId) {
		Account a=accountRepository.findById(accountId).orElseThrow(()->new NotFoundException("Account Not Found"));
		return a.getBalance();
	}

}
