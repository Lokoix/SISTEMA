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

         String a = "125BLO.txt";
         String b = "123BLOC.txt";
         
         System.out.println(a.substring(0, a.indexOf("BLO")));
         System.out.println(b.substring(0, b.indexOf("BLO")));
                   
         
        
    }
}
