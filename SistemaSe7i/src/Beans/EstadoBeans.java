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
    
    private int id;
    private String nome;

    public EstadoBeans(){
        
    }
    
    public EstadoBeans(int id, String nome){
       this.id = id;
       this.nome = nome;
    }
    
    public EstadoBeans(String nome){
       
       this.nome = nome;
    }
    
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
    
}
