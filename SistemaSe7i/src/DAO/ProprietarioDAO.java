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
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class ProprietarioDAO {

    CidadeController munC;
    CidadeDAO cidadeDAO = new CidadeDAO();

    public void CadastrarProprietario(ProprietarioBeans propB) {
        String sqlInsertion = "insert into proprietarios (nome, cpfCnpj, rg, complemento, endereco, endNumero, bairro, cep, idCidade, dataCad) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sqlInsertion);

            st.setString(1, propB.getNome());
            st.setString(2, propB.getCpfCpnpj());
            st.setString(3, propB.getRg());
            st.setString(4, propB.getComplemento());

            st.setString(5, propB.getEndereco());
            st.setString(6, propB.getEndNumero());
            st.setString(7, propB.getBairro());
            st.setString(8, propB.getCep());
            System.out.println("aaaaaaa");
            if (propB.getCidade().getNome() == null) {
                st.setString(9, null);
            } else {
                st.setString(9, (cidadeDAO.carregarCidade(propB.getCidade())).getId().toString());
            }
            System.out.println("bbbbb");
            st.setString(10, Corretores.DataAtual());
            st.execute();
            Conexao.getConnection().commit();
            // JOptionPane.showMessageDialog(null, "Registro salvo ");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Proprietario no banco: " + e);
        }
    }

    public boolean ExisteProprietario(ProprietarioBeans a) {
        String sql = "select * from proprietarios where cpfCnpj like ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, a.getCpfCpnpj());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //JOptionPane.showMessageDialog(null, "Veiculo ja existe no sistema");
                return true;
            } else {
                sql = "select * from proprietarios where rg like ?";
                try {
                    st = Conexao.getConnection().prepareStatement(sql);
                    st.setString(1, a.getRg());
                    rs = st.executeQuery();
                    if (rs.next()) {
                        // JOptionPane.showMessageDialog(null, "Veiculo ja existe no sistema");
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

    public ProprietarioBeans getProprietarioBeans(ProprietarioBeans x) {
        String sql = "select * from proprietarios where cpfCnpj like ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, x.getCpfCpnpj());
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

                if (rs.getString("idCidade") != null) {
                    proB.setCidade(cidadeDAO.getCidadeId(rs.getInt("idCidade")));
                }
                proB.setDataCad(Corretores.ConverterParaJava(rs.getString("dataCad")));
                return proB;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao getProprietario no banco: " + e);
        }
        return null;
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

    public void AlterarProprietario(ProprietarioBeans x) {
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
            pst.setString(1, x.getNome());
            pst.setString(2, x.getCpfCpnpj());
            pst.setString(3, x.getRg());
            pst.setString(4, x.getEndereco());
            pst.setString(5, x.getEndNumero());
            pst.setString(6, x.getComplemento());
            pst.setString(7, x.getBairro());
            pst.setString(8, x.getCep());
            pst.setString(9, x.getCidade().getId().toString());
            pst.setInt(10, x.getId());
            x.exibe();

            pst.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Alterado Com OK");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar Automovel no banco: " + e);
        }
    }
}
