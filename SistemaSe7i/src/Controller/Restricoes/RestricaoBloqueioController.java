/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Restricoes;

import Beans.Restricoes.RestricaoBloqueioBeans;
import DAO.RestricaoBloqueioDAO;

/**
 *
 * @author rafae
 */
public class RestricaoBloqueioController {

    RestricaoBloqueioDAO daoRestricaoBloqueio = new RestricaoBloqueioDAO();
    BloqueioController conBloqueio = new BloqueioController();

    public RestricaoBloqueioBeans corrigirRestricaoBloqueio(RestricaoBloqueioBeans restricao) {
        
            restricao.setBloqueio(conBloqueio.corrigirBloqueio(restricao.getBloqueio()));
            daoRestricaoBloqueio.cadastrar(restricao);
            return restricao;
        }
    }


