/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.MarcaBeans;
import Beans.ModeloBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael Piedade
 */
public class ModeloDAO {

    public void cadastrar(ModeloBeans modelo) {
        String sqlInsertion = "insert into modelos (nome, idMarca) value (?,?)";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sqlInsertion);
            st.setString(1, modelo.getNome());
            st.setInt(2, modelo.getMarca().getId());
            st.execute();
            Conexao.getConnection().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ModeloDAO(cadastrar): " + e);
        }
    }

    public boolean existe(ModeloBeans modelo) {
        String sql = "select * from modelos inner join marcas on modelos.idMarca = marcas.id where modelos.nome like ? and marcas.nome like ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, modelo.getNome());
            st.setString(2, modelo.getMarca().getNome());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ModeloDAO(existe): " + e);
        }
        return false;
    }

    public ModeloBeans carregar(ModeloBeans modelo) {
        String sql = "select * from modelos inner join marcas on modelos.idMarca = marcas.id where modelos.nome like ? and marcas.nome like ?";
        try {//procura o modelo         
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setString(1, modelo.getNome());
            pst.setString(2, modelo.getMarca().getNome());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {//retorna o modelo encontrado
                ModeloBeans modeloBs = new ModeloBeans(rs.getInt("modelos.id"), rs.getString("modelos.nome"));
                modeloBs.setMarca(new MarcaBeans(rs.getInt("idMarca"), rs.getString("marcas.nome")));
                return modeloBs;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ModeloDAO(carregar)" + e);
        }
        return new ModeloBeans();
    }

    public ModeloBeans carregarPorId(String id) {     
        String sqlSelect = "select * from modelos inner join marcas on modelos.idMarca = marcas.id where modelos.id = ?";
        ModeloBeans modelo = new ModeloBeans();
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sqlSelect);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                modelo.setId(rs.getInt("modelos.id"));
                modelo.setNome(rs.getString("modelos.nome"));
                modelo.getMarca().setId(rs.getInt("marcas.id"));
                modelo.getMarca().setNome(rs.getString("marcas.nome"));
                return modelo;
            }        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ModeloDAO(carregarPorId): " + e);
        }
        return modelo;
    }
}
