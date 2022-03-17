package com.add.desafio.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.add.desafio.model.dao.ConexaoMySQL;
import com.add.desafio.model.domain.Escola;

public class EscolaRepository {
	
	
	EnderecoRepository enderecoRepository = new EnderecoRepository();
	
	public String Create(Escola escola) {
		try {
			
			Connection connection = ConexaoMySQL.getConexaoMySQL();
			String sql = "INSERT INTO escola (nome, idEndereco) "
					+ "VALUES(?, ?);";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, escola.getNome());
			ps.setInt(2, escola.getEndereco().getId());
			
			ps.executeUpdate();
			
			return "Escola foi adicionada com sucesso!";
			
		} catch (SQLException e) {
			return "Problemas com o banco de dados!";
		}
	}
	
	public List<Escola> GetAll() {
		
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		List<Escola> escolas = new ArrayList<Escola>();
		
		String sql = "SELECT id, nome, idEndereco FROM escola;";
		
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Escola escola = new Escola();
				escola.setId(rs.getInt(1));
				escola.setNome(rs.getString(2));
				escola.setEndereco(enderecoRepository.GetById(rs.getInt(3)));
				escolas.add(escola);
			}
			
		} catch (SQLException e) {
			System.out.println("Problemas com banco de dados.");
		}  
		
		return escolas;
	}
	
	public Escola GetById(Integer id) {
		
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		Escola escola = new Escola();
		
		String sql = "SELECT id, nome, idEndereco "
				+ "FROM escola WHERE id="+id+";";
		
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			escola.setId(rs.getInt(1));
			escola.setNome(rs.getString(2));
			escola.setEndereco(enderecoRepository.GetById(rs.getInt(3)));
					
		} catch (SQLException e) {
			System.out.println("Problemas com banco de dados.");
			escola = null;
		}  
		
		return escola;
	}
	
	public String Update(Escola escola) {
		try {
			
			Connection connection = ConexaoMySQL.getConexaoMySQL();
			String sql = "UPDATE escola SET nome=?, idEndereco=? "
					+ "WHERE id=?;";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, escola.getNome());
			ps.setInt(2, escola.getEndereco().getId());
			ps.setInt(3, escola.getId());
			
			ps.executeUpdate();
			
			return "Escola foi atualizada com sucesso!";
			
		} catch (SQLException e) {
			return "Problemas com o banco de dados!";
		}
	}
	
	public String Delete(Integer id) {
		try {
			
			Connection connection = ConexaoMySQL.getConexaoMySQL();
			String sql = "DELETE FROM escola WHERE id=?;";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			return "Escola foi removida com sucesso!";
			
		} catch (SQLException e) {
			return "Problemas com o banco de dados!";
		}
	}

}
