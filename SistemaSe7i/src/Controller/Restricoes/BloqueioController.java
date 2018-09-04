/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Restricoes;

import Beans.Restricoes.BloqueioBeans;
import DAO.BloqueioDAO;

/**
 *
 * @author rafae
 */



public class BloqueioController {
    
    BloqueioDAO daoBloqueio = new BloqueioDAO();
    
    public BloqueioBeans corrigirBloqueio(BloqueioBeans bloqueio) {
        if(daoBloqueio.existe(bloqueio)){
            bloqueio = daoBloqueio.carregar(bloqueio);
            return bloqueio;
        }else if(bloqueio.getDescricao()== null){
            //JOptionPane.showMessageDialog(null, "Marca sem nome para o cadastro!","Aviso", 1);
            bloqueio.setId(5);
            return bloqueio;
        }else{
            bloqueio.setId(5);
            return bloqueio;
            //daoBloqueio.cadastrar(bloqueio);
            //return this.corrigirBloqueio(bloqueio);
        }
    }
}
