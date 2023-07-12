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
    public void consoleNomeMenosDoisCaracteres() {
        Console newConsole = new Console();
        newConsole.setNome("N");
        newConsole.setFabricante("Sony");
        newConsole.setAnoLancamento(1994L);
        newConsole.setUrlImagem("https://url.com");
        
        Set<ConstraintViolation<Console>> constraintViolations = validator.validate(newConsole);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void consoleFabricanteMenosDoisCaracteres() {
        Console newConsole = new Console();
        newConsole.setNome("PlayStation");
        newConsole.setFabricante("S");
        newConsole.setAnoLancamento(1994L);
        newConsole.setUrlImagem("https://url.com");
        
        Set<ConstraintViolation<Console>> constraintViolations = validator.validate(newConsole);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void consoleImagemMenosDoisCaracteres() {
        Console newConsole = new Console();
        newConsole.setNome("PlayStation");
        newConsole.setFabricante("Sony");
        newConsole.setAnoLancamento(1994L);
        newConsole.setUrlImagem("H");
        
        Set<ConstraintViolation<Console>> constraintViolations = validator.validate(newConsole);
        assertEquals(2, constraintViolations.size());
    }
    
    @Test
    public void consoleNomeMenos255Caracteres() {
        Console newConsole = new Console();
        newConsole.setNome(string260);
        newConsole.setFabricante("Sony");
        newConsole.setAnoLancamento(1994L);
        newConsole.setUrlImagem("https://url.com");
        
        Set<ConstraintViolation<Console>> constraintViolations = validator.validate(newConsole);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void consoleFabricanteMenos255Caracteres() {
        Console newConsole = new Console();
        newConsole.setNome("Nome");
        newConsole.setFabricante(string260);
        newConsole.setAnoLancamento(1994L);
        newConsole.setUrlImagem("https://url.com");
        
        Set<ConstraintViolation<Console>> constraintViolations = validator.validate(newConsole);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void consoleImagemMenos255Caracteres() {
        Console newConsole = new Console();
        newConsole.setNome("PlayStation");
        newConsole.setFabricante("Nome");
        newConsole.setAnoLancamento(1994L);
        newConsole.setUrlImagem(string260);
        
        Set<ConstraintViolation<Console>> constraintViolations = validator.validate(newConsole);
        assertEquals(2, constraintViolations.size());
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
        consoleService.getRomPackFile(null);
    }
    
    @Test
    public void downloadRomPackConsoleSemNome() throws Exception {
        Console console = new Console();
        InputStream result = consoleService.getRomPackFile(console);
        assertNull(result);
    }
    
    @Test
    public void downloadRomPackConsoleNomeNaoExiste() throws Exception {
        Console console = new Console();
        console.setNome("PlayStation 9");
        InputStream result = consoleService.getRomPackFile(console);
        assertNull(result);
    }
    
}