/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.LoteBeans;
import DAO.LoteDAO;

/**
 *
 * @author rafae
 */
public class LoteController {
    LoteDAO lotD = new LoteDAO();
    AutomovelController autC = new AutomovelController();
    ProprietarioController propC = new ProprietarioController();
    
    public void CorrigirLote(LoteBeans a){
        if(lotD.ExisteLote(a)){
            int id = lotD.BuscaLote(a);
            System.out.println("fffff");
            LoteBeans b = new LoteBeans();
                System.out.println("ffffffff");
            b = lotD.CarregarLoteBD(id);
            System.out.println("ffffff : "+ b.getAutomovel().getRenavan());
            b = this.CompararLote(a, b);
               System.out.println("ffffffff");
            lotD.AlterarLote(b);
            System.out.println("fffffff");
        }else{
            a.setAutomovel(autC.CorrigirAutomovel(a.getAutomovel()));
            a.setProprietario(propC.CorrigirProprietario(a.getProprietario()));
            lotD.cadastrarLote(a);
        }  
    }
    
    private LoteBeans CompararLote(LoteBeans lote, LoteBeans loteBD){
        System.out.println("ttttttt");
        loteBD.setAutomovel(autC.CorrigirAutomovel(lote.getAutomovel()));
        loteBD.setAutomovel(autC.CompararAutomovel(lote.getAutomovel(), loteBD.getAutomovel()));
        System.out.println("tttttttttt");
        if(loteBD.getProprietario() == null && lote.getProprietario() != null){
            loteBD.setProprietario(lote.getProprietario());
        }else{
            loteBD.setProprietario(null);
        }
        return loteBD;
    }
    
    
    public void CorrigirLoteBin(LoteBeans a){
        if(lotD.ExisteLote(a)){
            a.setCod(lotD.BuscaLote(a));
            a.setAutomovel(autC.CorrigirAutomovel(a.getAutomovel()));
            a.setProprietario(propC.CorrigirProprietario(a.getProprietario()));
            lotD.AlterarLote(a);

        }else{
            System.out.println("Corrigindo automovel");
            a.setAutomovel(autC.CorrigirAutomovel(a.getAutomovel()));
            System.out.println("Corrigido el automovel");
            //if(a.getProprietario().getCpf() != null){
             //   System.out.println("Tem coisa no cpf");
             // a.setProprietario(propC.CorrigirProprietario(a.getProprietario()));  
            //}
            System.out.println("Indo para cadastrar lote");
            lotD.cadastrarLote(a);
        }
    }
}
