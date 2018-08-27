/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.LoteBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class PesquisaDAO {
    
    public boolean existe(int idleilao, String numLote, String desc) {
        System.out.println("existe:"
                + "\nidLeilao: "+idleilao
                + "\nnumLote: "+numLote
                + "\ndesc: "+desc);
        String sql = "select * from pesquisas where idLeilao = ? and numeroLote = ? and descricao = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setInt(1, idleilao);
            st.setString(2, numLote);
            st.setString(3, desc);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {           
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro PesquisaDAO(existe): " + e);
        }
        return false;
    }
    
    public void cadastrar(LoteBeans lote, String desc, String caminho) {
        String sqlInsertion = "insert into pesquisas (numeroLote, idLeilao, caminho, descricao) value (?,?,?,?)";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sqlInsertion);
            st.setString(1, lote.getNumeroLote());
            st.setInt(2, lote.getLeilao().getId());
            st.setString(3, caminho);
            st.setString(4, desc);
            st.execute();
            Conexao.getConnection().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ModeloDAO(cadastrar): " + e);
        }
    }
}
