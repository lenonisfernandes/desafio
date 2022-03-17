package com.add.desafio.test;

import com.add.desafio.model.domain.Escola;
import com.add.desafio.model.repository.EnderecoRepository;
import com.add.desafio.model.repository.EscolaRepository;

public class EscolaTest {

	public static void main(String[] args) {
		
		EnderecoRepository enderecoRepository = new EnderecoRepository();
		EscolaRepository escolaRepository = new EscolaRepository();
		
		Escola escola = new Escola();
		escola.setNome("ABC da Alegria");
		escola.setEndereco(enderecoRepository.GetById(7));
		
		System.out.println("Create:");
		System.out.println(escolaRepository.Create(escola));
		
		
		for (Escola e : escolaRepository.GetAll()) {
			System.out.println(e.toString());
		}
		
		System.out.println("\nGetById:");
		System.out.println(escolaRepository.GetById(13).toString());
		
		System.out.println("\nUpdate:");
		escola.setNome("DEF da Alegria");
		escola.setId(17);
		System.out.println(escolaRepository.Update(escola));
		
		System.out.println("\nDelete:");
		System.out.println(escolaRepository.Delete(16));
		
		for (Escola e : escolaRepository.GetAll()) {
			System.out.println(e.toString());
		}
		
		

	}

}
