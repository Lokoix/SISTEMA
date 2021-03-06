/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Beans.UsuarioBeans;
import Controller.UsuarioController;
import DAO.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guilhermengenharia
 */
public class Usuario extends javax.swing.JInternalFrame {

    UsuarioController usuarioC;
    UsuarioDAO usuarioD;
    UsuarioBeans usuarioB;
    DefaultTableModel Modelo;

    public Usuario() {
        initComponents();
        usuarioB = new UsuarioBeans();
        usuarioC = new UsuarioController();
        usuarioD = new UsuarioDAO();
        txt_id.setVisible(false);
        lbl_id.setVisible(false);
        habilitarCampos(false);
        btn_novo.setEnabled(true);
        Modelo = (DefaultTableModel) tb_usuario.getModel();
        usuarioD.buscarTodosUsuarios(Modelo);
        controlaEsc();
        limparCampos();

    }

    private void cadastrar() {
        popularUsuario();
        System.out.println(usuarioB.getNome());
        usuarioC.cadastrar(usuarioB);

    }

    private void popularUsuario() {
        usuarioB.setNome(txt_nome.getText());
        usuarioB.setLogin(txt_login.getText());
        usuarioB.setSenha(txt_senha.getText());
        if (rb_adm.isSelected()) {
            usuarioB.setPermissao("Administrador");
        }
        if (rb_colab.isSelected()) {
            usuarioB.setPermissao("Colaborador");
        }
        if (rb_finan.isSelected()) {
            usuarioB.setPermissao("Financeiro");
        }

    }

    final void habilitarCampos(boolean valor) {//desabilitar campos
        txt_nome.setEnabled(valor);
        txt_login.setEnabled(valor);
        txt_senha.setEnabled(valor);
        rb_adm.setEnabled(valor);
        rb_colab.setEnabled(valor);
        rb_finan.setEnabled(valor);


    }

