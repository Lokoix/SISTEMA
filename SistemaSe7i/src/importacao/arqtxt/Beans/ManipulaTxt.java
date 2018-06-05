/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importacao.arqtxt.Beans;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael Piedade
 */
public class ManipulaTxt {

    public List<String> Leitura(String local, String arquivo) {
        ArrayList<String> result = new ArrayList();
        System.out.println("\n------" + arquivo + "-------\n");
        try {
            Scanner s = new Scanner(new FileReader(local + arquivo));
            //PrintStream ps = new PrintStream("C:\\Users\\rafae\\Documents\\NetBeansProjects\\Java-III\\src\\Aula4\\Video\\saida.txt");
            String linha = "";

            while (s.hasNext()) {
                linha = s.next();
                
                if (!linha.trim().equals("")) {
                    result.add(linha);
                    System.out.println(linha);
                }
            }
            s.close();
            return result;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo:'" + arquivo + "', erro: " + e);
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
