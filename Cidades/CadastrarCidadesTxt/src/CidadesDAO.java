
import Conexao.Conexao;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */

        
public class CidadesDAO {

    CidadeBeans cidade;
    
    public void Cadastrar(CidadeBeans a){
        String sql = "insert into cidades (pkcidade ,txnome, txestado) values (?,?,?);";
        try {
            PreparedStatement pst = Conexao.getConnection().prepareStatement(sql);
            pst.setInt(1, a.getCodigo());
            pst.setString(2, a.getNome());
            pst.setString(3, a.getUf());
            pst.execute();
            Conexao.getConnection().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cidade" + e);
        }
    }
}
