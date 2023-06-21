package br.ifpe.triunfopixel.bean;

import br.ifpe.triunfopixel.model.Console;
import br.ifpe.triunfopixel.model.Game;
import br.ifpe.triunfopixel.model.Usr;
import br.ifpe.triunfopixel.service.GameService;
import br.ifpe.triunfopixel.util.Util;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.StreamedContent;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.primefaces.PrimeFaces;

@SessionScoped
@ManagedBean
@Getter
@Setter
public class GameBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Game> listGames = new ArrayList<>();
    private Game selectedGame = new Game();
    private StreamedContent file;
    private Usr usuario;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final GameService gameService = new GameService();

    @NotNull(message = "O campo NOME é obrigatório.")
    @Size(min = 2, max = 255, message = "O campo NOME não pode ter menos de 2 ou mais de 255 caractéres.")
    private String name;

    @NotNull(message = "O campo URL DA IMAGEM é obrigatório.")
    @Size(min = 2, max = 255, message = "O campo URL DA IMAGEM não pode ter menos de 2 ou mais de 255 caractéres.")
    @Pattern(regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$",
            message = "Insira uma URL Válida para o campo URL DA IMAGEM")
    private String urlImagem;

    @NotNull(message = "O campo URL DA ROM é obrigatório.")
    @Size(min = 2, max = 255, message = "O campo URL DA ROM não pode ter menos de 2 ou mais de 255 caractéres.")
    @Pattern(regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$",
            message = "Insira uma URL Válida para o campo URL DA ROM")
    private String urlRoom;

    @NotNull(message = "O campo GÊNERO é obrigatório.")
    @Size(min = 2, max = 255, message = "O campo GÊNERO não pode ter menos de 2 ou mais de 255 caractéres.")
    private String genre;

    @NotNull(message = "O campo HASH é obrigatório.")
    @Size(min = 2, max = 255, message = "O campo HASH não pode ter menos de 2 ou mais de 255 caractéres.")
    private String hash;

    @NotNull(message = "O campo CONSOLE é obrigatório.")
    private Console console;

    @PostConstruct
    public void init() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        usuario = Util.getLoginUSer(request);
        listGames = gameService.listAll();
    }

    public void register() {
        Game newGame = new Game();
        newGame.setName(name);
        newGame.setUrlImagem(urlImagem);
        newGame.setUrlRoom(urlRoom);
        newGame.setGenre(genre);
        newGame.setHash(hash);
        newGame.setConsole(console);

        Boolean cadastroSucesso = gameService.insert(newGame);

        PrimeFaces.current().executeScript("PF('registerGameDialog').hide()");
        listGames = gameService.listAll();
        PrimeFaces.current().ajax().update("form:tableGames");

        limparCampos();
        
        FacesMessage message;
        
        if(cadastroSucesso) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Jogo " + newGame.getName() + " adicionado com sucesso!", null);
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao cadastrar jogo. Contate o suporte!", null);
        }

        Util.getFacesContext().addMessage(null, message);
    }

    public void limparCampos() {
        name = "";
        urlImagem = "";
        urlRoom = "";
        genre = "";
        hash = "";
    }

    public void deletaJogo() {

        gameService.remove(selectedGame);
        listGames = gameService.listAll();

        FacesMessage message = new FacesMessage("Jogo " + selectedGame.getName() + " deletado com sucesso!");
        Util.getFacesContext().addMessage(null, message);
        PrimeFaces.current().ajax().update("form:tableGames");
    }

    public void prepareDownload() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect(this.selectedGame.getUrlRoom());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
