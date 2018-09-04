/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Beans.LoteBeans;
import Beans.Restricoes.BloqueioBeans;
import Beans.Restricoes.RestricaoBloqueioBeans;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafae
 */
public class Bloqueio {

    // tamanho 39, 5BLO.txt
    public void getBloqueio1(List<String> result, RestricaoBloqueioBeans restricaoBlo) {

        //municipio bloqueio
        if (result.get(16).toString() != null) {
            restricaoBlo.setMunicipioBloqueio(result.get(16).toString());
        }

        //protocolo
        if (result.get(18) != null) {
            restricaoBlo.setProtocolo(result.get(18) + "-" + result.get(19));
        }

        //processo
        if (result.get(20) != null) {
            restricaoBlo.setProcesso(result.get(20) + "-" + result.get(21));
        }

        //autoridade
        if (result.get(22) != null) {
            restricaoBlo.setAutoridade(result.get(22));
        }

        //oficio
        if (result.get(23) != null) {
            restricaoBlo.setOficio(result.get(23) + "-" + result.get(24));
        }

        //laudo
        if (result.get(25) != null) {
            restricaoBlo.setLaudo(result.get(25));
        }

        //org. expedidor
        if (result.get(26) != null) {
            restricaoBlo.setOrgaoExpedidor(result.get(26));
        }

        // motivo
        if (result.get(30) != null) {
            restricaoBlo.setDescricao(
                    (result.get(30) + " " + result.get(31) + " " + result.get(32) + " " + result.get(33)).trim()
            );
        }

        //bloqueio descricao
        if (result.get(17).toString() != null) {
            restricaoBlo.getBloqueio().setDescricao(result.get(17).toString());
        }

    }

    public void getBloqueio2(ArrayList<String> result, RestricaoBloqueioBeans restricaoBlo) {
        //municipio bloqueio
        if (result.get(16).toString() != null) {
            restricaoBlo.setMunicipioBloqueio(result.get(16).toString());
        }

        /*//protocolo
        if (result.get(18) != null) {
            restricaoBlo.setProtocolo(result.get(18) + "-" + result.get(19));
        }

        //processo
        if (result.get(20) != null) {
            restricaoBlo.setProcesso(result.get(20) + "-" + result.get(21));
        }

        //autoridade
        if (result.get(22) != null) {
            restricaoBlo.setAutoridade(result.get(22));
        }

        //oficio
        if (result.get(23) != null) {
            restricaoBlo.setOficio(result.get(23) + "-" + result.get(24));
        }

        //laudo
        if (result.get(25) != null) {
            restricaoBlo.setLaudo(result.get(25));
        }

        //org. expedidor
        if (result.get(26) != null) {
            restricaoBlo.setOrgaoExpedidor(result.get(26));
        }
         */
        // motivo
        if (result.get(30) != null) {
            restricaoBlo.setDescricao(
                    (result.get(17) + ", Edital: " + result.get(18) + "-" + result.get(19) + " Lote: " + result.get(20)).trim()
            );
        }

        //bloqueio descricao
        if (result.get(17).toString() != null) {
            restricaoBlo.getBloqueio().setDescricao(result.get(17).toString());
        }
    }

    public void getBloqueio3(ArrayList<String> result, RestricaoBloqueioBeans restricaoBlo) {
        //municipio bloqueio
        /*if (result.get(16).toString() != null) {
            restricaoBlo.setMunicipioBloqueio(result.get(16).toString());
        }

        //protocolo
        if (result.get(18) != null) {
            restricaoBlo.setProtocolo(result.get(18) + "-" + result.get(19));
        }

        //processo
        if (result.get(20) != null) {
            restricaoBlo.setProcesso(result.get(20) + "-" + result.get(21));
        }

        //autoridade
        if (result.get(22) != null) {
            restricaoBlo.setAutoridade(result.get(22));
        }

        //oficio
        if (result.get(23) != null) {
            restricaoBlo.setOficio(result.get(23) + "-" + result.get(24));
        }

        //laudo
        if (result.get(25) != null) {
            restricaoBlo.setLaudo(result.get(25));
        }

        //org. expedidor
        if (result.get(26) != null) {
            restricaoBlo.setOrgaoExpedidor(result.get(26));
        }
         */
        // motivo
        if (result.get(17) != null) {
            restricaoBlo.setDescricao(
                    (result.get(17).substring(0, result.get(17).indexOf("-"))).trim()
            );
        }

        //bloqueio descricao
        //if (result.get(8).toString() != null) {
        //    restricaoBlo.getBloqueio().setDescricao(result.get(17).toString());
       // }
    }

}
