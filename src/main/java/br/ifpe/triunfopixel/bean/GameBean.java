package br.ifpe.triunfopixel.bean;

import br.ifpe.triunfopixel.model.Game;
import br.ifpe.triunfopixel.service.GameService;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@ViewScoped
@ManagedBean
@Getter
@Setter
public class GameBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String ola = "olaaa";
     private List<Game> listGames = new ArrayList<>();
    
    @Getter(AccessLevel.NONE)@Setter(AccessLevel.NONE)
    private final GameService gameService = new GameService();
    
    @PostConstruct
    public void init() {
        gameService.insertGames();
        listGames = gameService.listAll();
        ola = "xxxx";
    }
    
}
