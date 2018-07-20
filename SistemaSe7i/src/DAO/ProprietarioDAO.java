/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.ProprietarioBeans;
import Controller.CidadeController;
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
public class ProprietarioDAO {

    CidadeController conCidade = new CidadeController();
    CidadeDAO daoCidade = new CidadeDAO();

    public void cadastrar(ProprietarioBeans proprietario) {
        String sqlInsertion = "insert into proprietarios (nome, cpfCnpj, rg, complemento, endereco, endNumero, bairro, cep, idCidade, dataCad) values (?,?,?,?,?,?,?,?,?,?)";
        proprietario.exibe();
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sqlInsertion);

            st.setString(1, proprietario.getNome());
            st.setString(2, proprietario.getCpfCpnpj());
            st.setString(3, proprietario.getRg());
            st.setString(4, proprietario.getComplemento());

            st.setString(5, proprietario.getEndereco());
            st.setString(6, proprietario.getEndNumero());
            st.setString(7, proprietario.getBairro());
            st.setString(8, proprietario.getCep());
            
            //cidade
            if (proprietario.getCidade().getId() != null) {
                 st.setInt(9, proprietario.getCidade().getId());
            }else{
                st.setNull(9, Types.NULL);
            }
            System.out.println("rtyfghrty");
            
            st.setString(10, Corretores.DataAtual());
            st.execute();
            Conexao.getConnection().commit();
            // JOptionPane.showMessageDialog(null, "Registro salvo ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ProprietarioDAO(cadastrar): " + e);
        }
    }

    public boolean existe(ProprietarioBeans proprietario) {
        String sql = "select * from proprietarios where cpfCnpj like ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, proprietario.getCpfCpnpj());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                sql = "select * from proprietarios where rg like ?";
                try {
                    st = Conexao.getConnection().prepareStatement(sql);
                    st.setString(1, proprietario.getRg());
                    rs = st.executeQuery();
                    if (rs.next()) {
                        return true;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ProprietarioDAO(existe rg): " + e);
                }
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ProprietarioDAO(existe cpf/cnpj): " + e);
        }
        return false;
    }

    public ProprietarioBeans carregar(ProprietarioBeans proprietario) {
        String sql = "select * from proprietarios where cpfCnpj like ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, proprietario.getCpfCpnpj());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                ProprietarioBeans proB = new ProprietarioBeans();
                proB.setId(rs.getInt("id"));
                proB.setNome(rs.getString("nome"));
                proB.setCpfCpnpj(rs.getString("cpfCnpj"));
                proB.setRg(rs.getString("rg"));
                proB.setEndereco(rs.getString("endereco"));
                proB.setEndNumero(rs.getString("endNumero"));
                proB.setComplemento(rs.getString("complemento"));
                proB.setBairro(rs.getString("complemento"));
                proB.setCep(rs.getString("cep"));
               
               
                if(rs.getString("idCidade") != null){
                    proB.setCidade(daoCidade.carregarPorId(rs.getString("idCidade")));
                }
                              
                proB.setDataCad(Corretores.ConverterParaJava(rs.getString("dataCad")));
                return proB;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ProprietarioDAO(carregar): " + e);
        }
        return proprietario;
    }

    public Integer BuscarProprietario(ProprietarioBeans propB) {
        String sql = "select * from proprietarios where cpfCnpj like ?";//placa existe
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, propB.getCpfCpnpj());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
            return null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Proprietario no banco: " + e);
        }
        return null;
    }// retorna o cod

    public void alterar(ProprietarioBeans proprietario) {
        String sqlUpdate = "update proprietarios set "
                + "nome=?,"
                + "cpfCnpj=?,"
                + "rg=?,"
                + "endereco=?,"
                + "endNumero=?,"
                + "complemento=?,"
                + "bairro=?,"
                + "cep=?,"
                + "idCidade=?"
                + "where id=?";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sqlUpdate);
            pst.setString(1, proprietario.getNome());
            pst.setString(2, proprietario.getCpfCpnpj());
            pst.setString(3, proprietario.getRg());
            pst.setString(4, proprietario.getEndereco());
            pst.setString(5, proprietario.getEndNumero());
            pst.setString(6, proprietario.getComplemento());
            pst.setString(7, proprietario.getBairro());
            pst.setString(8, proprietario.getCep());
            
            if (proprietario.getCidade().getId() != null) {
                pst.setInt(9, proprietario.getId());
            }else{
                pst.setNull(9, Types.NULL);
            }           

            pst.setInt(10, proprietario.getId());
            pst.executeUpdate();
            Conexao.getConnection().commit();
            //JOptionPane.showMessageDialog(null, "Alterado Com OK");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ProprietarioDAo(alterar): " + e);
        }
    }
}
