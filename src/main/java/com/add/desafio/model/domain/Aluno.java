package com.add.desafio.model.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluno {
	
	private Integer id;
	private String nome;
	private LocalDate dataDeNascimento;
	private Turma turma;
	
	
	
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		StringBuilder string = new StringBuilder();
		string.append(this.id);
		string.append(" - ");
		string.append(this.nome);
		string.append(" - ");
		string.append(this.dataDeNascimento.format(formatter));
		string.append(" - ");
		string.append(this.turma.getNome());
		
		return string.toString();
	}
	
	public void setDataDeNascimento(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.dataDeNascimento = LocalDate.parse(data, formatter);
		
	}
	
	public void setDataDeNascimentoDB(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.dataDeNascimento = LocalDate.parse(data, formatter);
		
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
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	

}
