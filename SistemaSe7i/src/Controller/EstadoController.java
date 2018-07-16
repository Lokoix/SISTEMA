/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.EstadoBeans;
import DAO.EstadoDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael Piedade
 */
public class EstadoController {
    EstadoDAO daoEstado = new EstadoDAO();
    
    public EstadoBeans corrigirEstado(EstadoBeans estado){
        if(daoEstado.existe(estado)){
            estado = daoEstado.carregar(estado);
            return estado;
        }else{
            JOptionPane.showMessageDialog(null, "Estado não localizado","Aviso!", 1);
        }
        return new EstadoBeans();
    }
    
    
    
}
