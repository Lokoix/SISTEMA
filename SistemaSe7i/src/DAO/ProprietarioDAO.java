/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.ProprietarioBeans;

/**
 *
 * @author rafae
 */
public class ProprietarioDAO {
    
    
    public void Adicionar (ProprietarioBeans a){
        String sql = "Insert into proprietarios (txnome, txendereco, txcpf, txrg, fkcidade) values (?,?,?,?,?)";
        
    }
}
