package br.ifpe.triunfopixel.service;

import br.ifpe.triunfopixel.model.Game;
import br.ifpe.triunfopixel.repository.GameRepository;
import java.io.Serializable;
import java.util.List;

public class GameService implements Serializable, IBaseService<Game> {
    
    private static final long serialVersionUID = 1L;
    private final GameRepository gameRepository;

    public GameService() {
        gameRepository =  new GameRepository();
    }

    @Override
    public void insert(Game t) {
        gameRepository.insert(t);
    }

    @Override
    public void insertAll(List<Game> list) {
        gameRepository.insertAll(list);
    }

    @Override
    public void remove(Game t) {
        gameRepository.remove(t);
    }

    @Override
    public void update(Game t) {
        gameRepository.update(t);
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
}
