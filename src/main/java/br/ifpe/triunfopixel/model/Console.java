/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifpe.triunfopixel.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private String nome;
    private String urlImagem;
    private String AnoLancamento;
    private String Fabricante;

    public Console() {
    }

    public Console(Long id, String nome, String urlImagem, String AnoLancamento, String Fabricante) {
        this.id = id;
        this.nome = nome;
        this.urlImagem = urlImagem;
        this.AnoLancamento = AnoLancamento;
        this.Fabricante = Fabricante;
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
