package edu.jsp.Banking_Application.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uid;
	@NotBlank(message = "Name cannot be blank")
	private String name;
	@Email(message = "Enter valid email")
	private String email;
	@Size(min=6,max=15,message="Enter password with the range")
	private String password;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",orphanRemoval = true)
	private List<Loan> loans;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",orphanRemoval = true)
	private List<Account> accounts;
	
	
	
	public void addLoan(Loan l)
	{
		loans.add(l);
		l.setUser(this);
	}
	public void removeLoan(Loan l)
	{
		loans.remove(l);
		l.setUser(null);
	}
	
	public void addAccount(Account a)
	{
		accounts.add(a);
		a.setUser(this);
	}
	
	public void removeAccount(Account a)
	{
		accounts.remove(a);
		a.setUser(null);
	}
	
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Loan> getLoans() {
		return loans;
	}
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}


	
	

}
