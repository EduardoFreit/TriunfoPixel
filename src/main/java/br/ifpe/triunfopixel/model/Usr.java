package br.ifpe.triunfopixel.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "O campo 'email' é obrigatório.")
    @Size(min = 2, max = 255, message = "O campo 'Email' não pode ter menos de 2 ou mais de 255 caractéres.")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "O campo 'email' deve ser um endereço de email válido.")
    @Column(unique = true, nullable = false)
    private String email;
    
    @NotNull(message = "O campo 'Password' é obrigatório.")
    @Column(nullable = false)
    private String password;
    
    @NotNull(message = "O campo 'Nome' é obrigatório.")
    @Size(min = 2, max = 255, message = "O campo 'Nome' não pode ter menos de 2 ou mais de 255 caractéres.")
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private Boolean isAdmin = false;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usr)) {
            return false;
        }
        Usr other = (Usr) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ifpe.triunfopixel.model.User[ id=" + id + " ]";
    }
    
}
