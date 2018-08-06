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

        ArrayList<String> lista = new ArrayList<>();
        lista.add("1CAD.txt");lista.add("2CAD.txt");lista.add("3CAD.txt");lista.add("4CAD.txt");lista.add("5CAD.txt");
        lista.add("12CAD.txt");lista.add("122CAD.txt");lista.add("111CAD.txt");lista.add("124CAD.txt");lista.add("22CAD.txt");
        
        System.out.println(lista.indexOf("2222CAD.txt"));
        
        
        /*
        int inicio = 0;
        int fim; // = tamanho da lista
        int achou  = 0;
        int meio;
        while ((inicio <= fim) && (achou == 0)) {
            meio = (inicio + fim) / 2;
            if (vet[meio] == n) {
                achou = 1;
            } else if (vet[meio] < n) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
*/
    }
}
