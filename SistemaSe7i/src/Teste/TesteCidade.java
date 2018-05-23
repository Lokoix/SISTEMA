/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import Beans.CidadeBeans;
import DAO.CidadeDAO;
import java.util.ArrayList;
/**
 *
 * @author rafae
 */
public class TesteCidade {
    public static void main(String[] args) {
        CidadeBeans cidB;
        CidadeDAO cidD = new CidadeDAO();
        
        ArrayList<CidadeBeans> cidades = new ArrayList<>(cidD.ArrayMunicipioBD());
        System.out.println("ola");
        System.out.println(cidades.size());
       for(int i=0; cidades.size() > i;i++){
           System.out.println(cidades.get(i).getId()+" - "+cidades.get(i).getNome()+" - "+ cidades.get(i).getUf());
       }
    }
    
    
}
