package com.add.desafio.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.add.desafio.model.domain.Escola;
import com.add.desafio.model.repository.EnderecoRepository;
import com.add.desafio.model.repository.EscolaRepository;

@Controller
public class EscolaController {
	
	EscolaRepository escolaRepository = new EscolaRepository();
	EnderecoRepository enderecoRepository = new EnderecoRepository();
	
	
	@GetMapping(value="/escolas")
	public List<Escola> listar() {
		return escolaRepository.GetAll();
	}
	
	@GetMapping(value="/escola/{id}")
	public Escola obterPorId(@PathVariable Integer id) {
		return escolaRepository.GetById(id);
	}
	
	@DeleteMapping(value="/escola/excluir/{id}")
	public void deletar(@PathVariable Integer id) {
		escolaRepository.Delete(id);
	}
	
	@PostMapping(value="/escola/atualizar")
	public void atualizar(@RequestParam Integer id, @RequestParam String nome, 
			@RequestParam Integer idEndereco) {
		
		Escola escola = new Escola();
		escola.setId(id);
		escola.setNome(nome);
		escola.setEndereco(enderecoRepository.GetById(idEndereco));
		
		escolaRepository.Update(escola);
	}
	
	@PostMapping(value="/escola/incluir")
	public void incluir(@RequestParam String nome, @RequestParam Integer idEndereco) {
		
		Escola escola = new Escola();
		escola.setNome(nome);
		escola.setEndereco(enderecoRepository.GetById(idEndereco));
		
		escolaRepository.Create(escola);
	}

}
