package pl.restaurant.order;

import java.util.Date;
import java.util.List;
import pl.restaurant.*;
import pl.restaurant.models.Client;
import pl.restaurant.models.Meal;

import javax.persistence.*;

@Entity
public class Order {
	
	@Id
	@GeneratedValue
	private int id;
	private Date orderedAt;
	private double totalPrice;
	@ManyToMany
	@JoinTable(
	        name = "Order_Meal", 
	        joinColumns = { @JoinColumn(name = "order_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "meal_id") }
	    )
	private List<Meal> meals;
	@ManyToOne
	@JoinColumn(name ="client_id", nullable = false)
	private Client client;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
