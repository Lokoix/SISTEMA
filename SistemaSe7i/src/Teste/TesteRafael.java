package Teste;

import importacao.arqtxt.Beans.ManipulaTxt;
import java.util.List;

/**
 *
 * @author rafael Piedade
 */
public class TesteRafael {
    public static void main(String[] args) {
        ManipulaTxt m = new ManipulaTxt();
        String local = "C:\\Users\\rafae\\Desktop\\interface\\";
       
        List<String> arquivos = m.listaDeArquivos(local);
        
        for(int i=0; i<arquivos.size();i++){
            m.Leitura(local, arquivos.get(i));
        }
        
    }
}
