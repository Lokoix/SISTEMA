/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.MarcaBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael Piedade
 */
public class MarcaDAO {

    public void cadastrar(MarcaBeans marca) {
        String sqlInsertion = "insert into marcas (nome) value (?)";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sqlInsertion);
            st.setString(1, marca.getNome());
            st.executeUpdate();
            Conexao.getConnection().commit();           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro MarcaDAO(cadastrar): " + e);
        }
    }

    public MarcaBeans carregar(MarcaBeans marca) {
        String sqlInsertion = "select * from marcas where nome like ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sqlInsertion);
            st.setString(1, marca.getNome());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new MarcaBeans(rs.getInt("id"), rs.getString("nome"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro MarcaDAO(carregar): " + e);
        }
        return new MarcaBeans();
    }
    
    public boolean existe(MarcaBeans marca){
        String sql = "select * from marcas where nome like ?";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setString(1, marca.getNome());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro MarcaDAO(existe): " + e);
        }
        return false;
    }
    

    /*public MarcaBeans CarregarMarca(MarcaBeans x) {
        String sql = "select * from marcas where marcas.nome like ?";
        try {//procura a marca           
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setString(1, x.getNome());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {//se existe a marca, retorna                  
                return new MarcaBeans(rs.getInt("id"), rs.getString("nome"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Carregar marca: " + e);
        }
        // se não existe a marca então cadastra, E retorna a mesma função procurando a marca
        this.Cadastrar(x);
        return this.CarregarMarca(x);
    }*/
}
