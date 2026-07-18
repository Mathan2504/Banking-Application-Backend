package edu.jsp.Banking_Application.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.jsp.Banking_Application.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	@Query(value="select t from Transaction t where t.account.user.uid = ?1 order by date")
	List<Transaction> getAllTransactionByUser(Long userId);
	
	@Query(value="select t from Transaction t where t.account.user.uid=?1 and t.date between ?2 and ?3")
	List<Transaction> getAllTransactionByUserDate(Long userId,LocalDateTime st,LocalDateTime end);
	
	List<Transaction> findByAccountUserUidAndAmountBetween(Long uid,double st,double end);
}
