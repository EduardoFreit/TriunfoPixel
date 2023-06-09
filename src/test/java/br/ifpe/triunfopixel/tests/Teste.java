package br.ifpe.triunfopixel.tests;

import br.ifpe.triunfopixel.service.ConsoleService;
import br.ifpe.triunfopixel.service.GameService;
import br.ifpe.triunfopixel.service.UserService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Before;
import org.junit.BeforeClass;

public class Teste {

    protected static GameService gameService;
    protected static UserService userService;
    protected static ConsoleService consoleService;
    protected static Logger logger;
    protected Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    
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
        consoleService = new ConsoleService();
        DbUnitUtil.inserirDados();
    }
    
}
