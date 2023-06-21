package br.ifpe.triunfopixel.converter;

import br.ifpe.triunfopixel.model.Console;
import br.ifpe.triunfopixel.service.ConsoleService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("consoleConverter")
public class ConsoleConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }

        ConsoleService consoleService = new ConsoleService();
        Console console = consoleService
                .read("SELECT c FROM Console c WHERE c.nome = '" + value + "'").get(0);

        return console;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        }

        Console console = (Console) o;

        return console.getNome();
    }
}
