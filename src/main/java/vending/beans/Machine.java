package vending.beans;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Machines")
public class Machine implements java.io.Serializable{
	private long id;
	private String details;
	private Set<Item> items = new HashSet<Item>(0);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public Set<Item> getItems() {
		return this.items;
	}
	
	public void setItems(Set<Item> items) {
		this.items = items;
	}
}
