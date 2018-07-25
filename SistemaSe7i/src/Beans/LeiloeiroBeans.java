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
public class LeiloeiroBeans {

    private int id;
    private String nome;
    private String endereco;
    private String numero;
    private String bairro;
    private String cep;
    private String telefone;
    private String celular;
    private String email;
    private String jucesp;
    private CidadeBeans cidade;
    private EmpresaBeans empresa;

    public EmpresaBeans getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaBeans empresa) {
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getJucesp() {
        return jucesp;
    }

    public void setJucesp(String jucesp) {
        this.jucesp = jucesp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void exibe() {
        System.out.println(this.id + " - " + this.getNome());
    }

    @Override
    public String toString() {
        return getNome();
    }

}
