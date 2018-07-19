/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class qqqq {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        StringBuffer sb = new StringBuffer();
        List<String> lista = new ArrayList<>();
        try {
            Scanner s = new Scanner(new FileReader("C:\\P. PRUDENTE MUNICIPAL 002-2018\\2622\\2622 - Judicial.txt"));
            //PrintStream ps = new PrintStream("C:\\Users\\rafae\\Documents\\NetBeansProjects\\Java-III\\src\\Aula4\\Video\\saida.txt");

            String linha = "";

            //s.useDelimiter(" ");
            System.out.println(s.delimiter());
            while (s.hasNext()) {
                //System.out.println(s.nextLine());
                sb.append(s.nextLine());

            }
            s.close();
            System.out.println(sb);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }

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

    }
}
