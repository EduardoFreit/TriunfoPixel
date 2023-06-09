package br.ifpe.triunfopixel.bean;

import br.ifpe.triunfopixel.model.Console;
import br.ifpe.triunfopixel.model.Game;
import br.ifpe.triunfopixel.model.Usr;
import br.ifpe.triunfopixel.service.GameService;
import br.ifpe.triunfopixel.util.Util;
import java.io.IOException;
import java.io.InputStream;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.primefaces.PrimeFaces;
import org.primefaces.model.DefaultStreamedContent;

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

    public void update() {
        selectedGame.setName(name);
        selectedGame.setUrlImagem(urlImagem);
        selectedGame.setGenre(genre);
        selectedGame.setHash(hash);
        selectedGame.setConsole(console);
        
        Boolean atualizacaoSucesso = gameService.update(selectedGame);
        
        PrimeFaces.current().executeScript("PF('updateGameDialog').hide()");
        listGames = gameService.listAll();
        PrimeFaces.current().ajax().update("form:tableGames");
        
        limparCampos();
        
        FacesMessage message;

        if(atualizacaoSucesso) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Jogo " + selectedGame.getName() + " editado com sucesso!", null);
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao editar jogo. Contate o suporte!", null);
        }

        Util.getFacesContext().addMessage(null, message);
    }
    
    // Preenche os campos do modal atuazicao de jogo com os valores do jogo selecionado quando o modal for acionado
    public void preencheCamposComSelectedGameValores() {
        name = selectedGame.getName();
        urlImagem = selectedGame.getUrlImagem();
        urlRoom = selectedGame.getUrlRoom();
        genre = selectedGame.getGenre();
        hash = selectedGame.getHash();
        console = selectedGame.getConsole();
    }

    public void deletaJogo() {

        gameService.remove(selectedGame);
        listGames = gameService.listAll();

        FacesMessage message = new FacesMessage("Jogo " + selectedGame.getName() + " deletado com sucesso!");
        Util.getFacesContext().addMessage(null, message);
        PrimeFaces.current().ajax().update("form:tableGames");
    }

    public void prepareDownload(Game game) throws Exception {
        this.selectedGame = game;
        try {
            InputStream it = gameService.getRomFile(game);
            file = DefaultStreamedContent.builder()
                    .name(game.getName() + ".zip")
                    .contentType("application/zip")
                    .stream(() -> it)
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
