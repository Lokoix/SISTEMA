/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.MarcaBeans;
import DAO.MarcaDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class MarcaController {

    MarcaDAO daoMarca = new MarcaDAO();
    
    public MarcaBeans CorrigirMarca(MarcaBeans marca) {
        if(daoMarca.existe(marca)){
            marca = daoMarca.carregar(marca);
            return marca;
        }else if(marca.getNome() == null){
            //JOptionPane.showMessageDialog(null, "Marca sem nome para o cadastro!","Aviso", 1);
            return new MarcaBeans();
        }else{
            daoMarca.cadastrar(marca);
            return this.CorrigirMarca(marca);
        }
    }
}
