/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    public void CadastrarUsuario(String nome, String email, String senha) throws SQLException {
        Connection conexao = new Conexao().getConnection();
        String sql = "INSERT INTO login (nome, email, senha) VALUES ('" + nome + "','" + email + "','" + senha + "')";
        PreparedStatement statment = conexao.prepareStatement(sql);
        statment.execute();
        conexao.close();
    }
    
    public void login(String email, String senha) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "SELECT email,senha FROM login WHERE email = '"+email+"' AND senha = '"+senha+"'";
        System.out.println(sql);
        PreparedStatement statment = conexao.prepareStatement(sql);
        ResultSet rs = statment.executeQuery();
        if (rs.next()){
            System.out.println("Usuário informado, possui um cadastro.");
        }else{
            System.out.println("Usuário informado, não possui um cadastro");
        }
        conexao.close();
    }
}
