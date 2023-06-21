package br.ifpe.triunfopixel.dao;

import java.util.List;
import java.util.Set;
import javax.validation.Validator;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;

public abstract class BaseJPA<T> {
    
    private final EntityManager em = DAO.getEntityManager();
    protected Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    
    private final Class<T> cls;
    
    public BaseJPA(Class<T> cls) {
        this.cls = cls;
    }
    
    public Boolean insert(T t) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
        if(constraintViolations.isEmpty()) {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } else {
            return false;
        }
        return true;
    }
    
    public Boolean insertAll(List<T> list) {
        Set<ConstraintViolation<T>> constraintViolations;
        em.getTransaction().begin();
        for (T t : list) {
            constraintViolations = validator.validate(t);
            if(constraintViolations.isEmpty()) {
                em.persist(t);
            } else {
                return false;
            }
        }
        em.getTransaction().commit();
        return true;
    }

    public void remove(T t) {
        em.getTransaction().begin();
        em.remove(em.merge(t));
        em.getTransaction().commit();
    }

    public Boolean update(T t) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
        if(constraintViolations.isEmpty()) {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } else {
            return false;
        }
        return true;
    }

    public List<T> listAll() {
        CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(cls);
        query.select(query.from(cls));
        List<T> returnedList = em.createQuery(query).getResultList();
        return returnedList;
    }
    
    public T findById(Long id) {
        T instancia = em.find(cls, id);
        return instancia;
    }
    
    public List<T> read(String query) {
        List<T> returnedList = em.createQuery(query, cls).getResultList();
        return returnedList;
    }
    
    public List<T> readQuery(CriteriaQuery<T> cq) {
        return em.createQuery(cq).getResultList();
    }
}
