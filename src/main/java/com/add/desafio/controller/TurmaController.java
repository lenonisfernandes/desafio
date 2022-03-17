package com.add.desafio.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.add.desafio.model.domain.Turma;
import com.add.desafio.model.repository.EscolaRepository;
import com.add.desafio.model.repository.TurmaRepository;

@Controller
public class TurmaController {
	
	TurmaRepository turmaRepository = new TurmaRepository();
	EscolaRepository escolaRepository = new EscolaRepository();
	
	
	@GetMapping(value="/turmas")
	public List<Turma> listar() {
		return turmaRepository.GetAll();
	}
	
	@GetMapping(value="/turma/{id}")
	public Turma obterPorId(@PathVariable Integer id) {
		return turmaRepository.GetById(id);
	}
	
	@DeleteMapping(value="/turma/excluir/{id}")
	public void deletar(@PathVariable Integer id) {
		turmaRepository.Delete(id);
	}
	
	@PostMapping(value="/turma/atualizar")
	public void atualizar(@RequestParam Integer id, @RequestParam String nome, 
			@RequestParam Integer idEscola, @RequestParam Integer capacidade) {
		
		Turma turma = new Turma();
		turma.setId(id);
		turma.setNome(nome);
		turma.setEscola(escolaRepository.GetById(idEscola));
		turma.setCapacidade(capacidade);
		
		turmaRepository.Update(turma);
	}
	
	@PostMapping(value="/turma/incluir")
	public void incluir(@RequestParam String nome, @RequestParam Integer idEscola, 
			@RequestParam Integer capacidade) {
		
		Turma turma = new Turma();
		turma.setNome(nome);
		turma.setEscola(escolaRepository.GetById(idEscola));
		turma.setCapacidade(capacidade);
		
		turmaRepository.Create(turma);
	}

}
