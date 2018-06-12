/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Beans.LoteBeans;
import Beans.ModeloBeans;
import Beans.VeiculoBeans;
import java.util.List;

/**
 *
 * @author rafael Piedade
 */
public class Cadastro {
     
    
    public LoteBeans getLote(List<String> result){
              
    }
    
    
    public VeiculoBeans getVeiculo(List<String> result){
        VeiculoBeans veic = new VeiculoBeans();
        veic.setPlaca(result.get(6));
        veic.setRenavam(result.get(9));
        veic.setChassiVeiculo(result.get(10));
        
        
    }
    
}
