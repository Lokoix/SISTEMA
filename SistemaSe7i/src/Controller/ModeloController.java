/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.ModeloBeans;
import DAO.ModeloDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class ModeloController {

    ModeloDAO daoModelo = new ModeloDAO();
    MarcaController conMarca = new MarcaController();

    public ModeloBeans corrigirModelo(ModeloBeans modelo) {
        modelo.setMarca(conMarca.CorrigirMarca(modelo.getMarca()));

        if (daoModelo.existe(modelo)) {
            modelo = daoModelo.carregar(modelo);
            return modelo;
        } else if (modelo.getNome() == null) {
            //JOptionPane.showMessageDialog(null, "Modelo sem nome para o cadastro!", "Aviso", 1);
            return new ModeloBeans();
        } else if (modelo.getMarca().getNome() == null) {
            //JOptionPane.showMessageDialog(null, "Modelo sem marca para o cadastro!", "Aviso", 1);
            return new ModeloBeans();
        } else {
            daoModelo.cadastrar(modelo);
            return this.corrigirModelo(modelo);
        }
    }
}
