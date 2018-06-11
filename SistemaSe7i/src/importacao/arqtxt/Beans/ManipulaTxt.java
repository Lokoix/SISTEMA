/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importacao.arqtxt.Beans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael Piedade
 */
public class ManipulaTxt {

    public List<String> Leitura(String local, String arquivo) {
        try {
            FileReader fileReader = new FileReader(
                    new File(local, arquivo));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha = "";
            ArrayList<String> result = new ArrayList();

            while ((linha = bufferedReader.readLine()) != null) {

                if (linha != null || !linha.isEmpty() || !linha.equals(" ")) {
                    result.add(linha);
                    System.out.println(linha);
                }
            }
            fileReader.close();
            bufferedReader.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }
        return null;
    }

    public List<String> listaDeArquivos(String local) {
        File dir = new File(local);
        ArrayList<String> lista = new ArrayList();
        for (File f : dir.listFiles()) {// lista o que possui no diretorio dir
            if (f.isDirectory()) {//se for um diretorio/pasta true;
                //System.out.println(f + " é um diretório");
            } else if (f.isFile()) {//se for um arquivo true;
                lista.add(f.getName());
            }
        }
        return lista;
    }

}
