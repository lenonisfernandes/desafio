package com.add.desafio.test;

import com.add.desafio.model.domain.Turma;
import com.add.desafio.model.repository.EscolaRepository;
import com.add.desafio.model.repository.TurmaRepository;

public class TurmaTest {

	public static void main(String[] args) {
		
		EscolaRepository escolaRepository = new EscolaRepository();
		TurmaRepository turmaRepository = new TurmaRepository();
		
		Turma turma = new Turma();
		turma.setNome("F6.1");
		turma.setEscola(escolaRepository.GetById(13));
		turma.setCapacidade(35);
		
		System.out.println("Create:");
		System.out.println(turmaRepository.Create(turma));
		
		for (Turma t : turmaRepository.GetAll()) {
			System.out.println(t.toString());
		}
		
		System.out.println("\nGetById:");
		System.out.println(turmaRepository.GetById(11).toString());
		
		System.out.println("\nUpdate:");
		turma.setNome("F6.3");
		turma.setId(11);
		System.out.println(turmaRepository.Update(turma));
		
		System.out.println("\nDelete:");
		System.out.println(turmaRepository.Delete(13));
		
		for (Turma t : turmaRepository.GetAll()) {
			System.out.println(t.toString());
		}
		
		

	}

}
