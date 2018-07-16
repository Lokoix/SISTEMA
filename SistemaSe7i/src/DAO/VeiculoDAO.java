/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.CidadeBeans;
import Beans.VeiculoBeans;
import Controller.CidadeController;
import Controller.ModeloController;
import Utilitarios.Conexao;
import Utilitarios.Corretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class VeiculoDAO {

    CidadeController munC;
    ModeloDAO modeloDAO = new ModeloDAO();
    CidadeDAO cidadeDAO = new CidadeDAO();

    public void cadastrar(VeiculoBeans veiculo) {
        String sqlInsertion = "insert into veiculos(placa, renavam, idModelo, cor, anoFabricacao, anoModelo, combustivel, categoria, tipo, especie, potencia, cilindrada,licenciamento, idCidade, dataCad)\n"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sqlInsertion);
            st.setString(1, veiculo.getPlaca());
            st.setString(2, veiculo.getRenavam());
            st.setString(3, veiculo.getModelo().getId().toString());
            st.setString(4, veiculo.getCor());
            st.setString(5, veiculo.getAnoFab());
            st.setString(6, veiculo.getAnoMod());
            st.setString(7, veiculo.getCombustivel());
            st.setString(8, veiculo.getCategoria());
            st.setString(9, veiculo.getTipo());
            st.setString(10, veiculo.getEspecie());
            st.setString(11, veiculo.getPotencia());
            st.setString(12, veiculo.getCilidrada());
            st.setString(13, Corretores.ConverterParaSQL(veiculo.getLicenciamento()));
            st.setString(14, veiculo.getCidade().getId().toString());
            st.setString(15, Corretores.DataAtual());
            st.execute();
            Conexao.getConnection().commit();
            //JOptionPane.showMessageDialog(null, "Registro salvo ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro VeiculoDAO(cadastrar): " + e);
        }
    }

    public boolean existe(VeiculoBeans veiculo) {
        String sql = "select * from veiculos where placa = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, veiculo.getPlaca());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //JOptionPane.showMessageDialog(null, "Veiculo ja existe no sistema (placa)");
                return true;
            } else {
                sql = "select * from veiculos where chassiVeiculo = ?";
                try {
                    st = Conexao.getConnection().prepareStatement(sql);
                    st.setString(1, veiculo.getChassiVeiculo());
                    rs = st.executeQuery();
                    if (rs.next()) {
                        //JOptionPane.showMessageDialog(null, "Veiculo ja existe no sistema(chassiVeiculo)");
                        return true;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro VeiculoDAO(existe/chassiVeiculo): " + e);
                }
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro VeiculoDAO(existe/placa): " + e);
        }
        return false;
    }

    public VeiculoBeans getVeiculo(int id) {
        String sql = "select * from veiculos where id = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                VeiculoBeans veiculo = new VeiculoBeans();
                veiculo.setId(id);
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setRenavam(rs.getString("renavam"));
                veiculo.setChassiVeiculo(rs.getString("chassiVeiculo"));
                veiculo.setMotorVeiculo(rs.getString("motorVeiculo"));
                veiculo.setModelo(modeloDAO.carregarPorId(rs.getString("idModelo")));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setAnoFab(rs.getString("anoFabricacao"));
                veiculo.setAnoMod(rs.getString("anoModelo"));
                veiculo.setCombustivel(rs.getString("combustivel"));
                veiculo.setCategoria(rs.getString("categoria"));
                veiculo.setTipo(rs.getString("tipo"));
                veiculo.setEspecie(rs.getString("especie"));
                veiculo.setPotencia(rs.getString("potencia"));
                veiculo.setCilidrada(rs.getString("cilindrada"));
                veiculo.setLicenciamento(Corretores.ConverterParaJava(rs.getString("licenciamento")));

                if (rs.getString("idCidade") == null) {
                    veiculo.setCidade(null);
                } else {
                    veiculo.setCidade(cidadeDAO.getCidadeId(rs.getInt("idCidade")));
                }

                veiculo.setDataCad(Corretores.ConverterParaJava(rs.getString("dataCad")));
                return veiculo;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao getVeiculo no banco: " + e);
        }
        return null;
    }

    public VeiculoBeans carregar(VeiculoBeans veiculo) {
        String sql = "select * from veiculos where placa = ? ";//placa existe
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, veiculo.getPlaca());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                VeiculoBeans veiculoB = new VeiculoBeans();
                veiculoB.setId(rs.getInt("id"));
                veiculoB.setPlaca(rs.getString("placa"));
                veiculoB.setRenavam(rs.getString("renavam"));
                veiculoB.setChassiVeiculo(rs.getString("chassiVeiculo"));
                veiculoB.setMotorVeiculo(rs.getString("motorVeiculo"));
                veiculoB.setModelo(modeloDAO.carregarPorId(rs.getString("idModelo")));
                veiculoB.setCor(rs.getString("cor"));
                veiculoB.setAnoFab(Corretores.ano(rs.getString("anoFabricacao")));
                veiculoB.setAnoMod(Corretores.ano(rs.getString("anoModelo")));
                veiculoB.setCombustivel(rs.getString("combustivel"));
                veiculoB.setCategoria(rs.getString("categoria"));
                veiculoB.setTipo(rs.getString("tipo"));
                veiculoB.setEspecie(rs.getString("especie"));
                veiculoB.setPotencia(rs.getString("potencia"));
                veiculoB.setCilidrada(rs.getString("cilindrada"));
                veiculoB.setLicenciamento(Corretores.ConverterParaJava(rs.getString("licenciamento")));
                veiculoB.setCidade(cidadeDAO.carregarPorId(rs.getString("idCidade")));
                veiculoB.setDataCad(Corretores.ConverterParaJava(rs.getString("dataCad")));
                return veiculoB;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro VeiculoDAO(carregar): " + e);
        }
        return veiculo;
    }

    public Integer BuscarVeiculo(VeiculoBeans veiculo) {
        String sql = "select * from veiculos where placa = ?";//placa existe
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, veiculo.getPlaca());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
            return null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Automovel no banco: " + e);
        }
        return null;
    }// retorna o cod

    public void AlterarVeiculo(VeiculoBeans automovel) {
        automovel.exibe();
        String sqlUpdate = "update veiculos set placa  = ?,renavam = ?, idModelo = ?, cor = ?, anoFabricacao = ?, anoModelo = ?, "
                + "combustivel = ?, categoria = ?, tipo = ?, especie = ?, potencia = ?, cilindrada = ?, licenciamento = ?, "
                + "idCidade = ? where id = ?";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sqlUpdate);
            pst.setString(1, automovel.getPlaca());
            pst.setString(2, automovel.getRenavam());
            pst.setString(3, automovel.getModelo().getId().toString());
            pst.setString(4, automovel.getCor());
            pst.setString(5, automovel.getAnoFab());
            pst.setString(6, automovel.getAnoMod());
            pst.setString(7, automovel.getCombustivel());
            pst.setString(8, automovel.getCategoria());
            pst.setString(9, automovel.getTipo());
            pst.setString(10, automovel.getEspecie());
            pst.setString(11, automovel.getPotencia());
            pst.setString(12, automovel.getCilidrada());
            pst.setString(13, Corretores.ConverterParaSQL(automovel.getLicenciamento()));
            pst.setString(14, automovel.getCidade().getId().toString());         
            pst.setInt(15, automovel.getId());
            pst.executeUpdate();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Alterado Com OK");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar Automovel no banco: " + e);
        }
    }

}
