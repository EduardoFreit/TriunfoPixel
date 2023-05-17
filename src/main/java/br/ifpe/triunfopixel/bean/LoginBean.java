/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.ifpe.triunfopixel.bean;

import br.ifpe.triunfopixel.model.Game;
import br.ifpe.triunfopixel.model.Usr;
import br.ifpe.triunfopixel.service.GameService;
import br.ifpe.triunfopixel.service.LoginService;
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
    private final LoginService loginService = new LoginService();
    private Usr user;
    private String email;
    private String password;
    
    
    @PostConstruct
    public void init() {
        user = new Usr();
    }
    
    public String login() {
        String passwordMd5 = Util.md5(password);
        Usr foundUser = loginService.login(email, passwordMd5);

        if (foundUser == null) {
            String summary = "Falha ao realizar login";
            Util.getFacesContext().addMessage("sticky-key-login", new FacesMessage(summary));
            return "login";
        }
        HttpSession session = (HttpSession) Util.getFacesContext()
                .getExternalContext()
                .getSession(true);
        session.setAttribute("user", foundUser);
        return "games.xhtml?faces-redirect=true";
    }
    
    public void register() { 
        Usr foundPerson = loginService.checkPersonWithEmail(user.getEmail()); 
        if (foundPerson != null) { 
            String summary = "Já existe Usuário com este email"; 
            Util.getFacesContext().addMessage("sticky-register", new FacesMessage(FacesMessage.SEVERITY_WARN, summary, null));
        }  else {
            String encryptPassword = Util.md5(user.getPassword()); 
            user.setPassword(encryptPassword); 
            loginService.insert(user); 
            String summary = "Usuário Criado com Sucesso."; 
            Util.getFacesContext().addMessage("sticky-register", new FacesMessage(summary));
            PrimeFaces.current().executeScript("PF('registrarDialog').hide()");
        }
    }
    
    public String logout() {
        HttpSession session = Util.getSession();
        session.invalidate();
        return "login?faces-redirect=true";
    }
}
