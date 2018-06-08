/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.EmpresaBeans;
import Beans.UsuarioBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilhermengenharia
 */
public class LoginDAO {

    public boolean logar(UsuarioBeans usuario) {

        String SQL = "select * from usuarios where login = ? and senha = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQL);
            st.setString(1, usuario.getLogin());
            st.setString(2, usuario.getSenha());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                if (usuario.getLogin().equals(rs.getString("login")) && usuario.getSenha().equals(rs.getString("senha"))) {
                    return true;
                } else {
                    return false;
                }

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex);
        }
        return false;

    }
    
    public boolean logarEmpresa(EmpresaBeans empresa){
        String SQL = "select * from empresas where login = ? and senha = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQL);
            st.setString(1, empresa.getLogin());
            st.setString(2, empresa.getSenha());
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                if(empresa.getLogin().equals(rs.getString("login")) && empresa.getSenha().equals(rs.getString("senha"))){
                    return true;
                }else{
                    return false;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
}
