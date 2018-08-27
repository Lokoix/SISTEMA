/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importacao.arqtxt.Beans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael Piedade
 */
public class ManipulaTxt {

    public ArrayList<String> Leitura(File pesquisa) {
        StringBuffer sb = new StringBuffer();
        String linha = "";
        ArrayList<String> lista = new ArrayList<>();
        try {
            try {
                Scanner s = new Scanner(new FileInputStream(pesquisa),"UTF-16LE");
                
                
                //PrintStream ps = new PrintStream("C:\\Users\\rafae\\Documents\\NetBeansProjects\\Java-III\\src\\Aula4\\Video\\saida.txt");

                //s.useDelimiter(" ");
                //System.out.println(s.delimiter());
                while (s.hasNext()) {
                    //System.out.println(s.nextLine());
                    sb.append(s.nextLine());

                }
                s.close();
                /*
                BufferedReader myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream(local+arquivo), "UTF-8"));
                
                        File arq = new File(local, arquivo);
            FileReader fileReader = new FileReader(arq);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha;

            while ((linha = myBuffer.readLine()) != null) {
                if (linha != null && !linha.isEmpty()) {
                    sb.append(linha);

                }
            }
            fileReader.close();
            bufferedReader.close();
           myBuffer.close();
                 */
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro " + e);
            }

            //System.out.println(sb);

            String regex1 = "\\[";
            String regex2 = "\\]";

            Pattern pattern1 = Pattern.compile(regex1);
            Matcher matcher1 = pattern1.matcher(sb);//sb

            Pattern pattern2 = Pattern.compile(regex2);
            Matcher matcher2 = pattern2.matcher(sb);//sb

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
            if (matcher1.find()) {// [ - abre
                c1 = matcher1.start();
                c2 = matcher1.end();
            } else {
                c1 = 0;
                c2 = 0;
            }

            if (matcher2.find()) {// ] - fecha
                d1 = matcher2.start();
                d2 = matcher2.end();
            } else {
                d1 = 0;
                d2 = 0;
            }

            if ((a1 < b1) && (c1 <= d1)) {
                if (c1 < b1 && c1 != 0) {
                    //System.out.println("if 1.1 ");
                    lista.add(sb.substring(a2, c1).trim());
                    System.out.println(count + "item: " + lista.get(count).toString());
                    count++;
                    aux1 = a2;
                    aux2 = a2;
                } else {
                    //System.out.println("if 1.2 ");
                    lista.add(sb.substring(a2, b1).trim());
                    System.out.println(count + "item: " + lista.get(count).toString());
                    count++;
                    aux1 = b2;
                    aux2 = b2;
                }

                if (c1 == 0 && d1 == 0) {
                    break;
                }
            } else if (a1 < b1 && c1 > d1) {
                //System.out.println("if 2  ");
                lista.add(sb.substring(a2, b1).trim());
                System.out.println(count + "item: " + lista.get(count).toString());
                count++;
                aux1 = c1;
                aux2 = b1;
            } else if (b1 < d1 && d1 < a1) {
                //System.out.println("if 3 :  ");
                lista.add(sb.substring(b2, d1).trim());
                System.out.println(count + "item: " + lista.get(count).toString());
                count++;
                aux1 = a1;
                aux2 = d1;
            } else if (a1 > b1) {
                //System.out.println("if 4 :  ");
                lista.add(sb.substring(b2, a1).trim());
                System.out.println(count + "item: " + lista.get(count).toString());
                count++;
                aux1 = a1;
                aux2 = a1;
            } else {
                System.out.println("bug");
            }
        }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
            return lista;
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
