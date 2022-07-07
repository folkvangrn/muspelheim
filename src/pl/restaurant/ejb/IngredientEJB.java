package pl.restaurant.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pl.restaurant.EJBinterface.IIngredientEJB;
import pl.restaurant.models.Ingredient;

@Stateless
public class IngredientEJB implements IIngredientEJB{
    @PersistenceContext(name="restaurant")
    EntityManager manager;

    public Ingredient add(Ingredient ingredient)
    {
        manager.persist(ingredient);
        return ingredient;
    }

    public List<Ingredient> getAll(){
        Query q = manager.createQuery("select i from Ingredient i");
        @SuppressWarnings("unchecked")
        List<Ingredient> ingredients = q.getResultList();
        return ingredients;
    }

    public Ingredient get(int id)
    {
        return manager.find(Ingredient.class, id);
    }

    public void update(Ingredient ingredient)
    {
        ingredient = manager.merge(ingredient);
    }

    public void delete(int id){
        Ingredient ingredient = manager.find(Ingredient.class, id);
        manager.remove(ingredient);
    }
}
