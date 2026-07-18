package edu.jsp.Banking_Application.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.Banking_Application.entity.Account;
import edu.jsp.Banking_Application.entity.Transaction;
import edu.jsp.Banking_Application.exception.NotFoundException;
import edu.jsp.Banking_Application.repository.AccountRepository;
import edu.jsp.Banking_Application.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public String addTransaction(Long  aid,Transaction t)
	{
		Account a=accountRepository.findById(aid).orElseThrow(()-> new NotFoundException("Account Not Found"));
		a.addTransaction(t);
		accountRepository.save(a);
		return "Transaction added";
	}
	
	public String removeTransaction(long aid,long tid) {
		Account a=accountRepository.findById(aid).orElseThrow(()->new NotFoundException("Account Not Found"));
		Transaction t=transactionRepository.findById(tid).orElseThrow(()->new NotFoundException("Transaction Not Found"));
		a.removeTranaction(t);
		accountRepository.save(a);
		return "Transaction removed";
	}
	
	public List<Transaction> getAllTransactionByUser(Long userId)
	{
		return transactionRepository.getAllTransactionByUser(userId);
	}
	
	public List<Transaction> getAllTransactionByUserDate(Long userId,LocalDateTime st,LocalDateTime end){
		return transactionRepository.getAllTransactionByUserDate(userId, st, end);
	}
	
	public List<Transaction> getAllTransactionByUserUidAndAmountBetween(Long uid,double st,double end)
	{
		return transactionRepository.findByAccountUserUidAndAmountBetween(uid, st, end);
	}
 
}
