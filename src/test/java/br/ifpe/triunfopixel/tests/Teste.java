/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifpe.triunfopixel.tests;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author lepf9
 */
public class Teste {

    protected static EntityManagerFactory emf;
    protected static Logger logger;
    protected EntityManager em;
    protected EntityTransaction et;

    @BeforeClass
    public static void setUpClass() {
        logger = Logger.getGlobal();
        logger.setLevel(Level.INFO);
        emf = Persistence.createEntityManagerFactory("TriunfoPixel_PU");
        DbUnitUtil.inserirDados();
    }

    @AfterClass
    public static void tearDownClass() {
        //emf.close();
    }

    @Before
    public void setUp() {
        /*em = emf.createEntityManager();
        beginTransaction();*/
    }

    @After
    public void tearDown() {
        /**commitTransaction();
        em.close();*/
    }

    private void beginTransaction() {
        /*et = em.getTransaction();
        et.begin();*/
    }

    private void commitTransaction() {
        /*if (!et.getRollbackOnly()) {
            et.commit();
        }*/
    }

    /*protected Date getData(Integer dia, Integer mes, Integer ano) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, ano);
        c.set(Calendar.MONTH, mes);
        c.set(Calendar.DAY_OF_MONTH, dia);
        return c.getTime();
    }*/
}
