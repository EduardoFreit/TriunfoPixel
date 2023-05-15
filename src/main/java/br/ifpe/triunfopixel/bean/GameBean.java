/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.ifpe.triunfopixel.bean;

import br.ifpe.triunfopixel.model.Game;
import br.ifpe.triunfopixel.service.GameService;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@ViewScoped
@ManagedBean
@Getter
@Setter
public class GameBean implements Serializable {

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
