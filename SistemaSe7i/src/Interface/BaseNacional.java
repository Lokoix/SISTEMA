/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Beans.ProprietarioBeans;
import Beans.VeiculoBeans;
import DAO.CidadeDAO;
import DAO.ModeloDAO;
import java.util.ArrayList;

/**
 *
 * @author rafae
 */
public class BaseNacional {

    private VeiculoBeans veic = new VeiculoBeans();
    private ModeloDAO modD = new ModeloDAO();
    private CidadeDAO cidD = new CidadeDAO();
    
    
    public VeiculoBeans getVeiculo(ArrayList<String> result){
        VeiculoBeans veic = new VeiculoBeans();
        ModeloDAO modD = new ModeloDAO();
        CidadeDAO cidD = new CidadeDAO();

        //Placa
        if (!result.get(4).toString().equals("")) {
            veic.setPlaca(result.get(4).toString());
        }

        //Renavam
        if (!result.get(9).toString().equals("")) {
            veic.setRenavam(result.get(9).toString());
        }

        //Modelo
        if (!result.get(11).toString().equals("")) {
            veic.getModelo().setNome(result.get(11).toString().substring(result.get(11).indexOf("/") + 1));
            veic.getModelo().getMarca().setNome(result.get(11).toString().substring(0, result.get(11).indexOf("/")));
        }

        //Cor
        if (!result.get(14).toString().equals("")) {
            veic.setCor(result.get(14).toString());
        }

        //Ano Fabricacao
        if (!result.get(16).toString().equals("")) {
            veic.setAnoFab(result.get(16).toString());
        }

        //Ano Modelo
        if (!result.get(17).toString().equals("")) {
            veic.setAnoMod(result.get(17).toString());
        }

        //Combustivel
        if (!result.get(18).toString().equals("")) {
            veic.setCombustivel(result.get(18).toString());
        }

        //Categoria
       // if (!result.get(19).toString().equals("")) {
       //     veic.setCategoria(result.get(19).toString());
       // }

        //Tipo
        //if (!result.get(20).toString().equals("")) {
        //    veic.setTipo(result.get(20).toString());
        //}

        //Especie
        //if (!result.get(22).toString().equals("")) {
        //    veic.setEspecie(result.get(22).toString());
        //}

        //Potencia
        if (!result.get(20).toString().equals("")) {
            veic.setPotencia(result.get(20).toString());
        }

        //Cilindrada
        if (!result.get(21).toString().equals("")) {
            veic.setCilidrada(result.get(21).toString());
        }

        //Licenciamento
        //if (!result.get(37).toString().equals("")) {
        //    veic.setLicenciamento(result.get(37).toString());
        //}

        //Cidade id
        //if (!result.get(7).toString().equals("")) {
        //    veic.getCidade().setId(Integer.parseInt(result.get(7).toString()));
        //}

        //Cidade nome
        if (!result.get(5).toString().equals("")) {
            veic.getCidade().setNome(result.get(5).toString());
        }
        //Cidade estado uf
        if (!result.get(6).toString().equals("")) {
            veic.getCidade().getEstado().setUf(result.get(6).toString());
        }
        return veic;
    }
    
    public ProprietarioBeans getProprietario(ArrayList<String> result) {
        ProprietarioBeans prop = new ProprietarioBeans();

        //cpf ou cnpj
        if (result.get(46).toString().substring(0, 3).equals("000")) {
            prop.setCpfCpnpj(result.get(46).toString().substring(3));
        } else {
            prop.setCpfCpnpj(result.get(46).toString());
        }
        
        /*//Nome
        if (!result.get(58).toString().equals("")) {
            prop.setNome(result.get(58).toString());
        }

        // Endereco
        if (!result.get(60).toString().equals("")) {
            prop.setEndereco(result.get(60).toString());
        }

        //Complemento
        if (!result.get(62).toString().equals("")) {
            prop.setComplemento(result.get(62).toString());
        }
        
        //Endereco numero
        if (!result.get(61).toString().equals("")) {
            prop.setEndNumero(result.get(61).toString());
        }

        //cep
        if (!result.get(64).toString().equals("")) {
            prop.setCep(result.get(64).toString());
        }

        //Cidade nome
        if (!result.get(66).toString().equals("")) {
            prop.getCidade().setNome(result.get(66).toString());
        }
        //Cidade estado uf
        if (!result.get(68).toString().equals("")) {
            prop.getCidade().getEstado().setUf(result.get(68).toString());
        }

        //rg
        if (!result.get(67).toString().equals("")) {
            prop.setRg(result.get(67).toString());
        }

        //cpf ou cnpj
        if (result.get(69).toString().substring(0, 3).equals("000")) {
            prop.setCpfCpnpj(result.get(69).toString().substring(3));
        } else {
            prop.setCpfCpnpj(result.get(69).toString());
        }

        //bairro
        if (!result.get(63).toString().equals("")) {
            prop.setBairro(result.get(63).toString());
        }*/
        
        return prop;
    }
    
    
    
}
