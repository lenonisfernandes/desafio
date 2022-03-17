package com.add.desafio.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
	
	public static String status = "Não conectou...";
	
	public ConexaoMySQL() {
		
	}
	
	public static Connection getConexaoMySQL() {
		
		Connection connection = null;
		
		try {
			String serverName = "localhost";
			String mydatabase = "dbDesafio";
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
	        String username = "root";        
	        String password = "123456";      
	        connection = DriverManager.getConnection(url, username, password);
	        
	        if (connection != null) {
	        	status = ("Conectado com sucesso");
	        }
	        else {
	        	status = ("Não foi possível realizar a conexão.");
	        }
	        
	        return connection;
		} catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
		}
	}
		
	public static String statusConexao() {
		return status;
	}
		
	public static boolean fecharConexao() {
		try {
			ConexaoMySQL.getConexaoMySQL().close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public static Connection reiniciarConexao() {
		ConexaoMySQL.fecharConexao();
		return ConexaoMySQL.getConexaoMySQL();
	}
}