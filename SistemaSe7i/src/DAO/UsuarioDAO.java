/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.UsuarioBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static sun.security.jgss.GSSUtil.login;

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

    public void buscarUsuario(String Pesquisa, DefaultTableModel Modelo) {
        try {
            String sql = "select * from usuarios where id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Modelo.addRow(new Object[]{rs.getString("id"), rs.getString("nome"), rs.getString("login"), rs.getString("senha"), rs.getString("permissao")});
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public UsuarioBeans preencherCampos(int Codigo) {
        UsuarioBeans Usuario = new UsuarioBeans();
        try {
            String sql = "select * from usuarios where id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setInt(1, Codigo);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Usuario.setId(rs.getInt("id"));
                Usuario.setNome(rs.getString("nome"));
                Usuario.setLogin(rs.getString("login"));
                Usuario.setSenha(rs.getString("senha"));
                Usuario.setPermissao(rs.getString("permissao"));

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return Usuario;
    }

    public void editar(UsuarioBeans usuario) {
        String sql = "update usuarios set nome = ?, login = ?, senha = ?, permissao = ? where id = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, usuario.getNome());
            st.setString(2, usuario.getLogin());
            st.setString(3, usuario.getSenha());
            st.setString(4, usuario.getPermissao());
            st.setInt(5, usuario.getId());

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Editado com Sucesso", "Salvo", 1, new ImageIcon("Imagens/ok.png"));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }



    public void buscarTodosUsuarios(DefaultTableModel Modelo) {
        try {
            String sql = "select * from usuarios";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Modelo.addRow(new Object[]{rs.getString("id"), rs.getString("nome"), rs.getString("login"), rs.getString("permissao")});
                
            }
        } catch (Exception e) {
        }

    }

    public void deletar(UsuarioBeans usuarioB) {
        String sql = "delete from usuario where id=?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
        } catch (Exception e) {
        }
    }

}
