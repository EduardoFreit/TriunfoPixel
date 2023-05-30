package br.ifpe.triunfopixel.service;

import br.ifpe.triunfopixel.dao.BaseJPA;
import static br.ifpe.triunfopixel.dao.DAO.getEntityManager;
import br.ifpe.triunfopixel.model.Usr;
import br.ifpe.triunfopixel.util.Util;
import java.io.Serializable;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserService extends BaseJPA<Usr> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public UserService() {
        super(Usr.class);
    }
    
    public Usr login(String email, String password) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usr> cq = cb.createQuery(Usr.class);
        Root<Usr> from = cq.from(Usr.class);
        cq.where(cb.and(cb.equal(from.get("email"), email),
                cb.equal(from.get("password"), password)));
        return getEntityManager().createQuery(cq).getResultStream().findFirst().orElse(null);
    }
    
    public Usr checkPersonWithEmail(String email) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usr> cq = cb.createQuery(Usr.class);
        Root<Usr> from = cq.from(Usr.class);
        cq.where(cb.equal(from.get("email"), email));
        return getEntityManager()
                .createQuery(cq)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public void insert(Usr user) {
        String encryptPassword = Util.md5(user.getPassword()); 
        user.setPassword(encryptPassword); 
        super.insert(user);
    }
      
}