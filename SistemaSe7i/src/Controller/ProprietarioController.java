/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.ProprietarioBeans;
import DAO.ProprietarioDAO;

/**
 *
 * @author rafae
 */
public class ProprietarioController {
    ProprietarioDAO proD = new ProprietarioDAO();
    
    
    public void CorrigirProprietarioPesquisa(ProprietarioBeans a) {
        if (proD.ExisteProprietario(a)) {//SE EXISTE
            ProprietarioBeans b = proD.getProprietarioBeans(a); //CARREGA PROBRIETARIO BANCO
            b = compararProprietarios(a, b);//COMPARA OS PROPRIETARIOS
            proD.AlterarProprietario(b);//ALTERA O PROPRIETARIO
        } else { //SE NÃO
           proD.CadastrarProprietario(a); //CADASTRA O PROPRIETARIO                 
        }
    }
    
    public void CorrigirProprietarioPesquisaCadastro(ProprietarioBeans a) {
        if (proD.ExisteProprietario(a)) {//SE EXISTE
            ProprietarioBeans b = proD.getProprietarioBeans(a); //CARREGA PROBRIETARIO BANCO
            b = compararProprietarios(b, a);//COMPARA OS PROPRIETARIOS
            proD.AlterarProprietario(b);//ALTERA O PROPRIETARIO
        } else { //SE NÃO
           proD.CadastrarProprietario(a); //CADASTRA O PROPRIETARIO                 
        }
    }
    
    public ProprietarioBeans compararProprietarios(ProprietarioBeans a, ProprietarioBeans b){
        //id
        if(b.getId() == null){
            b.setId(a.getId());
        }

        //nome
        if(b.getNome().equals("") || b.getNome() == null){
            b.setNome(a.getNome());
        }
        
        //cpfcnpj
        if(b.getCpfCpnpj().equals("") || b.getCpfCpnpj() == null){
            b.setCpfCpnpj(a.getCpfCpnpj());
        }
        
        //rg
        if(b.getRg() == null){
            b.setRg(a.getRg());
        }
        
        //endereco
        if(b.getEndereco() == null){
            b.setEndereco(a.getEndereco());
        }
        
        //endNumero
        if(b.getEndNumero() == null){
            b.setEndNumero(a.getEndNumero());
        }
        
        //complemento
        if(b.getComplemento() == null){
            b.setComplemento(a.getComplemento());
        }
        
        //bairro
        if(b.getBairro() == null){
            b.setBairro(a.getBairro());
        }
        
        //cep
        if(b.getCep() == null){
            b.setCep(a.getCep());
        }
        
        //cidade
        if(b.getCidade().getId() == null){
            b.setCidade(a.getCidade());
        }
            
        return b;
    }
}
