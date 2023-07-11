package br.ifpe.triunfopixel.service;

import br.ifpe.triunfopixel.model.Console;
import br.ifpe.triunfopixel.model.Game;
import br.ifpe.triunfopixel.repository.GameRepository;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

public class GameService implements Serializable, IBaseService<Game> {
    
    private static final long serialVersionUID = 1L;
    private final GameRepository gameRepository;

    public GameService() {
        gameRepository =  new GameRepository();
    }

    @Override
    public Boolean insert(Game t) {
        return gameRepository.insert(t);
    }

    @Override
    public Boolean insertAll(List<Game> list) {
        return gameRepository.insertAll(list);
    }

    @Override
    public void remove(Game t) {
        gameRepository.remove(t);
    }

    @Override
    public Boolean update(Game t) {
        return gameRepository.update(t);
    }

    @Override
    public List<Game> listAll() {
        return gameRepository.listAll();
    }

    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id);
    }

    @Override
    public List<Game> read(String query) {
        return gameRepository.read(query);
    }
    
    public InputStream getRomFile(Game game) throws Exception {
        InputStream input = null;
        if(game == null) {
            throw new Exception();
        }
        String fileName = game.getName()+ ".zip";
        String pathRomWindows = "consoles\\" + game.getConsole().getNome() + 
                "\\roms\\" + fileName;
        String pathRomLinux="consoles/" + game.getConsole().getNome() + 
                "/roms/" + fileName;
        input = getClass().getClassLoader().getResourceAsStream(pathRomWindows);
        if(input == null) {
            input = getClass().getClassLoader().getResourceAsStream(pathRomLinux);
        }
        return input;
    }
}
