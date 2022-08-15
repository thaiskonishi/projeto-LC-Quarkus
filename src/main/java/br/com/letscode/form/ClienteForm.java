package br.com.letscode.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import br.com.letscode.model.Cliente;
import br.com.letscode.repository.ClienteRepository;

public class ClienteForm {

    @Pattern(regexp = "[A-z]{2}\\d{8,9}", message = "O padrão do vatnumber não foi atendido (XX123456789). ")
    @NotNull(message = "vatnumber não pode ser nulo")
    private String vatnumber;
    @NotBlank
    @NotEmpty
    @Length(min = 5, max=100)
    private String nome;
    @NotBlank
    @NotEmpty
    private String email;
    @Min(18)
    private int idade;
    private Long idcategoria;

    public Long getIdCategoria(){
        return idcategoria;
    }

    public void setIdCategoria(Long idcategoria){
        this.idcategoria=idcategoria;
    }
    public String getVatnumber() {
        return vatnumber;
    }

    public void setVatnumber(String vatnumber) {
        this.vatnumber = vatnumber;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Cliente converter() {
        return new Cliente(vatnumber, nome, email, idade, idcategoria);
    }

    public Cliente alterarDados(Long id, ClienteRepository clienteRepository) {
        Cliente cliente = clienteRepository.findByIdentificador(id);
        cliente.setEmail(this.email);
        cliente.setIdade(this.idade);
        cliente.setNome(this.nome);
        cliente.setVatnumber(this.vatnumber);
        cliente.setIdcategoria(idcategoria);
        return cliente;

    }

    public Long getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Long idcategoria) {
        this.idcategoria = idcategoria;
    }
}