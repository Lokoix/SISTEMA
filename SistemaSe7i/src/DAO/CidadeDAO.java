/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.CidadeBeans;
import Utilitario.Conexao;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author rafae
 */
public class CidadeDAO {
    private CidadeBeans cidB;
    
    public List<CidadeBeans> ArrayMunicipioBD(){
        String sql = "select * from cidades";
        List<CidadeBeans> cidades = new ArrayList<CidadeBeans>();
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                cidB.setId(rs.getInt("pkcidade"));
                cidB.setNome(rs.getString("txnome"));
                cidB.setUf(rs.getString("txestado"));
                System.out.println(cidB.getNome());
                cidades.add(cidB);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar municipioBD: " + e);
        }
        return cidades;
    }
}
