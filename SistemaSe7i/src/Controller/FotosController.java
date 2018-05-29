/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.FotosBeans;
import DAO.FotosDAO;

/**
 *
 * @author joaoh
 */
public class FotosController {
    FotosDAO FotosD;
    
    public FotosController()
    {
        FotosD = new FotosDAO(); 
    }
    
    public void InserirFotos(FotosBeans FotosB)
    {
        FotosD.InserirFotos(FotosB);
    }
    
}
