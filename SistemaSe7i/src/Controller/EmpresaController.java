
package Controller;

import Beans.EmpresaBeans;
import DAO.EmpresaDao;
import javax.swing.table.DefaultTableModel;



public class EmpresaController {
    EmpresaDao empresaD = new EmpresaDao();
    
        public void cadastrar(EmpresaBeans empresa) {
        empresaD.cadastrar(empresa);
    }

    public EmpresaBeans controlePreencherCampos(int id) {
        return empresaD.preencherCampos(id);
    }

    public void editarController(EmpresaBeans empresa) {
        empresaD.editar(empresa);
    }
    
    public void deletarController(EmpresaBeans empresa){
        empresaD.deletar(empresa);
    }
    
}
