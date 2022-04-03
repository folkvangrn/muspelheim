package pl.restaurant;

import java.util.List;

import javax.persistence.*;

@Entity
public class Ingredient {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double quantity;
	@ManyToMany(mappedBy = "ingredients")
	private List<Meal> meals;
	
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
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public List<Meal> getMeals() {
		return meals;
	}
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	
}
