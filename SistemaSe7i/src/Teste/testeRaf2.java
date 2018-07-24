/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import Beans.CidadeBeans;
import Beans.LoteBeans;
import Beans.ModeloBeans;
import Controller.CidadeController;
import Controller.ModeloController;
import Interface.Cadastro;
import importacao.arqtxt.Beans.ManipulaTxt;
import java.util.ArrayList;


/**
 *
 * @author rafae
 */
public class testeRaf2 {

    public static void main(String[] args) {
        ManipulaTxt m = new ManipulaTxt();
         ArrayList<String> result = new ArrayList<>();
         LoteBeans lote = new LoteBeans();
         Cadastro iCadastro = new Cadastro();
         String local="C:\\Users\\rafae\\Desktop\\interface\\Cad\\";
         String s = "86CAD.txt";
         
         
         result = m.Leitura(local, s);
         iCadastro.getLoteCadastro3(result, lote);
         
         lote.exibe();
        
    }
}
