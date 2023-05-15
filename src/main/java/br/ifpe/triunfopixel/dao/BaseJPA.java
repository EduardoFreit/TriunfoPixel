package br.ifpe.triunfopixel.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public abstract class BaseJPA<T> {
    
    private final EntityManager em = DAO.getEntityManager();
    
    private final Class<T> cls;
    
    public BaseJPA(Class<T> cls) {
        this.cls = cls;
    }
    
    public void insert(T t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }
    
    public void insertAll(List<T> list) {
        em.getTransaction().begin();
        for (T t : list) {
            em.persist(t);
        }
        em.getTransaction().commit();
    }

    public void remove(T t) {
        em.getTransaction().begin();
        em.remove(em.merge(t));
        em.getTransaction().commit();
    }

    public void update(T t) {
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
    }

    public List<T> listAll() {
        CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(cls);
        query.select(query.from(cls));
        List<T> returnedList = em.createQuery(query).getResultList();
        return returnedList;
    }
    
    public T findById(Integer id) {
        T instancia = em.find(cls, id);
        return instancia;
    }
    
    public List<T> read(String query){
        List<T> returnedList = em.createQuery(query, cls).getResultList();
        return returnedList;
    }
}
