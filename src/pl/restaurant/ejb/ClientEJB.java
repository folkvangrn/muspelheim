package pl.restaurant.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pl.restaurant.EJBinterface.IClientEJB;
import pl.restaurant.models.Client;

@Stateless
public class ClientEJB implements IClientEJB{
    @PersistenceContext(name="restaurant")
    EntityManager manager;

    public Client add(Client client)
    {
        manager.persist(client);
        return client;
    }

    public List<Client> getAll(){
        Query q = manager.createQuery("select c from Client c");
        @SuppressWarnings("unchecked")
        List<Client> clients = q.getResultList();
        return clients;
    }

    public Client get(int id)
    {
        return manager.find(Client.class, id);
    }

    public void update(Client client)
    {
        client = manager.merge(client);
    }

    public void delete(int id){
        Client client = manager.find(Client.class, id);
        manager.remove(client);
    }
}
