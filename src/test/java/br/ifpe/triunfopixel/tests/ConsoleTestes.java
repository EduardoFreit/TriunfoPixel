package br.ifpe.triunfopixel.tests;

import br.ifpe.triunfopixel.model.Game;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

 public class ConsoleTestes extends Teste {
     
     @Test
     public void teste(){
         
     }
     
    /*
    @Test
    public void findGame() {
        Game gameUpdate = gameService.findById(1L);
        assertTrue(gameUpdate.getName().equals("Metal Slug Advance"));
        //assertTrue(gameUpdate.getConsole().equals("Game Boy Advance"));
        assertTrue(gameUpdate.getGenre().equals("Run and Gun"));
        assertTrue(gameUpdate.getUrlImagem().equals("https://media.retroachievements.org/Images/069381.png"));
    }
     
     
    @Test
    public void insertGame() {
        List<Game> listGames = gameService.listAll();
        assertTrue(listGames.size() == 20);
        
        Game newGame = new Game();
        //newGame.setConsole("PlayStation");
        newGame.setName("Alien Trilogy");
        newGame.setGenre("First-Person Shooter");
        newGame.setUrlImagem("https://media.retroachievements.org/Images/054485.png");
        newGame.setUrlRoom("");
        
        gameService.insert(newGame);
        
        listGames = gameService.listAll();
        assertTrue(listGames.size() == 21);
    }
    
    @Test
    public void updateGame() {
        Game gameUpdate = gameService.findById(1L);
        assertTrue(gameUpdate.getName().equals("Metal Slug Advance"));
        assertTrue(gameUpdate.getConsole().equals("Game Boy Advance"));
        assertTrue(gameUpdate.getGenre().equals("Run and Gun"));
        assertTrue(gameUpdate.getUrlImagem().equals("https://media.retroachievements.org/Images/069381.png"));
      
        gameUpdate.setName("Breath of Fire");
        //gameUpdate.setConsole("Game Boy");
        gameUpdate.setGenre("Role-Playing Game");
        gameUpdate.setUrlImagem("https://media.retroachievements.org/Images/033806.png");
        
        gameService.update(gameUpdate);
        
        gameUpdate = gameService.findById(1L);
        assertTrue(gameUpdate.getName().equals("Breath of Fire"));
        assertTrue(gameUpdate.getConsole().equals("Game Boy"));
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
*/
}