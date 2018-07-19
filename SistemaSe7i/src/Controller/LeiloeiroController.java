/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.LeiloeiroBeans;
import DAO.LeiloeiroDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class LeiloeiroController {
    
        LeiloeiroDAO leiloeiroD = new LeiloeiroDAO();

    public void cadastrar(LeiloeiroBeans leiloeiro) {
        leiloeiroD.cadastrar(leiloeiro);
    }

    public LeiloeiroBeans controlePreencherCampos(int id) {
        return leiloeiroD.preencherCampos(id);
    }

    public void controlePesquisa(String Pesquisa, DefaultTableModel Modelo) {
        leiloeiroD.buscarLeiloeiro(Pesquisa, Modelo);
    }

    public void editarController(LeiloeiroBeans leiloeiro) {
        leiloeiroD.editar(leiloeiro);
    }

    public void deletarController(LeiloeiroBeans leiloeiro) {
        leiloeiroD.deletar(leiloeiro);
    }

    public boolean verificarDados(LeiloeiroBeans leiloeiro) {
        if (leiloeiro.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencher Campo Nome", "Erro", 0);
            return false;
        }

        if (leiloeiro.getEmail().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencher Campo Nome Fantasia", "Eroo", 0);
            return false;
        }

        if (leiloeiro.getCidade().getId() == 0) {
            JOptionPane.showMessageDialog(null, "Selecionar Cidade", "Erro", 0);
            return false;
        }
        
        if(leiloeiro.getEmpresa().getId() == 0){
            JOptionPane.showMessageDialog(null, "Selecionar Empresa");
        }
        
        return true;
    }
    
}
