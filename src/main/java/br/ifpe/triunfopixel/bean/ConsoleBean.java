package br.ifpe.triunfopixel.bean;

import br.ifpe.triunfopixel.model.Console;
import br.ifpe.triunfopixel.service.ConsoleService;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
@ManagedBean
@Getter
@Setter
public class ConsoleBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private List<Console> listConsoles = new ArrayList<>();
    private Console selectedConsole = new Console();
    
    @Getter(AccessLevel.NONE)@Setter(AccessLevel.NONE)
    private final ConsoleService consoleService = new ConsoleService();
    
    @PostConstruct
    public void init() {
        listConsoles = consoleService.listAll();
    }
    
    public void prepareDownload() {
    }
    
    public void prepareDownloadGame(String url) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
    
}
