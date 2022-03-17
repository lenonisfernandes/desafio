package com.add.desafio.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.add.desafio.model.domain.Endereco;
import com.add.desafio.model.repository.EnderecoRepository;

@Controller
public class EnderecoController {
	
	EnderecoRepository enderecoRepository = new EnderecoRepository();
	
	@GetMapping(value="/enderecos")
	public List<Endereco> listar() {
		return enderecoRepository.GetAll();
	}
	
	@GetMapping(value="/endereco/{id}")
	public Endereco obterPorId(@PathVariable Integer id) {
		return enderecoRepository.GetById(id);
	}
	
	@DeleteMapping(value="/endereco/excluir/{id}")
	public void deletar(@PathVariable Integer id) {
		enderecoRepository.Delete(id);
	}
	
	@PostMapping(value="/endereco/atualizar")
	public void atualizar(@RequestParam Integer id, @RequestParam String logradouro, 
			@RequestParam String complemento, @RequestParam String bairro, 
			@RequestParam String cidade, @RequestParam String estado) {
		
		Endereco endereco = new Endereco();
		endereco.setId(id);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setComplemento(complemento);
		endereco.setEstado(estado);
		endereco.setLogradouro(logradouro);
		
		enderecoRepository.Update(endereco);
	}
	
	@PostMapping(value="/endereco/incluir")
	public void incluir(@RequestParam String logradouro, @RequestParam String complemento, 
			@RequestParam String bairro, @RequestParam String cidade, @RequestParam String estado) {
		
		Endereco endereco = new Endereco();
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setComplemento(complemento);
		endereco.setEstado(estado);
		endereco.setLogradouro(logradouro);
		
		enderecoRepository.Create(endereco);
	}

}
