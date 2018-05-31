/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.UsuarioBeans;
import DAO.UsuarioDAO;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guilhermengenharia
 */
public class UsuarioController {
    UsuarioDAO usuarioD = new UsuarioDAO();
    
    public void cadastrar(UsuarioBeans usuario){
        usuarioD.cadastrar(usuario);
    }
    public void controlePesquisa(String Pesquisa, DefaultTableModel Modelo) {
        usuarioD.buscarUsuario(Pesquisa, Modelo);
    }

    public UsuarioBeans controlePreencherCampos(int Codigo) {
        return usuarioD.preencherCampos(Codigo);
    }
    
       public void editarController(UsuarioBeans usuarioB) {
        usuarioD.editar(usuarioB);
    }
       

    public String controleDeCodigo() {
        return usuarioD.proximoRegeistro();
    }
}

