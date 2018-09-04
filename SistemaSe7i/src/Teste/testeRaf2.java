/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import Beans.CidadeBeans;
import Beans.LoteBeans;
import Beans.ModeloBeans;
import Beans.Restricoes.RestricaoBloqueioBeans;
import Controller.CidadeController;
import Controller.ModeloController;
import Controller.Restricoes.RestricaoBloqueioController;
import DAO.PesquisaDAO;
import Interface.Bloqueio;
import Interface.Cadastro;
import importacao.arqtxt.Beans.ManipulaTxt;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class testeRaf2 {

    public static void main(String[] args) {

        Bloqueio iBloqueio = new Bloqueio();
        RestricaoBloqueioController conRestricaoBloqueio = new RestricaoBloqueioController();
        ManipulaTxt manipulaTxt = new ManipulaTxt();
        PesquisaDAO pesqDAO = new PesquisaDAO();
        RestricaoBloqueioBeans restricao = new RestricaoBloqueioBeans();

        restricao.getLote().setId(837);
        restricao.getLote().setNumeroLote("5");
        restricao.getLote().getLeilao().setId(2);
        ArrayList<String> result = manipulaTxt.Leitura(new File("C:\\Users\\rafae\\Desktop\\interface\\Cad\\teste 5\\blo\\5BLOA.txt"));

        iBloqueio.getBloqueio1(result, restricao);
        conRestricaoBloqueio.corrigirRestricaoBloqueio(restricao);

        

        String destino = "C://Assis Fase 4//Pesquisas//";
        File arquivoDestino = new File(destino + "5BLO.txt");

        try {
            if (!pesqDAO.existe(2, restricao.getLote().getNumeroLote(), "BLO")) {
                manipulaTxt.copy(new File("C:\\Users\\rafae\\Desktop\\interface\\Cad\\teste 5\\blo\\5BLO.txt"), arquivoDestino);
                pesqDAO.cadastrar(restricao.getLote(), "BLO", arquivoDestino.toString());
            }else{
                System.out.println("ja existess");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro: "+ e);
        }

        System.out.println("OK");
    }
}
