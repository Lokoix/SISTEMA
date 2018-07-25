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
public class EstadoBeans {

    private Integer id;
    private String nome;
    private String uf;

    public EstadoBeans(Integer id, String nome, String uf) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
    }
    
     public EstadoBeans(String nome) {
        this.nome = nome;
    }

    public EstadoBeans() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getUf(){
        return uf;
    }
    
    public void setUf(String uf){
        this.uf = uf;
    }
    
    public void exibe (){
        System.out.println("Estado: " + this.getId() +", "+this.getNome()+", "+this.getUf());
    }

}
