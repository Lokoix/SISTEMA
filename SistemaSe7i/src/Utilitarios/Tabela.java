/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author joaoh
 */
public class Tabela extends AbstractTableModel {
    private static final int colunaCheckbox = 0;
    @Override public Class getColumnClass(int columnIndex) {
        int colunaCheckBox = 0;
        if (columnIndex == colunaCheckBox) return Boolean.class; // assim gera uma Checkbox.
        return String.class;
    }

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}