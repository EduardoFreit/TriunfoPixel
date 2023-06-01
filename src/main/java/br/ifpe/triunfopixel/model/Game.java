package br.ifpe.triunfopixel.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "O campo 'Nome' é obrigatório.")
    @Size(min = 2, message = "O campo 'Nome' não pode ter menos de 2 caractéres.")
    @Column(nullable = false)
    private String name;
    
    @NotNull(message = "O campo 'UrlImagem' é obrigatório.")
    @Size(min = 2,message = "O campo 'UrlImagem' não pode ter menos de 2 caractéres.")
    @Column(nullable = false)
    private String urlImagem;
    
    @NotNull(message = "O campo 'UrlRoom' é obrigatório.")
    @Size(min = 2,message = "O campo 'UrlRoom' não pode ter menos de 2 caractéres.")
    @Column(nullable = false)
    private String urlRoom;
    
    @NotNull(message = "O campo 'Gênero' é obrigatório.")
    @Size(min = 2,message = "O campo 'Gênero' não pode ter menos de 2 caractéres.")
    @Column(nullable = false)
    private String genre;
    
    @NotNull(message = "O campo 'Hash' é obrigatório.")
    @Size(min = 2,message = "O campo 'Hash' não pode ter menos de 2 caractéres.")
    @Column(nullable = false)
    private String hash;
    
    @ManyToOne
    @JoinColumn(name = "CONSOLE_ID")
    @NotNull(message = "O campo 'Console' é obrigatório.")
    private Console console;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Game)) {
            return false;
        }
        Game other = (Game) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ifpe.triunfopixel.bean.model.Game[ id=" + id + " ]";
    }
    
}
