package vending.beans;

import java.util.ArrayList;
import java.util.List;

public class User{

	private List<Item> items = new ArrayList<Item>();

	public User() {
		super();
	}

	public List<Item> getItems() {
		return items;
	}
	
	public void addItems(Item item) {
		items.add(item);
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
	
	public double getCost() {
		double cost = 0;
		for(Item i : items) {
			cost += i.getPrice();
		}
		return cost;
	}
}
