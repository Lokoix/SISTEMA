/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import Beans.CidadeBeans;
import Controller.CidadeController;


/**
 *
 * @author rafae
 */
public class testeRaf2 {

    public static void main(String[] args) {
        CidadeController cont = new CidadeController();
        CidadeBeans cidade = new CidadeBeans();
        
        System.out.println(cidade.getNome());
        
    }
}
