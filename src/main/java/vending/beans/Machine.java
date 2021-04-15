package vending.beans;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Machine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String details;
	private List<Item> items;
	private List<User> users;
	
	public Machine() {
		super();
	}
	
	public Machine(long id) {
		super();
		this.id = id;
	}
	
	public Machine(String details) {
		super();
		this.details = details;
	}

	public Machine(long id, String details) {
		super();
		this.id = id;
		this.details = details;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Machines")
	public List<Item> getItems() {
		return this.items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Machines")
	public List<User> getUsers() {
		return this.users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
