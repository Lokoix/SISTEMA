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
       
        List<String> arquivos = m.ListaDeArquivos(local);
        
        for(int i=0; i<arquivos.size();i++){
            List<String> res = m.LeituraBuffer(local, arquivos.get(i));
            System.out.println(res.get(17).toString());
            System.out.println((res.get(17).substring(83, 101)).toString());
        }        
    }
}
