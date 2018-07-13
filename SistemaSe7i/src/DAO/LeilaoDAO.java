/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.CidadeBeans;
import Beans.LeilaoBeans;
import Beans.LeiloeiroBeans;
import Beans.PatioBeans;
import Beans.VistoriaBeans;
import Utilitarios.Conexao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class LeilaoDAO {

    public void cadastrar(LeilaoBeans leilao) {

        String sql = "insert into leiloes(descricao, dataInicio, dataPrevista, edital, custoLaudo, desvDoc, desvSemDoc, desvSucata,"
                + "cartaNotificacao, idVistoria, idPatio, idCidade, idLeiloeiro) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, leilao.getDescricao());
            st.setDate(2, (Date) leilao.getDataInicio());
            st.setDate(3, (Date) leilao.getDataPrevista());
            st.setString(4, leilao.getEdital());
            st.setDouble(5, leilao.getCustoLaudo());
            st.setDouble(6, leilao.getDesvComDoc());
            st.setDouble(7, leilao.getDesvSemDoc());
            st.setDouble(8, leilao.getDesvSucata());
            st.setString(9, leilao.getCartaDeNotificacao());
            if (leilao.getVistoriadora() == null) {
                st.setInt(10, 0);
            } else {
                st.setInt(10, leilao.getVistoriadora().getId());
            }
            if (leilao.getPatio() == null) {
                st.setInt(11, 0);
            } else {
                st.setInt(11, leilao.getPatio().getId());
            }
            if (leilao.getCidade() == null) {
                st.setInt(12, 0);
            } else {
                st.setInt(12, leilao.getCidade().getId());
            }
            if (leilao.getLeiloeiro() == null) {
                st.setInt(13, 0);
            } else {
                st.setInt(13, leilao.getLeiloeiro().getId());
            }

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Salvo com Sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro cadastrarDAO" + e);
        }

    }

    public void editar(LeilaoBeans leilao) {

        String sql = "update leiloes set descricao = ?, dataInicio = ?, dataPrevista = ?, edital = ?, custoLaudo = ?, desvDoc,"
                + "desvSemDoc = ?, desvSucata = ?, cartaNotificacao = ?, idVistoria = ?, idPatio = ?, idCidade= ?, "
                + "idLeiloeiro = ? where id = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, leilao.getDescricao());
            st.setDate(2, (Date) leilao.getDataInicio());
            st.setDate(3, (Date) leilao.getDataPrevista());
            st.setString(4, leilao.getEdital());
            st.setDouble(5, leilao.getCustoLaudo());
            st.setDouble(6, leilao.getDesvComDoc());
            st.setDouble(7, leilao.getDesvSemDoc());
            st.setDouble(8, leilao.getDesvSucata());
            st.setString(9, leilao.getCartaDeNotificacao());
            if (leilao.getVistoriadora() == null) {
                st.setInt(10, 0);
            } else {
                st.setInt(10, leilao.getVistoriadora().getId());
            }
            if (leilao.getPatio() == null) {
                st.setInt(11, 0);
            } else {
                st.setInt(11, leilao.getPatio().getId());
            }
            if (leilao.getCidade() == null) {
                st.setInt(12, 0);
            } else {
                st.setInt(12, leilao.getCidade().getId());
            }
            if (leilao.getLeiloeiro() == null) {
                st.setInt(13, 0);
            } else {
                st.setInt(13, leilao.getLeiloeiro().getId());
            }

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Editado com Sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro eidtarDao" + e);
        }

    }

    public void deletar(LeilaoBeans leilao) {
        String sql = "delete from leiloes where id = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setInt(1, leilao.getId());
            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Deletado com Sucesso");
            Conexao.getConnection().commit();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível deletar registro");
        }
    }

    public void buscarLeilao(String Pesquisa, DefaultTableModel Modelo) {
        try {
            String sql = "select * from leiloes where descricao like '%" + Pesquisa + "%' ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Modelo.addRow(new Object[]{rs.getString("id"), rs.getString("descricao"), rs.getString("idLeiloeiro"), rs.getString("idPatio"), rs.getString("idCidade"), rs.getString("edital")});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar LeilaoDAO" + e);
        }

    }

    public void buscarTodosLeiloes(DefaultTableModel Modelo) {
        try {
            String sql = "SELECT leiloes.* , leiloeiros.nome, patios.nome, cidades.nome from leiloes INNER JOIN leiloeiros ON leiloes.idLeiloeiro = leiloeiros.id"
                    + " INNER JOIN patios ON leiloes.idPatio = patios.id INNER JOIN cidades ON leiloes.idCidade = cidades.id";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Modelo.addRow(new Object[]{rs.getString("id"), rs.getString("descricao"), rs.getString("leiloeiros.nome"), rs.getString("patios.nome"), rs.getString("cidades.nome"), rs.getString("edital")});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar todos LeiloesDAO" + e);
        }

    }

    public LeilaoBeans preencherCampos(int id) {
        LeilaoBeans leilao = new LeilaoBeans();
        VistoriaBeans vistoria = new VistoriaBeans();
        PatioBeans patio = new PatioBeans();
        CidadeBeans cidade = new CidadeBeans();
        LeiloeiroBeans leiloeiro = new LeiloeiroBeans();
        try {
            String sql = "select * from leiloes where id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                leilao.setId(rs.getInt("id"));
                leilao.setDescricao(rs.getString("descricao"));
                leilao.setDataInicio(rs.getDate("dataInicio"));
                leilao.setDataPrevista(rs.getDate("dataPrevista"));
                leilao.setEdital(rs.getString("edital"));
                leilao.setCustoLaudo(rs.getDouble("custoLaudo"));
                leilao.setDesvComDoc(rs.getDouble("desvDoc"));
                leilao.setDesvSemDoc(rs.getDouble("desvSemDoc"));
                leilao.setDesvSucata(rs.getDouble("desvSucata"));
                leilao.setCartaDeNotificacao(rs.getString("cartaNotificacao"));
                vistoria.setId(rs.getInt("idVistoria"));
                leilao.setVistoriadora(vistoria);
                patio.setId(rs.getInt("idPatio"));
                leilao.setPatio(patio);
                cidade.setId(rs.getInt("idCidade"));
                leilao.setCidade(cidade);
                leiloeiro.setId(rs.getInt("idLeiloeiro"));
                leilao.setLeiloeiro(leiloeiro);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher camposDAO" + e);
        }
        return leilao;
    }
}
