/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Beans.CidadeBeans;
import Beans.LeilaoBeans;
import Beans.LeiloeiroBeans;
import Beans.PatioBeans;
import Beans.VistoriaBeans;
import Controller.LeilaoController;
import DAO.CidadeDAO;
import DAO.LeilaoDAO;
import DAO.LeiloeiroDAO;
import DAO.PatioDAO;
import DAO.VistoriaDAO;
import Utilitarios.Corretores;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

public class Leilao extends javax.swing.JInternalFrame {

    PatioDAO patioD;
    LeilaoBeans leilaoB;
    LeilaoController leilaoC;
    LeilaoDAO leilaoD;
    LeiloeiroDAO leiloeiroD;
    VistoriaDAO vistoriaD;
    CidadeDAO cidadeD;
    DefaultTableModel Modelo;

    JDesktopPane desk;

    SimpleDateFormat spf;

    public Leilao(JDesktopPane desktop) {
        initComponents();
        desk = desktop;
        patioD = new PatioDAO();
        leilaoB = new LeilaoBeans();
        leilaoC = new LeilaoController();
        leilaoD = new LeilaoDAO();
        leiloeiroD = new LeiloeiroDAO();
        vistoriaD = new VistoriaDAO();
        cidadeD = new CidadeDAO();
        spf = new SimpleDateFormat("dd/MM/YYYY");
        lbl_id.setVisible(false);
        txt_id.setVisible(false);
        habilitarCampos(false);
        btn_novo1.setEnabled(true);
        Modelo = (DefaultTableModel) tb_leilao.getModel();
        leilaoD.buscarTodosLeiloes(Modelo);
        controlaEsc();

        PatioBeans patio2 = new PatioBeans();
        patio2.setNome("Selecionar Patio");
        cbox_patio.addItem(patio2);
        for (PatioBeans patio : patioD.carregarPatios()) {
            cbox_patio.addItem(patio);
        }

        LeiloeiroBeans leiloeiro2 = new LeiloeiroBeans();
        leiloeiro2.setNome("Selecionar Leiloeiro");
        cbox_leiloeiro.addItem(leiloeiro2);
        for (LeiloeiroBeans leiloeiro : leiloeiroD.carregarLeiloeiros()) {
            cbox_leiloeiro.addItem(leiloeiro);
        }

        VistoriaBeans vistoria2 = new VistoriaBeans();
        vistoria2.setNome("Selecionar Vistoriadora");
        cbox_vistoria.addItem(vistoria2);
        for (VistoriaBeans vistoria : vistoriaD.carregarVistoria()) {
            cbox_vistoria.addItem(vistoria);
        }

        CidadeBeans cidade2 = new CidadeBeans();
        cidade2.setNome("Selecionar ");
        cidade2.getEstado().setNome("Cidade");
        cidade2.setId(0);
        //cidade2.setEstado(new EstadoBeans("Cidade"));
        cbox_cidade.addItem(cidade2);
        for (CidadeBeans cidade : cidadeD.carregarCidades()) {
            cbox_cidade.addItem(cidade);

        }

    }

    public void popularLeilao() {
        leilaoB.setDescricao(txt_descricao.getText());
        leilaoB.setDataInicio(spf.format(data_inicio.getDate()));
        leilaoB.setDataPrevista(spf.format(data_termino.getDate()));
        if (!txt_custoLaudo.getText().equals("")) {
            leilaoB.setCustoLaudo(Double.parseDouble(txt_custoLaudo.getText()));
        }
        if (!txt_doc.getText().equals("")) {
            leilaoB.setDesvComDoc(Integer.parseInt(txt_doc.getText()));
        }
        if (!txt_noDoc.getText().equals("")) {
            leilaoB.setDesvSemDoc(Integer.parseInt(txt_noDoc.getText()));
        }
        if (!txt_sucata.getText().equals("")) {
            leilaoB.setDesvSucata(Double.parseDouble(txt_sucata.getText()));
        }

        leilaoB.setEdital(txt_edital.getText());
        if (cbox_cidade.getSelectedItem().equals("")) {
            cbox_cidade.setSelectedItem("");

        } else {
            leilaoB.setCidade((CidadeBeans) cbox_cidade.getSelectedItem());
        }
        if (cbox_leiloeiro.getSelectedItem().equals("")) {
            cbox_leiloeiro.setSelectedItem("");
        } else {
            leilaoB.setLeiloeiro((LeiloeiroBeans) cbox_leiloeiro.getSelectedItem());
        }
        if (cbox_vistoria.getSelectedItem().equals("")) {
            cbox_vistoria.setSelectedItem("");
        } else {
            leilaoB.setVistoriadora((VistoriaBeans) cbox_vistoria.getSelectedItem());
        }
        if (cbox_patio.getSelectedItem().equals("")) {
            cbox_patio.setSelectedItem("");
        } else {
            leilaoB.setPatio((PatioBeans) cbox_patio.getSelectedItem());
        }
        leilaoB.setCartaDeNotificacao(txt_notificacao.getText());

    }

