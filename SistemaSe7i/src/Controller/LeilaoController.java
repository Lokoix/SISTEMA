/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.LeilaoBeans;
import DAO.LeilaoDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class LeilaoController {
    
    LeilaoDAO leilaoD = new LeilaoDAO();
    
        public void cadastrar(LeilaoBeans leilao) {
        leilaoD.cadastrar(leilao);
    }

    public LeilaoBeans controlePreencherCampos(int id) {
        return leilaoD.preencherCampos(id);
    }

    public void controlePesquisa(String Pesquisa, DefaultTableModel Modelo) {
        leilaoD.buscarLeilao(Pesquisa, Modelo);
    }

    public void editarController(LeilaoBeans leilao) {
        leilaoD.editar(leilao);
    }

    public void deletarController(LeilaoBeans leilao) {
        leilaoD.deletar(leilao);
    }

    public boolean verificarDados(LeilaoBeans leilao) {
        if (leilao.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencher Campo Descrição", "Erro", 0);
            return false;
        }

        if (leilao.getLeiloeiro().equals("Selecionar Leiloeiro")) {
            JOptionPane.showMessageDialog(null, "Selecione o Leiloeiro", "Eroo", 0);
            return false;
        }

        if (leilao.getCidade().equals("Selecionar Cidade")) {
            JOptionPane.showMessageDialog(null, "Selecione a Cidade", "Eroo", 0);
            return false;
        }

        if (leilao.getPatio().equals("Selecionar Pátio")) {
            JOptionPane.showMessageDialog(null, "Selecione o Pátio", "Erro", 0);
            return false;
        }
        //System.out.println(empresa.getCnpj());
        if (leilao.getVistoriadora().equals("Selecionar Vistoriadora")) {
            JOptionPane.showMessageDialog(null, "Selecione a Vistoriadora", "Erro", 0);
            return false;
        }
        
        if (leilao.getDesvComDoc() == 0){
            JOptionPane.showMessageDialog(null, "Preencher Campo Desv. Doc", "Erro", 0);
            return false;
        } 
        
        if (leilao.getDesvSemDoc() == 0){
            JOptionPane.showMessageDialog(null, "Preencher Campo Desv. Sem Doc", "Erro", 0);
            return false;
        }
        
        if(leilao.getDesvSucata() == 0){
            JOptionPane.showMessageDialog(null, "Preencher Campo Desv. Sucata", "Erro", 0);
            return false;
        }
        
        if(leilao.getDataInicio() == null){
             JOptionPane.showMessageDialog(null, "Preencher Campo Data de Início", "Erro", 0);
            return false;
        }
        
        if(leilao.getDataPrevista() == null){
             JOptionPane.showMessageDialog(null, "Preencher Campo Data Prevista", "Erro", 0);
            return false;
        }
        return true;
    }
    
}
