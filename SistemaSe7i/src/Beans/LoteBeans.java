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
public class LoteBeans {

    private int id;
    private ProprietarioBeans proprietario;
    private ComunicacaoBeans comunicacao;
    private ProprietarioBeans alienacao;
    private VeiculoBeans veiculo;
    private LeilaoBeans leilao;
    private Date dataDeCadastro;
    private String numeroLote;
    private String observacao;
    private String motorBase;
    private String chassiBase;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProprietarioBeans getProprietario() {
        return proprietario;
    }

    public void setProprietario(ProprietarioBeans proprietario) {
        this.proprietario = proprietario;
    }

    public ComunicacaoBeans getComunicacao() {
        return comunicacao;
    }

    public void setComunicacao(ComunicacaoBeans comunicacao) {
        this.comunicacao = comunicacao;
    }

    public ProprietarioBeans getAlienacao() {
        return alienacao;
    }

    public void setAlienacao(ProprietarioBeans alienacao) {
        this.alienacao = alienacao;
    }

    public VeiculoBeans getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoBeans veiculo) {
        this.veiculo = veiculo;
    }

    public LeilaoBeans getLeilao() {
        return leilao;
    }

    public void setLeilao(LeilaoBeans leilao) {
        this.leilao = leilao;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getMotorBase() {
        return motorBase;
    }

    public void setMotorBase(String motorBase) {
        this.motorBase = motorBase;
    }

    public String getChassiBase() {
        return chassiBase;
    }

    public void setChassiBase(String chassiBase) {
        this.chassiBase = chassiBase;
    }

}
