package GUI;

import Beans.CidadeBeans;
import Beans.EmpresaBeans;
import Controller.EmpresaController;
import DAO.CidadeDAO;
import DAO.EmpresaDao;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

public class Empresa extends javax.swing.JInternalFrame {

    EmpresaBeans empresaB;
    EmpresaController empresaC;
    EmpresaDao empresaD;
    DefaultTableModel Modelo;
    CidadeDAO cidadeD;

    public Empresa() {
        initComponents();
        empresaB = new EmpresaBeans();
        empresaC = new EmpresaController();
        empresaD = new EmpresaDao();
        cidadeD = new CidadeDAO();
        txt_id.setVisible(false);
        lbl_id.setVisible(false);
        habilitarCampos(false);
        btn_novo.setEnabled(true);
        Modelo = (DefaultTableModel) tb_empresa.getModel();
        empresaD.buscarTodasEmpresas(Modelo);
        controlaEsc();
        limparCampos();
        /* for (CidadeBeans cidade : cidadeD.carregarCidades()) {
            cbox_cidade.addItem(cidade);

        }*/

    }

    public void popularEmpresa() {
        empresaB.setRazaoSocial(txt_razao.getText());
        empresaB.setNomeFantasia(txt_fantasia.getText());
        empresaB.setEndereco(txt_endereco.getText());
        empresaB.setNumero(txt_numero.getText());
        empresaB.setBairro(txt_bairro.getText());
        empresaB.setCep(txt_cep.getText());
        empresaB.setTelefone(txt_telefone.getText());
        empresaB.setCnpj(txt_cnpj.getText());
        empresaB.setLogin(txt_login.getText());
        empresaB.setSenha(txt_senha.getText());
        empresaB.setCidade((CidadeBeans) cbox_cidade.getSelectedItem());

    }

    final void habilitarCampos(boolean valor) {
        txt_razao.setEnabled(valor);
        txt_fantasia.setEnabled(valor);
        txt_endereco.setEnabled(valor);
        txt_numero.setEnabled(valor);
        txt_bairro.setEnabled(valor);
        txt_cep.setEnabled(valor);
        txt_telefone.setEnabled(valor);
        txt_cnpj.setEnabled(valor);
        txt_login.setEnabled(valor);
        txt_senha.setEnabled(valor);

    }

    final void limparCampos() {
        txt_id.setText("");
        txt_razao.setText("");
        txt_fantasia.setText("");
        txt_endereco.setText("");
        txt_numero.setText("");
        txt_bairro.setText("");
        txt_cep.setText("");
        txt_telefone.setText("");
        txt_login.setText("");
        txt_senha.setText("");
        txt_cnpj.setText("");
        cbox_cidade.setSelectedItem("");
    }

    private void cadastrar() {
        popularEmpresa();
        System.out.println(empresaB.getRazaoSocial());
        empresaC.cadastrar(empresaB);

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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        lbl_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_razao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_fantasia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_endereco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_numero = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_bairro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbox_cidade = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_login = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_senha = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_empresa = new javax.swing.JTable();
        btn_novo = new javax.swing.JButton();
        btn_salvar = new javax.swing.JButton();
        btn_alterar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_deletar = new javax.swing.JButton();
        txt_cep = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_cnpj = new javax.swing.JFormattedTextField();
        txt_telefone = new javax.swing.JFormattedTextField();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);

        lbl_id.setText("ID");

        txt_id.setEditable(false);

        jLabel2.setText("Razão Social");

        jLabel3.setText("Nome Fantasia");

        jLabel4.setText("Endereço");

        jLabel5.setText("n°");

        jLabel6.setText("Bairro");

        jLabel7.setText("CEP");

        jLabel8.setText("Cidade");

