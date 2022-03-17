package com.add.desafio.test;

import com.add.desafio.model.dao.ConexaoMySQL;

public class ConexaoMySQLTest {

	public static void main(String[] args) {
		System.out.println(ConexaoMySQL.statusConexao());
		
		ConexaoMySQL.getConexaoMySQL();
		System.out.println(ConexaoMySQL.statusConexao());
		
		

	}

}
