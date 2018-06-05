/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.MarcaBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael Piedade
 */
public class MarcaDAO {
    
    public void Cadastrar(MarcaBeans x) {
        String sqlInsertion = "insert into marcas (id, nome) value (?,?)";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sqlInsertion);
            st.setInt(1, x.getId());
            st.setString(2, x.getNome());
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro salvo ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao CADASTRAR Marca no banco: " + e);
        }
    }
    
    public void Buscar(MarcaBeans x){
        
    }
    
    
}
