package Controller;

import Beans.EmpresaBeans;
import DAO.EmpresaDao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmpresaController {

    EmpresaDao empresaD = new EmpresaDao();

    public void cadastrar(EmpresaBeans empresa) {
        empresaD.cadastrar(empresa);
    }

    public EmpresaBeans controlePreencherCampos(int id) {
        return empresaD.preencherCampos(id);
    }

    public void controlePesquisa(String Pesquisa, DefaultTableModel Modelo) {
        empresaD.buscarEmpresa(Pesquisa, Modelo);
    }

    public void editarController(EmpresaBeans empresa) {
        empresaD.editar(empresa);
    }

    public void deletarController(EmpresaBeans empresa) {
        empresaD.deletar(empresa);
    }

    public boolean verificarDados(EmpresaBeans empresa) {
        if (empresa.getRazaoSocial().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencher Campo Razão Social", "Erro", 0);
            return false;
        }

        if (empresa.getNomeFantasia().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencher Campo Nome Fantasia", "Eroo", 0);
            return false;
        }

        if (empresa.getLogin().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencher Campo Login", "Eroo", 0);
            return false;
        }

        if (empresa.getSenha().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencher Campo Senha", "Erro", 0);
            return false;
        }
        //System.out.println(empresa.getCnpj());
        if (empresa.getCnpj().equals("  .   .   /    -  ")) {
            JOptionPane.showMessageDialog(null, "Preencher Campo CNPJ", "Erro", 0);
            return false;
        }
        return true;
    }
}
