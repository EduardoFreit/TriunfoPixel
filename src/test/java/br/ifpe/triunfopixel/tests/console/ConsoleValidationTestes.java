package br.ifpe.triunfopixel.tests.console;

import br.ifpe.triunfopixel.model.Console;
import br.ifpe.triunfopixel.tests.Teste;
import java.io.InputStream;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

 public class ConsoleValidationTestes extends Teste {
     
    private String string260;
     
    @Before
    public void beforeTest(){
        string260 = RandomStringUtils.randomAlphanumeric(260);
    }
     
    
    @Test
    public void consoleSemGenero() {
        Console newConsole = new Console();
        newConsole.setNome(null);
        newConsole.setAnoLancamento(1990L);
        newConsole.setFabricante("Marca");
        newConsole.setUrlImagem("https://teste.com");
        
        Set<ConstraintViolation<Console>> constraintViolations = validator.validate(newConsole);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void consoleSemAnoLancamento() {
        Console newConsole = new Console();
        newConsole.setNome("Nome");
        newConsole.setAnoLancamento(null);
        newConsole.setFabricante("Marca");
        newConsole.setUrlImagem("https://teste.com");
        
        Set<ConstraintViolation<Console>> constraintViolations = validator.validate(newConsole);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void consoleSemFabricante() {
        Console newConsole = new Console();
        newConsole.setNome("Nome");
        newConsole.setAnoLancamento(1990L);
        newConsole.setFabricante(null);
        newConsole.setUrlImagem("https://teste.com");
        
        Set<ConstraintViolation<Console>> constraintViolations = validator.validate(newConsole);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void consoleSemUrlImagem() {
        Console newConsole = new Console();
        newConsole.setNome("Nome");
        newConsole.setAnoLancamento(1990L);
        newConsole.setFabricante("Marca");
        newConsole.setUrlImagem(null);
        
        Set<ConstraintViolation<Console>> constraintViolations = validator.validate(newConsole);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void consoleMenosDoisCaracteres() {
        Console newConsole = new Console();
        newConsole.setNome("N");
        newConsole.setAnoLancamento(1990L);
        newConsole.setFabricante("M");
        newConsole.setUrlImagem("M");
        
        Set<ConstraintViolation<Console>> constraintViolations = validator.validate(newConsole);
        assertEquals(4, constraintViolations.size());
    }
    
    @Test
    public void consoleMenos255Caracteres() {
        Console newConsole = new Console();
        newConsole.setNome(string260);
        newConsole.setAnoLancamento(1990L);
        newConsole.setFabricante(string260);
        newConsole.setUrlImagem(string260);
        
        Set<ConstraintViolation<Console>> constraintViolations = validator.validate(newConsole);
        assertEquals(4, constraintViolations.size());
    }
    
    @Test
    public void consoleSemUrlImagemValida() {
        Console newConsole = new Console();
        newConsole.setNome("Nome");
        newConsole.setAnoLancamento(1990L);
        newConsole.setFabricante("Marca");
        newConsole.setUrlImagem("teste");
        
        Set<ConstraintViolation<Console>> constraintViolations = validator.validate(newConsole);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test(expected = Exception.class)
    public void downloadRomPackConsoleNull() throws Exception {
        consoleService.getPackRomFile(null);
    }
    
    @Test
    public void downloadRomPackConsoleSemNome() throws Exception {
        Console console = new Console();
        InputStream result = consoleService.getPackRomFile(console);
        assertNull(result);
    }
    
    @Test
    public void downloadRomPackConsoleNomeNaoExiste() throws Exception {
        Console console = new Console();
        console.setNome("PlayStation 9");
        InputStream result = consoleService.getPackRomFile(console);
        assertNull(result);
    }
    
}