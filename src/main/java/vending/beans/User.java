package vending.beans;

import java.util.List;

public class User{

	private long id;
	private long machineId;
	private String firstName;
	private String lastName;
	private List<Item> items;

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

	
	public List<Item> getItems() {
		return items;
	}
	
	public void addItems(Item item) {
		this.items.add(item);
	}
	
	public double checkOut() {
		double total = 0;
		for(Item item : items) {
			total += item.getPrice();
		}
		return total;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public long getMachineId() {
		return machineId;
	}

	public void setMachineId(long machineId) {
		this.machineId = machineId;
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
}
