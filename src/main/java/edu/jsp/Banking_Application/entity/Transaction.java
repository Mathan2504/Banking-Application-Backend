package edu.jsp.Banking_Application.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double amount;
	private LocalDateTime date;
	private String type;//could be "DEBIT" or "CREDIT"
	
	
	@ManyToOne
	@JoinColumn
	@JsonBackReference
	private Account account;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}

}
