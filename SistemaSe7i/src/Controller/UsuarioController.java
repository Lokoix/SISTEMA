/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.UsuarioBeans;
import DAO.UsuarioDAO;

/**
 *
 * @author Guilhermengenharia
 */
public class UsuarioController {
    UsuarioDAO usuarioD = new UsuarioDAO();
    
    public void cadastrar(UsuarioBeans usuario){
        usuarioD.cadastrar(usuario);
    }
}

