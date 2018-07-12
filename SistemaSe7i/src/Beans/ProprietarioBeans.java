/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Eu
 */
public class ProprietarioBeans {

    private Integer id;
    private String cpfCpnpj;
    private String rg;
    private String nome;
    private String endereco;
    private String endNumero;
    private String complemento;
    private String bairro;

    public String getEndNumero() {
        return endNumero;
    }

    public void setEndNumero(String endNumero) {
        this.endNumero = endNumero;
    }
    private String cep;
    private CidadeBeans cidade = new CidadeBeans();
    private String dataCad;

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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getDataCad() {
        return dataCad;
    }

    public void setDataCad(String dataCad) {
        this.dataCad = dataCad;
    }

    public void exibe() {
        System.out.println("--------------"
                + "\nID: " + this.id
                + "\nNOME: " + this.getNome()
                + "\nCPF/CNPJ: " + this.cpfCpnpj
                + "\nEndereço: " + this.endereco
                + "\nBairro: " + this.bairro
                + "\nComplemento: " + this.complemento
                + "\nCep: " + this.cep
                + "\nCidade: " + this.cidade.getId() + "-" + this.getCidade().getNome()
                + "\nEstado: " + this.getCidade().getEstado().getId() + "-" + this.getCidade().getEstado().getNome()
                + "-" + this.getCidade().getEstado().getUf()
                + "-----------------");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

}
