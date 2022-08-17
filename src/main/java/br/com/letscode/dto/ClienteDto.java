package br.com.letscode.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;

import br.com.letscode.model.Categoria;
import br.com.letscode.model.Cliente;
import br.com.letscode.repository.CategoriaRepository;

public class ClienteDto {

    private String vatnumber;
    private String nome;
    private String email;
    private int idade;
    private String categoria;

    @Inject
    CategoriaRepository categoriaRepository = new CategoriaRepository();

    public ClienteDto(Cliente cliente) {
        this.vatnumber = cliente.getVatnumber();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.idade = cliente.getIdade();
        this.categoria = categoriaRepository.findById(cliente.getIdcategoria()).getNome();
    }

    public String getvatnumber() {
        return vatnumber;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdade() {
        return idade;
    }

    public String getCategoria() {
        return categoria;
    }

    public static List<ClienteDto> converter(List<Cliente> clientes) {
        return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
    }

}