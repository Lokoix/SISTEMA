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
    private VistoriadoraBeans vistoriadora;
    private DelegaciaBeans delegacia;
    private double custoLaudo;
    private String tipoPatio;
    private CidadeBeans cidade;
    private double DesvComDoc;
    private double DesvSemDoc;
    private String nomePatio;
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

    public VistoriadoraBeans getVistoriadora() {
        return vistoriadora;
    }

    public void setVistoriadora(VistoriadoraBeans vistoriadora) {
        this.vistoriadora = vistoriadora;
    }

    public DelegaciaBeans getDelegacia() {
        return delegacia;
    }

    public void setDelegacia(DelegaciaBeans delegacia) {
        this.delegacia = delegacia;
    }

    public double getCustoLaudo() {
        return custoLaudo;
    }

    public void setCustoLaudo(double custoLaudo) {
        this.custoLaudo = custoLaudo;
    }

    public String getTipoPatio() {
        return tipoPatio;
    }

    public void setTipoPatio(String tipoPatio) {
        this.tipoPatio = tipoPatio;
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

    public String getNomePatio() {
        return nomePatio;
    }

    public void setNomePatio(String nomePatio) {
        this.nomePatio = nomePatio;
    }

    public String getCartaDeNotificacao() {
        return cartaDeNotificacao;
    }

    public void setCartaDeNotificacao(String cartaDeNotificacao) {
        this.cartaDeNotificacao = cartaDeNotificacao;
    }
    
    
}
