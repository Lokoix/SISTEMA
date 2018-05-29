/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.UsuarioBeans;
import DAO.LoginDAO;



public class LoginController {
    LoginDAO loginD = new LoginDAO();

    public boolean logar(UsuarioBeans usuario) {
        return loginD.logar(usuario);
                
    }
    
}
