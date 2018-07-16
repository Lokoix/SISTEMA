/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rafae
 */
public class Corretores {

    public static String ConverterParaSQL(String data) {
        if (data != null) {
            return data.substring(6, 10) + "-" + data.substring(3, 5) + "-" + data.substring(0, 2);
        }
        return null;

    }

    public static String ConverterParaJava(String data) {
        System.out.println("ola mundo");
        if (data == null) {
            System.out.println("retornou nulo a data");
            return null;
        } else {
            System.out.println("retornou a data?");
            return data.substring(8, 10) + "/" + data.substring(5, 7) + "/" + data.substring(0, 4);
        }
    }

    public static String DataAtual() {
        Date b = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("YYYY-MM-dd");
        return sd.format(b);
    }

    public static String ano(String s) {
        if (s == null) {
            return null;
        } else {
            return s.substring(0, 4);
        }
    }
}
