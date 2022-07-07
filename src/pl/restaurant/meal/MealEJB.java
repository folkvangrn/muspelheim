package pl.restaurant.meal;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class MealEJB {

    @PersistenceContext(name="restaurant")
    EntityManager manager;

    public void add(Meal meal)
    {
        manager.persist(meal);
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
}