/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Beans.EstadoBeans;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael Piedade
 */
public class EstadoDAO {

    private EstadoBeans estado = new EstadoBeans();

    public EstadoBeans carregar(EstadoBeans estado) {
        String sql = "Select * from estados where estados.uf like ?";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setString(1, estado.getUf());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                estado.setId(rs.getInt("id"));
                estado.setNome(rs.getString("nome"));
                return estado;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro EstadoDAO(carregar): " + e);
        }
        JOptionPane.showMessageDialog(null, "Estado não localizado! ", "Aviso", 1);
        return new EstadoBeans();
    }

    public boolean existe(EstadoBeans estado) {
        String sql = "select * from estados where estados.uf like ?";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setString(1, estado.getUf());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro EstadoDAO(existe): " + e);
        }
        return false;
    }
}
