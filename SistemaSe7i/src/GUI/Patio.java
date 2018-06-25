/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Beans.CidadeBeans;
import Beans.EstadoBeans;
import Beans.PatioBeans;
import Controller.PatioController;
import DAO.CidadeDAO;
import DAO.PatioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;



public class Patio extends javax.swing.JInternalFrame {

    PatioBeans patioB;
    PatioController patioC;
    PatioDAO patioD;
    DefaultTableModel Modelo;
    CidadeDAO cidadeD;

    /**
     * Creates new form Patio
     */
    public Patio() {
        initComponents();
        patioD = new PatioDAO();
        patioC = new PatioController();
        patioB = new PatioBeans();
        cidadeD = new CidadeDAO();
        lbl_id.setVisible(false);
        txt_id.setVisible(false);
        habilitarCampos(false);
        btn_novo.setEnabled(true);
        Modelo = (DefaultTableModel) tb_patio.getModel();
        patioD.buscarTodosPatios(Modelo);
        controlaEsc();

        CidadeBeans cidade2 = new CidadeBeans();
        cidade2.setNome("Selecionar ");
        cidade2.setEstado(new EstadoBeans("Cidade"));
        cbox_cidade.addItem(cidade2);
        for (CidadeBeans cidade : cidadeD.carregarCidades()) {
            cbox_cidade.addItem(cidade);

        }
        limparCampos();

    }

    public void popularPatio() {
        patioB.setNome(txt_nome.getText());
        patioB.setEndereco(txt_endereco.getText());
        patioB.setNumero(txt_numero.getText());
        patioB.setBairro(txt_bairro.getText());
        patioB.setCep(txt_cep.getText());
        patioB.setTelefone(txt_telefone.getText());
        patioB.setResponsavel(txt_responsa.getText());
        if (cbox_cidade.getSelectedItem().equals("")) {
            cbox_cidade.setSelectedItem("");

        } else {
            patioB.setCidade((CidadeBeans) cbox_cidade.getSelectedItem());
        }

    }

    final void habilitarCampos(boolean valor) {
        txt_nome.setEnabled(valor);
        txt_endereco.setEnabled(valor);
        txt_numero.setEnabled(valor);
        txt_bairro.setEnabled(valor);
        txt_cep.setEnabled(valor);
        txt_telefone.setEnabled(valor);
        txt_responsa.setEnabled(valor);
        cbox_cidade.setEnabled(valor);
        txt_buscar.setEnabled(true);
        
    }

    final void limparCampos() {
        txt_id.setText("");
        txt_nome.setText("");
        txt_endereco.setText("");
        txt_numero.setText("");
        txt_bairro.setText("");
        txt_cep.setText("");
        txt_telefone.setText("");
        txt_responsa.setText("");
        cbox_cidade.setSelectedIndex(0);
    }

    public void controlaEsc() {
        KeyStroke ks = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, true);
        getRootPane().getInputMap().put(ks, "esc");
        getRootPane().getActionMap().put("esc", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_endereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_numero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_bairro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_cep = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_telefone = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_responsa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbox_cidade = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_patio = new javax.swing.JTable();
        btn_novo = new javax.swing.JButton();
        btn_salvar = new javax.swing.JButton();
        btn_alterar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_deletar = new javax.swing.JButton();

        setClosable(true);

        lbl_id.setText("ID");

        jLabel1.setText("Nome");

        jLabel2.setText("Endereço");

        jLabel3.setText("N°");

        jLabel4.setText("Bairro");

        jLabel5.setText("CEP");

        try {
            txt_cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Telefone");

        try {
            txt_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setText("Responsável");

        jLabel8.setText("Cidade");

        jLabel9.setText("Buscar");

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });

        tb_patio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Responsável", "Cidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_patio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_patioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_patio);
        if (tb_patio.getColumnModel().getColumnCount() > 0) {
            tb_patio.getColumnModel().getColumn(0).setMinWidth(25);
            tb_patio.getColumnModel().getColumn(0).setPreferredWidth(25);
            tb_patio.getColumnModel().getColumn(0).setMaxWidth(25);
        }

