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

import pl.restaurant.EJBinterface.IIngredientEJB;
import pl.restaurant.dto.GenericCreateResponse;
import pl.restaurant.models.Client;
import pl.restaurant.models.Ingredient;

@Path("/ingredient")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class IngredientREST{

    @EJB
    IIngredientEJB repository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public GenericCreateResponse<Ingredient> create(Ingredient ingredient){
    	try{
    		Ingredient responseIngredient = repository.add(ingredient);
    		return new GenericCreateResponse<Ingredient>(responseIngredient, Response.status(Status.ACCEPTED).build());
    	}catch(Exception ex){
    		return new GenericCreateResponse<Ingredient>(Response.status(Status.NOT_FOUND).build());
    	}
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ingredient get(@PathParam("id") int id){
        Ingredient ingredient = repository.get(id);
        return ingredient;
    }

    @GET
    public List<Ingredient> getAll(){
        List<Ingredient> ingredient = repository.getAll();
        return ingredient;
    }

    @PUT
    public Response update(Ingredient ingredient){
    	try{
    		repository.update(ingredient);
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