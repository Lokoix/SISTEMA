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
                cidade = new CidadeBeans(rs.getInt("cidades.id"),rs.getString("cidades.nome"));
                cidade.getEstado().setId(rs.getInt("estados.id"));
                cidade.getEstado().setNome(rs.getString("estados.nome"));
                cidade.getEstado().setUf(rs.getString("estados.uf"));               
                return cidade;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro metodo dao getCidadeId: " + e);
        }
        return null;
    }

    /*public ArrayList<CidadeBeans> carregarCidades(String a) {// retorna uma lista das cidades que inicial com a string
        ArrayList<CidadeBeans> lista = new ArrayList<>();
        try {
            String sql = "select * from cidades, estados                \n"
                    + " where cidades.idEstado = estados.id and cidades.nome like ? order by cidades.nome ASC";
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setString(1, a + '%');
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cidade = new CidadeBeans(rs.getInt("cidades.id"),rs.getString("cidades.nome"));
                cidade.getEstado().setId(rs.getInt("estados.id"));
                cidade.getEstado().setNome(rs.getString("estados.nome"));
                cidade.getEstado().setUf(rs.getString("estados.uf")); 
                lista.add(cidade);
                cidade.exibe();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro metodo dao carregarCidade: " + e);
        }
        return lista;
    }*/

    public ArrayList<CidadeBeans> carregarCidades() {// retorna uma lista das cidades que inicial com a string
        ArrayList<CidadeBeans> lista = new ArrayList<>();
        try {
            String sql = "SELECT * from cidades INNER JOIN estados ON "
                    + "cidades.idEstado = estados.id order by cidades.nome ASC";
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cidade = new CidadeBeans(rs.getInt("cidades.id"),rs.getString("cidades.nome"));
                cidade.getEstado().setId(rs.getInt("estados.id"));
                cidade.getEstado().setNome(rs.getString("estados.nome"));
                //cidade.getEstado().setUf(rs.getString("estados.uf")); 
                lista.add(cidade);
                cidade.exibe();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro metodo dao carregarCidade: " + e);
        }
        return lista;
    }

    public boolean ExisteCidade(CidadeBeans a) {
        String sql = "select * from cidades where id = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setInt(1, a.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //JOptionPane.showMessageDialog(null, "boolean-municipio ja existe no sistema");
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro o verificar se cidade existe no BD: " + e);
        }
        return false;
    }

    public void Cadastrar(CidadeBeans x) {
        String sqlInsertion = "insert into cidades (nome, idEstado) value (?,?)";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sqlInsertion);
            st.setString(1, x.getNome());
            st.setInt(2, x.getEstado().getId());
            st.execute();
            Conexao.getConnection().commit();
            //JOptionPane.showMessageDialog(null, "Registro salvo ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao CADASTRAR cidade no banco: " + e);
        }
    }
    
    public CidadeBeans carregarCidade(CidadeBeans x) {
        String sql = "select * from cidades inner join estados on cidades.idEstado=estados.id where cidade.nome like ? and estados.uf like ?";
        try {//prsocura o modelo         
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setString(1, x.getNome() + '%');
            pst.setString(2, x.getEstado().getUf());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {//retorna a cidade encontrada
                CidadeBeans cidadeBs = new CidadeBeans(rs.getInt("cidades.id"), rs.getString("cidades.nome"));
                cidadeBs.setEstado(new EstadoBeans(rs.getInt("estados.id"), rs.getString("estados.nome"), rs.getString("estados.uf")));
                return cidadeBs;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Carregar cidade" + e);
        }
        //se não encontrar cidade, Carrega o estado e cadastra a cidade , retorna a função                                                       
        x.setEstado(estadoDAO.getEstadoId(x.getEstado()));
        this.Cadastrar(x);
        return this.carregarCidade(x);
    }

}
