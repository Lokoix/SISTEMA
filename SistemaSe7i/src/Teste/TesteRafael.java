
package Teste;

import Beans.CidadeBeans;
import Beans.EstadoBeans;
import DAO.CidadeDAO;
import DAO.EstadoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafael Piedade
 */
public class TesteRafael {
    public static void main(String[] args) {
        CidadeBeans b = new CidadeBeans();
        CidadeDAO d = new CidadeDAO();
        
        List<CidadeBeans> lista = d.carregarCidades("SÃO P");
        
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).exibe();
        }       
    }
}
