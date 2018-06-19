/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.MarcaBeans;
import Beans.ModeloBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael Piedade
 */
public class ModeloDAO {

    public void Cadastrar(ModeloBeans x) {
        String sqlInsertion = "insert into modelos (nome, idMarca) value (?,?)";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sqlInsertion);            
            st.setString(1, x.getNome());
            st.setInt(2, x.getMarca().getId());
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro salvo ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao CADASTRAR Modelo no banco: " + e);
        }
    }

    public ModeloBeans BuscarPorId(int x) {
        String sqlSelect = "SELECT  modelos.id as modeloId, modelos.nome as modeloNome, marcas.id as marcaId, marcas.nome as marcaNome \n"
                + "	FROM modelos, marcas WHERE modelos.idMarca = marcas.id AND modelos.id = ?; ";
        ModeloBeans modelo = null;
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sqlSelect);
            pst.setInt(1, x);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                modelo = new ModeloBeans();
                modelo.setId(rs.getInt("modeloid"));
                modelo.setNome(rs.getString("modeloNome"));
                modelo.setMarca(new MarcaBeans(rs.getInt("marcaId"), rs.getString("marcaNome")));
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro metodo dao getCidadeId: " + e);
        }
        return null;
    }

    public ModeloBeans CarregarModelo(String modelo, String marca) {

        try {//procura o modelo
            String sql = "select marcas.id as idMarca, marcas.nome as nomeMarca, modelos.id as idModelo, modelos.nome as nomeModelo\n"
                    + "	from marcas, modelos where modelos.idMarca=marcas.id and modelos.nome like ?";
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setString(1, modelo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {//retorna o modelo encontrado
                ModeloBeans modeloB = new ModeloBeans(rs.getInt("idModelo"), rs.getString("nomeModelo"), new MarcaBeans(rs.getInt("idMarca"), rs.getString("nomeMarca")));
                return modeloB;
            } else {//se não encontrar modelo
                try {//procura a marca
                    sql = "select marcas.id as idMarca, marcas.nome as nomeMarca\n" +
"                                   from marcas where marcas.nome like ?";
                    pst = Conexao.getConnection().prepareStatement(sql);
                    pst.setString(1, marca);
                    rs = pst.executeQuery();
                    if(rs.next()){//se existe a marca, então cadastra o modelo E retorna a mesma função
                        MarcaBeans marcaB = new MarcaBeans(rs.getInt("idMarca"), rs.getString("nomeMarca"));
                        this.Cadastrar(new ModeloBeans(modelo, marcaB));
                        return this.CarregarModelo(modelo, marca);
                    }else{// se não existe a marca então cadastra, E retorna a mesma função procurando o modelo
                        MarcaDAO marcaDAO = new MarcaDAO();
                        marcaDAO.Cadastrar(marca);
                        return this.CarregarModelo(modelo, marca);
                    }
                } catch (Exception e) {
                    System.out.println("Erro ao buscar/cadastrar marca: " + e);
                }

            }
        } catch (Exception e) {
             System.out.println("Erro ao buscar modelo" + e);
        }
        return null;
    }

}
