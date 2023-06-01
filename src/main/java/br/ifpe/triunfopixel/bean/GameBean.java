package br.ifpe.triunfopixel.bean;

import br.ifpe.triunfopixel.model.Game;
import br.ifpe.triunfopixel.service.GameService;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.StreamedContent;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
@ManagedBean
@Getter
@Setter
public class GameBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private List<Game> listGames = new ArrayList<>();
    private Game selectedGame = new Game();
    private StreamedContent file;
    
    @Getter(AccessLevel.NONE)@Setter(AccessLevel.NONE)
    private final GameService gameService = new GameService();
    
    @PostConstruct
    public void init() {
        listGames = gameService.listAll();
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
