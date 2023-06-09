package br.ifpe.triunfopixel.tests.user;

import br.ifpe.triunfopixel.model.Usr;
import br.ifpe.triunfopixel.tests.Teste;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.junit.Test;
import static org.junit.Assert.*;

 public class LoginRegisterValidationTestes extends Teste {
     
    @Test
    public void usuarioSemNome() {
        Usr newUsuario = new Usr();
        newUsuario.setEmail("luiz@email.com");
        newUsuario.setPassword("123");
        
        Set<ConstraintViolation<Usr>> constraintViolations = validator.validate(newUsuario);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void usuarioNomePequeno() {
        Usr newUsuario = new Usr();
        newUsuario.setName("l");
        newUsuario.setPassword("123");
        newUsuario.setEmail("luiz@email.com");
        
        Set<ConstraintViolation<Usr>> constraintViolations = validator.validate(newUsuario);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void usuarioSemEmail() {
        Usr newUsuario = new Usr();
        newUsuario.setName("luiz");
        newUsuario.setPassword("123");
        
        Set<ConstraintViolation<Usr>> constraintViolations = validator.validate(newUsuario);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void usuarioSemSenha() {
        Usr newUsuario = new Usr();
        newUsuario.setName("luiz");
        newUsuario.setEmail("luiz@email.com");
        
        Set<ConstraintViolation<Usr>> constraintViolations = validator.validate(newUsuario);
        assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void usuarioEmailInvalido() {
        Usr newUsuario = new Usr();
        newUsuario.setName("luiz");
        newUsuario.setPassword("123");
        newUsuario.setEmail("luiz.com");
        
        Set<ConstraintViolation<Usr>> constraintViolations = validator.validate(newUsuario);
        assertEquals(1, constraintViolations.size());
    }
}
