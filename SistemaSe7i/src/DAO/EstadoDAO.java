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
    
    public EstadoBeans getEstadoId(int id){
        String sql = "Select * from estados where id = ?";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                estado.setId(rs.getInt("id"));
                estado.setNome(rs.getString("nome"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao usar getEstado: " + e);
        }
        return estado;
    }
    
    
}
