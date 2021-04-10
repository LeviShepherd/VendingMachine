package vending.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User implements java.io.Serializable {
	private long id;
	private String firstName;
	private String lastName;
	private Set<Wallet> wallets = new HashSet<Wallet>(0);
	private Machine machine;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public Set<Wallet> getWallets() {
		return this.wallets;
	}
	
	public void setWallets(Set<Wallet> wallets) {
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
