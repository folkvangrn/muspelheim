package pl.restaurant.EJBinterface;

import pl.restaurant.models.Meal;

public interface IMealEJB extends IGenericEJB<Meal>{
	public void putDiscount(int id, double discount);
}
