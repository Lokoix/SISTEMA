/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.VeiculoBeans;
import DAO.VeiculoDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class VeiculoController {
    VeiculoDAO veiD = new VeiculoDAO();
    CidadeController cidC = new CidadeController();

    public VeiculoBeans CorrigirAutomovel(VeiculoBeans a) {
        if (veiD.ExisteVeiculo(a)) {
            int id = autD.BuscarAutomovel(a);
            AutomovelBeans b = new AutomovelBeans();
            b = autD.PreencherAutomovel(id);
            b = CompararAutomovel(a, b);
            JOptionPane.showMessageDialog(null, "LicenBd:" + b.getLicenciamento());
            JOptionPane.showMessageDialog(null, "LicenAA:" + a.getLicenciamento());
            autD.AlterarCarro(b);
            return b;
        } else {
            a.setMunicipio(munC.CorrigirMunicipio(a.getMunicipio()));
            autD.CadastrarAutomovel(a);
            a.setCod(autD.BuscarAutomovel(a));
            return a;
        }
    }

    public AutomovelBeans CompararAutomovel(AutomovelBeans a, AutomovelBeans b) {
        System.out.println("kkkkkk");
        System.out.println(b.getCod() + "b");
        System.out.println(a.getCod() + "a");
        if (b.getPlaca() == null) {
            b.setPlaca(a.getPlaca());
        }
        System.out.println("111111");
        if (b.getRenavan()== null) {
            b.setRenavan(a.getRenavan());
        }
        System.out.println("111112");
        if (b.getChassiBase()== null) {
            b.setChassiBase(a.getChassiBase());
        }
        System.out.println("111113");
        if (b.getMarca()== null) {
            b.setMarca(a.getMarca());
        }
        System.out.println("111114");
        if (b.getCor()== null) {
            b.setCor(a.getCor());
        }
        System.out.println("1111115");
        if (b.getModelo()== null) {
            b.setModelo(a.getModelo());
        }
        System.out.println("1111116");
        if (b.getFabricacao()== null) {
            b.setFabricacao(a.getFabricacao());
        }
        System.out.println("1111117");
        if (b.getCombustivel()== null) {
            b.setCombustivel(a.getCombustivel());
        }
        System.out.println("1111118");
        if (b.getMotorBase()== null) {
            b.setMotorBase(a.getMotorBase());
        }
        System.out.println("1111119");
        if (b.getTipo()== null) {
            b.setTipo(a.getTipo());
        }
        System.out.println("1111110");
        if (b.getEspec()== null) {
            b.setEspec(a.getEspec());
        }
        System.out.println("1111111111");
        if (b.getLicenciamento()== null || b.getLicenciamento().equals("")) {
            b.setLicenciamento(a.getLicenciamento());
        }
        System.out.println("kkkkkkkkkkkkk");
        //carroA.setMunicipio(carroB.getMunicipio());// criar um deste la no municipio quando tiver a relaçao de todos
        return b;
    }

    public AutomovelBeans CarregarAutomovel(int id){
        return autD.PreencherAutomovel(id);
    }
}
