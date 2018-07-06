/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author rafae
 */
public class VeiculoBeans {

    private Integer id;
    private String placa;
    private String renavam;
    private String chassiVeiculo;
    private String motorVeiculo;
    private ModeloBeans modelo = new ModeloBeans();
    private String cor;
    private String anoFab;
    private String anoMod;
    private String combustivel;
    private String categoria;
    private String tipo;
    private String especie;
    private String potencia;
    private String cilidrada;
    private String licenciamento;
    private CidadeBeans cidade = new CidadeBeans();
    private String apreencao;
    private String dataCad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getChassiVeiculo() {
        return chassiVeiculo;
    }

    public void setChassiVeiculo(String chassiVeiculo) {
        this.chassiVeiculo = chassiVeiculo;
    }

    public String getMotorVeiculo() {
        return motorVeiculo;
    }

    public void setMotorVeiculo(String motorVeiculo) {
        this.motorVeiculo = motorVeiculo;
    }

    public ModeloBeans getModelo() {
        return modelo;
    }

    public void setModelo(ModeloBeans modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAnoFab() {
        return anoFab;
    }

    public void setAnoFab(String anoFab) {
        this.anoFab = anoFab;
    }

    public String getAnoMod() {
        return anoMod;
    }

    public void setAnoMod(String anoMod) {
        this.anoMod = anoMod;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getCilidrada() {
        return cilidrada;
    }

    public void setCilidrada(String cilidrada) {
        this.cilidrada = cilidrada;
    }

    public String getLicenciamento() {
        return licenciamento;
    }

    public void setLicenciamento(String licenciamento) {
        this.licenciamento = licenciamento;
    }

    public CidadeBeans getCidade() {
        return cidade;
    }

    public void setCidade(CidadeBeans cidade) {
        this.cidade = cidade;
    }

    public String getApreencao() {
        return apreencao;
    }

    public void setApreencao(String apreencao) {
        this.apreencao = apreencao;
    }

    public String getDataCad() {
        return dataCad;
    }

    public void setDataCad(String dataCad) {
        this.dataCad = dataCad;
    }

    public void exibe() {
        System.out.println("------------------"
                + "\nID: " + this.id
                + "\nPlaca: " + this.placa
                + "\nRENAVAM: " + this.renavam
                + "\nCHASSI VEICULO: " + this.chassiVeiculo
                + "\nMOTOR VEICULO: " + this.motorVeiculo
                + "\nMODELO: " + this.modelo.getNome()
                + "\nMARCA: " + this.getModelo().getMarca().getNome()
                + "\nCOR: " + this.cor
                + "\nANO FAB.: " + this.anoFab
                + "\nANO MOD.: " + this.anoMod
                + "\nCOMBUSTIVEL: " + this.combustivel
                + "\nCATEGORIA: " + this.categoria
                + "\nTIPO: " + this.tipo
                + "\nESPECIE: " + this.especie
                + "\nPOTENCIA: " + this.potencia
                + "\nCILINDRADA: " + this.cilidrada
                + "\nLICENCIAMENTO: " + this.licenciamento
                + "\nCIDADE ID: " + this.cidade.getId()
                + "\nCIDADE NOME: " + this.cidade.getNome()
                + "\nCIDADE ESTADO: " + this.cidade.getEstado().getNome() +", "+ this.cidade.getEstado().getUf()
                + "\n------------------"
        );
    }
}
