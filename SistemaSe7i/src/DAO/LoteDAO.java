/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.LeilaoBeans;
import Beans.LoteBeans;
import Controller.ProprietarioController;
import Controller.VeiculoController;
import Utilitarios.Conexao;
import Utilitarios.Corretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class LoteDAO {

    DecimalFormat df = new DecimalFormat("0.##");
    VeiculoController conVeiculo = new VeiculoController();
    VeiculoDAO daoVeiculo = new VeiculoDAO();
    ProprietarioController conProprietario = new ProprietarioController();

    public boolean existe(LoteBeans lote) {
        String sql = "select * from lotes where numeroLote = ? and idLeilao = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, lote.getNumeroLote());
            st.setInt(2, lote.getLeilao().getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //JOptionPane.showMessageDialog(null, "Lote " + a.getLote() + " ja existe no sistema");
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro LoteDAO(existe): " + e);
        }
        return false;
    }

    public LoteBeans carregar(LoteBeans lote) {
        LoteBeans base = new LoteBeans();
        String sql = "select * from lotes where numeroLote = ? and idLeilao = ?";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setString(1, lote.getNumeroLote());
            pst.setInt(2, lote.getLeilao().getId());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                base.setId(rs.getInt("id"));
                base.setNumeroLote(rs.getString("numeroLote"));
                base.getLeilao().setId(rs.getInt("idLeilao"));

                if (rs.getString("idProprietario") != null) {
                    base.getProprietario().setId(rs.getInt("idProprietario"));
                }

                if (rs.getString("idVeiculo") != null) {
                    base.getVeiculo().setId(rs.getInt("idVeiculo"));
                }

                base.setMotorBase(rs.getString("motorBase"));
                base.setChassiBase(rs.getString("chassiBase"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro LoteDAO(carregar): " + e);
        }

        return base;
    }

    public void alterar(LoteBeans lote) {
        String sqlUpdate = "update lotes set idProprietario = ?, idVeiculo = ?, motorBase = ?, chassiBase = ?, observacao = ? where id = ?";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sqlUpdate);

            //Proprietario
            if (lote.getProprietario().getId() != null) {
                pst.setInt(1, lote.getProprietario().getId());
            } else {
                pst.setNull(1, Types.NULL);
            }

            //Veiculo
            if (lote.getVeiculo().getId() != null) {
                pst.setInt(2, lote.getVeiculo().getId());
            } else {
                pst.setNull(2, Types.NULL);
            }

            //Motor Base
            pst.setString(3, lote.getMotorBase());
            //Chassi Base
            pst.setString(4, lote.getChassiBase());
            //obs
            pst.setString(5, lote.getObservacao());
            //id
            pst.setInt(6, lote.getId());
            pst.executeUpdate();
            Conexao.getConnection().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro LoteDAO(alterar):\n" + e);
        }
    }

    public void cadastrar(LoteBeans lote) {//cad
        String sqlInsertion = "insert into lotes (numeroLote, idLeilao, idProprietario, idVeiculo, motorBase, chassiBase, observacao, dataCad) values (?,?,?,?,?,?,?,?)";
        lote.exibe();
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sqlInsertion);
            pst.setString(1, lote.getNumeroLote());
            pst.setInt(2, lote.getLeilao().getId());

            //Proprietario
            if (lote.getProprietario().getId() != null) {
                pst.setInt(3, lote.getProprietario().getId());
            } else {
                pst.setNull(3, Types.NULL);
            }

            //Veiculo
            if (lote.getVeiculo().getId() != null) {
                pst.setInt(4, lote.getVeiculo().getId());
            } else {
                pst.setNull(4, Types.NULL);
            }

            pst.setString(5, lote.getMotorBase());

            pst.setString(6, lote.getChassiBase());

            pst.setString(7, lote.getObservacao());
            
            pst.setString(8, Corretores.DataAtual());

            pst.execute();
            Conexao.getConnection().commit();
            //JOptionPane.showMessageDialog(null, "Registro salvo ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro LoteDAO(cadastrar): " + e);
        }
    }

    public ArrayList<LoteBeans> buscarTodosLotesDoLeilao(LeilaoBeans leilao) {
        ArrayList<LoteBeans> lotes = new ArrayList<>();
        LoteBeans lote;
        try {
            String sql = "SELECT lotes.*, veiculos.placa, veiculos.fipe, veiculos.debito, marcas.nome, modelos.nome FROM lotes, veiculos, marcas, modelos WHERE lotes.idVeiculo = veiculos.id "
                    + "AND veiculos.idModelo = modelos.id AND modelos.idMarca = marcas.id AND lotes.idLeilao = ? order by lotes.numeroLote ASC";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setInt(1, leilao.getId());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lote = new LoteBeans();
                lote.setId(rs.getInt("id"));
                lote.setNumeroLote(rs.getString("numeroLote"));
                System.out.println(lote.getNumeroLote());
                lote.getLeilao().setId(rs.getInt("idLeilao"));
                lote.getProprietario().setId(rs.getInt("idProprietario"));
                lote.getVeiculo().setId(rs.getInt("idVeiculo"));
                lote.getVeiculo().setPlaca(rs.getString("veiculos.placa"));
                lote.getVeiculo().getModelo().setNome(rs.getString("modelos.nome"));
                lote.getVeiculo().getModelo().getMarca().setNome(rs.getString("marcas.nome"));
                lote.getComunicao().setId(rs.getInt("idComunicacao"));
                lote.getAlienacao().setId(rs.getInt("idAlienacao"));
                lote.setDataCad(rs.getDate("dataCad").toString());
                lote.setObservacao(rs.getString("observacao"));
                lote.setMotorBase(rs.getString("motorBase"));
                lote.setChassiBase(rs.getString("chassiBase"));
                lote.getVeiculo().setFipe(rs.getBigDecimal("veiculos.fipe"));
                lote.getVeiculo().setDebito(rs.getBigDecimal("veiculos.debito"));
               
                lotes.add(lote);
            }
        } catch (Exception e) {
        }
        return lotes;
    }

}
