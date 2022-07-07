package pl.restaurant.models;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Meal {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double price;
	private boolean availability;
	@OneToMany(fetch = FetchType.EAGER, mappedBy ="meal")
	@JsonManagedReference(value="meal-mealIngredient")
	private List<MealIngredient> mealIngredients;
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "meals")
	private List<TemporaryOrder> orders;
	
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
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public List<TemporaryOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<TemporaryOrder> orders) {
		this.orders = orders;
	}
	public List<MealIngredient> getMealIngredients() {
		return mealIngredients;
	}
	public void setMealIngredients(List<MealIngredient> mealIngredients) {
		this.mealIngredients = mealIngredients;
	}
	
}
