package pl.restaurant.rest;

import java.util.Collections;



import java.util.Date;
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

import pl.restaurant.EJBinterface.IClientEJB;
import pl.restaurant.dto.GenericCreateResponse;
import pl.restaurant.models.Client;
import pl.restaurant.models.TemporaryOrder;

/**
 * rest endpoint to manage clients of the restaurant
 * <p>
 * POST consumes json representing client object in following format:
 * "{
 *     "name":"rafal",
 *     "surname":"jurczyk",
 *     "address":"owocowa",
 *     "email":"mailrafala",
 *     "clientOrders":null
 * }"
 *
 */
@Path("/client")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class ClientREST{

    @EJB
    IClientEJB repository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public GenericCreateResponse<Client> create(Client client){
    	try{
    		Client responseClient = repository.add(client);
    		return new GenericCreateResponse<Client>(responseClient, Response.status(Status.ACCEPTED).build());
    	}catch(Exception ex){
    		return new GenericCreateResponse<Client>(Response.status(Status.NOT_FOUND).build());
    	}
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Client get(@PathParam("id") int id){
        Client client = repository.get(id);
        return client;
    }

    @GET
    public List<Client> getAll(){
        List<Client> clients = repository.getAll();
        return clients;
    }

    @PUT
    public Response update(Client client){
    	try{
    		repository.update(client);
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