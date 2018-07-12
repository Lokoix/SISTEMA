/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import Beans.CidadeBeans;
import Beans.ModeloBeans;
import Controller.CidadeController;
import Controller.ModeloController;
import importacao.arqtxt.Beans.ManipulaTxt;


/**
 *
 * @author rafae
 */
public class testeRaf2 {

    public static void main(String[] args) {
        ManipulaTxt m = new ManipulaTxt();
        
        m.Leitura("C:\\Users\\rafae\\Desktop\\interface\\ttt\\", "8CAD.txt");
        
    }
}
