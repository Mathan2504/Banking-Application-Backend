package edu.jsp.Banking_Application.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import edu.jsp.Banking_Application.entity.Account;
import edu.jsp.Banking_Application.entity.Transaction;
import edu.jsp.Banking_Application.exception.NotFoundException;
import edu.jsp.Banking_Application.service.TransactionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/transaction")
public class TransactionController {
	
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/{aid}")
	public String addTransaction(@PathVariable Long  aid,@RequestBody Transaction t)
	{
		return transactionService.addTransaction(aid, t);
	}
	
	@DeleteMapping("/{aid}/{tid}")
	public String removeTransaction(@PathVariable long aid,@PathVariable long tid) {
	
		return transactionService.removeTransaction(aid, tid);
	}
	
	
	@GetMapping("/user/{userId}")
	public List<Transaction> getAllTransactionByUser(@PathVariable Long userId)
	{
		return transactionService.getAllTransactionByUser(userId);
	}
	
	@GetMapping("/date/{userId}/{st}/{end}")
	public List<Transaction> getAllTransactionByUserDate(@PathVariable Long userId,@PathVariable LocalDateTime st,@PathVariable LocalDateTime end){
		return transactionService.getAllTransactionByUserDate(userId, st, end);
	}
	
	 @GetMapping("/amount/{uid}/{st}/{end}")
	public List<Transaction> getAllTransactionByUserUidAndAmountBetween(Long uid,double st,double end)
	{
		return transactionService.getAllTransactionByUserUidAndAmountBetween(uid, st, end);
	}
	

}
