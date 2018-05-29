/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.UsuarioBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilhermengenharia
 */
public class UsuarioDAO {

    public void cadastrar(UsuarioBeans usuario) {
        String sql = "insert into usuarios(nome, login, senha, permissao) values(?, ?, ?, ?)";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, usuario.getNome());
            st.setString(2, usuario.getLogin());
            st.setString(3, usuario.getSenha());
            st.setString(4, usuario.getPermissao());

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Salvo com Sucesso", "Salvo", 1, new ImageIcon("Imagens/ok.png"));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

}
