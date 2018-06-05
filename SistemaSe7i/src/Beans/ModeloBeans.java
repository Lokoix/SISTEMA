/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author rafael Piedade
 */
public class ModeloBeans {

    private int id;
    private String nome;
    private MarcaBeans marca;

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

    public MarcaBeans getMarca() {
        return marca;
    }

    public void setMarca(MarcaBeans marca) {
        this.marca = marca;
    }

    public void exibe() {
        System.out.println(this.id + "-" + this.nome + "-" + this.marca.getId() + "-" + this.marca.getNome());
    }

}
