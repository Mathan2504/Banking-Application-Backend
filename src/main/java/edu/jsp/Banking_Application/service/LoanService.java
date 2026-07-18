package edu.jsp.Banking_Application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.Banking_Application.entity.Loan;
import edu.jsp.Banking_Application.entity.User;
import edu.jsp.Banking_Application.exception.NotFoundException;
import edu.jsp.Banking_Application.repository.LoanRepository;
import edu.jsp.Banking_Application.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class LoanService {
	
	
	@Autowired
	private LoanRepository loanRepository;
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	public String applyLoan(Long userId,Loan loan) {
		Optional<User> o=userRepository.findById(userId);
		
		if(o.isPresent()) {
			User u=o.get();
			u.addLoan(loan);
			userRepository.save(u);
			return "Loan applied !!!";
		}else{
			throw new NotFoundException("User Not Found");
		}
	}
		
	@Transactional
		public String deleteLoan(Long userId,Long loanId)
		{
			Optional<User> uo=userRepository.findById(userId);
			Optional<Loan> lo=loanRepository.findById(loanId);
			
			if(uo.isPresent() && lo.isPresent())
			{
				User u=uo.get();
				Loan l=lo.get();
				u.removeLoan(l);
			
				userRepository.save(u);
				return "Loan Deleted";
				
			}else {
				throw new NotFoundException("User Not Found");
			}
			
		}
	public Loan getLoanById(Long id) {
		return loanRepository.findById(id).orElseThrow(()-> new NotFoundException("Loan Not Found"));
	}
	
	public List<Loan> getLoanByUserId(Long userId)
	{
		return loanRepository.getLoanUserId(userId);
	}
	
	public String repayLoan(Long loanId,String status) {
		Loan l=loanRepository.findById(loanId).orElseThrow(()->new NotFoundException("Loan Not Found"));
		l.setStatus(status);
		return "Status updated";
	}
	public String getStatus(Long loanId) {
		Loan l=loanRepository.findById(loanId).orElseThrow(()->new NotFoundException("Loan Not Found"));
		return l.getStatus();
	}

}
