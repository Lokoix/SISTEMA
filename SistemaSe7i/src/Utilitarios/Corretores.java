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
        if (data.equals("")) {
            return null;
        } else {
            return data.substring(6, 10) + "-" + data.substring(3, 5) + "-" + data.substring(0, 2);
        }

    }

    public static String ConverterParaJava(String Data) {
        if (Data.equals("")) {
            return null;
        } else {
            return Data.substring(8, 10) + "/" + Data.substring(5, 7) + "/" + Data.substring(0, 4);
        }
    }

    public static String DataAtual() {
        Date b = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("YYYY-MM-dd");
        return sd.format(b);
    }
}
