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

    public void CadastrarVeiculo(VeiculoBeans automovel) {
        String sqlInsertion = "insert into veiculos(placa, renavam, idModelo, cor, anoFabricacao, anoModelo, combustivel, categoria, tipo, especie, potencia, cilindrada,licenciamento, idCidade, dataCad)\n"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        //automovel.exibe();
        System.out.println("CADASTRANDO VEICULO");
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sqlInsertion);
            System.out.println("1111111");
            st.setString(1, automovel.getPlaca());
            st.setString(2, automovel.getRenavam());                        
            st.setInt(3,(modeloDAO.CarregarModelo(automovel.getModelo())).getId());          
            st.setString(4, automovel.getCor());
            st.setString(5, automovel.getAnoFab());
            System.out.println("2222222");
            st.setString(6, automovel.getAnoMod());
            st.setString(7, automovel.getCombustivel());
            st.setString(8, automovel.getCategoria());
            st.setString(9, automovel.getTipo());
            st.setString(10, automovel.getEspecie());
            st.setString(11, automovel.getPotencia());
            System.out.println("33333333");
            st.setString(12, automovel.getCilidrada());
            st.setString(13, Corretores.ConverterParaSQL(automovel.getLicenciamento()));
            System.out.println("444444444444");
            //automovel.exibe();
            automovel.getCidade().exibe();
            st.setInt(14, (cidadeDAO.carregarCidade(automovel.getCidade())).getId());
            System.out.println("55555555555555");
            st.setString(15, Corretores.DataAtual());
            System.out.println("66666666666");
            st.execute();
            Conexao.getConnection().commit();
            //JOptionPane.showMessageDialog(null, "Registro salvo ");
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
                System.out.println("!!!11111");
                veiculo.setChassiVeiculo(rs.getString("chassiVeiculo"));
                System.out.println("!!!!22222");
                veiculo.setMotorVeiculo(rs.getString("motorVeiculo"));
                veiculo.setModelo(modeloDAO.BuscarPorId(rs.getInt("idModelo")));
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
                System.out.println("!!!!3333");

                if (rs.getString("idCidade") == null) {
                    veiculo.setCidade(null);
                } else {
                    veiculo.setCidade(cidD.getCidadeId(rs.getInt("idCidade")));
                }

                System.out.println("!!!!!4444");
                veiculo.setDataCad(Corretores.ConverterParaJava(rs.getString("dataCad")));
                return veiculo;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao getVeiculo no banco: " + e);
        }
        return null;
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
        String sqlUpdate = "update veiculos set "
                + "placa  = ?, "
                + "renavam = ?, "
                + "idModelo = ?, "
                + "cor = ?, "
                + "anoFabricacao = ?, "
                + "anoModelo = ?, "
                + "combustivel = ?, "
                + "categoria = ?, "
                + "tipo = ?, "
                + "especie = ?, "
                + "potencia = ?, "
                + "cilindrada = ?, "
                + "licenciamento = ?, "
                + "idCidade = ? "
                + "where id = ?";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sqlUpdate);
            pst.setString(1, automovel.getPlaca());
            pst.setString(2, automovel.getRenavam());
            pst.setInt(3, automovel.getModelo().getId());
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
            System.out.println("????111");
            automovel.exibe();
            
            if (automovel.getCidade() == null) {
                pst.setString(14, null);
            } else {
                pst.setInt(14, automovel.getCidade().getId());
            }
            System.out.println("????2222");
            pst.setInt(15, automovel.getId());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado Com OK");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar Automovel no banco: " + e);
        }
    }
    
    
    
}
