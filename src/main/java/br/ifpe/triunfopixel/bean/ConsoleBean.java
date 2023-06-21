package br.ifpe.triunfopixel.bean;

import br.ifpe.triunfopixel.model.Console;
import br.ifpe.triunfopixel.model.Usr;
import br.ifpe.triunfopixel.service.ConsoleService;
import br.ifpe.triunfopixel.util.Util;
import java.io.IOException;
import java.io.InputStream;
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
import javax.servlet.http.HttpServletRequest;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@SessionScoped
@ManagedBean
@Getter
@Setter
public class ConsoleBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private List<Console> listConsoles = new ArrayList<>();
    private Console selectedConsole = new Console();
    private StreamedContent file;
    private Usr usuario;
    
    @Getter(AccessLevel.NONE)@Setter(AccessLevel.NONE)
    private final ConsoleService consoleService = new ConsoleService();
    
    @PostConstruct
    public void init() {
        HttpServletRequest request =  (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        usuario = Util.getLoginUSer(request);
        listConsoles = consoleService.listAll();
    }
    
    public void prepareDownloadRomPack(Console selectedConsole) throws Exception {
        this.selectedConsole = selectedConsole;
        InputStream it = consoleService.getPackRomFile(selectedConsole);
        file = DefaultStreamedContent.builder()
                .name(selectedConsole.getNome() + ".zip")
                .contentType("application/zip")
                .stream(() -> it)
                .build();
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
