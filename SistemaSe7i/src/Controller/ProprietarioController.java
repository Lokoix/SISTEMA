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

    ProprietarioDAO daoProprietario = new ProprietarioDAO();
    CidadeController conCidade = new CidadeController();


    public ProprietarioBeans CorrigirProprietarioPesquisa(ProprietarioBeans proprietario) {
        if (daoProprietario.existe(proprietario)) {//SE EXISTE
            proprietario.setCidade(conCidade.CorrigirCidade(proprietario.getCidade()));

            ProprietarioBeans base = daoProprietario.carregar(proprietario); //CARREGA PROBRIETARIO BANCO
            base = compararProprietarios(proprietario, base);//COMPARA OS PROPRIETARIOS
            daoProprietario.alterar(base);//ALTERA O PROPRIETARIO
            return base;
        } else { //SE NÃO
            proprietario.setCidade(conCidade.CorrigirCidade(proprietario.getCidade()));
            daoProprietario.cadastrar(proprietario); //CADASTRA O PROPRIETARIO         
            return daoProprietario.carregar(proprietario);
        }
    }

    public ProprietarioBeans CorrigirProprietarioPesquisaCadastro(ProprietarioBeans proprietario) {
        if (daoProprietario.existe(proprietario)) {//SE EXISTE
            proprietario.setCidade(conCidade.CorrigirCidade(proprietario.getCidade()));

            ProprietarioBeans base = daoProprietario.carregar(proprietario); //CARREGA PROBRIETARIO BANCO
            
            if (proprietario.getCpfCpnpj().length() == 14) {
                base = compararProprietarios(proprietario, base);//COMPARA OS PROPRIETARIOS
            }else{
                base = compararProprietarios(base, proprietario);//COMPARA OS PROPRIETARIOS
            }
     
            daoProprietario.alterar(base);//ALTERA O PROPRIETARIO
            return base;
        } else { //SE NÃO
            proprietario.setCidade(conCidade.CorrigirCidade(proprietario.getCidade()));
            daoProprietario.cadastrar(proprietario); //CADASTRA O PROPRIETARIO         
            return daoProprietario.carregar(proprietario);
        }
    }

    public ProprietarioBeans compararProprietarios(ProprietarioBeans a, ProprietarioBeans b) {
        //id
        if (b.getId() == null) {
            b.setId(a.getId());
        }

        //nome
        if (b.getNome() == null) {
            b.setNome(a.getNome());
        }

        //cpfcnpj
        if (b.getCpfCpnpj() == null) {
            b.setCpfCpnpj(a.getCpfCpnpj());
        }

        //rg
        if (b.getRg() == null) {
            b.setRg(a.getRg());
        }

        //endereco
        if (b.getEndereco() == null) {
            b.setEndereco(a.getEndereco());
        }

        //endNumero
        if (b.getEndNumero() == null) {
            b.setEndNumero(a.getEndNumero());
        }

        //complemento
        if (b.getComplemento() == null) {
            b.setComplemento(a.getComplemento());
        }

        //bairro
        if (b.getBairro() == null) {
            b.setBairro(a.getBairro());
        }

        //cep
        if (b.getCep() == null) {
            b.setCep(a.getCep());
        }

        //cidade
        if (b.getCidade().getId() == null) {
            b.setCidade(a.getCidade());
        }

        return b;
    }
}
