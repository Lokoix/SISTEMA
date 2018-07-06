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
    
    public EstadoBeans getEstadoId(EstadoBeans x){
        String sql = "Select * from estados where uf like ?";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setString(1, x.getUf());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                x.setId(rs.getInt("id"));               
                x.setNome(rs.getString("nome"));
                return x;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao usar getEstado: " + e);
        }
        JOptionPane.showMessageDialog(null, "PROBLEMA FATAL, UF DE ESTADO NAO LOCALIZADO ");
        return null;
    }
    
    
}
