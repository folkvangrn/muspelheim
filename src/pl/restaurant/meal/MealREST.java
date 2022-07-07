package pl.restaurant.meal;

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

@Path("/meal")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class MealREST{

    @EJB
    MealEJB repository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Meal meal)
    {
        repository.add(meal);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Meal get(@PathParam("id") int id){
        Meal meal = repository.get(id);
        return meal;
    }

    @GET
    public List<Meal> getAll(){
        List<Meal> meal = repository.getAll();
        return meal;
    }

    @PUT
    public void update(Meal meal){
        repository.update(meal);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id){
        repository.delete(id);
    }
}