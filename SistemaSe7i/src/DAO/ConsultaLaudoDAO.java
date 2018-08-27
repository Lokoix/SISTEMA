/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.LeilaoBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaLaudoDAO {

    public void buscarLeilaoConsulta(DefaultTableModel Modelo, LeilaoBeans leilao) {
        try {
            String sql = "select lotes.* , leiloes.descricao from lotes INNER JOIN leiloes ON lotes.idLeilao = leiloes.id where idLeilao = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setInt(1, leilao.getId());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("leiloes.descricao"));
                System.out.println(rs.getString("numeroLote"));
            Modelo.addRow(new Object[]{rs.getString("leiloes.descricao"), rs.getString("numeroLote")});
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar LeilaoConsultaDAO" + e);
        }

    }
}
