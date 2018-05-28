/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilhermengenharia
 */
public class LoginDAO {

    public boolean logar(String login, String senha) {

        String SQL = "select * from usuarios where login = ? and senha = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQL);
            st.setString(1, login);
            st.setString(2, senha);
            
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                System.out.println("passou por aqui");
                return true;
                
            }else{
                System.out.println("passou por ali");
                return false;
            }

            

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
        

    }
}

