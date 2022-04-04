package pl.restaurant;

import javax.persistence.*;

@Entity
public class MealIngredient {

	@Id
	@GeneratedValue
	private int id;
	private int quantity;
	@ManyToOne
	@JoinColumn(name ="meal_id", nullable = false)
	private Meal meal;
	@ManyToOne
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
