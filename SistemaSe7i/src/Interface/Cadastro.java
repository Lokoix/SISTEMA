/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Beans.CidadeBeans;
import Beans.ProprietarioBeans;
import DAO.CidadeDAO;
import java.util.List;

/**
 *
 * @author rafael Piedade
 */
public class Cadastro {

    CidadeDAO cidD;
    
    public ProprietarioBeans getProprietario(List<String> result) {
        ProprietarioBeans x = new ProprietarioBeans();

        x.setNome(RemoverEspacosDuplo(result.get(16).substring(11, 132)));
        x.setEndereco(RemoverEspacosDuplo(result.get(17).substring(9, 70) +" ,"+result.get(17).substring(71, 81)));
        
        x.setBairro(RemoverEspacosDuplo(result.get(17).substring(70, 85)));
        x.setCep(RemoverTodosEspacos(result.get(17).substring(90, 97)));

        x.setCidade(cidD.getCidadeId());

        x.setRg(rg);
        x.setCpfCpnpj(cpfCpnpj);

    }

    private String RemoverTodosEspacos(String s) {
        while (s.contains(" ")) {
            s = s.replaceAll(" ", "");
        }
        s = s.trim();

        return s;
    }

    private String RemoverEspacosDuplo(String s) {
        while (s.contains("  ")) {
            s = s.replaceAll("  ", " ");
        }
        s = s.trim();

        return s;
    }
}
