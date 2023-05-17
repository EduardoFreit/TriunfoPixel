package br.ifpe.triunfopixel.tests;

import br.ifpe.triunfopixel.service.GameService;
import br.ifpe.triunfopixel.service.LoginService;
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

public class Teste {

    protected static GameService gameService;
    protected static LoginService loginService;
    protected static Logger logger;

    @BeforeClass
    public static void setUpClass() {
        logger = Logger.getGlobal();
        logger.setLevel(Level.INFO);
        gameService = new GameService();
        loginService = new LoginService();
        DbUnitUtil.inserirDados();
    }

}
