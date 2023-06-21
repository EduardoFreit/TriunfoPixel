package br.ifpe.triunfopixel.service;

import java.util.List;

/**
 *
 * @author lepf9
 */
public interface IBaseService<T> {
    
    public Boolean insert(T t);
    
    public Boolean insertAll(List<T> list);
    
    public void remove(T t);
    
    public Boolean update(T t);
    
    public List<T> listAll();
    
    public T findById(Long id);
    
    public List<T> read(String query);
    
}
