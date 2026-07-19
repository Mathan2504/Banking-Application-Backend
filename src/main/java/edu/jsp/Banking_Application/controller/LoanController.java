package edu.jsp.Banking_Application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.Banking_Application.entity.Loan;
import edu.jsp.Banking_Application.entity.User;
import edu.jsp.Banking_Application.service.LoanService;
@CrossOrigin(origins = "https://banking-application-sigma.vercel.app/")
@RestController
@RequestMapping("api/loan")
public class LoanController {
	
	@Autowired
	public LoanService loanService;
	
	//http://localhost:8080/api/loan
		@PostMapping("/{id}")
		public String createLoan(@RequestBody Loan l,@PathVariable long id){
			return loanService.applyLoan(id,l);
		}
		
		
		@DeleteMapping("/{userId}/loan/{loanId}")
		public String deleteLoan(@RequestParam long userId,@RequestParam long loanId)
		{
			return loanService.deleteLoan(userId,loanId);
		}
		
		@GetMapping("/{id}")
		public Loan getLoanById(@PathVariable long id) {
			return loanService.getLoanById(id);
		}

		@GetMapping("/user/{userId}")
		public List<Loan> getLoanByUserId(@PathVariable Long userId) {
			return loanService.getLoanByUserId(userId);
		}

		@PutMapping("/{loanId}/status/{status}")
		public String repayLoan(@PathVariable Long loanId,@PathVariable  String status) {
			return loanService.repayLoan(loanId, status);
		}

		@GetMapping("/status/{loanId}")
		public String getStatus(@PathVariable Long loanId) {
			return loanService.getStatus(loanId);
		}

}
