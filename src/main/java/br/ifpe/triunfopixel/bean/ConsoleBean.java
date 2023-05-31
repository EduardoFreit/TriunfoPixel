package br.ifpe.triunfopixel.bean;

import br.ifpe.triunfopixel.model.Console;
import br.ifpe.triunfopixel.model.Game;
import br.ifpe.triunfopixel.service.ConsoleService;
import br.ifpe.triunfopixel.service.GameService;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.faces.bean.SessionScoped;

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
    
}
