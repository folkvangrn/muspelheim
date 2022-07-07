package pl.restaurant.EJBinterface;

import java.util.List;

public interface IGenericEJB<T> {
    T add(T entity);
    T get(int id);
    List<T> getAll();
    void delete(int id);
    void update(T entity);
}
