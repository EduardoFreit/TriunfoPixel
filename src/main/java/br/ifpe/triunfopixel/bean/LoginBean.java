package br.ifpe.triunfopixel.bean;

import br.ifpe.triunfopixel.model.Usr;
import br.ifpe.triunfopixel.service.UserService;
import br.ifpe.triunfopixel.util.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
@Getter
@Setter
public class LoginBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Getter(AccessLevel.NONE)@Setter(AccessLevel.NONE)
    private final UserService userService = new UserService();
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "O campo 'Email' deve ser um endereço de email válido.")
    private String email;
    @NotNull(message = "Digite a 'Senha'")
    private String password;
    @NotNull(message = "O campo 'Nome' é obrigatório.")
    @Size(min = 2, max = 255, message = "O tamanho do campo 'Nome' deve ser entre 2 e 255 caractéres")
    private String cadName;
    @NotNull(message = "O campo 'Email' é obrigatório.")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "O campo 'email' deve ser um endereço de email válido.")
    private String cadEmail;
    @NotNull(message = "O campo 'Senha' é obrigatório.")
    @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caractéres")
    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$", 
        message = "A senha deve conter pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial")
    private String cadPassword;
    @NotNull(message = "O campo 'Confirmar Senha' é obrigatório.")
    private String cadPasswordConfirm;
    private Boolean validationPasswordNoMatch = false;
    
    @PostConstruct
    public void init() {
    }
    
    public String login() {
        Usr user = this.userService.login(email, password);
       
        if (user == null) {
            String summary = "Falha ao realizar login";
            Util.getFacesContext().addMessage("sticky-key-login", new FacesMessage(summary));
            return "login";
        }
        HttpSession session = (HttpSession) Util.getFacesContext()
                .getExternalContext()
                .getSession(true);
        session.setAttribute("user", user);
        return "games.xhtml?faces-redirect=true";
    }
    
    public void limparCampos() {
        email = "";
        password = "";
        cadName = "";
        cadEmail = "";
        cadPassword = "";
        cadPasswordConfirm = "";
    }
    
    public void register() { 
        validationPasswordNoMatch = false;
        Usr newUser = new Usr();
        newUser.setName(cadName);
        newUser.setEmail(cadEmail);
        newUser.setPassword(cadPassword);
        if(!cadPassword.equals(cadPasswordConfirm)) {
            FacesMessage message = new FacesMessage("A senha e a confirmação de senha não são iguais.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            Util.getFacesContext().addMessage(cadPassword, message);
            Util.getFacesContext().validationFailed();
            validationPasswordNoMatch = true;
        } else {
            this.userService.register(newUser);
            this.limparCampos();
        }
    }
    
    public String logout() {
        return this.userService.logout();
    }
    
}

