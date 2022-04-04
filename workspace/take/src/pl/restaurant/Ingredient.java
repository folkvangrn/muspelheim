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
	@OneToMany(mappedBy ="ingredient")
	private List<MealIngredient> mealIngredients;
	
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
	public List<MealIngredient> getMealIngredients() {
		return mealIngredients;
	}
	public void setMealIngredients(List<MealIngredient> mealIngredients) {
		this.mealIngredients = mealIngredients;
	}
	
}