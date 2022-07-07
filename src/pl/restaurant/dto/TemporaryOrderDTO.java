package pl.restaurant.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import pl.restaurant.models.Client;
import pl.restaurant.models.Meal;
import pl.restaurant.models.TemporaryOrder;

public class TemporaryOrderDTO {

	private int id;
	private Date orderedAt;
	private double totalPrice;
	private List<Meal> meals;
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
	
	public TemporaryOrderDTO(TemporaryOrder order){
		id = order.getId();
		orderedAt = order.getOrderedAt();
		totalPrice = order.getTotalPrice();
		meals = order.getMeals();
		client = order.getClient();
	}
}
