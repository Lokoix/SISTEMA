/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.VeiculoBeans;
import Controller.CidadeController;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class VeiculoDAO {
    CidadeController munC;

    public void CadastrarAutomovel(AutomovelBeans automovel) {
        String sqlInsertion = "insert into automoveis (aut_placa, aut_renavam, aut_chassi, aut_chassiBase, aut_marca, aut_cor, aut_modelo, aut_fab, aut_comb,"
                + " aut_motor, aut_motorBase, aut_especie, aut_tipo, aut_lic, aut_idCidade) value (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sqlInsertion);
            st.setString(1, automovel.getPlaca());
            System.out.println("!");
            st.setString(2, automovel.getRenavan());
            System.out.println("!");
            st.setString(3, automovel.getChassiVeiculo());
            System.out.println("!");
            st.setString(4, automovel.getChassiBase());
            System.out.println("!");
            st.setString(5, automovel.getMarca());
            System.out.println("!");
            st.setString(6, automovel.getCor());
            System.out.println("!");
            st.setString(7, automovel.getModelo());
            System.out.println("!");
            st.setString(8, automovel.getFabricacao());
            System.out.println("!");
            st.setString(9, automovel.getCombustivel());
            System.out.println("!");
            st.setString(10, automovel.getMotorVeiculo());
            st.setString(11, automovel.getMotorBase());
            st.setString(12, automovel.getEspec());
            st.setString(13, automovel.getTipo());
            st.setString(14, automovel.getLicenciamento());
            if (automovel.getMunicipio() != null) {
                st.setInt(15, automovel.getMunicipio().getId());
            } else {
                st.setInt(15, 0);
            }

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro salvo ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Automovel no banco: " + e);
        }
    }

    public boolean ExisteVeiculo(VeiculoBeans a) {
        String sql = "select * from veiculos where placa = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, a.getPlaca());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Veiculo ja existe no sistema");
                return true;
            } else {
                sql = "select * from veiculos where chassiVeiculo = ?";
                try {
                    st = Conexao.getConnection().prepareStatement(sql);
                    st.setString(1, a.getChassiVeiculo());
                    rs = st.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Veiculo ja existe no sistema");
                        return true;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public Integer BuscarVeiculo(VeiculoBeans veiculo) {
        String sql = "select * from veiculos where placa = ?";//placa existe
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, veiculo.getPlaca());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return Integer.parseInt(rs.getString("id"));
            } else {
                sql = "select * from veiculos where chassiVeiculo = ?";//chassi existe
                try {
                    st = Conexao.getConnection().prepareStatement(sql);
                    st.setString(1, veiculo.getChassiVeiculo());
                    rs = st.executeQuery();
                    if (rs.next()) {
                        return Integer.parseInt(rs.getString("id"));
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao buscar veiculo no banco: " + e);
                }
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Automovel no banco: " + e);
        }
        return null;
    }// retorna o cod

    
    public void AlterarCarro(AutomovelBeans automovel) {
        String sqlUpdate = "update automoveis set aut_placa = ?, aut_renavam = ?, aut_chassi = ?, aut_chassiBase = ?, aut_marca = ?, aut_cor = ?, aut_modelo = ?, aut_fab = ?, aut_comb = ?, aut_motor = ?, aut_motorBase = ?, aut_especie = ?, aut_tipo = ?, aut_lic = ?, aut_idCidade = ? where aut_id = ?";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sqlUpdate);
            pst.setString(1, automovel.getPlaca());
            pst.setString(2, automovel.getRenavan());
            pst.setString(3, null);
            pst.setString(4, automovel.getChassiBase());
            pst.setString(5, automovel.getMarca());
            pst.setString(6, automovel.getCor());
            pst.setString(7, automovel.getModelo());
            pst.setString(8, automovel.getFabricacao());
            pst.setString(9, automovel.getCombustivel());
            pst.setString(10, null);
            pst.setString(11, automovel.getMotorBase());
            pst.setString(12, automovel.getEspec());
            pst.setString(13, automovel.getTipo());
            pst.setString(14, automovel.getLicenciamento());
            JOptionPane.showMessageDialog(null,automovel.getCod() + " DAODAO:" + automovel.getLicenciamento());
            if (automovel.getMunicipio() != null) {
                pst.setString(15, automovel.getMunicipio().getCod());
            } else {
                pst.setInt(15, 0);
            }
            pst.setInt(16, automovel.getCod());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado Com OK");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar Automovel no banco: " + e);
        }
    }
}
