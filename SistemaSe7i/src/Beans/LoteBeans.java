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

    private Integer id;
    private LeilaoBeans leilao = new LeilaoBeans();
    private ProprietarioBeans proprietario = new ProprietarioBeans();
    private ProprietarioBeans comunicao = new ProprietarioBeans();
    private ProprietarioBeans alienacao = new ProprietarioBeans();
    private VeiculoBeans veiculo = new VeiculoBeans();
    private String numeroLote;
    private String observacao;
    private String motorBase;
    private String chassiBase;
    private String dataCad;
    private double fipe;
    private double debito;

    public LoteBeans() {

    }

    public ProprietarioBeans getComunicao() {
        return comunicao;
    }

    public void setComunicao(ProprietarioBeans comunicao) {
        this.comunicao = comunicao;
    }

    public ProprietarioBeans getAlienacao() {
        return alienacao;
    }

    public void setAlienacao(ProprietarioBeans alienacao) {
        this.alienacao = alienacao;
    }

    public double getFipe() {
        return fipe;
    }

    public void setFipe(double fipe) {
        this.fipe = fipe;
    }

    public double getDebito() {
        return debito;
    }

    public void setDebito(double debito) {
        this.debito = debito;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LeilaoBeans getLeilao() {
        return leilao;
    }

    public void setLeilao(LeilaoBeans leilao) {
        this.leilao = leilao;
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

    public String getDataCad() {
        return dataCad;
    }

    public void setDataCad(String dataCad) {
        this.dataCad = dataCad;
    }

    public void exibe() {
        System.out.println("-----LOTE------");
        System.out.println("ID: " + this.getId()
                + "\nLeilão: " + this.getLeilao().getId() + ", " + this.getLeilao().getDescricao()
                + "\nNumero: " + this.getNumeroLote()
                + "\nChassi Base: " + this.getChassiBase()
                + "\nMotor Base: " + this.getMotorBase()
                + "\nObservação: " + this.getObservacao()
                + "\nData Cadastro: " + this.getDataCad());
        this.getVeiculo().exibe();
        this.getProprietario().exibe();
        System.out.println("-----LOTE FIM------");
    }

}
