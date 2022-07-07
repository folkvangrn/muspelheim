package pl.restaurant.models;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Ingredient {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double quantity;
	@OneToMany(fetch = FetchType.EAGER, mappedBy ="ingredient")
	@JsonIgnore
	//@JsonBackReference(value="ingredient-mealIngredient")
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
