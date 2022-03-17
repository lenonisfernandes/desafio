package com.add.desafio.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.add.desafio.model.dao.ConexaoMySQL;
import com.add.desafio.model.domain.Turma;

public class TurmaRepository {
	
	
	EscolaRepository escolaRepository = new EscolaRepository();
	
	public String Create(Turma turma) {
		try {
			
			Connection connection = ConexaoMySQL.getConexaoMySQL();
			String sql = "INSERT INTO turma (nome, idEscola, capacidade) "
					+ "VALUES(?, ?, ?);";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, turma.getNome());
			ps.setInt(2, turma.getEscola().getId());
			ps.setInt(3, turma.getCapacidade());
			
			ps.executeUpdate();
			
			return "Turma foi adicionada com sucesso!";
			
		} catch (SQLException e) {
			return "Problemas com o banco de dados!";
		}
	}
	
	public List<Turma> GetAll() {
		
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		List<Turma> turmas = new ArrayList<Turma>();
		
		String sql = "SELECT id, nome, idEscola, capacidade FROM turma;";
		
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Turma turma = new Turma();
				turma.setId(rs.getInt(1));
				turma.setNome(rs.getString(2));
				turma.setEscola(escolaRepository.GetById(rs.getInt(3)));
				turma.setCapacidade(rs.getInt(4));
				turmas.add(turma);
			}
			
		} catch (SQLException e) {
			System.out.println("Problemas com banco de dados.");
		}  
		
		return turmas;
	}
	
	public Turma GetById(Integer id) {
		
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		Turma turma = new Turma();
		
		String sql = "SELECT id, nome, idEscola, capacidade "
				+ "FROM turma WHERE id="+id+";";
		
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			turma.setId(rs.getInt(1));
			turma.setNome(rs.getString(2));
			turma.setEscola(escolaRepository.GetById(rs.getInt(3)));
			turma.setCapacidade(rs.getInt(4));
					
		} catch (SQLException e) {
			System.out.println("Problemas com banco de dados.");
			turma = null;
		}  
		
		return turma;
	}
	
	public String Update(Turma turma) {
		try {
			
			Connection connection = ConexaoMySQL.getConexaoMySQL();
			String sql = "UPDATE turma SET nome=?, idEscola=?, capacidade=? "
					+ "WHERE id=?;";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, turma.getNome());
			ps.setInt(2, turma.getEscola().getId());
			ps.setInt(3, turma.getCapacidade());
			ps.setInt(4, turma.getId());
			
			ps.executeUpdate();
			
			return "Turma foi atualizada com sucesso!";
			
		} catch (SQLException e) {
			return "Problemas com o banco de dados!";
		}
	}
	
	public String Delete(Integer id) {
		try {
			
			Connection connection = ConexaoMySQL.getConexaoMySQL();
			String sql = "DELETE FROM turma WHERE id=?;";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			return "Turma foi removida com sucesso!";
			
		} catch (SQLException e) {
			return "Problemas com o banco de dados!";
		}
	}

}
