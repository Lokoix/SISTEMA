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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

/**
 *
 * @author rafae
 */
public class aaaaaa {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        File arq = new File("C:\\Users\\rafae\\Desktop\\interface\\ttt\\", "8CAD.txt");

        Scanner s = new Scanner(new FileInputStream(arq), "UTF-16LE");

        Writer out = new OutputStreamWriter(new FileOutputStream(new File("C:\\Users\\rafae\\Desktop\\interface\\ttt\\", "new.txt")), "UTF-8");
        Scanner ss = new Scanner(new FileInputStream(arq), "UTF-8");
        PrintStream ps = new PrintStream(new File("C:\\Users\\rafae\\Desktop\\interface\\ttt\\", "new.txt"));
  
        while (s.hasNextLine()) {
            ps.println(s.nextLine());
        }

    }
}
