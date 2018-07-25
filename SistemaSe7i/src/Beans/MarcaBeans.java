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
public class MarcaBeans {

    private Integer id;
    private String nome;

    public MarcaBeans(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public MarcaBeans(){
        
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
    
    public void exibe(){
        System.out.println("Marca: "+this.getId()+", "+this.getNome());
    }

}
