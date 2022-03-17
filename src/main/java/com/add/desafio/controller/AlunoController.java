package com.add.desafio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.add.desafio.model.domain.Aluno;
import com.add.desafio.model.repository.AlunoRepository;
import com.add.desafio.model.repository.TurmaRepository;

@Controller
public class AlunoController {
	
	AlunoRepository alunoRepository = new AlunoRepository();
	TurmaRepository turmaRepository = new TurmaRepository();
	
	
	@GetMapping(value="/")
	public String listar(Model model) {
		model.addAttribute("alunos", alunoRepository.GetAll());
		
		return "listar";
	}
	
	@GetMapping(value="/aluno/cadastro")
	public String telaCadastro(Model model) {
		
		model.addAttribute("turmas", turmaRepository.GetAll());
		
		return "cadastro";
	}
	
	@GetMapping(value="/aluno/{id}")
	public Aluno obterPorId(@PathVariable Integer id) {
		return alunoRepository.GetById(id);
	}
	
	@DeleteMapping(value="/aluno/excluir/{id}")
	public void deletar(@PathVariable Integer id) {
		alunoRepository.Delete(id);
	}
	
	@PostMapping(value="/aluno/atualizar")
	public void atualizar(@RequestParam Integer id, @RequestParam String nome, 
			@RequestParam Integer idTurma, @RequestParam String data) {
		
		Aluno aluno = new Aluno();
		aluno.setId(id);
		aluno.setNome(nome);
		aluno.setDataDeNascimento(data);
		aluno.setTurma(turmaRepository.GetById(idTurma));
		
		alunoRepository.Update(aluno);
	}
	
	@PostMapping(value="/aluno/incluir")
	public String incluir(@RequestParam String nome, @RequestParam Integer idturma, @RequestParam String data, Model model) {
		
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setDataDeNascimento(data);
		aluno.setTurma(turmaRepository.GetById(idturma));
		
		alunoRepository.Create(aluno);
		
		return listar(model);
	}

}
