package br.ifpe.triunfopixel.tests.game;

import br.ifpe.triunfopixel.model.Console;
import br.ifpe.triunfopixel.model.Game;
import br.ifpe.triunfopixel.tests.Teste;
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
        newGame.setUrlRoom("https://teste.com");
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
        newGame.setUrlRoom("https://teste.com");
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
        newGame.setUrlRoom("https://teste.com");
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
        newGame.setUrlRoom("testes");
        newGame.setHash("testes");
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(2, constraintViolations.size());
    }
    
    @Test
    public void gameSemUrlRom() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName("Alien Trilogy");
        newGame.setGenre("First-Person Shooter");
        newGame.setUrlImagem("testes");
        newGame.setUrlRoom(null);
        newGame.setHash("testes");
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(2, constraintViolations.size());
    }
    
    @Test
    public void gameSemHash() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName("Alien Trilogy");
        newGame.setGenre("First-Person Shooter");
        newGame.setUrlImagem("testes");
        newGame.setUrlRoom("https://teste.com/");
        newGame.setHash("testes");
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void gameNomeMenosDoisCaracteres() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName("A");
        newGame.setGenre("First-Person Shooter");
        newGame.setUrlImagem("https://media.retroachievements.org/Images/054485.png");
        newGame.setUrlRoom("https://media.retroachievements.org/Images/054485.png");
        newGame.setHash("Pasjm124HXS");
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void gameGenreMenosDoisCaracteres() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName("Alien Trilogy");
        newGame.setGenre("A");
        newGame.setUrlImagem("https://media.retroachievements.org/Images/054485.png");
        newGame.setUrlRoom("https://media.retroachievements.org/Images/054485.png");
        newGame.setHash("Pasjm124HXS");
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void gameImagemMenosDoisCaracteres() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName("Alien Trilogy");
        newGame.setGenre("First-Person Shooter");
        newGame.setUrlImagem("A");
        newGame.setUrlRoom("https://media.retroachievements.org/Images/054485.png");
        newGame.setHash("Pasjm124HXS");
        
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(2, constraintViolations.size());
    }
    
    @Test
    public void gameRomMenosDoisCaracteres() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName("Alien Trilogy");
        newGame.setGenre("First-Person Shooter");
        newGame.setUrlImagem("https://media.retroachievements.org/Images/054485.png");
        newGame.setUrlRoom("A");
        newGame.setHash("Pasjm124HXS");
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(2, constraintViolations.size());
    }
    
    @Test
    public void gameHashMenosDoisCaracteres() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName("Alien Trilogy");
        newGame.setGenre("First-Person Shooter");
        newGame.setUrlImagem("https://media.retroachievements.org/Images/054485.png");
        newGame.setUrlRoom("https://media.retroachievements.org/Images/054485.png");
        newGame.setHash("A");
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void gameNomeMais255Caracteres() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName(string260);
        newGame.setGenre("First-Person Shooter");
        newGame.setUrlImagem("https://media.retroachievements.org/Images/054485.png");
        newGame.setUrlRoom("https://media.retroachievements.org/Images/054485.png");
        newGame.setHash("Pasjm124HXS");
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void gameGenreMais255Caracteres() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName("Alien Trilogy");
        newGame.setGenre(string260);
        newGame.setUrlImagem("https://media.retroachievements.org/Images/054485.png");
        newGame.setUrlRoom("https://media.retroachievements.org/Images/054485.png");
        newGame.setHash("Pasjm124HXS");
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void gameImagemMais255Caracteres() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName("Alien Trilogy");
        newGame.setGenre("First-Person Shooter");
        newGame.setUrlImagem(string260);
        newGame.setUrlRoom("https://media.retroachievements.org/Images/054485.png");
        newGame.setHash("Pasjm124HXS");
        
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(2, constraintViolations.size());
    }
    
    @Test
    public void gameRomMais255Caracteres() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName("Alien Trilogy");
        newGame.setGenre("First-Person Shooter");
        newGame.setUrlImagem("https://media.retroachievements.org/Images/054485.png");
        newGame.setUrlRoom(string260);
        newGame.setHash("Pasjm124HXS");
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(2, constraintViolations.size());
    }
    
    @Test
    public void gameHashsMais255Caracteres() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName("Alien Trilogy");
        newGame.setGenre("First-Person Shooter");
        newGame.setUrlImagem("https://media.retroachievements.org/Images/054485.png");
        newGame.setUrlRoom("https://media.retroachievements.org/Images/054485.png");
        newGame.setHash(string260);
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void gameSemUrlImageValida() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName("Alien Trilogy");
        newGame.setGenre("First-Person Shooter");
        newGame.setUrlImagem("sdasda");
        newGame.setUrlRoom("testes");
        newGame.setHash("testes");
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(2, constraintViolations.size());
    }
    
    @Test
    public void gameSemUrlRomValida() {
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName("Alien Trilogy");
        newGame.setGenre("First-Person Shooter");
        newGame.setUrlImagem("testes");
        newGame.setUrlRoom("wwqewqweeqwqwe");
        newGame.setHash("testes");
        
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(newGame);
        assertEquals(2, constraintViolations.size());
    }
    
}