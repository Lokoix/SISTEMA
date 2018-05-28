/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilhermengenharia
 */
public class Conexao {
    
     private final String URL = "jdbc:mysql://localhost:3306/sistemase7i";//private final não pode ser alterado; URL caminho para se chegar ao BD
    private final String Driver = "org.gjt.mm.mysql.Driver";//informação de conexão
    private final String Usuario = "root";
    private final String Senha = "";
    private static Connection Con;

    public Conexao() {
        try {
            Con = DriverManager.getConnection(URL, Usuario, Senha);
            Con.setAutoCommit(false);//não consegue voltar atrás
            //JOptionPane.showMessageDialog(null, "Conectado com Sucesso", "Conectado", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "Erro ao Conectar com o Banco", "Erro", 0);
        }

    }

    public static Connection getConnection() {
        if (Con == null) {
            new Conexao();
        }
        return Con;
    }

    public static void fecharConexao() {
        try {
            if (!Con.isClosed()) {
                Con.close();

            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

