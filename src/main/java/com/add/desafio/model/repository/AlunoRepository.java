package com.add.desafio.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.add.desafio.model.dao.ConexaoMySQL;
import com.add.desafio.model.domain.Aluno;

public class AlunoRepository {
		
	TurmaRepository turmaRepository = new TurmaRepository();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public String Create(Aluno aluno) {
		try {
			
			Connection connection = ConexaoMySQL.getConexaoMySQL();
			
			String data = aluno.getDataDeNascimento().format(formatter);
			
			String sql = "INSERT INTO aluno (nome, idTurma, dataDeNascimento) "
					+ "VALUES(?, ?, STR_TO_DATE(?, '%d/%m/%Y'));";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, aluno.getNome());
			ps.setInt(2, aluno.getTurma().getId());
			ps.setString(3, data);
			
			ps.executeUpdate();
			
			return "Aluno foi adicionado com sucesso!";
			
		} catch (SQLException e) {
			return "Problemas com o banco de dados!";
		}
	}
	
	public List<Aluno> GetAll() {
		
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		String sql = "SELECT id, nome, idTurma, DATE_FORMAT(dataDeNascimento, '%d-%m-%Y') FROM aluno;";
		
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt(1));
				aluno.setNome(rs.getString(2));
				aluno.setTurma(turmaRepository.GetById(rs.getInt(3)));
				aluno.setDataDeNascimentoDB(rs.getString(4));
				
				alunos.add(aluno);
			}
			
		} catch (SQLException e) {
			System.out.println("Problemas com banco de dados.");
		}  
		
		return alunos;
	}
	
	public Aluno GetById(Integer id) {
		
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		Aluno aluno = new Aluno();
		
		String sql = "SELECT id, nome, idTurma, DATE_FORMAT(dataDeNascimento, '%d-%m-%Y') "
				+ "FROM aluno WHERE id="+id+";";
		
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			aluno.setId(rs.getInt(1));
			aluno.setNome(rs.getString(2));
			aluno.setTurma(turmaRepository.GetById(rs.getInt(3)));
			aluno.setDataDeNascimentoDB(rs.getString(4));
					
		} catch (SQLException e) {
			System.out.println("Problemas com banco de dados.");
			aluno = null;
		}  
		
		return aluno;
	}
	
	public String Update(Aluno aluno) {
		try {
			
			Connection connection = ConexaoMySQL.getConexaoMySQL();
			String data = aluno.getDataDeNascimento().format(formatter);
			String sql = "UPDATE aluno SET nome=?, idTurma=?, dataDeNascimento=STR_TO_DATE(?, '%d/%m/%Y') "
					+ "WHERE id=?;";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, aluno.getNome());
			ps.setInt(2, aluno.getTurma().getId());
			ps.setString(3, data);
			ps.setInt(4, aluno.getId());
			
			ps.executeUpdate();
			
			return "Aluno foi atualizado com sucesso!";
			
		} catch (SQLException e) {
			return "Problemas com o banco de dados!";
		}
	}
	
	public String Delete(Integer id) {
		try {
			
			Connection connection = ConexaoMySQL.getConexaoMySQL();
			String sql = "DELETE FROM aluno WHERE id=?;";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			return "Aluno foi removido com sucesso!";
			
		} catch (SQLException e) {
			return "Problemas com o banco de dados!";
		}
	}

}
