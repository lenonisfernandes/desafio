package com.add.desafio.test;
//lenon
import com.add.desafio.model.domain.Aluno;
import com.add.desafio.model.repository.AlunoRepository;
import com.add.desafio.model.repository.TurmaRepository;

public class AlunoTest {

	public static void main(String[] args) {
		
		TurmaRepository turmaRepository = new TurmaRepository();
		AlunoRepository alunoRepository = new AlunoRepository();
		
		
		Aluno aluno = new Aluno();
		aluno.setId(1);
		aluno.setNome("Lenon");
		aluno.setTurma(turmaRepository.GetById(10));
		aluno.setDataDeNascimento("1992-03-26");
		
		System.out.println("Create:");
		System.out.println(alunoRepository.Create(aluno));
		

		for (Aluno a : alunoRepository.GetAll()) {
			System.out.println(a.toString());
		}
		
		System.out.println("\nGetById:");
		System.out.println(alunoRepository.GetById(10).toString());
		
		System.out.println("\nUpdate:");
		aluno.setNome("Lenon2");
		aluno.setId(13);
		System.out.println(alunoRepository.Update(aluno));
		
		System.out.println("\nDelete:");
		System.out.println(alunoRepository.Delete(14));
		
		for (Aluno a : alunoRepository.GetAll()) {
			System.out.println(a.toString());
		}
		


	}

}
