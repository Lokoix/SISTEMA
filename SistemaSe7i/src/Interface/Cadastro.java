/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Beans.LoteBeans;
import Beans.ModeloBeans;
import Beans.ProprietarioBeans;
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

        
        
        if(result.get(6).toString().equals("")){
            
        }else{
            
        }
        
        
        if(){
            
        }
        if(){
            
        }
        if(){
            
        }
        if(){
            
        }
        if(){
            
        }
        if(){
            
        }
        if(){
            
        }
        if(){
            
        }
        if(){
            
        }
        
        
        
        
        
        veic.setPlaca(result.get(6).toString());
        veic.setRenavam(result.get(9).toString());

        String marca = result.get(14).toString().substring(0, result.get(14).indexOf("/"));
        String modelo = result.get(14).toString().substring(result.get(14).indexOf("/") + 1);
        veic.setModelo(modD.CarregarModelo(modelo, marca));

        if (result.get(1).toString().equals("")) {
            veic.setCor(null);
        }
        veic.setCor(result.get(15).toString());

        if (result.get(16).toString().equals("")) {
            veic.setAnoMod(null);
        } else {
            veic.setAnoMod(result.get(16).toString());
        }

        if (result.get(17).toString().equals("")) {
            veic.setAnoFab(null);
        } else {
            veic.setAnoFab(result.get(17).toString());
        }

        if (result.get(18).toString().equals("")) {
            veic.setCombustivel(null);
        } else {
            veic.setCombustivel(result.get(18).toString());
        }

        if (result.get(19).toString().equals("")) {
            veic.setCategoria(null);
        } else {
            veic.setCategoria(result.get(19).toString());
        }

        if (result.get(20).toString().equals("")) {
            veic.setTipo(null);
        } else {
            veic.setTipo(result.get(20).toString());
        }

        if (result.get(22).toString().equals("")) {
            veic.setEspecie(null);
        } else {
            veic.setEspecie(result.get(22).toString());
        }

        if (result.get(27).toString().equals("")) {
            veic.setPotencia(null);
        } else {
            veic.setPotencia(result.get(27).toString());
        }

        if (result.get(28).toString().equals("")) {
            veic.setCilidrada(null);
        } else {
            veic.setCilidrada(result.get(28).toString());
        }

        veic.setLicenciamento(result.get(37).toString().trim());

        if (result.get(28).toString().equals("")) {
            veic.setCidade(null);
            System.out.println("È NULO CIDADE");
        } else {
            veic.setCidade(cidD.getCidadeId(Integer.parseInt(result.get(7).toString())));
        }

        return veic;
    }

    public ProprietarioBeans getProprietario(List<String> result) {
        ProprietarioBeans prop = new ProprietarioBeans();
        CidadeDAO cidD = new CidadeDAO();
        String end = "";

        prop.setNome(result.get(58).toString());

        if (result.get(69).toString().substring(0, 3).equals("000")) {
            prop.setCpfCpnpj(result.get(69).toString().substring(3));
        } else {
            prop.setCpfCpnpj(result.get(69).toString());
        }

        end = result.get(60).toString() + ", " + result.get(61).toString();
        if (!result.get(62).toString().equals("")) {
            end += "-" + result.get(62).toString();
        }
        prop.setEndereco(end);

        prop.setBairro(result.get(63).toString());
        prop.setCep(result.get(64).toString());
        prop.setCidade(cidD.getCidadeId(Integer.parseInt(result.get(65).toString())));

        return prop;
    }

}
