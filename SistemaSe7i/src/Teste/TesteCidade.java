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
        CidadeBeans cidB = new CidadeBeans();
        CidadeDAO cidD = new CidadeDAO();

        cidB = cidD.BuscarPk(6103);

        System.out.println(cidB.getId() + " - " + cidB.getNome() + " - " + cidB.getUf());

        ArrayList<CidadeBeans> cidades = new ArrayList();
        cidades = cidD.ArrayMunicipioBD();
        for (int i = 0; i < cidades.size(); i++) {
            System.out.println(cidades.get(i).getId() + " - " + cidades.get(i).getNome() + " - " + cidades.get(i).getUf());
        }
    }

}
