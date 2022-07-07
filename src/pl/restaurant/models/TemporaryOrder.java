package pl.restaurant.models;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class TemporaryOrder {

	@Id
	@GeneratedValue
	private int id;
	private Date orderedAt;
	private double totalPrice;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	        name = "TemporaryOrder_Meal", 
	        joinColumns = { @JoinColumn(name = "temporaryOrder_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "meal_id") }
	    )
	private List<Meal> meals;
	@ManyToOne(fetch = FetchType.EAGER)
	//@JsonManagedReference
	@JoinColumn(name ="client_id", nullable = false)
	private Client client;
	
	public int getId() {
		return id;
	}
	public void setOrderId(int id) {
		this.id = id;
	}
	public Date getOrderedAt() {
		return orderedAt;
	}
	public void setOrderedAt(Date orderedAt) {
		this.orderedAt = orderedAt;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<Meal> getMeals() {
		return meals;
	}
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
}
