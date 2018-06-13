/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import com.sun.corba.se.impl.oa.toa.TOA;

/**
 *
 * @author Eu
 */
public class CidadeBeans {

    private int id;
    private String nome;
    private EstadoBeans estado;

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

    public EstadoBeans getEstado() {
        return estado;
    }

    public void setEstado(EstadoBeans estado) {
        this.estado = estado;
    }

    public void exibe() {
        System.out.println(this.id + " - " + this.getNome() + " - " + this.estado.getId() + " - " + this.estado.getNome());
    }

    @Override
    public String toString() {
        return this.getNome() + " - " + this.getEstado().getNome();
    }
}
