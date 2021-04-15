package vending.beans;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private List<Wallet> wallets;
	private Machine machine;
	
	public User() {
		super();
	}
	
	public User(long id) {
		super();
		this.id = id;
	}
	
	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Users")
	public List<Wallet> getWallets() {
		return this.wallets;
	}
	
	public void setWallets(List<Wallet> wallets) {
		this.wallets = wallets;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MachineID", nullable = false)
	public Machine getMachine() {
		return machine;
	}
	
	public void setMachine(Machine machine) {
		this.machine = machine;
	}
}
