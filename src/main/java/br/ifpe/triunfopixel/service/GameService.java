package br.ifpe.triunfopixel.service;

import br.ifpe.triunfopixel.dao.BaseJPA;
import br.ifpe.triunfopixel.model.Game;
import java.io.Serializable;

public class GameService extends BaseJPA<Game> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public GameService() {
        super(Game.class);
    }
    
}
