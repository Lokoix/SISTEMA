package Utilitario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.util.logging.PlatformLogger;

public class Conexao {

    private final String url = "jdbc:mysql://localhost:3306/se7i";// final, não quero que ela seja alterada
    private final String driver = "org.gjt.mm.mysql.Driver";
    private final String usuario = "root";
    private final String senha = "";
    private static Connection con;

    public Conexao() {
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            con.setAutoCommit(false);
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso", "Conectado", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco: " + e, "Erro", 0);
        }
    }

    public static Connection getConnection() {
        if (con == null) {
            new Conexao();
        }
        System.out.println("conectado");
        return con;
    }

    public static void fecharConexao() {
        try {
            if (!con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main (String []args){
        Conexao.getConnection();
    }
}
