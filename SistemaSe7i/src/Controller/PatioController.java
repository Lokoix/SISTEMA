/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.PatioBeans;
import DAO.PatioDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guilhermengenharia
 */
public class PatioController {

    PatioDAO patioD = new PatioDAO();

    public void cadastrar(PatioBeans patio) {
        patioD.cadastrar(patio);
    }

    public PatioBeans controlePreencherCampos(int id) {
        return patioD.preencherCampos(id);
    }

    public void controlePesquisa(String Pesquisa, DefaultTableModel Modelo) {
        patioD.buscarPatio(Pesquisa, Modelo);
    }

    public void editarController(PatioBeans patio) {
        patioD.editar(patio);
    }

    public void deletarController(PatioBeans patio) {
        patioD.deletar(patio);
    }

    public boolean verificarDados(PatioBeans patio) {
        if (patio.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencher Campo Nome", "Erro", 0);
            return false;
        }

        if (patio.getResponsavel().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencher Campo Responsável", "Erro", 0);
            return false;
        }


        if (patio.getCidade().getId() == 0) {
            JOptionPane.showMessageDialog(null, "Preencher Campo Cidade", "Erro", 0);
            return false;
        }
        return true;
    }

}
