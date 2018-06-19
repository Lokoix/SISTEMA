package Teste;

import Beans.VeiculoBeans;
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
        ManipulaTxt m = new ManipulaTxt();
        Cadastro cad = new Cadastro();
        List<String> listaArq = new ArrayList<>();

        String local = "C:\\Users\\rafae\\Desktop\\interface\\teste\\";

        listaArq = m.listaDeArquivos(local);
        
        
        for (int i = 0; i < listaArq.size(); i++) {
            VeiculoBeans veic = new VeiculoBeans();
            
            veic = cad.getVeiculo(m.Leitura(local, listaArq.get(i).toString()));
            
            veic.exibe();
        }
        
    }
}
