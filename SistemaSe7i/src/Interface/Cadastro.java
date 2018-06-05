/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Beans.ModeloBeans;
import java.util.List;

/**
 *
 * @author rafael Piedade
 */
public class Cadastro {
    
    public void getModelo(List<String> result){
        
        System.out.println(result.get(10).subSequence(25, 50));
    }
}
