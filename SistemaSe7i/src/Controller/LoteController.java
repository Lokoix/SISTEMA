/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.LoteBeans;
import DAO.LoteDAO;
import java.awt.TextArea;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author rafae
 */
public class LoteController {

    LoteDAO daoLote = new LoteDAO();
    VeiculoController conVeiculo = new VeiculoController();
    ProprietarioController conProprietario = new ProprietarioController();

    public void corrigirLote(LoteBeans lote, JTextArea novo, JTextArea atualizado, String arquivo) {
        if (daoLote.existe(lote)) {
            LoteBeans base = daoLote.carregar(lote);
            this.compararLote(lote, base);
            daoLote.alterar(base);
            atualizado.setText(atualizado.getText() + "\n" + arquivo);
        } else {
            daoLote.cadastrar(lote);
            
            novo.setText(novo.getText() + "\n" + arquivo);
        }
    }
    
    public LoteBeans corrigirLotePesquisa (LoteBeans lote, JTextArea novo, JTextArea atualizado, String arquivo) {
        if (daoLote.existe(lote)) {
            LoteBeans base = daoLote.carregar(lote);
            this.compararLote(lote, base);
            daoLote.alterar(base);
            atualizado.setText(atualizado.getText() + "\n" + arquivo);
            return base;
        } else {
            daoLote.cadastrar(lote);
            
            novo.setText(novo.getText() + "\n" + arquivo);
            return daoLote.carregar(lote);
        }
    }

    public void corrigirLoteCadastro(LoteBeans lote, JTextArea novo, JTextArea atualizado, String arquivo) {
        if (daoLote.existe(lote)) {
            LoteBeans base = daoLote.carregar(lote);
            this.compararLoteCadastro(lote, base);
            daoLote.alterar(base);
            atualizado.setText(atualizado.getText() + "\n" + arquivo);
        } else {
            lote.exibe();
            daoLote.cadastrar(lote);
            novo.setText(novo.getText() + "\n" + arquivo);
        }
    }

    private void compararLoteCadastro(LoteBeans lote, LoteBeans base) {
        this.compararProprietarioLote(lote, base);
        this.compararVeiculoLote(lote, base);

        if (lote.getMotorBase() != null) {
            base.setMotorBase(lote.getMotorBase());
        }

        if (lote.getChassiBase() != null) {
            base.setChassiBase(lote.getChassiBase());
        }

        if (lote.getObservacao() != null && base.getObservacao() == null) {
            base.setObservacao(lote.getObservacao());
        }
        if (lote.getObservacao() != null && base.getObservacao() != null) {
            base.setObservacao(base.getObservacao() + " - " + lote.getObservacao());
        }

    }

    private void compararLote(LoteBeans lote, LoteBeans base) {
        this.compararProprietarioLote(lote, base);
        this.compararVeiculoLote(lote, base);

        if (base.getMotorBase() == null) {
            base.setMotorBase(lote.getMotorBase());
        }

        if (base.getChassiBase() == null) {
            System.out.println("Base: " + base.getChassiBase() + "  / Lote: " + lote.getChassiBase());
            base.setChassiBase(lote.getChassiBase());
        }
    }

    private void compararVeiculoLote(LoteBeans lote, LoteBeans base) {
        if (lote.getVeiculo().getId() != null && base.getVeiculo().getId() == null) {
            base.setVeiculo(lote.getVeiculo());
        }

        if (lote.getVeiculo().getId() != null && base.getVeiculo().getId() != null) {
            if (lote.getVeiculo().getId().intValue() != base.getVeiculo().getId().intValue()) {
                JOptionPane.showMessageDialog(null, "Pesquisas do lote " + base.getNumeroLote() + ", consta Veiculos diferentes!", "Aviso!", 2);
            }
        }

    }

    private void compararProprietarioLote(LoteBeans lote, LoteBeans base) {
        if (lote.getProprietario().getId() != null && base.getProprietario().getId() == null) {
            base.setProprietario(lote.getProprietario());
        }

        if (lote.getProprietario().getId() != null && lote.getProprietario().getId().intValue() != base.getProprietario().getId().intValue()) {
            JOptionPane.showMessageDialog(null, "Pesquisas do lote " + base.getNumeroLote() + ", consta Proprietarios diferentes!\n"
                    + "Proprietario lote: " + lote.getProprietario().getId() + " / base: " + base.getProprietario().getId(), "Aviso!", 2);
        }
    }

}
