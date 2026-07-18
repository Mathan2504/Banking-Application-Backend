package edu.jsp.Banking_Application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.Banking_Application.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findByName(String name);

}
