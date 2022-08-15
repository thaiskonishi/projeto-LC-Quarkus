package br.com.letscode.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.letscode.model.Cliente;

public class ClienteDto {

    private String vatnumber;
    private String nome;
    private String email;
    private int idade;
    private Long idcategoria;

    public ClienteDto(Cliente cliente) {
        this.vatnumber = cliente.getVatnumber();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.idade = cliente.getIdade();
        this.idcategoria = cliente.getIdcategoria();
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

    public Long getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Long idcategoria) {
        this.idcategoria = idcategoria;
    }

    public static List<ClienteDto> converter(List<Cliente> clientes) {
        return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
    }

}