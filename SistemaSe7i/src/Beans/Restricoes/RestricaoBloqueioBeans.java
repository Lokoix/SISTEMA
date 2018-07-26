/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.Restricoes;

import Beans.LoteBeans;

/**
 *
 * @author rafae
 */
public class RestricaoBloqueioBeans {
    
    private Integer id;
    private BloqueioBeans bloqueio = new BloqueioBeans();
    private LoteBeans lote = new LoteBeans();
    private String protocolo;
    private String processo;
    private String autoridade;
    private String oficio;
    private String laudo;
    private String orgaoExpedidor;
    private String descricao;
    private String municipioBloqueio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BloqueioBeans getBloqueio() {
        return bloqueio;
    }

    public void setBloqueio(BloqueioBeans bloqueio) {
        this.bloqueio = bloqueio;
    }

    public LoteBeans getLote() {
        return lote;
    }

    public void setLote(LoteBeans lote) {
        this.lote = lote;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public String getAutoridade() {
        return autoridade;
    }

    public void setAutoridade(String autoridade) {
        this.autoridade = autoridade;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public String getLaudo() {
        return laudo;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }

    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMunicipioBloqueio() {
        return municipioBloqueio;
    }

    public void setMunicipioBloqueio(String municipioBloqueio) {
        this.municipioBloqueio = municipioBloqueio;
    }

    

}
