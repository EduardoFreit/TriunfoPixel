package br.ifpe.triunfopixel.tests.console;

import br.ifpe.triunfopixel.model.Console;
import br.ifpe.triunfopixel.tests.Teste;
import java.io.InputStream;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

 public class ConsoleTestes extends Teste {
     
    @Before
    public void beforeTest(){
    }
    
    @Test
    public void findConsole() {
        Console consoleFind = consoleService.findById(2L);
        assertTrue(consoleFind.getNome().equals("SNES"));
        assertTrue(consoleFind.getFabricante().equals("Nintendo"));
        assertTrue(consoleFind.getAnoLancamento().equals(1990L));
    }
     
     
    @Test
    public void insertConsole() {
        List<Console> listConsoles = consoleService.listAll();
        assertTrue(listConsoles.size() == 4);
        
        Console newConsole = new Console();
        newConsole.setNome("PlayStation");
        newConsole.setFabricante("Sony");
        newConsole.setAnoLancamento(1994L);
        newConsole.setUrlImagem("https://url.com");
        
        consoleService.insert(newConsole);
        
        listConsoles = consoleService.listAll();
        assertTrue(listConsoles.size() == 5);
    }
    
    @Test
    public void updateConsole() {
        Console consoleUpdate = consoleService.findById(1L);
        assertTrue(consoleUpdate.getNome().equals("Game Boy Advance"));
        assertTrue(consoleUpdate.getFabricante().equals("Nintendo"));
        assertTrue(consoleUpdate.getAnoLancamento().equals(2001L));
      
        consoleUpdate.setNome("NES");
        consoleUpdate.setAnoLancamento(1986L);
        
        consoleService.update(consoleUpdate);
        
        consoleUpdate = consoleService.findById(1L);
        assertTrue(consoleUpdate.getNome().equals("NES"));
        assertTrue(consoleUpdate.getAnoLancamento().equals(1986L));
    }
    
    @Test
    public void removeConsole() {
        List<Console> listConsoles = consoleService.listAll();
        assertTrue(listConsoles.size() == 4);
        
        Console consoleDelete = consoleService.findById(1L);
        consoleService.remove(consoleDelete);
        
        listConsoles = consoleService.listAll();
        assertTrue(listConsoles.size() == 3);
    }
    
    @Test
    public void removeGameConsole() {
        Console consoleUpdate = consoleService.findById(1L);
        
        assertTrue(consoleUpdate.getNome().equals("Game Boy Advance"));
        assertTrue(consoleUpdate.getFabricante().equals("Nintendo"));
        assertTrue(consoleUpdate.getAnoLancamento().equals(2001L));
        assertTrue(consoleUpdate.getJogos().size() == 5);
      
        consoleUpdate.getJogos().remove(0);
        consoleService.update(consoleUpdate);
        
        consoleUpdate = consoleService.findById(1L);
        assertTrue(consoleUpdate.getNome().equals("Game Boy Advance"));
        assertTrue(consoleUpdate.getFabricante().equals("Nintendo"));
        assertTrue(consoleUpdate.getAnoLancamento().equals(2001L));
        assertTrue(consoleUpdate.getJogos().size() == 4);
    }
    
//    @Test
//    public void downloadRomPack() throws Exception {
//        Console console = new Console();
//        console.setNome("SNES");
//        InputStream result = consoleService.getPackRomFile(console);
//        assertTrue(result != null);
//    }

}