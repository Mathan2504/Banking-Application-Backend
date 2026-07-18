package edu.jsp.Banking_Application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.jsp.Banking_Application.entity.Loan;
import jakarta.persistence.NamedQuery;

public interface LoanRepository extends JpaRepository<Loan, Long> {
	
	@Query("select l from Loan l where l.user.uid=?1")
	List<Loan> getLoanUserId(long userId);

}
