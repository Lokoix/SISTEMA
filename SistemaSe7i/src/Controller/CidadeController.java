/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.CidadeBeans;
import DAO.CidadeDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael Piedade
 */
public class CidadeController {

    CidadeDAO daoCidade = new CidadeDAO();
    EstadoController conEstado = new EstadoController();

    public CidadeBeans CorrigirCidade(CidadeBeans cidade) {
        cidade.setEstado(conEstado.corrigirEstado(cidade.getEstado()));
        
        if(daoCidade.existe(cidade)){
            cidade = daoCidade.carregar(cidade);
            return cidade;
        }else if(cidade.getNome() == null){
            JOptionPane.showMessageDialog(null, "Cidade sem nome para o cadastro!","Aviso", 1);
            return new CidadeBeans();
        }else if(cidade.getEstado().getUf() == null){
             JOptionPane.showMessageDialog(null, "Cidade sem estado para o cadastro!","Aviso", 1);
             return new CidadeBeans();
        }else{
            daoCidade.cadastrar(cidade);
            return this.CorrigirCidade(cidade);
        }
    }

    public CidadeBeans CarregarCidade(int id) {
        return daoCidade.getCidadeId(id);
    }
}
