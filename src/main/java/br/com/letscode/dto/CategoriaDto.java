package br.com.letscode.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.letscode.model.Categoria;

public class CategoriaDto {
    
    private String nome;

    public CategoriaDto(Categoria categoria){
        this.nome = categoria.getNome();
    }
    public String getNome() {
        return nome;
    }
    
    public static List<CategoriaDto> converter(List<Categoria> categoria) {
        return categoria.stream().map(CategoriaDto::new).collect(Collectors.toList());
    }
}
