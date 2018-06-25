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
    private Date dataInicio;
    private Date dataPrevista;
    private LeiloeiroBeans leiloeiro;
    private String edital;
    private VistoriaBeans vistoriadora;
    private PatioBeans patio; 
    private double custoLaudo;
    private CidadeBeans cidade;
    private double DesvComDoc;
    private double DesvSemDoc;
    private double DesvSucata;
    private String cartaDeNotificacao;

    public PatioBeans getPatio() {
        return patio;
    }

    public void setPatio(PatioBeans patio) {
        this.patio = patio;
    }

    public double getDesvSucata() {
        return DesvSucata;
    }

    public void setDesvSucata(double DesvSucata) {
        this.DesvSucata = DesvSucata;
    }
    
    

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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
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

    public double getDesvComDoc() {
        return DesvComDoc;
    }

    public void setDesvComDoc(double DesvComDoc) {
        this.DesvComDoc = DesvComDoc;
    }

    public double getDesvSemDoc() {
        return DesvSemDoc;
    }

    public void setDesvSemDoc(double DesvSemDoc) {
        this.DesvSemDoc = DesvSemDoc;
    }

    public String getCartaDeNotificacao() {
        return cartaDeNotificacao;
    }

    public void setCartaDeNotificacao(String cartaDeNotificacao) {
        this.cartaDeNotificacao = cartaDeNotificacao;
    }
    
    
}
