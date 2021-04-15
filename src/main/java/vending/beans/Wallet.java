package vending.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private double balance;
	private User user;
	
	public Wallet() {
		super();
	}
	
	public Wallet(long id) {
		super();
		this.id = id;
	}
	
	public Wallet(double balance) {
		super();
		this.balance = balance;
	}

	public Wallet(long id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID", nullable = false)
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
