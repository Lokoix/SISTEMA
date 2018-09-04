/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Restricoes.BloqueioBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class BloqueioDAO {
    
    
    public void cadastrar(BloqueioBeans bloqueio) {
        String sqlInsertion = "insert into bloqueios (descricao) value (?)";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sqlInsertion);
            st.setString(1, bloqueio.getDescricao());
            st.executeUpdate();
            Conexao.getConnection().commit();           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro BloqueioDAO(cadastrar): " + e);
        }
    }

    public BloqueioBeans carregar(BloqueioBeans marca) {
        String sqlInsertion = "select * from bloqueios where descricao like ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sqlInsertion);
            st.setString(1, marca.getDescricao());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new BloqueioBeans(rs.getInt("id"), rs.getString("descricao"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro BloqueioDAO(carregar): " + e);
        }
        return new BloqueioBeans();
    }
    
    public boolean existe(BloqueioBeans bloqueio){
        String sql = "select * from bloqueios where descricao like ?";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setString(1, bloqueio.getDescricao());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro BloqueioDAOs(existe): " + e);
        }
        return false;
    }
}
