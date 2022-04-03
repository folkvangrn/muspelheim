package pl.restaurant;

import java.util.List;

import javax.persistence.*;

@Entity
public class Meal {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double price;
	private boolean availability;
	@ManyToMany
	@JoinTable(
	        name = "Meal_Ingredient", 
	        joinColumns = { @JoinColumn(name = "meal_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "ingredient_id") }
	    )
	private List<Ingredient> ingredients;
	@ManyToMany(mappedBy = "meals")
	private List<Order> orders;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isAvability() {
		return availability;
	}
	public void setAvability(boolean avability) {
		this.availability = avability;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
