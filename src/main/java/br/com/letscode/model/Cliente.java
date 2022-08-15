package br.com.letscode.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String vatnumber;
	private String nome;
	private String email;
	private int idade;
	private Long idcategoria;

	public Cliente (){}

	public Cliente(String vatnumber, String nome, String email, int idade, Long idcategoria) {
		this.vatnumber = vatnumber;
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.idcategoria = idcategoria;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Long idcategoria) {
		this.idcategoria = idcategoria;
	}
}
