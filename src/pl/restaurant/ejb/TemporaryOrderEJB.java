package pl.restaurant.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pl.restaurant.EJBinterface.ITemporaryOrder;
import pl.restaurant.models.TemporaryOrder;

@Stateless
public class TemporaryOrderEJB implements ITemporaryOrder {
	@PersistenceContext(name="restaurant")
    EntityManager manager;

    public TemporaryOrder add(TemporaryOrder order)
    {
    	order.setOrderedAt(new Date());
        manager.persist(order);
        return order;
    }

    public List<TemporaryOrder> getAll(){
        Query q = manager.createQuery("select t from TemporaryOrder t");
        @SuppressWarnings("unchecked")
        List<TemporaryOrder> order = q.getResultList();
        return order;
    }

    public TemporaryOrder get(int id)
    {
    	TemporaryOrder to = manager.find(TemporaryOrder.class, id);
    	to.getClient().setClientOrders(null);
        return to;
    }

    public void update(TemporaryOrder order)
    {
        order = manager.merge(order);
    }

    public void delete(int id){
        TemporaryOrder order = manager.find(TemporaryOrder.class, id);
        manager.remove(order);
    }
}
