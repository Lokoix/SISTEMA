/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.CidadeBeans;
import DAO.CidadeDAO;

/**
 *
 * @author rafae
 */
public class CidadeController {

    CidadeDAO cidD = new CidadeDAO();

    public CidadeBeans CorrigirCidade(CidadeBeans a) {
        if (cidD.ExisteCidade(a)) {
            return cidD.getCidadeId(a.getId());
        } else {
            //retorna qualquer municipio (impossiver de entrar no else!!quase)
            //a.setId(munD.BuscarMunicipio(a));
            return null;
        }
    }// fim do metodo

    public CidadeBeans CarregarCidade(int id) {
        return cidD.getCidadeId(id);
    }
}
