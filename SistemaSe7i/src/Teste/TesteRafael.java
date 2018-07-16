package Teste;

import Beans.CidadeBeans;
import Beans.ModeloBeans;
import Beans.VeiculoBeans;
import Controller.ModeloController;
import DAO.ModeloDAO;
import Interface.Cadastro;
import importacao.arqtxt.Beans.ManipulaTxt;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafael Piedade
 */
public class TesteRafael {

    public static void main(String[] args) {

        CidadeBeans cidade = new CidadeBeans();
        
        cidade.exibe();
        
        if(cidade.getNome() == null){
            System.out.println("é nulo");
        }
    }
}
