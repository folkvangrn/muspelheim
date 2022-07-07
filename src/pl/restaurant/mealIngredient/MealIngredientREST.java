package pl.restaurant.mealIngredient;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/mealIngredient")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class MealIngredientREST{

    @EJB
    MealIngredientEJB repository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(MealIngredient mealIngredient)
    {
        repository.add(mealIngredient);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MealIngredient get(@PathParam("id") int id){
        MealIngredient mealIngredient = repository.get(id);
        return mealIngredient;
    }

    @GET
    public List<MealIngredient> getAll(){
        List<MealIngredient> mealIngredient = repository.getAll();
        return mealIngredient;
    }

    @PUT
    public void update(MealIngredient mealIngredient){
        repository.update(mealIngredient);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id){
        repository.delete(id);
    }
}