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
    public void insert(Usr t) {
        userRepository.insert(t);
    }

    @Override
    public void insertAll(List<Usr> list) {
        userRepository.insertAll(list);
    }

    @Override
    public void remove(Usr t) {
        userRepository.remove(t);
    }

    @Override
    public void update(Usr t) {
        userRepository.update(t);
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
    
    public String login(String email, String password) {
        String passwordMd5 = Util.md5(password);
        Usr foundUser = userRepository.login(email, passwordMd5);

        if (foundUser == null) {
            String summary = "Falha ao realizar login";
            Util.getFacesContext().addMessage("sticky-key-login", new FacesMessage(summary));
            return "login";
        }
        HttpSession session = (HttpSession) Util.getFacesContext()
                .getExternalContext()
                .getSession(true);
        session.setAttribute("user", foundUser);
        return "games.xhtml?faces-redirect=true";
    }
    
    public void register(Usr user) { 
        Usr foundPerson = userRepository.checkPersonWithEmail(user.getEmail()); 
        if (foundPerson != null) { 
            String summary = "Já existe Usuário com este email"; 
            Util.getFacesContext().addMessage("sticky-register", new FacesMessage(FacesMessage.SEVERITY_WARN, summary, null));
        }  else {
            user.setEmail(null);
            userRepository.insert(user); 
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