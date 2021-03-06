/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.CidadeBeans;
import Beans.EmpresaBeans;
import Beans.LeiloeiroBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class LeiloeiroDAO {

    public void cadastrar(LeiloeiroBeans leiloeiro) {

        String sql = "insert into leiloeiros(nome, endereco, numero, bairro, cep, telefone,"
                + "celular, email, jucesp, idCidade, idEmpresa) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, leiloeiro.getNome());
            st.setString(2, leiloeiro.getEndereco());
            st.setString(3, leiloeiro.getNumero());
            st.setString(4, leiloeiro.getBairro());
            st.setString(5, leiloeiro.getCep());
            st.setString(6, leiloeiro.getTelefone());
            st.setString(7, leiloeiro.getCelular());
            st.setString(8, leiloeiro.getEmail());
            st.setString(9, leiloeiro.getJucesp());
            if (leiloeiro.getCidade() == null) {
                st.setInt(10, 0);
            } else {
                st.setInt(10, leiloeiro.getCidade().getId());//Cidade é objeto e quero só id desse objeto
            }
            if (leiloeiro.getEmpresa() == null) {
                st.setInt(11, 0);
            } else {
                st.setInt(11, leiloeiro.getEmpresa().getId());
            }

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Salvo com Sucesso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }

    }

    public void editar(LeiloeiroBeans leiloeiro) {
        String sql = "update leiloeiros set nome = ?, endereco = ?, numero = ?, bairro = ?, cep = ?, telefone = ?, "
                + "celular = ?, email = ?, jucesp = ?, idCidade = ?, idEmpresa = ? where id = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setString(1, leiloeiro.getNome());
            st.setString(2, leiloeiro.getEndereco());
            st.setString(3, leiloeiro.getNumero());
            st.setString(4, leiloeiro.getBairro());
            st.setString(5, leiloeiro.getCep());
            st.setString(6, leiloeiro.getTelefone());
            st.setString(7, leiloeiro.getCelular());
            st.setString(8, leiloeiro.getEmail());
            st.setString(9, leiloeiro.getJucesp());
            if (leiloeiro.getCidade() == null) {
                st.setInt(10, 0);
            } else {
                st.setInt(10, leiloeiro.getCidade().getId());//Cidade é objeto e quero só id desse objeto
            }
            if (leiloeiro.getEmpresa() == null) {
                st.setInt(11, 0);
            } else {
                st.setInt(11, leiloeiro.getEmpresa().getId());
            }
            st.setInt(12, leiloeiro.getId());

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Editado com Sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar registro");
        }

    }
    
    public void deletar(LeiloeiroBeans leiloeiro){
                String sql = "delete from leiloeiros where id = ?";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setInt(1, leiloeiro.getId());
            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Deletado com Sucesso");
            Conexao.getConnection().commit();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível deletar registro");
        }
    }
        
    

    public void buscarLeiloeiro(String Pesquisa, DefaultTableModel Modelo) {
        try {
            String sql = "select * from leiloeiros where nome like '%" + Pesquisa + "%' ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Modelo.addRow(new Object[]{rs.getString("id"), rs.getString("nome"), rs.getString("idEmpresa"), rs.getString("idCidade")});
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void buscarTodosLeiloeiros(DefaultTableModel Modelo) {
        try {
            String sql = "SELECT leiloeiros.* , cidades.nome, empresas.razaoSocial from leiloeiros INNER JOIN cidades ON leiloeiros.idCidade = cidades.id "
                    + "INNER JOIN empresas ON leiloeiros.idEmpresa = empresas.id";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Modelo.addRow(new Object[]{rs.getString("id"), rs.getString("nome"), rs.getString("empresas.razaoSocial"), rs.getString("cidades.nome")});
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public LeiloeiroBeans preencherCampos(int id) {
        LeiloeiroBeans leiloeiro = new LeiloeiroBeans();
        CidadeBeans cidade = new CidadeBeans();
        EmpresaBeans empresa = new EmpresaBeans();
        try {
            String sql = "select * from leiloeiros where id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                leiloeiro.setId(rs.getInt("id"));
                leiloeiro.setNome(rs.getString("nome"));
                leiloeiro.setEndereco(rs.getString("endereco"));
                leiloeiro.setNumero(rs.getString("numero"));
                leiloeiro.setBairro(rs.getString("bairro"));
                leiloeiro.setCep(rs.getString("cep"));
                leiloeiro.setTelefone(rs.getString("telefone"));
                leiloeiro.setCelular(rs.getString("celular"));
                leiloeiro.setEmail(rs.getString("email"));
                leiloeiro.setJucesp(rs.getString("jucesp"));
                cidade.setId(rs.getInt("idCidade"));
                leiloeiro.setCidade(cidade);
                empresa.setId(rs.getInt("idEmpresa"));
                leiloeiro.setEmpresa(empresa);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return leiloeiro;

    }

        public ArrayList<LeiloeiroBeans> carregarLeiloeiros() {// retorna uma lista das cidades que inicial com a string
        ArrayList<LeiloeiroBeans> lista = new ArrayList<>();
        try {
            String sql = "select * from leiloeiros order by leiloeiros.nome ASC";
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                LeiloeiroBeans leiloeiro = new LeiloeiroBeans();
                leiloeiro.setId(rs.getInt("id"));
                leiloeiro.setNome(rs.getString("nome"));
                lista.add(leiloeiro);
                leiloeiro.exibe();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro método dao carregar Patio: " + e);
        }
        return lista;
    }
    
            public int carregarComboLeiloeiro() {
        String sql = "select max(id) from leiloeiros";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getInt("max(id)"));
                return rs.getInt("max(id)");
                
            }
        } catch (SQLException ex) {

        }
        return 0;
    }
}
