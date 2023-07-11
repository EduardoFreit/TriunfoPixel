package br.ifpe.triunfopixel.tests.game;

import br.ifpe.triunfopixel.model.Console;
import br.ifpe.triunfopixel.model.Game;
import br.ifpe.triunfopixel.tests.Teste;
import java.io.InputStream;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

 public class GameValidationTestes extends Teste {
     
    private Console console1;
    private String string260;
     
    @Before
    public void beforeTest() {
        string260 = RandomStringUtils.randomAlphanumeric(260);
        this.console1 = consoleService.findById(1L);
    }
     
     
    @Test
    public void gameSemConsole() {
        Game newGame = new Game();
        newGame.setConsole(null);
        newGame.setName("Alien Trilogy");
        newGame.setGenre("First-Person Shooter");
        newGame.setUrlImagem("https://media.retroachievements.org/Images/054485.png");
        newGame.setHash("testes");
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void gameSemNome() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName(null);
        newGame.setGenre("First-Person Shooter");
        newGame.setUrlImagem("https://media.retroachievements.org/Images/054485.png");
        newGame.setHash("testes");
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void gameSemGenero() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName("Alien Trilogy");
        newGame.setGenre(null);
        newGame.setUrlImagem("https://media.retroachievements.org/Images/054485.png");
        newGame.setHash("testes");
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void gameSemUrlImage() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName("Alien Trilogy");
        newGame.setGenre("First-Person Shooter");
        newGame.setUrlImagem(null);
        newGame.setHash("testes");
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void gameSemHash() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName("Alien Trilogy");
        newGame.setGenre("First-Person Shooter");
        newGame.setUrlImagem("testes");
        newGame.setHash("testes");
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void gameCamposMenosDoisCaracteres() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName("A");
        newGame.setGenre("F");
        newGame.setUrlImagem("t");
        newGame.setHash("t");
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(5, constraintViolations.size());
    }
    
    @Test
    public void gameCamposMais255Caracteres() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName(string260);
        newGame.setGenre(string260);
        newGame.setUrlImagem(string260);
        newGame.setHash(string260);
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(5, constraintViolations.size());
    }
    
    @Test
    public void gameSemUrlImageValida() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName("Alien Trilogy");
        newGame.setGenre("First-Person Shooter");
        newGame.setUrlImagem("sdasda");
        newGame.setHash("testes");
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test(expected = Exception.class)
    public void downloadRomGameNull() throws Exception {
        gameService.getRomFile(null);
    }
    
    @Test
    public void downloadRomGameSemNome() throws Exception {
        Game game = gameService.findById(1L);
        game.setConsole(console1);
        InputStream result = gameService.getRomFile(game);
        assertNull(result);
    }
    
    @Test
    public void downloadRomGameNomeNaoExiste() throws Exception {
        Game game = gameService.findById(1L);
        game.setName("PlayStation 9");
        InputStream result = gameService.getRomFile(game);
        assertNull(result);
    }
    
    @Test(expected = Exception.class)
    public void downloadRomSemConsole() throws Exception {
        Game game = new Game();
        game.setName("PlayStation 9");
        gameService.getRomFile(game);
    }
    
}