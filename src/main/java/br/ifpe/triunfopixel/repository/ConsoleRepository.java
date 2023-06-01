package br.ifpe.triunfopixel.repository;

import br.ifpe.triunfopixel.service.*;
import br.ifpe.triunfopixel.dao.BaseJPA;
import br.ifpe.triunfopixel.model.Console;
import java.io.Serializable;

public class ConsoleRepository extends BaseJPA<Console> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public ConsoleRepository() {
        super(Console.class);
    }
    
}
