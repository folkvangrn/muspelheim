package pl.restaurant.rest;

import java.util.ArrayList;
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

import pl.restaurant.EJBinterface.ITemporaryOrder;
import pl.restaurant.dto.GenericCreateResponse;
import pl.restaurant.dto.TemporaryOrderDTO;
import pl.restaurant.models.Client;
import pl.restaurant.models.TemporaryOrder;

@Path("/order")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class TemporaryOrderREST {
	
	@EJB
    ITemporaryOrder repository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public GenericCreateResponse<TemporaryOrder> create(TemporaryOrder order){
    	try{
    		TemporaryOrder responseTemporaryOrder = repository.add(order);
    		return new GenericCreateResponse<TemporaryOrder>(responseTemporaryOrder, Response.status(Status.ACCEPTED).build());
    	}catch(Exception ex){
    		return new GenericCreateResponse<TemporaryOrder>(Response.status(Status.NOT_FOUND).build());
    	}
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TemporaryOrderDTO get(@PathParam("id") int id){
        TemporaryOrder order = repository.get(id);
        TemporaryOrderDTO orderToReturn = new TemporaryOrderDTO(order);
        return orderToReturn;
    }

    @GET
    public List<TemporaryOrderDTO> getAll(){
    	List<TemporaryOrderDTO> orderDto = new ArrayList<TemporaryOrderDTO>();
        List<TemporaryOrder> order = repository.getAll();
        for(TemporaryOrder o : order){
        	orderDto.add(new TemporaryOrderDTO(o));
        }
        return orderDto;
    }

    @PUT
    public Response update(TemporaryOrder order){
    	try{
    		repository.update(order);
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
