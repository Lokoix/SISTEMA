/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.LoteBeans;
import DAO.LoteDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class LoteController {

    LoteDAO daoLote = new LoteDAO();
    VeiculoController conVeiculo = new VeiculoController();
    ProprietarioController conProprietario = new ProprietarioController();

    public void corrigirLote(LoteBeans lote) {
        if (daoLote.existe(lote)) {
            LoteBeans base = daoLote.carregar(lote);
            this.compararProprietarioLote(lote, base);
            this.compararVeiculoLote(lote, base);
            daoLote.alterar(base);
        } else {
            lote.exibe();
            daoLote.cadastrar(lote);
        }
    }

    private void compararVeiculoLote(LoteBeans lote, LoteBeans base) {
        if (lote.getVeiculo().getId() != null && base.getVeiculo().getId() == null) {
            base.setVeiculo(lote.getVeiculo());
        }
        if (lote.getVeiculo().getId() != base.getVeiculo().getId()) {
            JOptionPane.showMessageDialog(null, "Pesquisas do lote " + base.getNumeroLote() + ", consta Veiculos diferentes!", "Aviso!", 2);
        }
    }

    private void compararProprietarioLote(LoteBeans lote, LoteBeans base) {
        if (lote.getProprietario().getId() != null && base.getProprietario().getId() == null) {
            base.setProprietario(lote.getProprietario());
        }
        if (lote.getVeiculo().getId() != base.getVeiculo().getId()) {
            JOptionPane.showMessageDialog(null, "Pesquisas do lote " + base.getNumeroLote() + ", consta Proprietarios diferentes!", "Aviso!", 2);
        }
    }

}
