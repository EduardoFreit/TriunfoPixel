package br.ifpe.triunfopixel.tests;

import br.ifpe.triunfopixel.model.Usr;
import br.ifpe.triunfopixel.util.Util;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

 public class LoginRegisterTestes extends Teste {
     
    @Test
    public void login() {
        String email = "jorge@email.com";
        String password = "123";
        Usr usuario = userService.login(email, Util.md5(password));
        
        assertTrue(usuario.getId().equals(1L));
    }
    
    @Test
    public void loginError() {
        String email = "jorge@email.com";
        String password = "12345";
        Usr usuario = userService.login(email, Util.md5(password));
        assertNull(usuario);
    }
     
    @Test
    public void registerSucess() {
        List<Usr> listUsers = userService.listAll();
        assertTrue(listUsers.size() == 2);
        
        Usr newUsuario = new Usr();
        newUsuario.setName("luiz");
        newUsuario.setPassword("123");
        newUsuario.setEmail("luiz@email.com");
        newUsuario.setIsAdmin(Boolean.FALSE);
        
        userService.insert(newUsuario);
        
        listUsers = userService.listAll();
        
        assertTrue(listUsers.size() == 3);
    }
    
    @Test(expected = Throwable.class)
    public void registerError() {
        List<Usr> listUsers = userService.listAll();
        assertTrue(listUsers.size() == 2);
        
        Usr newUsuario = new Usr();
        newUsuario.setName("luiz");
        newUsuario.setPassword("123");
        newUsuario.setEmail("jorge@email.com");
        newUsuario.setIsAdmin(Boolean.FALSE);
        
        userService.insert(newUsuario);
    }
}
