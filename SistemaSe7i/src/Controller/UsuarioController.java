/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.UsuarioBeans;
import DAO.UsuarioDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guilhermengenharia
 */
public class UsuarioController {

    UsuarioDAO usuarioD = new UsuarioDAO();

    public void cadastrar(UsuarioBeans usuario) {
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
    
    public void deletarController(UsuarioBeans usuarioB){
        usuarioD.deletar(usuarioB);
    }

    public boolean verificarDados(UsuarioBeans usuario) {
        if (usuario.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencher Campo Nome", "Erro", 0);
            return false;
        }

        if (usuario.getLogin().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencher Campo Login", "Eroo", 0);
            return false;
        }

        if (usuario.getSenha().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencher Campo Senha", "Erro", 0);
            return false;
        }
        
        if(usuario.getPermissao().equals("")){
            JOptionPane.showMessageDialog(null, "Selecionar Permissão", "Erro", 0);
            return false;
        }
        return true;
    }
}