        cbox_cidade.setEditable(true);
        cbox_cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_cidadeActionPerformed(evt);
            }
        });
        cbox_cidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbox_cidadeKeyPressed(evt);
            }
        });

        jLabel9.setText("Tel");

        jLabel10.setText("Login");

        jLabel11.setText("Senha");

        jLabel12.setText("Busca");

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });

        tb_empresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Razão", "Nome Fantasia", "Login", "CNPJ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_empresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_empresaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_empresa);

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

        try {
            txt_cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel13.setText("CNPJ");

        try {
            txt_cnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txt_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbl_id)
                .addGap(70, 70, 70)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addComponent(txt_razao, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addComponent(txt_fantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btn_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btn_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btn_deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(56, 56, 56)
                        .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(48, 48, 48)
                        .addComponent(cbox_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_senha)
                    .addComponent(txt_cnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(53, 53, 53)
                        .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(4, 4, 4)
                        .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_telefone))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(36, 36, 36)
                        .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)
                        .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbl_id))
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addComponent(txt_razao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(txt_fantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbox_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addComponent(txt_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel12))
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        tb_empresa.setVisible(false);
    }//GEN-LAST:event_btn_novoActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Deseja Salvar Empresa " + txt_razao.getText() + "?", "Cadastrar Empresa", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            if (txt_id.getText().equals("")) {
                System.out.println("passei aqui");
                popularEmpresa();
                if (empresaC.verificarDados(empresaB)) {
                    System.out.println("passei aqui");
                    btn_salvar.setEnabled(false);
                    btn_cancelar.setEnabled(false);
                    btn_alterar.setEnabled(false);
                    btn_deletar.setEnabled(false);
                    btn_novo.setEnabled(true);
                    tb_empresa.setVisible(true);
                    habilitarCampos(false);
                    limparCampos();
                    empresaC.cadastrar(empresaB);

                }
            } else {
                empresaB.setId(Integer.parseInt(txt_id.getText()));
                popularEmpresa();
                if (empresaC.verificarDados(empresaB)) {
                    empresaC.editarController(empresaB);
                    btn_alterar.setEnabled(false);
                    btn_cancelar.setEnabled(false);
                    btn_deletar.setEnabled(false);
                    btn_novo.setEnabled(true);
                    btn_salvar.setEnabled(false);
                    tb_empresa.setVisible(true);
                    habilitarCampos(true);
                    limparCampos();
                    txt_buscar.setText("");

                }

            }

        } else {

        }
        Modelo.setNumRows(0);
        empresaD.buscarTodasEmpresas(Modelo);
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
            tb_empresa.setVisible(true);
            limparCampos();
            habilitarCampos(false);

        } else {

        }
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deletarActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Deseja Excluir Registro" + "?", "Excluir Registro", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            popularEmpresa();
            empresaB.setId(Integer.parseInt(txt_id.getText()));
            empresaC.deletarController(empresaB);
            btn_novo.setEnabled(true);
            btn_salvar.setEnabled(false);
            btn_alterar.setEnabled(false);
            btn_deletar.setEnabled(false);
            btn_cancelar.setEnabled(false);
            tb_empresa.setVisible(true);
            habilitarCampos(false);
            limparCampos();
            Modelo.setNumRows(0);
            empresaD.buscarTodasEmpresas(Modelo);

        }
    }//GEN-LAST:event_btn_deletarActionPerformed

    private void tb_empresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_empresaMouseClicked
        empresaB = empresaC.controlePreencherCampos(Integer.parseInt(Modelo.getValueAt(tb_empresa.getSelectedRow(), 0).toString()));
        txt_id.setText(empresaB.getId() + "");
        txt_razao.setText(empresaB.getRazaoSocial());
        txt_fantasia.setText(empresaB.getNomeFantasia());
        txt_login.setText(empresaB.getLogin());
        txt_cnpj.setText(empresaB.getCnpj());
        txt_senha.setText(empresaB.getSenha());
        habilitarCampos(false);
        btn_novo.setEnabled(true);
        btn_salvar.setEnabled(false);
        btn_alterar.setEnabled(true);
        btn_cancelar.setEnabled(false);
        btn_deletar.setEnabled(true);
    }//GEN-LAST:event_tb_empresaMouseClicked


    private void cbox_cidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_cidadeActionPerformed


    }//GEN-LAST:event_cbox_cidadeActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        Modelo.setNumRows(0);
        empresaC.controlePesquisa(txt_buscar.getText(), Modelo);

    }//GEN-LAST:event_txt_buscarKeyReleased

    private void cbox_cidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbox_cidadeKeyPressed

    }//GEN-LAST:event_cbox_cidadeKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_alterar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_deletar;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JComboBox<Object> cbox_cidade;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JTable tb_empresa;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JFormattedTextField txt_cep;
    private javax.swing.JFormattedTextField txt_cnpj;
    private javax.swing.JTextField txt_endereco;
    private javax.swing.JTextField txt_fantasia;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_login;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JTextField txt_razao;
    private javax.swing.JPasswordField txt_senha;
    private javax.swing.JFormattedTextField txt_telefone;
    // End of variables declaration//GEN-END:variables
}
