/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifpe.triunfopixel.bean;

import br.ifpe.triunfopixel.model.Console;
import br.ifpe.triunfopixel.model.Usr;
import br.ifpe.triunfopixel.service.ConsoleService;
import br.ifpe.triunfopixel.service.UserService;
import br.ifpe.triunfopixel.util.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Anderson
 */
@SessionScoped
@ManagedBean
@Getter
@Setter
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private List<Usr> listUsuarios = new ArrayList<>();
    private Usr usuario;
    
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final UserService userService = new UserService();
    
    @NotNull(message = "O campo 'email' é obrigatório.")
    @Size(min = 2, max = 255, message = "O campo 'Email' não pode ter menos de 2 ou mais de 255 caractéres.")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "O campo 'email' deve ser um endereço de email válido.")
    @Column(unique = true, nullable = false)
    private String email;
    
    @NotNull(message = "O campo 'Password' é obrigatório.")
    @Column(nullable = false)
    private String password;
    
    @NotNull(message = "O campo 'Nome' é obrigatório.")
    @Size(min = 2, max = 255, message = "O campo 'Nome' não pode ter menos de 2 ou mais de 255 caractéres.")
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private Boolean isAdmin = false;
    
    @PostConstruct
    public void init() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        usuario = Util.getLoginUSer(request);
        listUsuarios = userService.listAll();
    }
    
}
