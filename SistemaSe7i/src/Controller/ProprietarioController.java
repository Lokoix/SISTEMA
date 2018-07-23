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
        ProprietarioBeans base = new ProprietarioBeans();
        if (daoProprietario.existe(proprietario)) {//SE EXISTE
            proprietario.setCidade(conCidade.CorrigirCidade(proprietario.getCidade()));

            base = daoProprietario.carregar(proprietario); //CARREGA PROBRIETARIO BANCO
            compararProprietarios(proprietario, base);//COMPARA OS PROPRIETARIOS
            daoProprietario.alterar(base);//ALTERA O PROPRIETARIO
            return base;
        } else { //SE NÃO
            proprietario.setCidade(conCidade.CorrigirCidade(proprietario.getCidade()));
            daoProprietario.cadastrar(proprietario); //CADASTRA O PROPRIETARIO         
            return daoProprietario.carregar(proprietario);
        }
    }

    public ProprietarioBeans CorrigirProprietarioPesquisaCadastro(ProprietarioBeans proprietario) {
        ProprietarioBeans base = new ProprietarioBeans();
        if (daoProprietario.existe(proprietario)) {//SE EXISTE
            proprietario.setCidade(conCidade.CorrigirCidade(proprietario.getCidade()));

            base = daoProprietario.carregar(proprietario); //CARREGA PROBRIETARIO BANCO
            compararProprietarios(proprietario, base);//COMPARA OS PROPRIETARIOS
            daoProprietario.alterar(base);//ALTERA O PROPRIETARIO
            return base;
        } else { //SE NÃO
            proprietario.setCidade(conCidade.CorrigirCidade(proprietario.getCidade()));
            daoProprietario.cadastrar(proprietario); //CADASTRA O PROPRIETARIO         
            return daoProprietario.carregar(proprietario);
        }
    }

    public void compararProprietarios(ProprietarioBeans proprietario, ProprietarioBeans base) {
        //id
        if (base.getId() == null) {
            base.setId(proprietario.getId());
        }

        //nome
        if (base.getNome() == null) {
            base.setNome(proprietario.getNome());
        }

        //cpfcnpj
        if (base.getCpfCpnpj() == null) {
            base.setCpfCpnpj(proprietario.getCpfCpnpj());
        }

        //rg
        if (base.getRg() == null) {
            base.setRg(proprietario.getRg());
        }

        //endereco
        if (base.getEndereco() == null) {
            base.setEndereco(proprietario.getEndereco());
        }

        //endNumero
        if (base.getEndNumero() == null) {
            base.setEndNumero(proprietario.getEndNumero());
        }

        //complemento
        if (base.getComplemento() == null) {
            base.setComplemento(proprietario.getComplemento());
        }

        //bairro
        if (base.getBairro() == null) {
            base.setBairro(proprietario.getBairro());
        }

        //cep
        if (base.getCep() == null) {
            base.setCep(proprietario.getCep());
        }

        //cidade
        if (base.getCidade().getId() == null) {
            base.setCidade(proprietario.getCidade());
        }
    }
}
