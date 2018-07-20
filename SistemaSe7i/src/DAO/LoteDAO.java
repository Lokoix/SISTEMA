/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.LoteBeans;
import Controller.ProprietarioController;
import Controller.VeiculoController;
import Utilitarios.Conexao;
import Utilitarios.Corretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class LoteDAO {

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
        System.out.println("oshfoaololl");
        lote.exibe();
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
        String sqlInsertion = "insert into lotes (numeroLote, idLeilao, idProprietario, idVeiculo, motorBase, chassiBase, dataCad) values (?,?,?,?,?,?,?)";
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

            pst.setString(7, Corretores.DataAtual());

            pst.execute();
            Conexao.getConnection().commit();
            //JOptionPane.showMessageDialog(null, "Registro salvo ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro LoteDAO(cadastrar): " + e);
        }
    }

}
