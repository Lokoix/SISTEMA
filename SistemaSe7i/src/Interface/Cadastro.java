/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Beans.LoteBeans;
import Beans.ModeloBeans;
import Beans.VeiculoBeans;
import DAO.CidadeDAO;
import DAO.ModeloDAO;
import java.util.List;

/**
 *
 * @author rafael Piedade
 */
public class Cadastro {

    private VeiculoBeans veic = new VeiculoBeans();
    private ModeloDAO modD = new ModeloDAO();
    private CidadeDAO cidD = new CidadeDAO();

    public VeiculoBeans getVeiculo(List<String> result) {
        VeiculoBeans veic = new VeiculoBeans();
        ModeloDAO modD = new ModeloDAO();
        CidadeDAO cidD = new CidadeDAO();

        veic.setPlaca(result.get(6).toString());
        veic.setRenavam(result.get(9).toString());

        String marca = result.get(14).toString().substring(0, result.get(14).indexOf("/"));
        String modelo = result.get(14).toString().substring(result.get(14).indexOf("/") + 1);
        veic.setModelo(modD.CarregarModelo(modelo, marca));

        veic.setCor(result.get(15).toString());
        veic.setAnoMod(result.get(16).toString());
        veic.setAnoFab(result.get(17).toString());
        veic.setCombustivel(result.get(18).toString());
        veic.setCategoria(result.get(19).toString());
        veic.setTipo(result.get(20).toString());
        veic.setEspecie(result.get(22).toString());
        veic.setPotencia(result.get(27).toString());
        veic.setCilidrada(result.get(28).toString());
        veic.setLicenciamento(result.get(37).toString());
        veic.setCidade(cidD.getCidadeId(Integer.parseInt(result.get(7).toString())));

        return veic;
    }

}
