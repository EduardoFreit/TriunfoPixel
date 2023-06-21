package br.ifpe.triunfopixel.service;

import br.ifpe.triunfopixel.model.Usr;
import br.ifpe.triunfopixel.repository.UserRepository;
import br.ifpe.triunfopixel.util.Util;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.servlet.http.HttpSession;
import org.primefaces.PrimeFaces;

public class UserService implements Serializable, IBaseService<Usr> {
    
    private static final long serialVersionUID = 1L;
    private final UserRepository userRepository;

    public UserService() {
        userRepository =  new UserRepository();
    }

    @Override
    public Boolean insert(Usr t) {
        return userRepository.insert(t);
    }

    @Override
    public Boolean insertAll(List<Usr> list) {
        return userRepository.insertAll(list);
    }

    @Override
    public void remove(Usr t) {
        userRepository.remove(t);
    }

    @Override
    public Boolean update(Usr t) {
        return userRepository.update(t);
    }

    @Override
    public List<Usr> listAll() {
        return userRepository.listAll();
    }

    @Override
    public Usr findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<Usr> read(String query) {
        return userRepository.read(query);
    }
    
    public Usr login(String email, String password) {
        String passwordMd5 = Util.md5(password);
        return userRepository.login(email, passwordMd5);
    }
    
    public void register(Usr user) { 
        Usr foundPerson = userRepository.checkPersonWithEmail(user.getEmail()); 
        if (foundPerson != null) { 
            String summary = "Já existe Usuário com este email"; 
            Util.getFacesContext().addMessage("sticky-register", new FacesMessage(FacesMessage.SEVERITY_WARN, summary, null));
        }  else {
            userRepository.insertUser(user);
            String summary = "Usuário Criado com Sucesso."; 
            Util.getFacesContext().addMessage("sticky-register", new FacesMessage(summary));
            PrimeFaces.current().executeScript("PF('registrarDialog').hide()");
        }
    }
    
    public String logout() {
        HttpSession session = Util.getSession();
        session.invalidate();
        return "login?faces-redirect=true";
    }
      
}