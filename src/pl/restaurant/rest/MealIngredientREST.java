package pl.restaurant.rest;

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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import pl.restaurant.EJBinterface.IMealIngredientEJB;
import pl.restaurant.dto.GenericCreateResponse;
import pl.restaurant.models.Client;
import pl.restaurant.models.MealIngredient;

@Path("/mealIngredient")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class MealIngredientREST{

    @EJB
    IMealIngredientEJB repository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public GenericCreateResponse<MealIngredient> create(MealIngredient mealIngredient){
    	try{
    		MealIngredient responseMealIngredient = repository.add(mealIngredient);
    		return new GenericCreateResponse<MealIngredient>(responseMealIngredient, Response.status(Status.ACCEPTED).build());
    	}catch(Exception ex){
    		return new GenericCreateResponse<MealIngredient>(Response.status(Status.NOT_FOUND).build());
    	}
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
    public Response update(MealIngredient mealIngredient){
    	try{
    		repository.update(mealIngredient);
    		return Response.status(Status.ACCEPTED).build();
    	}catch(Exception ex){
    		return Response.status(Status.NOT_FOUND).build();
    	}
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id){
        repository.delete(id);
    }
}