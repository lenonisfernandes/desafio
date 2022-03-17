package com.add.desafio.model.domain;

public class Escola {
	
	private Integer id;
	private String nome;
	private Endereco endereco;
	
	public String toString() {
		return this.id + " - " + this.nome + " - " + this.endereco.getId() + " - " + this.endereco.getLogradouro();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
