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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael Piedade
 */
public class ManipulaTxt {

    public List<String> Leitura(String local, String arquivo) {
        StringBuffer sb = new StringBuffer();
        List<String> lista = new ArrayList<>();
        try {
            try {
            File arq = new File(local, arquivo);
            FileReader fileReader = new FileReader(arq);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha;

            while ((linha = bufferedReader.readLine()) != null) {

                if (linha != null && !linha.isEmpty()) {
                    sb.append(linha);

                }
            }
            fileReader.close();
            bufferedReader.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }

        System.out.println(sb);

        String regex1 = "\\[";
        String regex2 = "\\]";

        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(sb);

        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(sb);

        int count = 0;
        int a1, a2, b1, b2, c1, c2, d1, d2;
        int aux1 = 0, aux2 = 0;
        while (matcher1.find(aux1) && matcher2.find(aux2)) {
            //guardando posição da primeira busca
            // [ - abre
            a1 = matcher1.start();
            a2 = matcher1.end();

            // ] - fecha
            b1 = matcher2.start();
            b2 = matcher2.end();

            //guardando a posição da proxima busca
            if (!matcher1.find()) {// [ - abre
                break;
            }
            c1 = matcher1.start();

            c2 = matcher1.end();

            matcher2.find();// ] - fecha
            d1 = matcher2.start();
            d2 = matcher2.end();

            if (c2 < b1) {
                //System.out.println("--if 1");
                lista.add(sb.substring(a2, c1).trim());
                System.out.println(count + "item: " + lista.get(count).toString());
                count++;
                aux1 = a2;
                aux2 = a2;
            } else if (c1 > d1) {
               // System.out.println("--if 2");
                String a = sb.substring(b2, d1);               
                if (a.contains(":")) {
                    lista.add(a.substring(a.indexOf(":") + 1).trim());
                    System.out.println(count + "item: " + lista.get(count).toString());
                } else {
                    lista.add(sb.substring(b2, d1).trim());
                    System.out.println(count + "item: " + lista.get(count).toString());
                }
                count++;
                aux1 = b2;
                aux2 = b2;

            } else if (c1 < b1) {
               // System.out.println("--if 3");
                lista.add(sb.substring(a2, c1).trim());
                System.out.println(count + "item: " + lista.get(count).toString());
                count++;
                aux1 = a2;
                aux2 = a2;
            } else if (b1 < a1) {
               // System.out.println("--if 4");
                lista.add(sb.substring(b2, a1).trim());
                System.out.println(count + "item: " + lista.get(count).toString());
                count++;
                aux1 = b2;
                aux2 = b2;
            } else {
               // System.out.println("---else");
                lista.add(sb.substring(a2, b1).trim());
                System.out.println(count + "item: " + lista.get(count).toString());
                count++;
                aux1 = b2;
                aux2 = b2;
            }
        }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }
        return lista;
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
