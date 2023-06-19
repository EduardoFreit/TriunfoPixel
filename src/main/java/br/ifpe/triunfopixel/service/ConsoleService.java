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
    public void insert(Console t) {
        consoleRepository.insert(t);
    }

    @Override
    public void insertAll(List<Console> list) {
        consoleRepository.insertAll(list);
    }

    @Override
    public void remove(Console t) {
        consoleRepository.remove(t);
    }

    @Override
    public void update(Console t) {
        consoleRepository.update(t);
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
        if(selectedConsole == null) {
            throw new Exception();
        }
        String fileName = selectedConsole.getNome() + ".zip";
        String pathRom ="consoles\\" + fileName;
        return getClass().getClassLoader().getResourceAsStream(pathRom);
    }
    
}
