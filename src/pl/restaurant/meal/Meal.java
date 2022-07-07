package pl.restaurant.meal;

import java.util.List;
import pl.restaurant.*;
import pl.restaurant.models.MealIngredient;
import pl.restaurant.order.Order;

import javax.persistence.*;

@Entity
public class Meal {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double price;
	private boolean availability;
	@OneToMany(mappedBy ="meal")
	private List<MealIngredient> mealIngredients;
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
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public List<MealIngredient> getMealIngredients() {
		return mealIngredients;
	}
	public void setMealIngredients(List<MealIngredient> mealIngredients) {
		this.mealIngredients = mealIngredients;
	}
	
}
