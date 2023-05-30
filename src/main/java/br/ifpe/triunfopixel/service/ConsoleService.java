package br.ifpe.triunfopixel.service;

import br.ifpe.triunfopixel.dao.BaseJPA;
import br.ifpe.triunfopixel.model.Console;
import java.io.Serializable;

public class ConsoleService extends BaseJPA<Console> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public ConsoleService() {
        super(Console.class);
    }
    
}