    final void habilitarCampos(boolean valor) {
        txt_descricao.setEnabled(valor);
        data_inicio.setEnabled(valor);
        data_termino.setEnabled(valor);
        txt_custoLaudo.setEnabled(valor);
        txt_edital.setEnabled(valor);
        txt_doc.setEnabled(valor);
        txt_noDoc.setEnabled(valor);
        txt_sucata.setEnabled(valor);
        txt_notificacao.setEnabled(valor);        
        cbox_leiloeiro.setEnabled(valor);
        cbox_vistoria.setEnabled(valor);
        cbox_cidade.setEnabled(valor);
        cbox_patio.setEnabled(valor);
    }

    final void limparCampos() {
        txt_descricao.setText("");
        data_inicio.setDate(null);
        data_termino.setDate(null);
        txt_custoLaudo.setText("");
        txt_edital.setText("");
        txt_doc.setText("");
        txt_noDoc.setText("");
        txt_sucata.setText("");
        txt_notificacao.setText("");
        cbox_leiloeiro.setSelectedIndex(0);
        cbox_vistoria.setSelectedIndex(0);
        cbox_cidade.setSelectedIndex(0);
        cbox_patio.setSelectedIndex(0);
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

        jLabel1 = new javax.swing.JLabel();
        txt_descricao = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        data_inicio = new com.toedter.calendar.JDateChooser();
        data_termino = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbox_leiloeiro = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_edital = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbox_vistoria = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbox_patio = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txt_custoLaudo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbox_cidade = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txt_doc = new javax.swing.JTextField();
        txt_noDoc = new javax.swing.JTextField();
        txt_sucata = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_notificacao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_leilao = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        btn_newPatio = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        lbl_id = new javax.swing.JLabel();
        txt_id1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_razao = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_fantasia = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_endereco = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_numero = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_bairro = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cbox_cidade1 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_login = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txt_senha = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        txt_buscar1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_empresa = new javax.swing.JTable();
        btn_novo = new javax.swing.JButton();
        btn_salvar = new javax.swing.JButton();
        btn_alterar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_deletar = new javax.swing.JButton();
        txt_cep = new javax.swing.JFormattedTextField();
        jLabel27 = new javax.swing.JLabel();
        txt_cnpj = new javax.swing.JFormattedTextField();
        txt_telefone = new javax.swing.JFormattedTextField();
        btn_novo1 = new javax.swing.JButton();
        btn_salvar1 = new javax.swing.JButton();
        btn_alterar1 = new javax.swing.JButton();
        btn_cancelar1 = new javax.swing.JButton();
        btn_deletar1 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();

        setClosable(true);

        jLabel1.setText("ID");

        jLabel2.setText("Descrição");

        jLabel3.setText("Data Início");

        jLabel4.setText("Data Prevista");

        jLabel5.setText("Leiloeiro");

        jLabel6.setText("Edital");

        jLabel7.setText("Vistoriadora");

        jLabel8.setText("Pátio");

        jLabel9.setText("Custo Laudo");

        jLabel10.setText("Cidade");

        jLabel11.setText("Desv. Doc");

        jLabel12.setText("Desv. Sem Doc");

        jLabel13.setText("Desv. Sucata");

        jLabel14.setText("Observações Carta de Notificação - Frente");

        tb_leilao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descrição", "Leiloeiro", "Pátio", "Cidade", "Edital"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_leilao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_leilaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_leilao);
        if (tb_leilao.getColumnModel().getColumnCount() > 0) {
            tb_leilao.getColumnModel().getColumn(0).setMinWidth(30);
            tb_leilao.getColumnModel().getColumn(0).setPreferredWidth(30);
            tb_leilao.getColumnModel().getColumn(0).setMaxWidth(30);
            tb_leilao.getColumnModel().getColumn(5).setMinWidth(100);
            tb_leilao.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_leilao.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        jLabel15.setText("Buscar");

        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });

