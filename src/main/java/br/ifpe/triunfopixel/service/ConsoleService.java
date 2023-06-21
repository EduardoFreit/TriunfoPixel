package br.ifpe.triunfopixel.service;

import br.ifpe.triunfopixel.model.Console;
import br.ifpe.triunfopixel.repository.ConsoleRepository;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

public class ConsoleService implements Serializable, IBaseService<Console> {
    
    private static final long serialVersionUID = 1L;
    private final ConsoleRepository consoleRepository;

    public ConsoleService() {
        consoleRepository = new ConsoleRepository();
    }

    @Override
    public Boolean insert(Console t) {
        return consoleRepository.insert(t);
    }

    @Override
    public Boolean insertAll(List<Console> list) {
        return consoleRepository.insertAll(list);
    }

    @Override
    public void remove(Console t) {
        consoleRepository.remove(t);
    }

    @Override
    public Boolean update(Console t) {
        return consoleRepository.update(t);
    }

    @Override
    public List<Console> listAll() {
        return consoleRepository.listAll();
    }

    @Override
    public Console findById(Long id) {
        return consoleRepository.findById(id);
    }

    @Override
    public List<Console> read(String query) {
        return consoleRepository.read(query);
    }
    
    public InputStream getPackRomFile(Console selectedConsole) throws Exception {
        InputStream input = null;
        if(selectedConsole == null) {
            throw new Exception();
        }
        String fileName = selectedConsole.getNome() + ".zip";
        String pathRomWin ="consoles\\" + fileName;
        String pathRomLin="consoles/" + fileName;
        input = getClass().getClassLoader().getResourceAsStream(pathRomWin);
        if(input == null) {
            input = getClass().getClassLoader().getResourceAsStream(pathRomLin);
        }
        return input;
    }
    
}
