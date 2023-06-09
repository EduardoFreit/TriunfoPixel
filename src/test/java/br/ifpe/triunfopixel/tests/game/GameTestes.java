package br.ifpe.triunfopixel.tests.game;

import br.ifpe.triunfopixel.model.Console;
import br.ifpe.triunfopixel.model.Game;
import br.ifpe.triunfopixel.tests.Teste;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

 public class GameTestes extends Teste {
    private Console console1;
    private Console console2;
     
    @Before
    public void beforeTest() {
        this.console1 = consoleService.findById(1L);
        this.console2 = consoleService.findById(2L);
    }
     
    @Test
    public void findGame() {
        Game gameFind = gameService.findById(1L);
        assertTrue(gameFind.getName().equals("Metal Slug Advance"));
        assertTrue(gameFind.getConsole().equals(console1));
        assertTrue(gameFind.getGenre().equals("Run and Gun"));
        assertTrue(gameFind.getUrlImagem().equals("https://media.retroachievements.org/Images/069381.png"));
    }
     
    @Test
    public void insertGame() {
        List<Game> listGames = gameService.listAll();
        assertTrue(listGames.size() == 20);
        
        Game newGame = new Game();
        newGame.setConsole(console1);
        newGame.setName("Alien Trilogy");
        newGame.setGenre("First-Person Shooter");
        newGame.setUrlImagem("https://media.retroachievements.org/Images/054485.png");
        newGame.setUrlRoom("https://media.retroachievements.org/Images/054485.png");
        newGame.setHash("Pasjm124HXS");
        
        gameService.insert(newGame);
        
        listGames = gameService.listAll();
        assertTrue(listGames.size() == 21);
    }
    
    @Test
    public void updateGame() {
        Game gameUpdate = gameService.findById(1L);
        assertTrue(gameUpdate.getName().equals("Metal Slug Advance"));
        assertTrue(gameUpdate.getConsole().equals(console1));
        assertTrue(gameUpdate.getGenre().equals("Run and Gun"));
        assertTrue(gameUpdate.getUrlImagem().equals("https://media.retroachievements.org/Images/069381.png"));
      
        gameUpdate.setName("Breath of Fire");
        gameUpdate.setConsole(console2);
        gameUpdate.setGenre("Role-Playing Game");
        gameUpdate.setUrlImagem("https://media.retroachievements.org/Images/033806.png");
        
        gameService.update(gameUpdate);
        
        gameUpdate = gameService.findById(1L);
        assertTrue(gameUpdate.getName().equals("Breath of Fire"));
        assertTrue(gameUpdate.getConsole().equals(console2));
        assertTrue(gameUpdate.getGenre().equals("Role-Playing Game"));
        assertTrue(gameUpdate.getUrlImagem().equals("https://media.retroachievements.org/Images/033806.png"));
    }
    
    @Test
    public void removeGame() {
        List<Game> listGames = gameService.listAll();
        assertTrue(listGames.size() == 20);
        
        Game gameDelete = gameService.findById(1L);
        
        gameService.remove(gameDelete);
        
        listGames = gameService.listAll();
        assertTrue(listGames.size() == 19);
    }
}