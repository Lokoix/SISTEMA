/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.LoteBeans;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class LoteDAO {

    AutomovelController autC = new AutomovelController();
    ProprietarioController proC = new ProprietarioController();

    public boolean ExisteLote(LoteBeans a) {
        String sql = "select * from lotes where lot_num = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, a.getLote());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Lote " + a.getLote() + " ja existe no sistema");
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public Integer BuscaLote(LoteBeans lote) {
        String sql = "select * from lotes where lot_num = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, lote.getLote());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                System.out.println("Achou o lote");
                return Integer.parseInt(rs.getString("lot_id"));
            } else {
                //CadastrarProrietario(proprietario);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void AlterarLote(LoteBeans lote) {
        String sqlUpdate = "update lotes set lot_num = ?, lot_idAut = ?, lot_idProp = ?, lot_obs = ? where lot_id = ?";
        try {
            System.out.println("vvvvvvv");
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sqlUpdate);
            System.out.println("vvvvvvv");
            pst.setString(1, lote.getLote());
            System.out.println("vvvvvvv");

            pst.setInt(2, lote.getAutomovel().getCod());
            System.out.println("vvvvvvv");
            if (lote.getProprietario() == null) {
                System.out.println("vvvvvvv");
                pst.setInt(3, 0);
            } else {
                System.out.println("vvvvvvvff");
                pst.setInt(3, lote.getProprietario().getCod());
            }
            System.out.println("vvvvvvv");
            pst.setString(4, lote.getObservacao());
            System.out.println("vvvvvvv");
            pst.setInt(5, lote.getCod());
            System.out.println("vvvvvvv");

            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar LOTE no banco: " + e);
        }
    }

    public void cadastrarLote(LoteBeans lote) {//cad
        String sqlInsertion = "insert into lotes (lot_num, lot_idAut, lot_idProp, lot_obs) value (?,?,?,?)";
        System.out.println("33");
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sqlInsertion);
            st.setString(1, lote.getLote());
            st.setInt(2, lote.getAutomovel().getCod());
            if (lote.getProprietario() == null) {
                st.setString(3, null);
            } else {
                st.setInt(3, lote.getProprietario().getCod());
            }
            st.setString(4, lote.getObservacao());
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro salvo ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar lote no banco: " + e);
        }
    }

    public LoteBeans CarregarLoteBD(int id) {
        LoteBeans loteBD = new LoteBeans();
        String sql = "select * from lotes where lot_id = ?";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                loteBD.setCod(id);
                loteBD.setLote(rs.getString("lot_num"));
                int idA = rs.getInt("lot_idAut");
                Integer idP = rs.getInt("lot_idProp");
                loteBD.setAutomovel(autC.CarregarAutomovel(id));
                if (idP != null) {
                    loteBD.setProprietario(proC.CarregarProprietario(idP));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Carregar loteBD: " + e);
        }
        return loteBD;
    }
}