        btn_novo.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btn_novo.setText("NOVO");
        btn_novo.setEnabled(false);
        btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoActionPerformed(evt);
            }
        });

        btn_salvar.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        btn_salvar.setText("SALVAR");
        btn_salvar.setEnabled(false);
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        btn_alterar.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        btn_alterar.setText("ALTERAR");
        btn_alterar.setEnabled(false);
        btn_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alterarActionPerformed(evt);
            }
        });

        btn_cancelar.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.setEnabled(false);
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_deletar.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        btn_deletar.setText("DELETAR");
        btn_deletar.setEnabled(false);
        btn_deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(lbl_id)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(txt_bairro)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txt_endereco)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txt_nome)
                                        .addComponent(txt_responsa, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbox_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btn_deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_responsa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbox_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed

        habilitarCampos(true);
        btn_salvar.setEnabled(true);
        btn_deletar.setEnabled(false);
        btn_alterar.setEnabled(false);
        btn_cancelar.setEnabled(true);
        txt_buscar.setEnabled(false);
        limparCampos();
        btn_novo.setEnabled(false);
        tb_patio.setVisible(false);
    }//GEN-LAST:event_btn_novoActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Deseja Salvar Empresa " + txt_nome.getText() + "?", "Cadastrar Pátio", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            if (txt_id.getText().equals("")) {
                popularPatio();
                if (patioC.verificarDados(patioB)) {
                    btn_salvar.setEnabled(false);
                    btn_cancelar.setEnabled(false);
                    btn_alterar.setEnabled(false);
                    btn_deletar.setEnabled(false);
                    btn_novo.setEnabled(true);
                    tb_patio.setVisible(true);
                    habilitarCampos(false);
                    limparCampos();
                    patioC.cadastrar(patioB);

                }
            } else {
                patioB.setId(Integer.parseInt(txt_id.getText()));
                popularPatio();
                if (patioC.verificarDados(patioB)) {
                    patioC.editarController(patioB);
                    btn_alterar.setEnabled(false);
                    btn_cancelar.setEnabled(false);
                    btn_deletar.setEnabled(false);
                    btn_novo.setEnabled(true);
                    btn_salvar.setEnabled(false);
                    tb_patio.setVisible(true);
                    habilitarCampos(false);
                    limparCampos();
                    txt_buscar.setText("");

                }

            }

        } else {

        }
        Modelo.setNumRows(0);
        patioD.buscarTodosPatios(Modelo);
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterarActionPerformed
        btn_salvar.setEnabled(true);
        btn_novo.setEnabled(false);
        btn_cancelar.setEnabled(true);
        btn_alterar.setEnabled(false);
        btn_deletar.setEnabled(false);
        //tb_usuario.setVisible(false);
        habilitarCampos(true);
    }//GEN-LAST:event_btn_alterarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Deseja cancelar esta operação" + "?", "Cancelar Operação", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            btn_cancelar.setEnabled(false);
            btn_alterar.setEnabled(false);
            btn_salvar.setEnabled(false);
            btn_novo.setEnabled(true);
            btn_deletar.setEnabled(false);
            tb_patio.setVisible(true);
            limparCampos();
            habilitarCampos(false);

        } else {

        }
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deletarActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Deseja Excluir Registro" + "?", "Excluir Registro", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            popularPatio();
            patioB.setId(Integer.parseInt(txt_id.getText()));
            patioC.deletarController(patioB);
            btn_novo.setEnabled(true);
            btn_salvar.setEnabled(false);
            btn_alterar.setEnabled(false);
            btn_deletar.setEnabled(false);
            btn_cancelar.setEnabled(false);
            tb_patio.setVisible(true);
            limparCampos();
            habilitarCampos(false);
            Modelo.setNumRows(0);
            patioD.buscarTodosPatios(Modelo);

        }
    }//GEN-LAST:event_btn_deletarActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        Modelo.setNumRows(0);
        patioC.controlePesquisa(txt_buscar.getText(), Modelo);
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void tb_patioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_patioMouseClicked
        patioB = patioC.controlePreencherCampos(Integer.parseInt(Modelo.getValueAt(tb_patio.getSelectedRow(), 0).toString()));
        txt_id.setText(patioB.getId() + "");
        txt_nome.setText(patioB.getNome());
        txt_endereco.setText(patioB.getEndereco());
        txt_numero.setText(patioB.getNumero());
        txt_bairro.setText(patioB.getBairro());
        txt_telefone.setText(patioB.getTelefone());
        txt_cep.setText(patioB.getCep());
        txt_responsa.setText(patioB.getResponsavel());
        for (int i = 0; i <= cbox_cidade.getItemCount(); i++) {

            CidadeBeans item = (CidadeBeans) cbox_cidade.getItemAt(i);
            if (item.getId() == patioB.getCidade().getId()) {
                cbox_cidade.setSelectedIndex(i);
                break;
            }
        }
        
        habilitarCampos(false);
        btn_novo.setEnabled(false);
        btn_salvar.setEnabled(false);
        btn_alterar.setEnabled(true);
        btn_cancelar.setEnabled(true);
        btn_deletar.setEnabled(true);
    }//GEN-LAST:event_tb_patioMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_alterar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_deletar;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JComboBox<Object> cbox_cidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JTable tb_patio;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JFormattedTextField txt_cep;
    private javax.swing.JTextField txt_endereco;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JTextField txt_responsa;
    private javax.swing.JFormattedTextField txt_telefone;
    // End of variables declaration//GEN-END:variables

}
