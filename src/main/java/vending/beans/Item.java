package vending.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String description;
	private int quantity;
	private double price;

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
	
	public Item(long id, String name, int quantity, double price) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
	//methods
	public void subtractFromQuantity(int toSubtract) {
		if(toSubtract > this.quantity) {
			System.out.println("This item is out of stock!");
		}
		else {
			int newQuantity = this.quantity - toSubtract;
			setQuantity(newQuantity);
		}
	}
}
