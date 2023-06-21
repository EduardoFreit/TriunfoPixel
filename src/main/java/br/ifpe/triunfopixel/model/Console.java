/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifpe.triunfopixel.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Anderson
 */
@Entity
@Getter
@Setter
public class Console implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "O campo 'Nome' é obrigatório.")
    @Size(min = 2, max = 255, message = "O campo 'Nome' não pode ter menos de 2 ou mais de 255 caractéres.")
    @Column(nullable = false)
    private String nome;
    
    @NotNull(message = "O campo 'Ano do Lancamento' é obrigatório.")
    @Column(nullable = false)
    private Long anoLancamento;
    
    @NotNull(message = "O campo 'Fabricante' é obrigatório.")
    @Size(min = 2, max = 255, message = "O campo 'Fabricante' não pode ter menos de 2 ou mais de 255 caractéres.")
    @Column(nullable = false)
    private String fabricante;
    
    @NotNull(message = "O campo 'UrlImagem' é obrigatório.")
    @Size(min = 2, max = 255, message = "O campo 'UrlImagem' não pode ter menos de 2 ou mais de 255 caractéres.")
    @Pattern(regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$",
        message = "Insira uma URL Válida para o campo 'UrlImagem")
    @Column(nullable = false)
    private String urlImagem;
    
    @OneToMany(mappedBy = "console", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Game> jogos;

    public Console() {
    }

    public Console(Long id, String nome, Long anoLancamento, String fabricante) {
        this.id = id;
        this.nome = nome;      
        this.anoLancamento = anoLancamento;
        this.fabricante = fabricante;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Console other = (Console) obj;
        return Objects.equals(this.id, other.id);
    }  
}
