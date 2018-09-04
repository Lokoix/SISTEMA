/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Restricoes.RestricaoBloqueioBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class RestricaoBloqueioDAO {

    public boolean existe(RestricaoBloqueioBeans restricao) {
        String sql = "select * from restricoesBloqueio where idLote = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setInt(1, restricao.getLote().getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //JOptionPane.showMessageDialog(null, "Lote " + a.getLote() + " ja existe no sistema");
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro RestricoesBloqueioDAO(existe): " + e);
        }
        return false;
    }

    public RestricaoBloqueioBeans carregar(RestricaoBloqueioBeans restricao) {
        RestricaoBloqueioBeans base = new RestricaoBloqueioBeans();
        String sql = "select * from restricoesBloqueio where idLote = ?";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setInt(1, restricao.getLote().getId());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                base.setId(rs.getInt("id"));

                if (rs.getString("idBloqueio") != null) {
                    base.getBloqueio().setId(rs.getInt("idBloqueio"));
                }

                base.getLote().setId(rs.getInt("idLote"));

                base.setProtocolo(rs.getString("protocolo"));
                base.setProcesso(rs.getString("processo"));
                base.setAutoridade(rs.getString("autoridade"));
                base.setOficio(rs.getString("oficio"));
                base.setLaudo(rs.getString("laudo"));
                base.setOrgaoExpedidor(rs.getString("orgaoExpedidor"));
                base.setDescricao(rs.getString("descricao"));
                base.setMunicipioBloqueio(rs.getString("municipioBloqueio"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro RestricoesBloqueioDAO(carregar): " + e);
        }

        return base;
    }

    public void cadastrar(RestricaoBloqueioBeans restricao) {
        System.out.println("ep1");
        String sqlInsertion = "insert into restricoesbloqueio (idBloqueio, idLote, protocolo, processo, autoridade, oficio, laudo, orgaoExpedidor, descricao, municipioBloqueio) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sqlInsertion);

            System.out.println("ep");
            if (restricao.getBloqueio().getId() != null) {
                pst.setInt(1, restricao.getBloqueio().getId());
            } else {
                pst.setNull(1, Types.NULL);
            }

            System.out.println("ep3");
            pst.setInt(2, restricao.getLote().getId());
            System.out.println("ep4");
            pst.setString(3, restricao.getProtocolo());
            System.out.println("ep5");
            pst.setString(4, restricao.getProcesso());
            System.out.println("ep6");
            pst.setString(5, restricao.getAutoridade());
            pst.setString(6, restricao.getOficio());
            pst.setString(7, restricao.getLaudo());
            pst.setString(8, restricao.getOrgaoExpedidor());
            pst.setString(9, restricao.getDescricao());
            pst.setString(10, restricao.getMunicipioBloqueio());

            pst.execute();
            Conexao.getConnection().commit();
            //JOptionPane.showMessageDialog(null, "Registro salvo ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro RestricaoBloqueioDAO(cadastrar): " + e);
        }
    }
}
