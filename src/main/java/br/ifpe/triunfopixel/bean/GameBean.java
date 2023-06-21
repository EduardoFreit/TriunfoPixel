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
    @NotEmpty(message = "O campo NOME deve conter no mínimo 2 caracteres.")
    @NotBlank(message = "O campo NOME não pode ser vazio.")
    @Size(min = 2, max = 255, message = "O campo NOME não pode ter menos de 2 ou mais de 255 caractéres.")
    private String name;

    @NotNull(message = "O campo URL DA IMAGEM é obrigatório.")
    @NotEmpty(message = "O campo URL DA IMAGEM deve conter no mínimo 2 caracteres.")
    @NotBlank(message = "O campo URL DA IMAGEM não pode ser vazio.")
    @Size(min = 2, max = 255, message = "O campo URL DA IMAGEM não pode ter menos de 2 ou mais de 255 caractéres.")
    private String urlImagem;

    @NotNull(message = "O campo URL DA ROM é obrigatório.")
    @NotEmpty(message = "O campo URL DA ROM deve conter no mínimo 2 caracteres.")
    @NotBlank(message = "O campo URL DA ROM não pode ser vazio.")
    @Size(min = 2, max = 255, message = "O campo URL DA ROM não pode ter menos de 2 ou mais de 255 caractéres.")
    private String urlRoom;

    @NotNull(message = "O campo GÊNERO é obrigatório.")
    @NotEmpty(message = "O campo GÊNERO deve conter no mínimo 2 caracteres.")
    @NotBlank(message = "O campo GÊNERO não pode ser vazio.")
    @Size(min = 2, max = 255, message = "O campo GÊNERO não pode ter menos de 2 ou mais de 255 caractéres.")
    private String genre;

    @NotNull(message = "O campo HASH é obrigatório.")
    @NotEmpty(message = "O campo HASH deve conter no mínimo 2 caracteres.")
    @NotBlank(message = "O campo HASH não pode ser vazio.")
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

        gameService.insert(newGame);

        PrimeFaces.current().executeScript("PF('registerGameDialog').hide()");
        listGames = gameService.listAll();
        PrimeFaces.current().ajax().update("form:tableGames");

        limpaCampos();

        FacesMessage message = new FacesMessage("Jogo " + newGame.getName() + " adicionado com sucesso!");
        Util.getFacesContext().addMessage(null, message);
    }

    public void limpaCampos() {
        name = "";
        urlImagem = "";
        urlRoom = "";
        genre = "";
        hash = "";
    }

    public void deletaJogo() {
        FacesMessage message = new FacesMessage("Jogo " + selectedGame.getName() + " deletado com sucesso!");
        Util.getFacesContext().addMessage(null, message);

        gameService.remove(selectedGame);

        listGames = gameService.listAll();

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
