package pl.restaurant.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class MealIngredient {

	@Id
	@GeneratedValue
	private int id;
	private int quantity;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference(value="meal-mealIngredient")
	@JoinColumn(name ="meal_id", nullable = false)
	private Meal meal;
	@ManyToOne(fetch = FetchType.EAGER)
	//@JsonManagedReference(value="ingredient-mealIngredient")
	@JoinColumn(name ="ingredient_id", nullable = false)
	private Ingredient ingredient;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Meal getMeal() {
		return meal;
	}
	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	public Ingredient getIngredient() {
		return ingredient;
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	
}