package pl.restaurant.order;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class OrderEJB {

    @PersistenceContext(name="restaurant")
    EntityManager manager;

    public void add(Order order)
    {
        manager.persist(order);
    }

    public List<Order> getAll(){
        Query q = manager.createQuery("select q from Order q");
        @SuppressWarnings("unchecked")
        List<Order> order = q.getResultList();
        return order;
    }

    public Order get(int id)
    {
        return manager.find(Order.class, id);
    }

    public void update(Order order)
    {
        order = manager.merge(order);
    }

    public void delete(int id){
        Order order = manager.find(Order.class, id);
        manager.remove(order);
    }
}