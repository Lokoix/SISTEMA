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
    private LeilaoBeans leilao;
    private String lote;
    private Date dataCadastro;
    private Date dataApreencao;
    private ProprietarioBeans proprietario;
    private VeiculoBeans veiculo;
    private String observacao;
    private ProprietarioBeans comunicacao;
    private ProprietarioBeans alienacao;
    private String motorBase;
    private String chassiBase;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LeilaoBeans getLeilao() {
        return leilao;
    }

    public void setLeilao(LeilaoBeans leilao) {
        this.leilao = leilao;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataApreencao() {
        return dataApreencao;
    }

    public void setDataApreencao(Date dataApreencao) {
        this.dataApreencao = dataApreencao;
    }

    public ProprietarioBeans getProprietario() {
        return proprietario;
    }

    public void setProprietario(ProprietarioBeans proprietario) {
        this.proprietario = proprietario;
    }

    public VeiculoBeans getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoBeans veiculo) {
        this.veiculo = veiculo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public ProprietarioBeans getComunicacao() {
        return comunicacao;
    }

    public void setComunicacao(ProprietarioBeans comunicacao) {
        this.comunicacao = comunicacao;
    }

    public ProprietarioBeans getAlienacao() {
        return alienacao;
    }

    public void setAlienacao(ProprietarioBeans alienacao) {
        this.alienacao = alienacao;
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
