/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.FotosBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joaoh
 */
public class FotosDAO {
    
    public void InserirFotos(FotosBeans Fotos)
    {
        String sql = "insert into fotos (caminho, lote, tipo, leilao) values (?, ?, ?, ?)"; 
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql); 
            st.setString(1, Fotos.getCaminho());
            st.setString(2, Fotos.getLote());
            st.setString(3, Fotos.getTipo());
            st.setInt(4, 1);          
            st.execute(); 
            Conexao.getConnection().commit();            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void BuscarFotos(DefaultTableModel Modelo)
    {
        
        Modelo.setNumRows(0);
        String sql = "select distinct lote from fotos order by lote";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Modelo.addRow(new Object[]{rs.getString("lote")});
            }

            st.execute();
            Conexao.getConnection().commit();
        } catch (Exception e) {
            System.out.println(e);
        }   
    }
    
    
    
    public void BuscarIntervaloFoto(DefaultTableModel Modelo, String lote,String lote2, String leilao)
    {
        Modelo.setNumRows(0); 
        String sql = "select distinct lote from fotos where lote between "+lote+" and "+lote2+" and leilao="+leilao; 
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql); 
            ResultSet rs = st.executeQuery(); 
            while(rs.next())
            {
               
                Modelo.addRow(new Object[]{rs.getString("lote")});
            }
            
            st.execute(); 
            Conexao.getConnection().commit();            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
}
