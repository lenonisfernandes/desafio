package com.add.desafio.test;

import com.add.desafio.model.domain.Endereco;
import com.add.desafio.model.repository.EnderecoRepository;

public class EnderecoTest {

	public static void main(String[] args) {
		
		EnderecoRepository enderecoRepository = new EnderecoRepository();
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua A");
		endereco.setComplemento("Casa 1");
		endereco.setBairro("Prata");
		endereco.setCidade("Nova Iguaçu");
		endereco.setEstado("RJ");
		endereco.setId(1);
		
		System.out.println("Create:");
		System.out.println(enderecoRepository.Create(endereco));
				
		System.out.println("\nGet All:");
		for (Endereco e : enderecoRepository.GetAll()) {
			System.out.println(e.toString());
		}
		
		System.out.println("\nGetById:");
		System.out.println(enderecoRepository.GetById(7).toString());
		
		System.out.println("\nUpdate:");
		endereco.setId(10);
		endereco.setLogradouro("Rua B");
		System.out.println(enderecoRepository.Update(endereco));
		
		System.out.println("\nDelete:");
		System.out.println(enderecoRepository.Delete(9));
		
		System.out.println("\nGet All:");
		for (Endereco e : enderecoRepository.GetAll()) {
			System.out.println(e.toString());
		}
		

	}

}
