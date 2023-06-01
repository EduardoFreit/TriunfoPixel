package br.ifpe.triunfopixel.bean;

import br.ifpe.triunfopixel.model.Usr;
import br.ifpe.triunfopixel.service.UserService;
import br.ifpe.triunfopixel.util.Util;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

@ManagedBean
@ViewScoped
@Getter
@Setter
public class LoginBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Getter(AccessLevel.NONE)@Setter(AccessLevel.NONE)
    private final UserService userService = new UserService();
    private Usr user;
    private String email;
    private String password;
    
    
    @PostConstruct
    public void init() {
        user = new Usr();
    }
    
    public String login() {
        return this.userService.login(email, password);
    }
    
    public void register() { 
        this.userService.register(user);
    }
    
    public String logout() {
        return this.userService.logout();
    }
}
