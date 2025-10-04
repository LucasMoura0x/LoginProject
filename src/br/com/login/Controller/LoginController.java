/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.login.Controller;

import br.com.login.dao.Conexao;
import br.com.login.dao.LoginDAO;
import br.com.login.view.CadastroView;
import br.com.login.view.LoginView;
import java.sql.Connection;
import java.sql.SQLException;


public class LoginController {

    public void CadastroUsuario(CadastroView view) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        LoginDAO cadastro = new LoginDAO();
        cadastro.CadastrarUsuario(view.getjTextFieldNome().getText(),view.getjTextFieldEmail().getText(), view.getjPasswordFieldSenha().getText());
    }
    
    public void LoginUsuario(LoginView view) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        LoginDAO login = new LoginDAO();
        login.login(view.getjTextFieldLogin().getText(), view.getjPasswordFieldSenha().getText());
    }
}
