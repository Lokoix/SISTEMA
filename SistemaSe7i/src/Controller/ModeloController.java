/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.ModeloBeans;
import DAO.ModeloDAO;

/**
 *
 * @author rafae
 */
public class ModeloController {
    
    ModeloDAO modeloD = new ModeloDAO();
    
    public ModeloBeans CorrigirModelo(ModeloBeans x){        
        return modeloD.CarregarModelo(x);
        
        
    }
}
