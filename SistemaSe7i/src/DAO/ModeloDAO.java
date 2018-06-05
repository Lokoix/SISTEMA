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

    public void Cadastrar(ModeloBeans x) {
        String sqlInsertion = "insert into modelos (id, nome, idMarca) value (?,?,?)";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sqlInsertion);
            st.setInt(1, x.getId());
            st.setString(2, x.getNome());
            st.setInt(3, x.getMarca().getId());
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro salvo ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao CADASTRAR Modelo no banco: " + e);
        }
    }
    
    public ModeloBeans BuscarPorId(int x){
        String sqlSelect = "SELECT  modelos.id as modeloId, modelos.nome as modeloNome, marcas.id as marcaId, marcas.nome as marcaNome \n" +
"	FROM modelos, marcas WHERE modelos.idMarca = marcas.id AND modelos.id = ?; ";
        ModeloBeans modelo = null;
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sqlSelect);
            pst.setInt(1, x);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                modelo = new ModeloBeans();
                modelo.setId(rs.getInt("modeloid"));
                modelo.setNome(rs.getString("modeloNome"));
                modelo.setMarca(new MarcaBeans(rs.getInt("marcaId"), rs.getString("marcaNome")));
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro metodo dao getCidadeId: " + e);
        }
        return null;
    }
    
    
    
}
