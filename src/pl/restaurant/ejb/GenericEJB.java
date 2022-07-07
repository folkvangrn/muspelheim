package pl.restaurant.ejb;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Type;
import java.util.List;

public abstract class GenericEJB<T> {
	private Class<T> temporaryType;
    @PersistenceContext(name="restaurant")
    EntityManager entityManager;

    GenericEJB(){
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        temporaryType = (Class) pt.getActualTypeArguments()[0];
    }

    public T add(T entity){
        entityManager.persist(entity);
        return entity;
    }

    public T getById(Long key){
        return entityManager.find(temporaryType, key);
    }

    public List<T> getAll(){
        Query query = entityManager.createQuery(String.format("select c from %s c", temporaryType.getName()));
        return query.getResultList();
    }

    public void delete(Long id){
        T entity = entityManager.find(temporaryType ,id);
        entityManager.remove(entity);
    }

    public void update(T entity){
        entityManager.merge(entity);
    }
}
