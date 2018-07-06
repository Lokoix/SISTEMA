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

    MarcaDAO marcaDAO = new MarcaDAO();

    public void Cadastrar(ModeloBeans x) {
        String sqlInsertion = "insert into modelos (nome, idMarca) value (?,?)";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sqlInsertion);
            st.setString(1, x.getNome());
            st.setInt(2, x.getMarca().getId());
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro salvo ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao CADASTRAR Modelo no banco: " + e);
        }
    }

    /*public ModeloBeans BuscarPorId(int x) {
        String sqlSelect = "SELECT  modelos.id as modeloId, modelos.nome as modeloNome, marcas.id as marcaId, marcas.nome as marcaNome \n"
                + "	FROM modelos, marcas WHERE modelos.idMarca = marcas.id AND modelos.id = ?; ";
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
    }*/

    public boolean Existe(ModeloBeans x) {
        String sql = "select * from modelos where nome like ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, x.getNome());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro o verificar se cidade existe no BD: " + e);
        }
        return false;
    }

    public ModeloBeans CarregarModelo(ModeloBeans x) {
        String sql = "select * from modelos inner join marcas on modelos.idMarca=marcas.id where modelos.nome like ?";
        try {//prsocura o modelo         
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setString(1, x.getNome());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {//retorna o modelo encontrado
                ModeloBeans modeloBs = new ModeloBeans(rs.getInt("modelos.id"), rs.getString("modelos.nome"));
                modeloBs.setMarca(new MarcaBeans(rs.getInt("idMarca"), rs.getString("marcas.nome")));
                return modeloBs;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Carregar modelo" + e);
        }
        //se não encontrar modelo, Carrega a marca e cadastra o modelo , retorna a função                                                
        x.setMarca(marcaDAO.CarregarMarca(x.getMarca()));
        this.Cadastrar(x);
        return this.CarregarModelo(x);
    }

}
