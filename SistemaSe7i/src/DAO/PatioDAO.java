/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.CidadeBeans;
import Beans.PatioBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guilhermengenharia
 */
public class PatioDAO {

    public void cadastrar(PatioBeans patio) {

        String sql = "insert into patios(nome, endereco, numero, bairro, cep, "
                + "telefone, responsavel, cidade) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, patio.getNome());
            st.setString(2, patio.getEndereco());
            st.setString(3, patio.getNumero());
            st.setString(4, patio.getBairro());
            st.setString(5, patio.getCep());
            st.setString(6, patio.getTelefone());
            st.setString(7, patio.getResponsavel());
            if (patio.getCidade() == null) {
                st.setInt(8, 0);
            } else {
                st.setInt(8, patio.getCidade().getId());//Cidade é objeto e quero só id desse objeto
            }

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Salvo com Sucesso", "Salvo", 1, new ImageIcon("Imagens/ok.png"));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void buscarPatio(String Pesquisa, DefaultTableModel Modelo) {
        try {
            String sql = "select * from patios where nome like '%" + Pesquisa + "%' ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Modelo.addRow(new Object[]{rs.getString("id"), rs.getString("nome"), rs.getString("responsavel"), rs.getString("cidade")});
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public PatioBeans preencherCampos(int id) {
        PatioBeans patio = new PatioBeans();
        CidadeBeans cidade = new CidadeBeans();
        try {
            String sql = "select * from patios where id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                patio.setId(rs.getInt("id"));
                patio.setNome(rs.getString("nome"));
                patio.setEndereco(rs.getString("endereco"));
                patio.setNumero(rs.getString("numero"));
                patio.setBairro(rs.getString("bairo"));
                patio.setCep(rs.getString("cep"));
                patio.setTelefone(rs.getString("telefone"));
                cidade.setId(rs.getInt("cidade"));
                patio.setCidade(cidade);
                patio.setResponsavel(rs.getString("responsavel"));


            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return patio;
    }

    public void editar(PatioBeans patio) {

        String sql = "update patios set nome = ?, endereco =?, numero = ? bairro = ? cep = ? "
                + "telefone = ?, responsavel = ?, cidade = ? where id = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, patio.getNome());
            st.setString(2, patio.getEndereco());
            st.setString(3, patio.getNumero());
            st.setString(4, patio.getBairro());
            st.setString(5, patio.getCep());
            st.setString(6, patio.getTelefone());
            st.setString(7, patio.getResponsavel());
            if (patio.getCidade() == null) {
                st.setInt(8, 0);
            } else {
                st.setInt(8, patio.getCidade().getId());//Cidade é objeto e quero só id desse objeto
            }

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Editado com Sucesso", "Salvo", 1, new ImageIcon("Imagens/ok.png"));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void buscarTodosPatios(DefaultTableModel Modelo) {
        try {
            String sql = "select * from patios";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Modelo.addRow(new Object[]{rs.getString("id"), rs.getString("nome"), rs.getString("responsavel"), rs.getString("cidade")});
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }
    
        public void deletar(PatioBeans patio) {
        String sql = "delete from patios where id = ?";
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
