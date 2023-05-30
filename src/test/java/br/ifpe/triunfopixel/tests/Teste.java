package br.ifpe.triunfopixel.tests;

import br.ifpe.triunfopixel.service.GameService;
import br.ifpe.triunfopixel.service.UserService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.BeforeClass;

public class Teste {

    protected static GameService gameService;
    protected static UserService userService;
    protected static Logger logger;
    
    @Before
    public void insertDB() {
        DbUnitUtil.inserirDados();
    }

    @BeforeClass
    public static void setUpClass() {
        logger = Logger.getGlobal();
        logger.setLevel(Level.INFO);
        gameService = new GameService();
        userService = new UserService();
    }
    
}
