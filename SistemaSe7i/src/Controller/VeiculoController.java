/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.VeiculoBeans;
import DAO.VeiculoDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class VeiculoController {

    VeiculoDAO daoVeiculo = new VeiculoDAO();
    CidadeController conCidade = new CidadeController();
    ModeloController conModelo = new ModeloController();

    public VeiculoBeans corrigirVeiculoPesquisa(VeiculoBeans veiculo) {
        if (daoVeiculo.existe(veiculo)) {//SE EXISTE
            veiculo.setModelo(conModelo.corrigirModelo(veiculo.getModelo()));
            veiculo.setCidade(conCidade.CorrigirCidade(veiculo.getCidade()));
            
            VeiculoBeans base = daoVeiculo.carregar(veiculo);  //CARREGA veiculo do BANCO
            base = CompararAutomovel(veiculo, base);//COMPARA OS PROPRIETARIOS
            daoVeiculo.AlterarVeiculo(base); //ALTERA O PROPRIETARIO
            return base;
        } else { 
            veiculo.setModelo(conModelo.corrigirModelo(veiculo.getModelo()));
            veiculo.setCidade(conCidade.CorrigirCidade(veiculo.getCidade()));
            daoVeiculo.cadastrar(veiculo);
            return daoVeiculo.carregar(veiculo);
        }
    }
    
    public VeiculoBeans corrigirVeiculoPesquisaCadastro(VeiculoBeans veiculo) {
        if (daoVeiculo.existe(veiculo)) {//SE EXISTE
            veiculo.setModelo(conModelo.corrigirModelo(veiculo.getModelo()));
            veiculo.setCidade(conCidade.CorrigirCidade(veiculo.getCidade()));
            
                   
            VeiculoBeans base = daoVeiculo.carregar(veiculo);  //CARREGA veiculo do BANCO
            base.exibe();
            veiculo.exibe();
            VeiculoBeans novo = new VeiculoBeans();
            novo = CompararAutomovel(base, veiculo);//COMPARA OS PROPRIETARIOS
            daoVeiculo.AlterarVeiculo(novo); //ALTERA O PROPRIETARIO
            
            return base;
        } else { 
            veiculo.setModelo(conModelo.corrigirModelo(veiculo.getModelo()));
            veiculo.setCidade(conCidade.CorrigirCidade(veiculo.getCidade()));
            daoVeiculo.cadastrar(veiculo);
            return daoVeiculo.carregar(veiculo);
        }
    }

    public VeiculoBeans CompararAutomovel(VeiculoBeans base, VeiculoBeans veiculo) {
        if(veiculo.getId() == null){
            veiculo.setId(base.getId());
        }
        
        if (veiculo.getPlaca() == null) {
            veiculo.setPlaca(base.getPlaca());
        }

        if (veiculo.getRenavam() == null) {
            veiculo.setRenavam(base.getRenavam());
        }

        if (veiculo.getModelo().getId() == null) {
            veiculo.setModelo(base.getModelo());
        }

        if (veiculo.getCor() == null) {
            veiculo.setCor(base.getCor());
        }

        if (veiculo.getAnoFab() == null) {
            veiculo.setAnoFab(base.getAnoFab());
        }

        if (veiculo.getAnoMod() == null) {
            veiculo.setAnoMod(base.getAnoMod());
        }

        if (veiculo.getCombustivel() == null) {
            veiculo.setCombustivel(base.getCombustivel());
        }

        if (veiculo.getCategoria() == null) {
            veiculo.setCategoria(base.getCategoria());
        }


        if (veiculo.getTipo() == null) {
            veiculo.setTipo(base.getTipo());
        }


        if (veiculo.getEspecie() == null) {
            veiculo.setEspecie(base.getEspecie());
        }

        if (veiculo.getPotencia() == null) {
            veiculo.setPotencia(base.getPotencia());
        }

        if (veiculo.getCilidrada() == null) {
            veiculo.setCilidrada(base.getCilidrada());
        }

        if (veiculo.getLicenciamento() == null || veiculo.getLicenciamento().equals("")) {
            veiculo.setLicenciamento(base.getLicenciamento());
        }

        if (veiculo.getCidade().getId() == null){
            veiculo.setCidade(base.getCidade());
        }
        
        return veiculo;
    }

}
