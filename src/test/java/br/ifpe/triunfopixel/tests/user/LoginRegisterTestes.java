package br.ifpe.triunfopixel.tests.user;

import br.ifpe.triunfopixel.model.Usr;
import br.ifpe.triunfopixel.tests.Teste;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

 public class LoginRegisterTestes extends Teste {
     
     
    @Test
    public void loginSuccess() {
        String email = "jorge@email.com";
        String password = "123";
        Usr usuario = userService.login(email, password);
        
        assertTrue(usuario.getName().equals("jorge"));
        assertTrue(usuario.getEmail().equals("jorge@email.com"));
    }
    
    @Test
    public void loginError() {
        String email = "jorge@email.com";
        String password = "12345";
        Usr usuario = userService.login(email, password);
        assertNull(usuario);
        
        email = "jorgee@email.com";
        password = "123";
        usuario = userService.login(email, password);
        assertNull(usuario);
    }
     
    @Test
    public void registerSuccess() {
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
