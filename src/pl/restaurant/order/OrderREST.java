package pl.restaurant.order;

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

@Path("/order")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class MealIngredientREST{

    @EJB
    OrderEJB repository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Order order)
    {
        repository.add(order);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order get(@PathParam("id") int id){
        Order order = repository.get(id);
        return order;
    }

    @GET
    public List<Order> getAll(){
        List<Order> order = repository.getAll();
        return order;
    }

    @PUT
    public void update(Order order){
        repository.update(order);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id){
        repository.delete(id);
    }
}