    final void limparCampos() {
        txt_id.setText("");
        txt_nome.setText(null);
        txt_login.setText(null);
        txt_senha.setText(null);
        buttonGroup1.clearSelection();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        lbl_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_login = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_senha = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        rb_adm = new javax.swing.JRadioButton();
        rb_colab = new javax.swing.JRadioButton();
        rb_finan = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txt = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_usuario = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        btn_novo = new javax.swing.JButton();
        btn_salvar = new javax.swing.JButton();
        btn_alterar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_deletar = new javax.swing.JButton();

        setClosable(true);

        lbl_id.setText("ID");

        txt_id.setEditable(false);

        jLabel2.setText("Nome");

        jLabel3.setText("Login");

        jLabel4.setText("Senha");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(rb_adm);
        rb_adm.setText("Administrador");
        rb_adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_admActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_colab);
        rb_colab.setText("Colaborador");
        rb_colab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_colabActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_finan);
        rb_finan.setText("Financeiro");
        rb_finan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_finanActionPerformed(evt);
            }
        });

        jLabel5.setText("Permissão");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rb_adm)
                        .addGap(27, 27, 27)
                        .addComponent(rb_colab)
                        .addGap(18, 18, 18)
                        .addComponent(rb_finan)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_finan)
                    .addComponent(rb_colab)
                    .addComponent(rb_adm))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        txt.setText("Buscar");

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });

        tb_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Login", "Permissão"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_usuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_usuario);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btn_deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_id)
                                .addGap(40, 40, 40)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_senha))
                                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(txt)
                                .addGap(18, 18, 18)
                                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        setBounds(0, 0, 593, 518);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Deseja Salvar Usuário " + txt_nome.getText() + "?", "Cadastrar Usuário", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            if (txt_id.getText().equals("")) {
                System.out.println("passei aqui");
                popularUsuario();
                if (usuarioC.verificarDados(usuarioB)) {
                    System.out.println("passei aqui");
                    btn_salvar.setEnabled(false);
                    btn_cancelar.setEnabled(false);
                    btn_alterar.setEnabled(false);
                    btn_deletar.setEnabled(false);
                    btn_novo.setEnabled(true);
                    tb_usuario.setVisible(true);
                    habilitarCampos(false);
                    limparCampos();
                    usuarioC.cadastrar(usuarioB);

                }
            } else {
                usuarioB.setId(Integer.parseInt(txt_id.getText()));
                popularUsuario();
                if (usuarioC.verificarDados(usuarioB)) {
                    usuarioC.editarController(usuarioB);
                    btn_alterar.setEnabled(false);
                    btn_cancelar.setEnabled(false);
                    btn_deletar.setEnabled(false);
                    btn_novo.setEnabled(true);
                    btn_salvar.setEnabled(false);
                    tb_usuario.setVisible(true);
                    habilitarCampos(true);
                    limparCampos();
                    txt_buscar.setText("");

                }

            }

        } else {

        }
        Modelo.setNumRows(0);
        usuarioD.buscarTodosUsuarios(Modelo);
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed

        habilitarCampos(true);
        btn_salvar.setEnabled(true);
        btn_deletar.setEnabled(false);
        btn_alterar.setEnabled(false);
        btn_cancelar.setEnabled(true);
        txt_buscar.setEnabled(false);
        limparCampos();
        btn_novo.setEnabled(false);
        tb_usuario.setVisible(false);
    }//GEN-LAST:event_btn_novoActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Deseja cancelar esta operação" + "?", "Cancelar Operação", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            btn_cancelar.setEnabled(false);
            btn_alterar.setEnabled(false);
            btn_salvar.setEnabled(false);
            btn_novo.setEnabled(true);
            tb_usuario.setVisible(true);
            limparCampos();
            habilitarCampos(false);

        } else {

        }
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deletarActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Deseja Excluir Registro" + "?", "Excluir Registro", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            popularUsuario();
            usuarioB.setId(Integer.parseInt(txt_id.getText()));
            usuarioC.deletarController(usuarioB);
            btn_novo.setEnabled(true);
            btn_salvar.setEnabled(false);
            btn_alterar.setEnabled(false);
            btn_deletar.setEnabled(false);
            btn_cancelar.setEnabled(false);
            tb_usuario.setVisible(true);
            habilitarCampos(false);
            limparCampos();
            Modelo.setNumRows(0);
            usuarioD.buscarTodosUsuarios(Modelo);

        }
    }//GEN-LAST:event_btn_deletarActionPerformed

    private void tb_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_usuarioMouseClicked
        usuarioB = usuarioC.controlePreencherCampos(Integer.parseInt(Modelo.getValueAt(tb_usuario.getSelectedRow(), 0).toString()));
        txt_id.setText(usuarioB.getId() + "");
        txt_nome.setText(usuarioB.getNome());
        txt_login.setText(usuarioB.getLogin());
        txt_senha.setText(usuarioB.getSenha());
        if (usuarioB.getPermissao().equals("Administrador")) {
            rb_adm.setSelected(true);
        }
        if (usuarioB.getPermissao().equals("Colaborador")) {
            rb_colab.setSelected(true);
        }
        if (usuarioB.getPermissao().equals("Financeiro")) {
            rb_finan.setSelected(true);
        }
        habilitarCampos(false);
        btn_novo.setEnabled(true);
        btn_salvar.setEnabled(false);
        btn_alterar.setEnabled(true);
        btn_cancelar.setEnabled(false);
        btn_deletar.setEnabled(true);
    }//GEN-LAST:event_tb_usuarioMouseClicked

    private void btn_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterarActionPerformed
        btn_salvar.setEnabled(true);
        btn_novo.setEnabled(false);
        btn_cancelar.setEnabled(true);
        btn_alterar.setEnabled(false);
        btn_deletar.setEnabled(false);
        //tb_usuario.setVisible(false);
        habilitarCampos(true);
        
    }//GEN-LAST:event_btn_alterarActionPerformed

    private void rb_admActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_admActionPerformed
        String Permissao = "Administrador";
    }//GEN-LAST:event_rb_admActionPerformed

    private void rb_colabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_colabActionPerformed
        String Permissao = "Colaborador";
    }//GEN-LAST:event_rb_colabActionPerformed

    private void rb_finanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_finanActionPerformed
        String Permissao = "Finaceiro";
    }//GEN-LAST:event_rb_finanActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        Modelo.setNumRows(0);
        usuarioC.controlePesquisa(txt_buscar.getText(), Modelo);
    }//GEN-LAST:event_txt_buscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_alterar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_deletar;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_salvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JRadioButton rb_adm;
    private javax.swing.JRadioButton rb_colab;
    private javax.swing.JRadioButton rb_finan;
    private javax.swing.JTable tb_usuario;
    private javax.swing.JLabel txt;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_login;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JPasswordField txt_senha;
    // End of variables declaration//GEN-END:variables
}
