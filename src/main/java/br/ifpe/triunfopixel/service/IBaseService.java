package br.ifpe.triunfopixel.service;

import java.util.List;

/**
 *
 * @author lepf9
 */
public interface IBaseService<T> {
    
    public void insert(T t);
    
    public void insertAll(List<T> list);
    
    public void remove(T t);
    
    public void update(T t);
    
    public List<T> listAll();
    
    public T findById(Long id);
    
    public List<T> read(String query);
    
}
