/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.VistoriaBeans;
import DAO.VistoriaDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class VistoriaController {
    
    VistoriaDAO vistoriaD = new VistoriaDAO();
    
        public void cadastrar(VistoriaBeans vistoria) {
        vistoriaD.cadastrar(vistoria);
    }

    public VistoriaBeans controlePreencherCampos(int id) {
        return vistoriaD.preencherCampos(id);
    }

    public void controlePesquisa(String Pesquisa, DefaultTableModel Modelo) {
        vistoriaD.buscarVistoria(Pesquisa, Modelo);
    }

    public void editarController(VistoriaBeans vistoria) {
        vistoriaD.editar(vistoria);
    }

    public void deletarController(VistoriaBeans vistoria) {
        vistoriaD.deletar(vistoria);
    }

    public boolean verificarDados(VistoriaBeans patio) {
        if (patio.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencher Campo Nome", "Erro", 0);
            return false;
        }

        if (patio.getCidade().getId() == 0) {
            JOptionPane.showMessageDialog(null, "Preencher Campo Cidade", "Erro", 0);
            return false;
        }
        return true;
    }
}
