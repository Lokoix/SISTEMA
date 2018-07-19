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

    VeiculoDAO veiD = new VeiculoDAO();
    CidadeController cidC = new CidadeController();

    public VeiculoBeans CorrigirAutomovel(VeiculoBeans a) {
        if (veiD.ExisteVeiculo(a)) {
            int id = veiD.BuscarVeiculo(a);
            VeiculoBeans b = new VeiculoBeans();
            b = veiD.getVeiculo(id);
            b = CompararAutomovel(a, b);
            veiD.AlterarVeiculo(b);
            return b;
        } else {
            
            a.setCidade(cidC.CorrigirCidade(a.getCidade()));
            
            veiD.CadastrarVeiculo(a);
            a.setId(veiD.BuscarVeiculo(a));
            return a;
        }
    }

    public VeiculoBeans CompararAutomovel(VeiculoBeans a, VeiculoBeans b) {
        if (b.getPlaca() == null) {
            b.setPlaca(a.getPlaca());
        }

        if (b.getRenavam() == null) {
            b.setRenavam(a.getRenavam());
        }

        if (b.getModelo() == null) {
            b.setModelo(a.getModelo());
        }

        if (b.getCor() == null) {
            b.setCor(a.getCor());
        }

        if (b.getAnoFab() == null) {
            b.setAnoFab(a.getAnoFab());
        }

        if (b.getAnoMod() == null) {
            b.setAnoMod(a.getAnoMod());
        }

        if (b.getCombustivel() == null) {
            b.setCombustivel(a.getCombustivel());
        }

        if (b.getCategoria() == null) {
            b.setCategoria(a.getCategoria());
        }

        if (b.getTipo() == null) {
            b.setTipo(a.getTipo());
        }

        if (b.getEspecie() == null) {
            b.setEspecie(a.getEspecie());
        }

        if (b.getPotencia() == null) {
            b.setPotencia(a.getPotencia());
        }

        if (b.getCilidrada() == null) {
            b.setCilidrada(a.getCilidrada());
        }

        if (b.getLicenciamento() == null || b.getLicenciamento().equals("")) {
            b.setLicenciamento(a.getLicenciamento());
        }

        if (b.getCidade() == null){
            b.setCidade(a.getCidade());
        }
        
        return b;
    }

}
