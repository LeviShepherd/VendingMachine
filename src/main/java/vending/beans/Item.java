package vending.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int quantity;
	private double price;
	private Machine machine;
	
	public Item() {
		super();
	}
	
	public Item(long id) {
		super();
		this.id = id;
	}
	
	public Item(int quantity, double price) {
		super();
		this.quantity = quantity;
		this.price = price;
	}
	
	public Item(long id, int quantity, double price) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
