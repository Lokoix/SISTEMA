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

    public CidadeBeans getCidadeId(int id) {// retornar um CidadeBeans com o estado de acordo com o id
        String sql = "select cidades.id as idCidade, cidades.nome as nomeCidade, estados.id as idEstado, estados.nome as nomeEstado \n"
                + "                           from cidades, estados \n"
                + "                     where cidades.idEstado = estados.id and cidades.id = ?;";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cidade = new CidadeBeans();
                cidade.setId(rs.getInt("idCidade"));
                cidade.setNome(rs.getString("nomeCidade"));
                cidade.setEstado(new EstadoBeans(rs.getInt("idEstado"), rs.getString("nomeEstado")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro metodo dao getCidadeId: " + e);
        }
        return cidade;
    }

    public ArrayList<CidadeBeans> carregarCidades(String a) {// retorna uma lista das cidades que inicial com a string
        ArrayList<CidadeBeans> lista = new ArrayList<>();
        try {
            String sql = "select cidades.id as idCidade, cidades.nome as nomeCidade, estados.id as idEstado, estados.nome as nomeEstado \n"
                    + " from cidades, estados                \n"
                    + " where cidades.idEstado = estados.id and cidades.nome like ? order by cidades.nome ASC";
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setString(1, a + '%');
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cidade = new CidadeBeans();
                cidade.setId(rs.getInt("idCidade"));
                cidade.setNome(rs.getString("nomeCidade"));
                cidade.setEstado(new EstadoBeans(rs.getInt("idEstado"), rs.getString("nomeEstado")));
                lista.add(cidade);
                cidade.exibe();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro metodo dao carregarCidade: " + e);
        }
        return lista;
    }

    public ArrayList<CidadeBeans> carregarCidades() {// retorna uma lista das cidades que inicial com a string
        ArrayList<CidadeBeans> lista = new ArrayList<>();
        try {
            String sql = "SELECT cidades.* , estados.nome from cidades INNER JOIN estados ON "
                    + "cidades.idEstado = estados.id order by cidades.nome ASC";
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cidade = new CidadeBeans();
                cidade.setId(rs.getInt("id"));
                cidade.setNome(rs.getString("nome"));
                cidade.setEstado(new EstadoBeans(rs.getInt("id"), rs.getString("estados.nome")));
                lista.add(cidade);
                cidade.exibe();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro metodo dao carregarCidade: " + e);
        }
        return lista;
    }

}
