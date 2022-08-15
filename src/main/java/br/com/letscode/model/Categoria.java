package br.com.letscode.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcategoria;
    
    private String nome;

    public Categoria(){}
    
    public Categoria(String nome){
        this.nome = nome;
    }
    public Long getIdcategoria() {
        return idcategoria;
    }
    public void setIdcategoria(Long idcategoria) {
        this.idcategoria = idcategoria;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
