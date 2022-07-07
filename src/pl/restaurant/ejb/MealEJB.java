package pl.restaurant.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pl.restaurant.EJBinterface.IMealEJB;
import pl.restaurant.models.Meal;

@Stateless
public class MealEJB implements IMealEJB{
    @PersistenceContext(name="restaurant")
    EntityManager manager;

    public Meal add(Meal meal)
    {
        manager.persist(meal);
        return meal;
    }

    public List<Meal> getAll(){
        Query q = manager.createQuery("select m from Meal m");
        @SuppressWarnings("unchecked")
        List<Meal> meal = q.getResultList();
        return meal;
    }

    public Meal get(int id)
    {
        return manager.find(Meal.class, id);
    }

    public void update(Meal meal)
    {
        meal = manager.merge(meal);
    }

    public void delete(int id){
        Meal meal = manager.find(Meal.class, id);
        manager.remove(meal);
    }
    
    public void putDiscount(int id, double discount){
    	Meal meal = manager.find(Meal.class, id);
    	meal.setPrice(meal.getPrice() * ((100.0 - discount)/100.0));
    	manager.merge(meal);
    }
}
