package br.ifpe.triunfopixel.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class DAO {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static EntityManager getEntityManager() {
        if (em == null) {
            emf = Persistence.createEntityManagerFactory("TriunfoPixel_PU");
            em = emf.createEntityManager();
        }
        return em;
    }

}

