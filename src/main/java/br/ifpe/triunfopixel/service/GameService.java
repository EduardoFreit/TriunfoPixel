package br.ifpe.triunfopixel.service;

import br.ifpe.triunfopixel.dao.BaseJPA;
import br.ifpe.triunfopixel.model.Console;
import br.ifpe.triunfopixel.model.Game;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameService extends BaseJPA<Game> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private final ConsoleService consoleService = new ConsoleService();

    public GameService() {
        super(Game.class);
    }
    
}
