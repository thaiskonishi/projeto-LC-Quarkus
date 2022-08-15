package br.com.letscode.model;

public class CategoriaForm {
    
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria alteraDados(Long id, CategoriaRepository categoriaRepository){
        Categoria categoria = categoriaRepository.findById(id);
        categoria.setNome(this.nome);
        return categoria;
    }

    public Categoria converter() {
        return new Categoria(nome);
    }

}
