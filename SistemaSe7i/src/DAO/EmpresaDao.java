/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.CidadeBeans;
import Beans.EmpresaBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guilhermengenharia
 */
public class EmpresaDao {
    private EmpresaBeans empresa;

    public void cadastrar(EmpresaBeans empresa) {
        String sql = "insert into empresas(razaoSocial, nomeFantasia, endereco, numero, bairro, cidade, cep, "
                + "telefone, cnpj, login, senha) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, empresa.getRazaoSocial());
            st.setString(2, empresa.getNomeFantasia());
            st.setString(3, empresa.getEndereco());
            st.setString(4, empresa.getNumero());
            st.setString(5, empresa.getBairro());
            if (empresa.getCidade() == null) {
                st.setInt(6, 0);
            } else {
                st.setInt(6, empresa.getCidade().getId());//Cidade é objeto e quero só id desse objeto
            }
            
            st.setString(7, empresa.getCep());
            st.setString(8, empresa.getTelefone());
            st.setString(9, empresa.getCnpj());
            st.setString(10, empresa.getLogin());
            st.setString(11, empresa.getSenha());

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Salvo com Sucesso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void buscarEmpresa(String Pesquisa, DefaultTableModel Modelo) {
        try {
            String sql = "select * from empresas where razaoSocial like '%" + Pesquisa + "%' ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Modelo.addRow(new Object[]{rs.getString("id"), rs.getString("razaoSocial"), rs.getString("nomeFantasia"), rs.getString("login"), rs.getString("cnpj")});
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public EmpresaBeans preencherCampos(int id) {
        EmpresaBeans empresa = new EmpresaBeans();
        CidadeBeans cidade = new CidadeBeans();
        try {
            String sql = "select * from empresas where id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                empresa.setId(rs.getInt("id"));
                empresa.setRazaoSocial(rs.getString("razaoSocial"));
                empresa.setNomeFantasia(rs.getString("nomeFantasia"));
                empresa.setEndereco(rs.getString("endereco"));
                empresa.setNumero(rs.getString("numero"));
                empresa.setBairro(rs.getString("bairro"));
                empresa.setCep(rs.getString("cep"));
                cidade.setId(rs.getInt("cidade"));
                empresa.setCidade(cidade);
                empresa.setCnpj(rs.getString("cnpj"));
                empresa.setLogin(rs.getString("login"));
                empresa.setSenha(rs.getString("senha"));

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return empresa;
    }

    public void editar(EmpresaBeans empresa) {
        String sql = "update empresas set razaoSocial = ?, nomeFantasia = ?, endereco = ?, numero = ?, bairro = ?,"
                + "cidade = ?, cep = ?, telefone = ?, cnpj = ?, login = ?, senha = ? where id = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, empresa.getRazaoSocial());
            st.setString(2, empresa.getNomeFantasia());
            st.setString(3, empresa.getEndereco());
            st.setString(4, empresa.getNumero());
            st.setString(5, empresa.getBairro());
            if (empresa.getCidade() == null) {
                st.setInt(6, 0);
            } else {
                st.setInt(6, empresa.getCidade().getId());//Cidade é objeto e quero só id desse objeto
            }
            st.setString(7, empresa.getCep());
            st.setString(8, empresa.getTelefone());
            st.setString(9, empresa.getCnpj());
            st.setString(10, empresa.getLogin());
            st.setString(11, empresa.getSenha());
            st.setInt(12, empresa.getId());

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Editado com Sucesso", "Salvo", 1, new ImageIcon("Imagens/ok.png"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void buscarTodasEmpresas(DefaultTableModel Modelo) {
        try {
            String sql = "SELECT empresas.* , cidades.nome from empresas INNER JOIN cidades ON empresas.cidade = cidades.id";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Modelo.addRow(new Object[]{rs.getString("id"), rs.getString("razaoSocial"), rs.getString("nomeFantasia"), rs.getString("login"), rs.getString("cnpj")});
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void deletar(EmpresaBeans empresa) {
        String sql = "delete from empresas where id = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setInt(1, empresa.getId());
            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Deletado com Sucesso");
            Conexao.getConnection().commit();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
        public ArrayList<EmpresaBeans> carregarEmpresas() {// retorna uma lista das cidades que inicial com a string
        ArrayList<EmpresaBeans> lista = new ArrayList<>();
        try {
            String sql = "select * from empresas order by empresas.razaoSocial ASC";
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                empresa = new EmpresaBeans();
                empresa.setId(rs.getInt("id"));
                empresa.setRazaoSocial(rs.getString("razaoSocial"));
                lista.add(empresa);
                empresa.exibe();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro método dao carregarEmpresa: " + e);
        }
        return lista;
    }
}
