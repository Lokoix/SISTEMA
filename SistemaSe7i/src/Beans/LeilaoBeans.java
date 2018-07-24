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
public class LeilaoBeans {

    private int id;
    private String descricao;
    private String dataInicio;
    private String dataPrevista;
    private LeiloeiroBeans leiloeiro;
    private String edital;
    private VistoriaBeans vistoriadora;
    private PatioBeans patio;
    private double custoLaudo;
    private CidadeBeans cidade;
    private int DesvComDoc;
    private int DesvSemDoc;
    private double DesvSucata;
    private String cartaDeNotificacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(String dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public LeiloeiroBeans getLeiloeiro() {
        return leiloeiro;
    }

    public void setLeiloeiro(LeiloeiroBeans leiloeiro) {
        this.leiloeiro = leiloeiro;
    }

    public String getEdital() {
        return edital;
    }

    public void setEdital(String edital) {
        this.edital = edital;
    }

    public VistoriaBeans getVistoriadora() {
        return vistoriadora;
    }

    public void setVistoriadora(VistoriaBeans vistoriadora) {
        this.vistoriadora = vistoriadora;
    }

    public PatioBeans getPatio() {
        return patio;
    }

    public void setPatio(PatioBeans patio) {
        this.patio = patio;
    }

    public double getCustoLaudo() {
        return custoLaudo;
    }

    public void setCustoLaudo(double custoLaudo) {
        this.custoLaudo = custoLaudo;
    }

    public CidadeBeans getCidade() {
        return cidade;
    }

    public void setCidade(CidadeBeans cidade) {
        this.cidade = cidade;
    }

    public int getDesvComDoc() {
        return DesvComDoc;
    }

    public void setDesvComDoc(int DesvComDoc) {
        this.DesvComDoc = DesvComDoc;
    }

    public int getDesvSemDoc() {
        return DesvSemDoc;
    }

    public void setDesvSemDoc(int DesvSemDoc) {
        this.DesvSemDoc = DesvSemDoc;
    }

    public double getDesvSucata() {
        return DesvSucata;
    }

    public void setDesvSucata(double DesvSucata) {
        this.DesvSucata = DesvSucata;
    }

    public String getCartaDeNotificacao() {
        return cartaDeNotificacao;
    }

    public void setCartaDeNotificacao(String cartaDeNotificacao) {
        this.cartaDeNotificacao = cartaDeNotificacao;
    }

    @Override
    public String toString() {
        return getDescricao(); //To change body of generated methods, choose Tools | Templates.
    }

}
