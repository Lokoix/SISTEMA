/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Beans.LoteBeans;
import Beans.ProprietarioBeans;
import Beans.VeiculoBeans;
import DAO.CidadeDAO;
import DAO.ModeloDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafae
 */
public class BaseNacional {

    public void getLoteBaseNacional1(List<String> result, LoteBeans lote) {
        //<--------VEICULO------->
        //Placa
        if (!result.get(5).toString().equals("")) {
            lote.getVeiculo().setPlaca(result.get(5).toString());
        }

        //Renavam
        if (!result.get(10).toString().equals("")) {
            lote.getVeiculo().setRenavam(result.get(10).toString());
        }

        //Modelo
        if (!result.get(12).toString().equals("")) {
            lote.getVeiculo().getModelo().setNome(result.get(12).toString().substring(result.get(12).indexOf("/") + 1));
            lote.getVeiculo().getModelo().getMarca().setNome(result.get(12).toString().substring(0, result.get(12).indexOf("/")));
        }

        //Cor
        if (!result.get(15).toString().equals("")) {
            lote.getVeiculo().setCor(result.get(15).toString());
        }

        //Ano Fabricacao
        if (!result.get(17).toString().equals("")) {
            lote.getVeiculo().setAnoFab(result.get(17).toString());
        }

        //Ano Modelo
        if (!result.get(18).toString().equals("")) {
            lote.getVeiculo().setAnoMod(result.get(18).toString());
        }

        //Combustivel
        if (!result.get(19).toString().equals("")) {
            lote.getVeiculo().setCombustivel(result.get(19).toString());
        }

        //Categoria
        if (!result.get(14).toString().equals("")) {
            lote.getVeiculo().setCategoria(result.get(14).toString());
        }

        //Tipo
        if (!result.get(13).toString().equals("")) {
            lote.getVeiculo().setTipo(result.get(13).toString());
        }

        //Especie
        if (!result.get(16).toString().equals("")) {
            lote.getVeiculo().setEspecie(result.get(16).toString());
        }

        //Potencia
        if (!result.get(21).toString().equals("")) {
            lote.getVeiculo().setPotencia(result.get(21).toString());
        }

        //Cilindrada
        if (!result.get(22).toString().equals("")) {
            lote.getVeiculo().setCilidrada(result.get(22).toString());
        }

        //Licenciamento
        
        //Cidade id
        

        //Cidade nome
        if (!result.get(6).toString().equals("")) {
            lote.getVeiculo().getCidade().setNome(result.get(6).toString());
        }
        //Cidade estado uf
        if (!result.get(7).toString().equals("")) {
            lote.getVeiculo().getCidade().getEstado().setUf(result.get(7).toString());
        }
        //<------ Fim de Veiculo --------->

        //<-------- Inicio Lote ---------->
        if (!result.get(29).toString().equals("")) {
            lote.setMotorBase(result.get(29).toString());
        }

        if (!result.get(8).toString().equals("")) {
            lote.setChassiBase(result.get(8).toString());
        }
        //<-------- Fim Lote ----------------->

    }
}
