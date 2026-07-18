package edu.jsp.Banking_Application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.jsp.Banking_Application.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	
	@Query(value="select a from Account a where a.user.uid=?1")
	List<Account> getAccountsByUserId(Long userId);

}
