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

    // Cadastro normal
    public void getLoteCadastro1(List<String> result, LoteBeans lote){          
        //<--------VEICULO------->
        //Placa
        if (!result.get(6).toString().equals("")) {
            lote.getVeiculo().setPlaca(result.get(6).toString());
        }

        //Renavam
        if (!result.get(9).toString().equals("")) {
            lote.getVeiculo().setRenavam(result.get(9).toString());
        }

        //Modelo
        if (!result.get(14).toString().equals("")) {
            lote.getVeiculo().getModelo().setNome(result.get(14).toString().substring(result.get(14).indexOf("/") + 1));
            lote.getVeiculo().getModelo().getMarca().setNome(result.get(14).toString().substring(0, result.get(14).indexOf("/")));
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
        if (!result.get(16).toString().equals("")) {
            lote.getVeiculo().setAnoMod(result.get(16).toString());
        }

        //Combustivel
        if (!result.get(18).toString().equals("")) {
            lote.getVeiculo().setCombustivel(result.get(18).toString());
        }

        //Categoria
        if (!result.get(19).toString().equals("")) {
            lote.getVeiculo().setCategoria(result.get(19).toString());
        }

        //Tipo
        if (!result.get(20).toString().equals("")) {
            lote.getVeiculo().setTipo(result.get(20).toString());
        }

        //Especie
        if (!result.get(22).toString().equals("")) {
            lote.getVeiculo().setEspecie(result.get(22).toString());
        }

        //Potencia
        if (!result.get(27).toString().equals("")) {
            lote.getVeiculo().setPotencia(result.get(27).toString());
        }

        //Cilindrada
        if (!result.get(28).toString().equals("")) {
            lote.getVeiculo().setCilidrada(result.get(28).toString());
        }

        //Licenciamento
        if (!result.get(37).toString().equals("")) {
            lote.getVeiculo().setLicenciamento(result.get(37).toString());
        }

        //Cidade id
        if (!result.get(7).toString().equals("")) {
            lote.getVeiculo().getCidade().setId(Integer.parseInt(result.get(7).toString()));
        }

        //Cidade nome
        if (!result.get(8).toString().equals("")) {
            lote.getVeiculo().getCidade().setNome(result.get(8).toString());
        }
        //Cidade estado uf
        if (!result.get(68).toString().equals("")) {
            lote.getVeiculo().getCidade().getEstado().setUf(result.get(68).toString());
        }
        //<------ Fim de Veiculo --------->
        
        
        //<------- Inicio Proprietario 

        //Nome
        if (!result.get(58).toString().equals("")) {
            lote.getProprietario().setNome(result.get(58).toString());
        }

        // Endereco
        if (!result.get(60).toString().equals("")) {
            lote.getProprietario().setEndereco(result.get(60).toString());
        }

        //Complemento
        if (!result.get(62).toString().equals("")) {
            lote.getProprietario().setComplemento(result.get(62).toString());
        }
        
        //Endereco numero
        if (!result.get(61).toString().equals("")) {
            lote.getProprietario().setEndNumero(result.get(61).toString());
        }

        //cep
        if (!result.get(64).toString().equals("")) {
            lote.getProprietario().setCep(result.get(64).toString());
        }

        //Cidade nome
        if (!result.get(66).toString().equals("")) {
            lote.getProprietario().getCidade().setNome(result.get(66).toString());
        }
        //Cidade estado uf
        if (!result.get(68).toString().equals("")) {
            lote.getProprietario().getCidade().getEstado().setUf(result.get(68).toString());
        }

        //rg
        if (!result.get(67).toString().equals("")) {
            lote.getProprietario().setRg(result.get(67).toString());
        }

        //cpf ou cnpj
        if (result.get(69).toString().substring(0, 3).equals("000")) {
            lote.getProprietario().setCpfCpnpj(result.get(69).toString().substring(3));
        } else {
            lote.getProprietario().setCpfCpnpj(result.get(69).toString());
        }

        //bairro
        if (!result.get(63).toString().equals("")) {
            lote.getProprietario().setBairro(result.get(63).toString());
        }
        
        //<-------- Fim Proprietario --------->
        
        //<-------- Inicio Lote ---------->
        
        if (!result.get(57).toString().equals("")) {
            lote.setMotorBase(result.get(57).toString());
        }
        
        if (!result.get(10).toString().equals("")) {
            lote.setChassiBase(result.get(10).toString());
        }
        //<-------- Fim Lote ----------------->
        
    }
    
    public void getLoteCadastro2(List<String> result, LoteBeans lote){
        
        lote.setObservacao(lote.getObservacao() + " - Cadastro sem registro");
        
    }
    
    public void getLoteCadastro3 (List<String> result, LoteBeans lote){
        //<--------VEICULO------->
        //Placa
        System.out.println("Placa: "+ result.get(4).toString());
        String placa = result.get(4).toString().substring(result.get(4).toString().indexOf(":")+1).trim();
        System.out.println(placa);
        if (!placa.equals("")) {
            lote.getVeiculo().setPlaca(placa);
        }

        //Renavam
        String renavam = result.get(9).toString().substring(result.get(9).toString().indexOf(":")+1).trim();
        if (!renavam.equals("")) {
            lote.getVeiculo().setRenavam(renavam);
        }

        //Modelo
        String marcaModelo = result.get(10).toString().substring(result.get(10).toString().indexOf(":")+1).trim();
        if (!marcaModelo.equals("")) {
            lote.getVeiculo().getModelo().setNome(marcaModelo.substring(marcaModelo.indexOf("/")+1));
            lote.getVeiculo().getModelo().getMarca().setNome(marcaModelo.substring(0, marcaModelo.indexOf("/")));
        }

        //Cor
        String cor = result.get(14).toString().substring(result.get(14).toString().indexOf(":")+1).trim();
        if (!cor.equals("")) {
            lote.getVeiculo().setCor(cor);
        }

        //Ano Fabricacao
        String fab = result.get(16).toString().substring(result.get(16).toString().indexOf(":")+1).trim();
        if (!fab.equals("")) {
            lote.getVeiculo().setAnoFab(fab);
        }

        //Ano Modelo
        String mod = result.get(17).toString().substring(result.get(17).toString().indexOf(":")+1).trim();
        if (!mod.equals("")) {
            lote.getVeiculo().setAnoMod(mod);
        }

        //Combustivel
        String combustivel = result.get(18).toString().substring(result.get(18).toString().indexOf(":")+1).trim();
        if (!combustivel.equals("")) {
            lote.getVeiculo().setCombustivel(combustivel);
        }

        //Categoria
        String cat = result.get(12).toString().substring(result.get(12).toString().indexOf(":")+1).trim();
        if (!cat.equals("")) {
            lote.getVeiculo().setCategoria(cat);
        }

        //Tipo
        String tipo = result.get(11).toString().substring(result.get(11).toString().indexOf(":")+1).trim();
        if (!tipo.equals("")) {
            lote.getVeiculo().setTipo(tipo);
        }

        //Especie
        String esp = result.get(15).toString().substring(result.get(15).toString().indexOf(":")+1).trim();
        if (!esp.equals("")) {
            lote.getVeiculo().setEspecie(esp);
        }

        //Potencia
        String pot = result.get(20).toString().substring(result.get(20).toString().indexOf(":")+1).trim();
        if (!pot.equals("")) {
            lote.getVeiculo().setPotencia(pot);
        }

        //Cilindrada
        String cil = result.get(21).toString().substring(result.get(21).toString().indexOf(":")+1).trim();
        if (!cil.equals("")) {
            lote.getVeiculo().setCilidrada(cil);
        }

        //Licenciamento            
        //Cidade id    

        //Cidade nome
        String cNome = result.get(6).toString().substring(result.get(6).toString().indexOf(":")+1).trim();
        if (!cNome.equals("")) {
            lote.getVeiculo().getCidade().setNome(cNome);
        }
        //Cidade estado uf
        String cUf = result.get(5).toString().substring(result.get(5).toString().indexOf(":")+1).trim();
        if (!cUf.equals("")) {
            lote.getVeiculo().getCidade().getEstado().setUf(cUf);
        }
        //<------ Fim de Veiculo --------->
        
        
        //<------- Inicio Proprietario 

        //Nome
        String nome = result.get(41).toString().substring(result.get(41).toString().indexOf(":")+1).trim();
        if (!nome.equals("")) {
            lote.getProprietario().setNome(nome);
        }

        // Endereco
        String end = result.get(44).toString().substring(result.get(44).toString().indexOf(":")+1).trim();
        if (!end.equals("")) {
            lote.getProprietario().setEndereco(end);
        }

        //Complemento
        String comp = result.get(46).toString().substring(result.get(46).toString().indexOf(":")+1).trim();
        if (!comp.equals("")) {
            lote.getProprietario().setComplemento(comp);
        }
        
        //Endereco numero
        String num = result.get(45).toString().substring(result.get(45).toString().indexOf(":")+1).trim();
        if (!num.equals("")) {
            lote.getProprietario().setEndNumero(num);
        }

        //cep
        String cep = result.get(47).toString().substring(result.get(47).toString().indexOf(":")+1).trim();
        if (!cep.equals("")) {
            lote.getProprietario().setCep(cep);
        }

        //Cidade nome
        if (!cNome.equals("")) {
            lote.getProprietario().getCidade().setNome(cNome);
        }
        //Cidade estado uf
        if (!cUf.equals("")) {
            lote.getProprietario().getCidade().getEstado().setUf(cUf);
        }

        //cpf ou cnpj
        String cpfCnpj = result.get(47).toString().substring(result.get(47).toString().indexOf(":")+1).trim();
        if (result.get(43).toString().substring(0, 3).equals("000")) {
            lote.getProprietario().setCpfCpnpj(result.get(43).toString().substring(3));
        } else {
            lote.getProprietario().setCpfCpnpj(result.get(43).toString());
        }

        //bairro
        
        
        //<-------- Fim Proprietario --------->
        
        //<-------- Inicio Lote ---------->
        
        //motor
        String motor = result.get(25).toString().substring(result.get(25).toString().indexOf(":")+1).trim();
        if (!motor.equals("")) {
            lote.setMotorBase(motor);
        }
        
        //chassi
        String chassi = result.get(7).toString().substring(result.get(7).toString().indexOf(":")+1).trim();
        if (!chassi.equals("")) {
            lote.setChassiBase(chassi);
        }
        //<-------- Fim Lote ----------------->
        
    }
    
}
