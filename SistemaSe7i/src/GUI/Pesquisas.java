/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Beans.LeilaoBeans;
import Beans.LoteBeans;
import Beans.ProprietarioBeans;
import Beans.Restricoes.RestricaoBloqueioBeans;
import Beans.VeiculoBeans;
import Controller.LoteController;
import Controller.ProprietarioController;
import Controller.Restricoes.RestricaoBloqueioController;
import Controller.VeiculoController;
import DAO.LeilaoDAO;
import Interface.BaseNacional;
import Interface.Bloqueio;
import Interface.Cadastro;
import importacao.arqtxt.Beans.ManipulaTxt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class Pesquisas extends javax.swing.JInternalFrame {

    /**
     * Creates new form Pesquisas
     */
    ManipulaTxt manipulaTxt;
    Cadastro iCadastro;
    BaseNacional iBaseNacional;
    Bloqueio iBloqueio;
    RestricaoBloqueioController conRestricaoBlo;
    VeiculoController conVeiculo;
    ProprietarioController conProprietario;
    ArrayList<Integer> tipoTxt;
    LeilaoDAO leilaoD;
    LoteController conLote;
    List<File> arquivosEntrada;
    List<File> arquivosBase;

    public Pesquisas() {
        initComponents();
        leilaoD = new LeilaoDAO();

        conVeiculo = new VeiculoController();
        conProprietario = new ProprietarioController();
        conLote = new LoteController();
        conRestricaoBlo = new RestricaoBloqueioController();

        iCadastro = new Cadastro();
        iBaseNacional = new BaseNacional();
        iBloqueio = new Bloqueio();

        manipulaTxt = new ManipulaTxt();
        
        arquivosBase = new ArrayList<>();
        arquivosEntrada = new ArrayList<>();

        for (LeilaoBeans leilao : leilaoD.buscarTodosLeiloes()) {
            cmb_Leilao.addItem(leilao);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_local = new javax.swing.JTextField();
        btn_iniciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmb_Leilao = new javax.swing.JComboBox<>();
        barraProgresso = new javax.swing.JProgressBar();

        setClosable(true);

        txt_local.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_localActionPerformed(evt);
            }
        });

        btn_iniciar.setText("Iniciar");
        btn_iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Leilão:");

        cmb_Leilao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_LeilaoActionPerformed(evt);
            }
        });

        barraProgresso.setForeground(new java.awt.Color(0, 0, 255));
        barraProgresso.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 255), 1, true));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_Leilao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txt_local, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(barraProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmb_Leilao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_iniciar)
                    .addComponent(txt_local, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(373, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarActionPerformed

        String destino = "C://" + ((LeilaoBeans) cmb_Leilao.getSelectedItem()).getDescricao() + "//pesquisas//";

        if (new File(destino).mkdirs()) {
            JOptionPane.showMessageDialog(null, "Pasta Criada");
        }
        String local = txt_local.getText();

        listaDeArquivos(destino, arquivosBase);
        listaDeArquivos(local, arquivosEntrada);

        new Thread() {
            @Override
            public void run() {
                try {
                    barraProgresso.setMaximum(arquivosEntrada.size() - 1);
                    //System.out.println("tamanho Lista de arquivos.size: "+listaDeArquivos.size() + "tamanho Tipos TXT: "+ tipoTxt.size());
                    for (int i = 0; i < arquivosEntrada.size(); i++) {

                        if (arquivosEntrada.indexOf(arquivosBase.get(i)) == -1) {
                            VeiculoBeans veic = new VeiculoBeans();
                            ProprietarioBeans proprietario = new ProprietarioBeans();
                            LoteBeans lote = new LoteBeans();

                            lote.setLeilao((LeilaoBeans) cmb_Leilao.getSelectedItem());
                            ArrayList<String> result = new ArrayList<>();
                            String s;

                            switch (tipoTxt.get(i)) {
                                case 1:
                                    s = listaDeArquivos.get(i);
                                    lote.setNumeroLote(s.substring(0, s.indexOf("CAD.txt")));
                                    result = manipulaTxt.Leitura(local, s);

                                    if (result.size() == 88) { // pesquisa de cadastro normal
                                        iCadastro.getLoteCadastro1(result, lote);
                                        lote.setVeiculo(conVeiculo.corrigirVeiculoPesquisaCadastro(lote.getVeiculo()));
                                        lote.setProprietario(conProprietario.CorrigirProprietarioPesquisaCadastro(lote.getProprietario()));
                                        conLote.corrigirLoteCadastro(lote);
                                        break;
                                    } else if (result.size() == 11) { //pesquisa de cadastro sem registro
                                        iCadastro.getLoteCadastro2(result, lote);
                                        conLote.corrigirLoteCadastro(lote);
                                        break;
                                    } else if (result.size() == 54) {
                                        iCadastro.getLoteCadastro3(result, lote); // pesquisa de cadastro de fora do estado
                                        lote.setVeiculo(conVeiculo.corrigirVeiculoPesquisaCadastro(lote.getVeiculo()));
                                        lote.setProprietario(conProprietario.CorrigirProprietarioPesquisaCadastro(lote.getProprietario()));
                                        conLote.corrigirLoteCadastro(lote);
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "interface difere de CAD: " + listaDeArquivos.get(i).toString());
                                        break;
                                    }

                                case 2:
                                    s = listaDeArquivos.get(i);
                                    lote.setNumeroLote(s.substring(0, s.indexOf("BIN.txt")));
                                    result = manipulaTxt.Leitura(local, s);

                                    if (result.size() == 62) {
                                        iBaseNacional.getLoteBaseNacional1(result, lote);
                                        lote.setVeiculo(conVeiculo.corrigirVeiculoPesquisa(lote.getVeiculo()));
                                        conLote.corrigirLote(lote);
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "interface difere de BIN: " + listaDeArquivos.get(i).toString());
                                    }
                                case 3:
                                    s = listaDeArquivos.get(i);
                                    lote.setNumeroLote(s.substring(0, s.indexOf("BLO")));
                                    result = manipulaTxt.Leitura(local, s);

                                    if (result.get(17).contains("OBITO") || result.get(17).contains("JUDICIAL")) {

                                    } else {
                                        if (result.size() == 39) { // bloqueio padrao 1
                                            RestricaoBloqueioBeans restricaoBlo = new RestricaoBloqueioBeans();
                                            restricaoBlo.setLote(lote);
                                            iBloqueio.getBloqueio1(listaDeArquivos, restricaoBlo);
                                            conRestricaoBlo.corrigirBloqueioPesquisa();

                                        }
                                    }

                                default:
                                    JOptionPane.showMessageDialog(null, "não: " + listaDeArquivos.get(i).toString());
                                    break;
                            }
                        }

                        //JOptionPane.showMessageDialog(null, "Arquivo lido: " + listaDeArquivos.get(i).toString());
                        //JOptionPane.showMessageDialog(null, "ID Leilao: " + ((LeilaoBeans) cmb_Leilao.getSelectedItem()).getId() + ", " + ((LeilaoBeans) cmb_Leilao.getSelectedItem()).getDescricao() + " Lote: " + lote.getNumeroLote() + "  " + listaDeArquivos.get(i).toString());
                        barraProgresso.setValue(i);
                    }
                    JOptionPane.showMessageDialog(null, "ACABOOO");

                } catch (Exception e) {

                }
            }
        }.start();


    }//GEN-LAST:event_btn_iniciarActionPerformed

    private void txt_localActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_localActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_localActionPerformed

    private void cmb_LeilaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_LeilaoActionPerformed

    }//GEN-LAST:event_cmb_LeilaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgresso;
    private javax.swing.JButton btn_iniciar;
    private javax.swing.JComboBox<Object> cmb_Leilao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt_local;
    // End of variables declaration//GEN-END:variables

    public void listaDeArquivos(String local, List<File> lista) {
        File dir = new File(local);
        for (File f : dir.listFiles()) {// lista o que possui no diretorio dir
            if (f.isFile()) {//se for um arquivo true;
                lista.add(f);
            }
        }
    }

    public void copy(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);           // Transferindo bytes de entrada para saída
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

}
