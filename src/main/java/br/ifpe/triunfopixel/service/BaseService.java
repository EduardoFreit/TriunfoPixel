package br.ifpe.triunfopixel.service;

import br.ifpe.triunfopixel.dao.BaseJPA;
import java.util.List;

public abstract class BaseService<T> {
    
    private final Class<T> cls;
    protected final BaseJPA<T> baseRepository;
    
    public BaseService(Class<T> cls, BaseJPA<T> baseRepository) {
        this.cls = cls;
        this.baseRepository = baseRepository;
    }
    
    public void insert(T t) {
        baseRepository.insert(t);
    }
    
    public void insertAll(List<T> list) {
        baseRepository.insertAll(list);
    }

    public void remove(T t) {
        baseRepository.remove(t);
    }

    public void update(T t) {
        baseRepository.update(t);
    }

    public List<T> listAll() {
        return baseRepository.listAll();
    }
    
    public T findById(Long id) {
        return baseRepository.findById(id);
    }
    
    public List<T> read(String query){
        return baseRepository.read(query);
    }
    
    
}
