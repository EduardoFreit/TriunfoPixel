package br.ifpe.triunfopixel.bean;

import br.ifpe.triunfopixel.model.Console;
import br.ifpe.triunfopixel.model.Usr;
import br.ifpe.triunfopixel.service.ConsoleService;
import br.ifpe.triunfopixel.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import static java.lang.Long.parseLong;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.primefaces.PrimeFaces;
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

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final ConsoleService consoleService = new ConsoleService();

    @NotNull(message = "O campo NOME é obrigatório.")
    @NotEmpty(message = "O campo NOME deve conter no mínimo 2 caracteres.")
    @NotBlank(message = "O campo NOME não pode ser vazio.")
    @Size(min = 2, max = 255, message = "O campo NOME não pode ter menos de 2 ou mais de 255 caractéres.")
    private String name;

    @NotNull(message = "O campo ANO é obrigatório.")
    @NotEmpty(message = "O campo ANO deve conter no 4 caracteres.")
    @NotBlank(message = "O campo ANO não pode ser vazio.")
    @Length(min = 4, max = 4, message = "O campo ANO não deve ter 4 caractéres.")
    private String year;

    @NotNull(message = "O campo FABRICANTE é obrigatório.")
    @NotEmpty(message = "O campo FABRICANTE deve conter no mínimo 2 caracteres.")
    @NotBlank(message = "O campo FABRICANTE não pode ser vazio.")
    @Size(min = 2, max = 255, message = "O campo FABRICANTE não pode ter menos de 2 ou mais de 255 caractéres.")
    private String manufacturer;

    @NotNull(message = "O campo URL DA IMAGEM é obrigatório.")
    @NotEmpty(message = "O campo URL DA IMAGEM deve conter no mínimo 2 caracteres.")
    @NotBlank(message = "O campo URL DA IMAGEM não pode ser vazio.")
    @Size(min = 4, max = 255, message = "O campo URL DA IMAGEM não pode ter menos de 2 ou mais de 255 caractéres.")
    private String urlImagem;

    @PostConstruct
    public void init() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
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

    public void registerConsole() {
        Console newConsole = new Console();
        newConsole.setNome(name);
        newConsole.setUrlImagem(urlImagem);
        newConsole.setAnoLancamento(parseLong(year));
        newConsole.setFabricante(manufacturer);

        consoleService.insert(newConsole);

        PrimeFaces.current().executeScript("PF('registerConsoleDialog').hide()");
        listConsoles = consoleService.listAll();
        PrimeFaces.current().ajax().update("form:tableConsoles");

        limpaCampos();

        FacesMessage message = new FacesMessage("Console " + newConsole.getNome() + " adicionado com sucesso!");
        Util.getFacesContext().addMessage(null, message);
    }

    public void limpaCampos() {
        name = "";
        urlImagem = "";
        year = "";
        manufacturer = "";
    }

    public void deletarConsole() {
        FacesMessage message = new FacesMessage("Console " + selectedConsole.getNome() + " deletado com sucesso!");
        Util.getFacesContext().addMessage(null, message);

        consoleService.remove(selectedConsole);

        listConsoles = consoleService.listAll();

        PrimeFaces.current().ajax().update("form:tableConsoles");
    }

}
