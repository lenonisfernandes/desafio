package com.add.desafio.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.add.desafio.model.dao.ConexaoMySQL;
import com.add.desafio.model.domain.Endereco;

public class EnderecoRepository {
	
	Connection connection = ConexaoMySQL.getConexaoMySQL();
	
	public String Create(Endereco endereco) {
		try {
			
			String sql = "INSERT INTO endereco (logradouro, complemento, bairro, cidade, estado) "
					+ "VALUES(?, ?, ?, ?, ?);";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, endereco.getLogradouro());
			ps.setString(2, endereco.getComplemento());
			ps.setString(3, endereco.getBairro());
			ps.setString(4, endereco.getCidade());
			ps.setString(5, endereco.getEstado());
			
			ps.executeUpdate();
			
			return "Endereço foi adicionado com sucesso!";
			
		} catch (SQLException e) {
			return "Problemas com o banco de dados!";
		}
	}
	
	public List<Endereco> GetAll() {
		
		List<Endereco> enderecos = new ArrayList<Endereco>();
		
		String sql = "SELECT id, logradouro, complemento, bairro, cidade, estado FROM endereco;";
		
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Endereco endereco = new Endereco();
				endereco.setId(rs.getInt(1));
				endereco.setLogradouro(rs.getString(2));
				endereco.setComplemento(rs.getString(3));
				endereco.setBairro(rs.getString(4));
				endereco.setCidade(rs.getString(5));
				endereco.setEstado(rs.getString(6));
				enderecos.add(endereco);
			}
			
		} catch (SQLException e) {
			System.out.println("Problemas com banco de dados.");
		}  
		
		return enderecos;
	}
	
	public Endereco GetById(Integer id) {
		
		Endereco endereco = new Endereco();
		String sql = "SELECT id, logradouro, complemento, bairro, cidade, estado "
				+ "FROM endereco WHERE id="+id+";";
		
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			endereco.setId(rs.getInt(1));
			endereco.setLogradouro(rs.getString(2));
			endereco.setComplemento(rs.getString(3));
			endereco.setBairro(rs.getString(4));
			endereco.setCidade(rs.getString(5));
			endereco.setEstado(rs.getString(6));
					
		} catch (SQLException e) {
			System.out.println("Problemas com banco de dados.");
			endereco = null;
		}  
		
		return endereco;
	}
	
	public String Update(Endereco endereco) {
		try {
			
			String sql = "UPDATE endereco SET logradouro=?, complemento=?, bairro=?, cidade=?, estado=? "
					+ "WHERE id=?;";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, endereco.getLogradouro());
			ps.setString(2, endereco.getComplemento());
			ps.setString(3, endereco.getBairro());
			ps.setString(4, endereco.getCidade());
			ps.setString(5, endereco.getEstado());
			ps.setInt(6, endereco.getId());
			
			ps.executeUpdate();
			
			return "Endereço foi atualizado com sucesso!";
			
		} catch (SQLException e) {
			return "Problemas com o banco de dados!";
		}
	}
	
	public String Delete(Integer id) {
		try {
			
			String sql = "DELETE FROM endereco WHERE id=?;";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			return "Endereço foi removido com sucesso!";
			
		} catch (SQLException e) {
			return "Problemas com o banco de dados!";
		}
	}

}
