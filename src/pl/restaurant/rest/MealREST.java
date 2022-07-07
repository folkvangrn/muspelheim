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

import pl.restaurant.EJBinterface.IMealEJB;
import pl.restaurant.dto.GenericCreateResponse;
import pl.restaurant.models.Client;
import pl.restaurant.models.Meal;

@Path("/meal")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class MealREST{

    @EJB
    IMealEJB repository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public GenericCreateResponse<Meal> create(Meal meal){
    	try{
    		Meal responseMeal = repository.add(meal);
    		return new GenericCreateResponse<Meal>(responseMeal, Response.status(Status.ACCEPTED).build());
    	}catch(Exception ex){
    		return new GenericCreateResponse<Meal>(Response.status(Status.NOT_FOUND).build());
    	}
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
    public Response update(Meal meal){
    	try{
    		repository.update(meal);
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
    
    @PUT
    @Path("/promotions/{id}/{discount}")
    public void putDiscount(@PathParam("id") int id, @PathParam("discount") double discount){
    	repository.putDiscount(id, discount);
    }
}