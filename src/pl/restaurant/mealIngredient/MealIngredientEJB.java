package pl.restaurant.mealIngredient;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class MealIngredientEJB {

    @PersistenceContext(name="restaurant")
    EntityManager manager;

    public void add(MealIngredient malIngredient)
    {
        manager.persist(mealIngredient);
    }

    public List<MealIngredient> getAll(){
        Query q = manager.createQuery("select m from MealIngredient m");
        @SuppressWarnings("unchecked")
        List<MealIngredient> mealIngredient = q.getResultList();
        return mealIngredient;
    }

    public MealIngredient get(int id)
    {
        return manager.find(MealIngredient.class, id);
    }

    public void update(MealIngredient mealIngredient)
    {
        mealIngredient = manager.merge(mealIngredient);
    }

    public void delete(int id){
        MealIngredient mealIngredient = manager.find(MealIngredient.class, id);
        manager.remove(mealIngredient);
    }
}