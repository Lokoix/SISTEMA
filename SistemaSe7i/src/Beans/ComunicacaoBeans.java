/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.Date;

/**
 *
 * @author Eu
 */
public class ComunicacaoBeans {

    private int id;
    private String cpfCpnpj;
    private String nome;
    private String endereco;
    private String bairro;
    private String cep;
    private CidadeBeans cidade;
    private Date dataDeVenda;
    private Date entregaDoDoc;
    private Date reconFirma;

    public Date getEntregaDoDoc() {
        return entregaDoDoc;
    }

    public void setEntregaDoDoc(Date entregaDoDoc) {
        this.entregaDoDoc = entregaDoDoc;
    }

    public Date getReconFirma() {
        return reconFirma;
    }

    public void setReconFirma(Date reconFirma) {
        this.reconFirma = reconFirma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpfCpnpj() {
        return cpfCpnpj;
    }

    public void setCpfCpnpj(String cpfCpnpj) {
        this.cpfCpnpj = cpfCpnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public CidadeBeans getCidade() {
        return cidade;
    }

    public void setCidade(CidadeBeans cidade) {
        this.cidade = cidade;
    }

    public Date getDataDeVenda() {
        return dataDeVenda;
    }

    public void setDataDeVenda(Date dataDeVenda) {
        this.dataDeVenda = dataDeVenda;
    }

}
