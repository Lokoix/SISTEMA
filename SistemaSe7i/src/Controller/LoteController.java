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
            this.compararLote(lote, base);
            daoLote.alterar(base);
            
        } else {
            daoLote.cadastrar(lote);
        }
    }
    
    public void corrigirLoteCadastro(LoteBeans lote) {
        if (daoLote.existe(lote)) {
            LoteBeans base = daoLote.carregar(lote);
            this.compararLoteCadastro(lote, base);
            daoLote.alterar(base);
        } else {
            lote.exibe();
            daoLote.cadastrar(lote);
        }
    }

    private void compararLoteCadastro (LoteBeans lote, LoteBeans base){
        this.compararProprietarioLote(lote, base);
        this.compararVeiculoLote(lote, base);
        
        if (lote.getMotorBase() != null) {
            base.setMotorBase(lote.getMotorBase());
        }

        if (lote.getChassiBase() != null) {
            base.setChassiBase(lote.getChassiBase());
        }  
    }
    
    private void compararLote (LoteBeans lote, LoteBeans base){
        this.compararProprietarioLote(lote, base);
        this.compararVeiculoLote(lote, base);
        
        if (base.getMotorBase() == null) {
            base.setMotorBase(lote.getMotorBase());
        }

        if (base.getChassiBase() == null) {
            base.setChassiBase(lote.getChassiBase());
        }  
    }
    
    private void compararVeiculoLote(LoteBeans lote, LoteBeans base) {
        if (lote.getVeiculo().getId() != null && base.getVeiculo().getId() == null) {
            base.setVeiculo(lote.getVeiculo());
        }
        if (lote.getVeiculo().getId().intValue() != base.getVeiculo().getId().intValue()) {
            JOptionPane.showMessageDialog(null, "Pesquisas do lote " + base.getNumeroLote() + ", consta Veiculos diferentes!", "Aviso!", 2);
        }
    }

    private void compararProprietarioLote(LoteBeans lote, LoteBeans base) {
        if (lote.getProprietario().getId() != null && base.getProprietario().getId() == null) {
            base.setProprietario(lote.getProprietario());
        }
        
        if (lote.getProprietario().getId() != null && lote.getProprietario().getId().intValue() != base.getProprietario().getId().intValue()){
            JOptionPane.showMessageDialog(null, "Pesquisas do lote " + base.getNumeroLote() + ", consta Proprietarios diferentes!\n"
                    +"Proprietario lote: "+lote.getProprietario().getId()+ " / base: "+base.getProprietario().getId(), "Aviso!", 2);
        }
    }

}
