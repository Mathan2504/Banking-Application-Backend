package edu.jsp.Banking_Application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.Banking_Application.entity.User;
import edu.jsp.Banking_Application.service.UserService;
import jakarta.validation.Valid;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/user")
public class UserController {
	
	
	@Autowired
	public UserService userService;
	
	
	//http://localhost:8080/api/user?id=1
	@GetMapping
	public User getUserById(@RequestParam long id) {
		return userService.getUserById(id);
		
	}
	
	//http://localhost:8080/api/user
	@PostMapping
	public ResponseEntity<User> createUser(@Valid  @RequestBody User u){
		return userService.createUser(u);
	}
	
	
	@DeleteMapping
	public ResponseEntity<String> deleteUser(@RequestParam long id)
	{
		return userService.deleteUser(id);
	}
	
	@PutMapping
	public ResponseEntity<String> updateUser(@RequestBody User u,@RequestParam long id)
	{
		return userService.updateUser(u, id);
	}
	
	
	@GetMapping("/{name}")
	public ResponseEntity<List<User>> searchUserByName(@PathVariable String name)
	{
		return userService.searchUserByName(name);
	}

}
