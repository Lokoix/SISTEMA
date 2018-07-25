/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.CidadeBeans;
import Beans.EstadoBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael Piedade
 */
public class CidadeDAO {

    private CidadeBeans cidade;
    private EstadoDAO estadoDAO = new EstadoDAO();

    public CidadeBeans getCidadeId(int id) {// retornar um CidadeBeans com o estado de acordo com o id
        String sql = "select * from cidades, estados \n"
                + "                     where cidades.idEstado = estados.id and cidades.id = ?;";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cidade = new CidadeBeans(rs.getInt("cidades.id"), rs.getString("cidades.nome"));
                cidade.getEstado().setId(rs.getInt("estados.id"));
                cidade.getEstado().setNome(rs.getString("estados.nome"));
                cidade.getEstado().setUf(rs.getString("estados.uf"));
                return cidade;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro CidadeDAO(getCidadeId): " + e);
        }
        return null;
    }

    public CidadeBeans carregarPorId(String id) {// retornar um CidadeBeans com o estado de acordo com o id
        String sql = "select * from cidades inner join estados on cidades.idEstado = estados.id and cidades.id = ?";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cidade = new CidadeBeans(rs.getInt("cidades.id"), rs.getString("cidades.nome"));
                cidade.getEstado().setId(rs.getInt("estados.id"));
                cidade.getEstado().setNome(rs.getString("estados.nome"));
                cidade.getEstado().setUf(rs.getString("estados.uf"));
                return cidade;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro CidadeDAO(getCidadeId): " + e);
        }
        return new CidadeBeans();
    }
    
    public ArrayList<CidadeBeans> carregarCidades() {// retorna uma lista das cidades que inicial com a string
        ArrayList<CidadeBeans> lista = new ArrayList<>();
        try {
            String sql = "SELECT * from cidades INNER JOIN estados ON "
                    + "cidades.idEstado = estados.id order by cidades.nome ASC";
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cidade = new CidadeBeans(rs.getInt("cidades.id"), rs.getString("cidades.nome"));
                cidade.getEstado().setId(rs.getInt("estados.id"));
                cidade.getEstado().setNome(rs.getString("estados.nome"));
                //cidade.getEstado().setUf(rs.getString("estados.uf")); 
                lista.add(cidade);
                cidade.exibe();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro metodo CidadeDAO(carregarCidades): " + e);
        }
        return lista;
    }

    public void cadastrar(CidadeBeans cidade) {
        String sqlInsertion = "insert into cidades (nome, idEstado) value (?,?)";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sqlInsertion);
            pst.setString(1, cidade.getNome());
            pst.setInt(2, cidade.getEstado().getId());
            pst.execute();
            Conexao.getConnection().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro CidadeDAO(cadastrar): " + e);
        }
    }

    public CidadeBeans carregar(CidadeBeans cidade) {
        String sql = "select * from cidades inner join estados on cidades.idEstado = estados.id where cidades.nome like ? and estados.uf like ?";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setString(1, cidade.getNome() + '%');
            pst.setString(2, cidade.getEstado().getUf());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {//retorna a cidade encontrada
                CidadeBeans cidadeBs = new CidadeBeans(rs.getInt("cidades.id"), rs.getString("cidades.nome"));
                cidadeBs.setEstado(new EstadoBeans(rs.getInt("estados.id"), rs.getString("estados.nome"), rs.getString("estados.uf")));
                return cidadeBs;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro CidadeDAO(carregar):" + e);
        }
        return new CidadeBeans();
    }

    public boolean existe(CidadeBeans cidade) {
        String sql = "select * from cidades inner join estados on cidades.idEstado = estados.id where cidades.nome like ? and estados.uf like ?";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setString(1, cidade.getNome() + '%');
            pst.setString(2, cidade.getEstado().getUf());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro CidadeDAO(existe): " + e);
        }
        return false;
    }

}