        btn_newPatio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/if_1_41688.png"))); // NOI18N
        btn_newPatio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newPatioActionPerformed(evt);
            }
        });

        jInternalFrame1.setClosable(true);

        lbl_id.setText("ID");

        txt_id1.setEditable(false);

        jLabel16.setText("Razão Social");

        jLabel17.setText("Nome Fantasia");

        jLabel18.setText("Endereço");

        jLabel19.setText("n°");

        jLabel20.setText("Bairro");

        jLabel21.setText("CEP");

        jLabel22.setText("Cidade");

        cbox_cidade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_cidade1ActionPerformed(evt);
            }
        });
        cbox_cidade1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbox_cidade1KeyPressed(evt);
            }
        });

        jLabel23.setText("Tel");

        jLabel24.setText("Login");

        jLabel25.setText("Senha");

        jLabel26.setText("Busca");

        txt_buscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscar1KeyReleased(evt);
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
        jScrollPane2.setViewportView(tb_empresa);

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

        jLabel27.setText("CNPJ");

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

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbl_id)
                .addGap(70, 70, 70)
                .addComponent(txt_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel16)
                .addGap(17, 17, 17)
                .addComponent(txt_razao, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel17)
                .addGap(5, 5, 5)
                .addComponent(txt_fantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel24)
                .addGap(60, 60, 60)
                .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel25)
                .addGap(5, 5, 5)
                .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(txt_buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
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
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(51, 51, 51)
                        .addComponent(cbox_cidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27)
                        .addGap(7, 7, 7)
                        .addComponent(txt_cnpj))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(37, 37, 37)
                        .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_numero))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(56, 56, 56)
                        .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel21)
                        .addGap(4, 4, 4)
                        .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbl_id))
                    .addComponent(txt_id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel16))
                    .addComponent(txt_razao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel17))
                    .addComponent(txt_fantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel20))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel21))
                    .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel23))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel22))
                    .addComponent(cbox_cidade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel27))
                    .addComponent(txt_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))))
                .addGap(21, 21, 21)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel26))
                    .addComponent(txt_buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_novo1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btn_novo1.setText("NOVO");
        btn_novo1.setEnabled(false);
        btn_novo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novo1ActionPerformed(evt);
            }
        });

        btn_salvar1.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        btn_salvar1.setText("SALVAR");
        btn_salvar1.setEnabled(false);
        btn_salvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvar1ActionPerformed(evt);
            }
        });

        btn_alterar1.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        btn_alterar1.setText("ALTERAR");
        btn_alterar1.setEnabled(false);
        btn_alterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alterar1ActionPerformed(evt);
            }
        });

        btn_cancelar1.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        btn_cancelar1.setText("CANCELAR");
        btn_cancelar1.setEnabled(false);
        btn_cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar1ActionPerformed(evt);
            }
        });

        btn_deletar1.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        btn_deletar1.setText("DELETAR");
        btn_deletar1.setEnabled(false);
        btn_deletar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deletar1ActionPerformed(evt);
            }
        });

        jLabel28.setText("Novo Pátio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(0, 356, Short.MAX_VALUE))
                                            .addComponent(txt_descricao))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(data_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(data_termino, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(325, 325, 325))
                                            .addComponent(cbox_leiloeiro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7)
                                            .addComponent(cbox_vistoria, 0, 434, Short.MAX_VALUE)
                                            .addComponent(cbox_cidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(70, 70, 70)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(cbox_patio, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel13)
                                                                .addComponent(txt_sucata, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGap(30, 30, 30)
                                                                .addComponent(jLabel6))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(jLabel28)
                                                                    .addComponent(btn_newPatio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_custoLaudo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel9)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel11)
                                                        .addGap(98, 98, 98)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txt_noDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel12))))
                                                .addGap(178, 178, 178)
                                                .addComponent(txt_edital, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel14))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 73, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_novo1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(btn_salvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(btn_alterar1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(btn_cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(btn_deletar1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(144, 144, 144)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_notificacao, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(data_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(data_termino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbox_leiloeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel9)
                        .addComponent(jLabel8))
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbox_vistoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbox_patio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_custoLaudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_newPatio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbox_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_doc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_noDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sucata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_edital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_notificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(btn_novo1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_alterar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_deletar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 466, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 467, Short.MAX_VALUE)))
        );

        setBounds(0, 0, 1228, 969);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newPatioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newPatioActionPerformed
        leilao_patio patio = new leilao_patio(cbox_patio);
        patio.setVisible(true);
        desk.add(patio);
        this.setVisible(false);


    }//GEN-LAST:event_btn_newPatioActionPerformed

    private void cbox_cidade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_cidade1ActionPerformed

    }//GEN-LAST:event_cbox_cidade1ActionPerformed

    private void cbox_cidade1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbox_cidade1KeyPressed

    }//GEN-LAST:event_cbox_cidade1KeyPressed

    private void txt_buscar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar1KeyReleased

    }//GEN-LAST:event_txt_buscar1KeyReleased

    private void tb_empresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_empresaMouseClicked

    }//GEN-LAST:event_tb_empresaMouseClicked

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed

    }//GEN-LAST:event_btn_novoActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed

    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterarActionPerformed

    }//GEN-LAST:event_btn_alterarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed

    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deletarActionPerformed

    }//GEN-LAST:event_btn_deletarActionPerformed

    private void btn_novo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novo1ActionPerformed

        habilitarCampos(true);
        btn_salvar1.setEnabled(true);
        btn_deletar1.setEnabled(false);
        btn_alterar1.setEnabled(false);
        btn_cancelar1.setEnabled(true);
        txt_buscar1.setEnabled(false);
        limparCampos();
        btn_novo1.setEnabled(false);
        tb_leilao.setVisible(false);
    }//GEN-LAST:event_btn_novo1ActionPerformed

    private void btn_salvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvar1ActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Deseja Salvar Leilão " + txt_descricao.getText() + "?", "Cadastrar Leilão", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            if (txt_id.getText().equals("")) {
                popularLeilao();
                if (leilaoC.verificarDados(leilaoB)) {
                    btn_salvar1.setEnabled(false);
                    btn_cancelar1.setEnabled(false);
                    btn_alterar1.setEnabled(false);
                    btn_deletar1.setEnabled(false);
                    btn_novo1.setEnabled(true);
                    tb_leilao.setVisible(true);
                    habilitarCampos(false);
                    limparCampos();
                    leilaoC.cadastrar(leilaoB);

                }
            } else {
                leilaoB.setId(Integer.parseInt(txt_id.getText()));
                popularLeilao();
                if (leilaoC.verificarDados(leilaoB)) {
                    leilaoC.editarController(leilaoB);
                    btn_alterar1.setEnabled(false);
                    btn_cancelar1.setEnabled(false);
                    btn_deletar1.setEnabled(false);
                    btn_novo1.setEnabled(true);
                    btn_salvar1.setEnabled(false);
                    tb_leilao.setVisible(true);
                    habilitarCampos(false);
                    limparCampos();
                    txt_buscar1.setText("");

                }

            }

        } else {

        }
        Modelo.setNumRows(0);
        leilaoD.buscarTodosLeiloes(Modelo);
    }//GEN-LAST:event_btn_salvar1ActionPerformed

    private void btn_alterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterar1ActionPerformed
        btn_salvar1.setEnabled(true);
        btn_novo1.setEnabled(false);
        btn_cancelar1.setEnabled(true);
        btn_alterar1.setEnabled(false);
        btn_deletar1.setEnabled(false);
        //tb_usuario.setVisible(false);
        habilitarCampos(true);
    }//GEN-LAST:event_btn_alterar1ActionPerformed

    private void btn_cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar1ActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Deseja cancelar esta operação" + "?", "Cancelar Operação", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            btn_cancelar1.setEnabled(false);
            btn_alterar1.setEnabled(false);
            btn_salvar1.setEnabled(false);
            btn_novo1.setEnabled(true);
            btn_deletar1.setEnabled(false);
            tb_leilao.setVisible(true);
            limparCampos();
            habilitarCampos(false);

        } else {

        }
    }//GEN-LAST:event_btn_cancelar1ActionPerformed

    private void btn_deletar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deletar1ActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Deseja Excluir Registro" + "?", "Excluir Registro", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            popularLeilao();
            leilaoB.setId(Integer.parseInt(txt_id.getText()));
            leilaoC.deletarController(leilaoB);
            btn_novo1.setEnabled(true);
            btn_salvar1.setEnabled(false);
            btn_alterar1.setEnabled(false);
            btn_deletar1.setEnabled(false);
            btn_cancelar1.setEnabled(false);
            tb_leilao.setVisible(true);
            habilitarCampos(false);
            limparCampos();
            Modelo.setNumRows(0);
            leilaoD.buscarTodosLeiloes(Modelo);

        }
    }//GEN-LAST:event_btn_deletar1ActionPerformed

    private void tb_leilaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_leilaoMouseClicked
        try {
            leilaoB = leilaoC.controlePreencherCampos(Integer.parseInt(Modelo.getValueAt(tb_leilao.getSelectedRow(), 0).toString()));
            txt_id.setText(leilaoB.getId() + "");
            txt_descricao.setText(leilaoB.getDescricao());
            data_inicio.setDate(spf.parse(Corretores.ConverterParaJava(leilaoB.getDataInicio())));
            data_termino.setDate(spf.parse(Corretores.ConverterParaJava(leilaoB.getDataPrevista())));
            txt_custoLaudo.setText(Double.toString(leilaoB.getCustoLaudo()));
            txt_edital.setText(leilaoB.getEdital());
            txt_doc.setText(Double.toString(leilaoB.getDesvComDoc()));
            txt_noDoc.setText(Double.toString(leilaoB.getDesvSemDoc()));
            txt_sucata.setText(Double.toString(leilaoB.getDesvSucata()));
            txt_notificacao.setText(leilaoB.getCartaDeNotificacao());

            for (int i = 0; i <= cbox_cidade.getItemCount(); i++) {
                CidadeBeans item = (CidadeBeans) cbox_cidade.getItemAt(i);
                if (Objects.equals(item.getId(), leilaoB.getCidade().getId())) {
                    cbox_cidade.setSelectedIndex(i);
                    break;
                }
            }

            for (int i = 0; i <= cbox_patio.getItemCount(); i++) {
                PatioBeans item = (PatioBeans) cbox_patio.getItemAt(i);
                if ((int) item.getId() == leilaoB.getPatio().getId()) {
                    cbox_patio.setSelectedIndex(i);
                    break;
                }
            }

            for (int k = 0; k <= cbox_vistoria.getItemCount(); k++) {
                VistoriaBeans item3 = (VistoriaBeans) cbox_vistoria.getItemAt(k);
                if ((int) item3.getId() == leilaoB.getVistoriadora().getId()) {
                    cbox_vistoria.setSelectedIndex(k);
                    break;
                }
            }

            for (int l = 0; l <= cbox_leiloeiro.getItemCount(); l++) {
                LeiloeiroBeans item4 = (LeiloeiroBeans) cbox_leiloeiro.getItemAt(l);
                if ((int) item4.getId() == leilaoB.getLeiloeiro().getId()) {
                    cbox_leiloeiro.setSelectedIndex(l);
                    break;
                }
            }

            habilitarCampos(false);
            btn_novo1.setEnabled(false);
            btn_salvar1.setEnabled(false);
            btn_alterar1.setEnabled(true);
            btn_cancelar1.setEnabled(true);
            btn_deletar1.setEnabled(true);
        } catch (ParseException ex) {
            Logger.getLogger(Leilao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tb_leilaoMouseClicked

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
       
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void txt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyPressed
        Modelo.setNumRows(0);
        leilaoC.controlePesquisa(txt_buscar1.getText(), Modelo);
    }//GEN-LAST:event_txt_buscarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_alterar;
    private javax.swing.JButton btn_alterar1;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_cancelar1;
    private javax.swing.JButton btn_deletar;
    private javax.swing.JButton btn_deletar1;
    private javax.swing.JButton btn_newPatio;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_novo1;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JButton btn_salvar1;
    private javax.swing.JComboBox<Object> cbox_cidade;
    private javax.swing.JComboBox<Object> cbox_cidade1;
    public javax.swing.JComboBox<Object> cbox_leiloeiro;
    public javax.swing.JComboBox<Object> cbox_patio;
    private javax.swing.JComboBox<Object> cbox_vistoria;
    private com.toedter.calendar.JDateChooser data_inicio;
    private com.toedter.calendar.JDateChooser data_termino;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JTable tb_empresa;
    private javax.swing.JTable tb_leilao;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_buscar1;
    private javax.swing.JFormattedTextField txt_cep;
    private javax.swing.JFormattedTextField txt_cnpj;
    private javax.swing.JTextField txt_custoLaudo;
    private javax.swing.JTextField txt_descricao;
    private javax.swing.JTextField txt_doc;
    private javax.swing.JTextField txt_edital;
    private javax.swing.JTextField txt_endereco;
    private javax.swing.JTextField txt_fantasia;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_id1;
    private javax.swing.JTextField txt_login;
    private javax.swing.JTextField txt_noDoc;
    private javax.swing.JTextField txt_notificacao;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JTextField txt_razao;
    private javax.swing.JPasswordField txt_senha;
    private javax.swing.JTextField txt_sucata;
    private javax.swing.JFormattedTextField txt_telefone;
    // End of variables declaration//GEN-END:variables
}
