package br.com.letscode.model;

import java.util.List;
import java.util.stream.Collectors;

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
