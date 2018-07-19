package GUI;

import Beans.FotosBeans;
import Controller.FotosController;
import Utilitarios.Conexao;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gabriel
 */
public class UploadFotos extends javax.swing.JFrame {

    ArrayList<BufferedImage> imagens;
    ArrayList<String> nomeDosArquivos;
    FotosBeans FotoB = new FotosBeans();
    FotosController FotoC = new FotosController();

    /**
     * Creates new form Upload
     */
    public UploadFotos() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        carregaComboBox();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImagem = new javax.swing.JLabel();
        cbleilao = new javax.swing.JComboBox<>();
        txtIdleilao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblexistentes = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblatualizados = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lblnovo = new javax.swing.JTextArea();
        btn_OpenFolder = new javax.swing.JButton();
        btn_Import = new javax.swing.JButton();
        barraProgresso = new javax.swing.JProgressBar();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);

        cbleilao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbleilao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbleilaoItemStateChanged(evt);
            }
        });
        cbleilao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbleilaoActionPerformed(evt);
            }
        });

        txtIdleilao.setEditable(false);
        txtIdleilao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIdleilao.setText("1");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Lotes Existentes");

        lblexistentes.setBackground(new java.awt.Color(255, 204, 204));
        lblexistentes.setColumns(10);
        lblexistentes.setRows(5);
        jScrollPane1.setViewportView(lblexistentes);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Lotes Atualizados");

        lblatualizados.setBackground(new java.awt.Color(51, 255, 255));
        lblatualizados.setColumns(10);
        lblatualizados.setRows(5);
        jScrollPane2.setViewportView(lblatualizados);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Lotes Novos");

        lblnovo.setBackground(new java.awt.Color(153, 255, 153));
        lblnovo.setColumns(10);
        lblnovo.setRows(5);
        jScrollPane3.setViewportView(lblnovo);

        btn_OpenFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/OpenFolder.png"))); // NOI18N
        btn_OpenFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OpenFolderActionPerformed(evt);
            }
        });

        btn_Import.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/CloseFolder.png"))); // NOI18N
        btn_Import.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ImportActionPerformed(evt);
            }
        });

        barraProgresso.setForeground(new java.awt.Color(0, 0, 255));
        barraProgresso.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 255), 1, true));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/asd.JPG"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(lblImagem))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)))
                .addComponent(jLabel10))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIdleilao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cbleilao, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btn_OpenFolder)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Import))
                    .addComponent(barraProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 1307, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_OpenFolder)
                    .addComponent(btn_Import)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdleilao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbleilao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(lblImagem))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    File[] arquivos;

    public void CaminhoFotos() {
        JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(true);
        int res = fc.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {

            arquivos = fc.getSelectedFiles();
            nomeDosArquivos = new ArrayList<>();
            imagens = new ArrayList<>();

            for (File f : arquivos) {
                nomeDosArquivos.add(f.getName());
                try {
                    imagens.add(Utilitarios.ManipularImagem.setImagemDimensao(f.getAbsolutePath(), 800, 600));
                } catch (Exception ex) {

                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Você não selecionou nenhum arquivo.");
        }
    }

    public void InserirFotos() {
        new Thread() {
            @Override
            public void run() {
                try {
                    int contador = 0;
                    barraProgresso.setMaximum(imagens.size());
                    for (BufferedImage i : imagens) {

                      
                        java.io.File diretorio1 = new java.io.File("C:\\Users\\joaoh\\Desktop\\Leilões");
                        boolean statusDir1 = diretorio1.mkdir();
                        
                        String leilao = cbleilao.getSelectedItem().toString();
                        java.io.File diretorio2 = new java.io.File(diretorio1 + "\\" + leilao + "\\");
                        boolean statusDir2 = diretorio2.mkdir();
                        
                        java.io.File diretorio3 = new java.io.File(diretorio2 + "\\Fotos\\");
                        boolean statusDir3 = diretorio3.mkdir();

                        
                        String caminhofinal = diretorio3 + "\\" + nomeDosArquivos.get(contador);
                        
                        String diretoriofinal = diretorio3 + "\\";
                         
                        String Lote, Tipo;
                        int idleilao = Integer.parseInt(txtIdleilao.getText()); 
                               
                        if (caminhofinal.contains("T_")) {
                            Lote = caminhofinal.substring(caminhofinal.lastIndexOf("\\") + 1, caminhofinal.lastIndexOf("T_"));
                            Tipo = caminhofinal.substring(caminhofinal.lastIndexOf("T_"), caminhofinal.lastIndexOf("T_") + 2);

                            String sql1 = "select * from fotos where caminho=?";
                            PreparedStatement st = Conexao.getConnection().prepareStatement(sql1);
                            st.setString(1, diretoriofinal + Lote + Tipo + ".jpg");
                            ResultSet rs = st.executeQuery();

                            if (!rs.next()) {
                                File outputfile = new File(diretoriofinal + Lote + Tipo + ".jpg");
                                ImageIO.write(i, "jpg", outputfile);

                                FotoB.setCaminho(caminhofinal);
                                FotoB.setLote(Lote);
                                FotoB.setTipo(Tipo);
                                FotoB.setIdleilao(idleilao);
                                FotoC.InserirFotos(FotoB);

                                String existente = Lote + Tipo;
                                lblatualizados.setText(lblatualizados.getText() + existente + "\n");
                    
                            } else {
                                String existente = Lote + Tipo;
                                lblexistentes.setText(lblexistentes.getText() + existente + "\n");
                            }
                        } else if (caminhofinal.contains("MP_")) {
                            Lote = caminhofinal.substring(caminhofinal.lastIndexOf("\\") + 1, caminhofinal.lastIndexOf("MP_"));
                            Tipo = caminhofinal.substring(caminhofinal.lastIndexOf("MP"), caminhofinal.lastIndexOf("MP_") + 3);

                            String sql1 = "select * from fotos where caminho=?";
                            PreparedStatement st = Conexao.getConnection().prepareStatement(sql1);
                            st.setString(1, diretoriofinal + Lote + Tipo + ".jpg");
                            ResultSet rs = st.executeQuery();

                            if (!rs.next()) {
                                File outputfile = new File(diretoriofinal + Lote + Tipo + ".jpg");
                                ImageIO.write(i, "jpg", outputfile);
                                FotoB.setCaminho(caminhofinal);
                                FotoB.setLote(Lote);
                                FotoB.setTipo(Tipo);
                                FotoB.setIdleilao(idleilao);
                                FotoC.InserirFotos(FotoB);
                                String existente = Lote + Tipo;
                                lblatualizados.setText(lblatualizados.getText() + existente + "\n");
                            } else {
                                String existente = Lote + Tipo;
                                lblexistentes.setText(lblexistentes.getText() + existente + "\n");
                            }
                        } else if (caminhofinal.contains("MF_")) {
                            Lote = caminhofinal.substring(caminhofinal.lastIndexOf("\\") + 1, caminhofinal.lastIndexOf("MF_"));
                            Tipo = caminhofinal.substring(caminhofinal.lastIndexOf("MF"), caminhofinal.lastIndexOf("MF_") + 3);

                            String sql1 = "select * from fotos where caminho=?";
                            PreparedStatement st = Conexao.getConnection().prepareStatement(sql1);
                            st.setString(1, diretoriofinal + Lote + Tipo + ".jpg");
                            ResultSet rs = st.executeQuery();

                            if (!rs.next()) {
                                File outputfile = new File(diretoriofinal + Lote + Tipo + ".jpg");
                                ImageIO.write(i, "jpg", outputfile);

                                FotoB.setCaminho(caminhofinal);
                                FotoB.setLote(Lote);
                                FotoB.setTipo(Tipo);
                                FotoB.setIdleilao(idleilao);
                                FotoC.InserirFotos(FotoB);

                                String existente = Lote + Tipo;
                                lblatualizados.setText(lblatualizados.getText() + existente + "\n");
                            } else {
                                String existente = Lote + Tipo;
                                lblexistentes.setText(lblexistentes.getText() + existente + "\n");
                            }
                        } else if (caminhofinal.contains("CH_")) {
                            Lote = caminhofinal.substring(caminhofinal.lastIndexOf("\\") + 1, caminhofinal.lastIndexOf("CH_"));
                            Tipo = caminhofinal.substring(caminhofinal.lastIndexOf("CH"), caminhofinal.lastIndexOf("CH_") + 3);

                            String sql1 = "select * from fotos where caminho=?";
                            PreparedStatement st = Conexao.getConnection().prepareStatement(sql1);
                            st.setString(1, diretoriofinal + Lote + Tipo + ".jpg");
                            ResultSet rs = st.executeQuery();

                            if (!rs.next()) {
                                File outputfile = new File(diretoriofinal + Lote + Tipo + ".jpg");
                                ImageIO.write(i, "jpg", outputfile);

                                FotoB.setCaminho(caminhofinal);
                                FotoB.setLote(Lote);
                                FotoB.setTipo(Tipo);
                                FotoB.setIdleilao(idleilao);
                                FotoC.InserirFotos(FotoB);
                                String existente = Lote + Tipo;
                                lblatualizados.setText(lblatualizados.getText() + existente + "\n");
                            } else {
                                String existente = Lote + Tipo;
                                lblexistentes.setText(lblexistentes.getText() + existente + "\n");
                            }
                        }
                       
                        else if (caminhofinal.substring(caminhofinal.length() - 6, caminhofinal.length()).contains("E")) {
                            //    
                            Lote = caminhofinal.substring(caminhofinal.lastIndexOf("\\") + 1, caminhofinal.lastIndexOf(".jpg") - 2);
                            Tipo = caminhofinal.substring(caminhofinal.indexOf(".jpg") - 2, caminhofinal.lastIndexOf(".jpg"));
                            
                            System.out.println(caminhofinal);   
                            String sql1 = "select * from fotos where caminho=?";
                            PreparedStatement st = Conexao.getConnection().prepareStatement(sql1);
                            st.setString(1, diretoriofinal + Lote + Tipo + ".jpg");
                            ResultSet rs = st.executeQuery();

                            if (!rs.next()) {
                                File outputfile = new File(diretoriofinal + Lote + Tipo + ".jpg");
                                ImageIO.write(i, "jpg", outputfile);

                                FotoB.setCaminho(caminhofinal);
                                FotoB.setLote(Lote);
                                FotoB.setTipo(Tipo);
                                FotoB.setIdleilao(idleilao);
                                FotoC.InserirFotos(FotoB);
                                
                                String existente = Lote + Tipo;
                                lblatualizados.setText(lblatualizados.getText() + existente + "\n");
                            } else {
                                String existente = Lote + Tipo;
                                lblexistentes.setText(lblexistentes.getText() + existente + "\n");
                            }
                        } else if (caminhofinal.contains("F.jpg")) {
                            Lote = caminhofinal.substring(caminhofinal.lastIndexOf("\\") + 1, caminhofinal.lastIndexOf("F"));
                            Tipo = caminhofinal.substring(caminhofinal.lastIndexOf("F"), caminhofinal.lastIndexOf("F") + 1);
                             
                            System.out.println(Lote);
                            System.out.println(Tipo);
                            
                            String sql1 = "select * from fotos where caminho=?";
                            PreparedStatement st = Conexao.getConnection().prepareStatement(sql1);
                            st.setString(1, diretoriofinal + Lote + Tipo + ".jpg");
                            ResultSet rs = st.executeQuery();

                            if (!rs.next()) {
                                File outputfile = new File(diretoriofinal + Lote + Tipo + ".jpg");
                                ImageIO.write(i, "jpg", outputfile);

                                FotoB.setCaminho(caminhofinal);
                                FotoB.setLote(Lote);
                                FotoB.setTipo(Tipo);
                                FotoB.setIdleilao(idleilao);
                                FotoC.InserirFotos(FotoB);

                                String existente = Lote + Tipo;
                                lblatualizados.setText(lblatualizados.getText() + existente + "\n");
                            } else {
                                String existente = Lote + Tipo;
                                lblexistentes.setText(lblexistentes.getText() + existente + "\n");
                            }
                        }
                        contador++;
                        barraProgresso.setValue(contador);
                    }
                   
                    nomeDosArquivos.clear();
                    imagens.clear();
                    JOptionPane.showMessageDialog(rootPane, "Imagens enviadas com sucesso");

                } catch (IOException ex) {
                    Logger.getLogger(UploadFotos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(UploadFotos.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }.start();
    }
    

    private void cbleilaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbleilaoItemStateChanged
        BuscarIdCidade();
      
    }//GEN-LAST:event_cbleilaoItemStateChanged

    private void btn_OpenFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OpenFolderActionPerformed
        CaminhoFotos();
    }//GEN-LAST:event_btn_OpenFolderActionPerformed

    private void btn_ImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ImportActionPerformed
        InserirFotos();

    }//GEN-LAST:event_btn_ImportActionPerformed

    private void cbleilaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbleilaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbleilaoActionPerformed

    public void BuscarIdCidade() {
        try {
            String sql = "select * from leiloes where descricao like '%" + cbleilao.getSelectedItem() + "%' ";
            PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                txtIdleilao.setText(rs.getString(1));
            }
        } catch (Exception e) {
        }
    }

    public void carregaComboBox() {
        try {
            Connection conn;
            conn = Conexao.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT leiloes.descricao FROM leiloes");
            while (rs.next()) {
                cbleilao.addItem(rs.getString("descricao"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Ocorreu erro ao carregar a Combo Box", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UploadFotos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UploadFotos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UploadFotos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UploadFotos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UploadFotos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgresso;
    private javax.swing.JButton btn_Import;
    private javax.swing.JButton btn_OpenFolder;
    private javax.swing.JComboBox<String> cbleilao;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JTextArea lblatualizados;
    private javax.swing.JTextArea lblexistentes;
    private javax.swing.JTextArea lblnovo;
    private javax.swing.JTextField txtIdleilao;
    // End of variables declaration//GEN-END:variables
}
