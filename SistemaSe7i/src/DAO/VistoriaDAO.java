/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.CidadeBeans;
import Beans.VistoriaBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class VistoriaDAO {
    public void cadastrar(VistoriaBeans vistoria){
    
    String sql = "insert into vistoriadoras(nome, endereco, numero, bairro, cep, "
                + "cidade) values(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, vistoria.getNome());
            st.setString(2, vistoria.getEndereco());
            st.setString(3, vistoria.getNumero());
            st.setString(4, vistoria.getBairro());
            st.setString(5, vistoria.getCep());
            if (vistoria.getCidade() == null) {
                st.setInt(6, 0);
            } else {
                st.setInt(6, vistoria.getCidade().getId());//Cidade é objeto e quero só id desse objeto
            }

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Salvo com Sucesso", "Salvo", 1, new ImageIcon("Imagens/ok.png"));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void buscarVistoria(String Pesquisa, DefaultTableModel Modelo) {
        try {
            String sql = "select * from vistoriadoras where nome like '%" + Pesquisa + "%' ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Modelo.addRow(new Object[]{rs.getString("id"), rs.getString("nome"), rs.getString("endereço"), rs.getString("cidade")});
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public VistoriaBeans preencherCampos(int id) {
        VistoriaBeans vistoria = new VistoriaBeans();
        CidadeBeans cidadeB = new CidadeBeans();
        try {
            String sql = "select * from vistoriadoras where id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                vistoria.setId(rs.getInt("id"));
                vistoria.setNome(rs.getString("nome"));
                vistoria.setEndereco(rs.getString("endereco"));
                vistoria.setNumero(rs.getString("numero"));
                vistoria.setBairro(rs.getString("bairro"));
                vistoria.setCep(rs.getString("cep"));
                cidadeB.setId(rs.getInt("cidade"));
                vistoria.setCidade(cidadeB);


            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return vistoria;
    }

    public void editar(VistoriaBeans vistoria) {

        String sql = "update vistoriadoras set nome = ?, endereco = ?, numero = ?, bairro = ?, cep = ?,"
                + "cidade = ? where id = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, vistoria.getNome());
            st.setString(2, vistoria.getEndereco());
            st.setString(3, vistoria.getNumero());
            st.setString(4, vistoria.getBairro());
            st.setString(5, vistoria.getCep());
            if (vistoria.getCidade() == null) {
                st.setInt(6, 0);
            } else {
                st.setInt(6, vistoria.getCidade().getId());//Cidade é objeto e quero só id desse objeto
            }
            st.setInt(7, vistoria.getId());

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Editado com Sucesso", "Salvo", 1, new ImageIcon("Imagens/ok.png"));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void buscarTodasVistorias(DefaultTableModel Modelo) {
        try {
            String sql = "SELECT vistoriadoras.* , cidades.nome from vistoriadoras INNER JOIN cidades ON vistoriadoras.cidade = cidades.id";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Modelo.addRow(new Object[]{rs.getString("id"), rs.getString("nome"), rs.getString("responsavel"), rs.getString("cidades.nome")});
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }
    
        public void deletar(VistoriaBeans patio) {
        String sql = "delete from vistoriadoras where id = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setInt(1, patio.getId());
            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Deletado com Sucesso");
            Conexao.getConnection().commit();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    
} 
}
