package com.add.desafio.model.domain;

public class Turma {
	
	private Integer id;
	private String nome;
	private Integer capacidade;
	private Escola escola;
	
	public String toString() {
		return this.id + " - " + this.nome + " - " + this.capacidade + " - " +this.escola.getNome();
	}
	
	public Integer getId() {
		return id;
	}
	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
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
	public Escola getEscola() {
		return escola;
	}
	public void setEscola(Escola escola) {
		this.escola = escola;
	}
	
	

}
