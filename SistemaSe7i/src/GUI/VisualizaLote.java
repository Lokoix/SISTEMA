/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.FotosDAO;
import Utilitarios.Conexao;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joaoh
 */
public class VisualizaLote extends javax.swing.JFrame {

    DefaultTableModel modelo; 
    FotosDAO FotoD = new FotosDAO(); 
    FrmVerFoto frmverfoto = new FrmVerFoto();
    public VisualizaLote() {
        initComponents();
        int nlotes = 0; 
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        modelo = (DefaultTableModel) tblote.getModel(); 
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblote = new javax.swing.JTable();
        txtbuscalote = new javax.swing.JTextField();
        cbleilao = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        lbltraseira = new javax.swing.JLabel();
        lblfrente = new javax.swing.JLabel();
        lblchassi = new javax.swing.JLabel();
        lblmotor = new javax.swing.JLabel();
        lbllote = new javax.swing.JLabel();
        txtidleilao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtbuscalote2 = new javax.swing.JTextField();
        totalotes = new javax.swing.JLabel();
        lbltotlot = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lote"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbloteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblote);

        cbleilao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbleilaoItemStateChanged(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbltraseira.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbltraseiraMouseClicked(evt);
            }
        });

        lblfrente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblfrenteMouseClicked(evt);
            }
        });

        lblchassi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblchassiMouseClicked(evt);
            }
        });

        lblmotor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblmotorMouseClicked(evt);
            }
        });

        lbllote.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbllote.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lbllotePropertyChange(evt);
            }
        });

        txtidleilao.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Lote:");

        totalotes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbltotlot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Lote Inicial");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Lote Final");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalotes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(417, 417, 417)
                        .addComponent(lbltotlot, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbllote, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(txtidleilao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbleilao, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtbuscalote, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtbuscalote2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbltraseira, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblfrente, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblchassi, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblmotor, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbuscalote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbleilao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(txtidleilao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbuscalote2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbllote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblmotor, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(lbltraseira, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(lblfrente, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(lblchassi, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbltotlot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalotes, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addContainerGap(496, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbloteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbloteMouseClicked
        SetarLabel();
    }//GEN-LAST:event_tbloteMouseClicked

    private void lbllotePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lbllotePropertyChange
        SetarLabelTraseira();
        SetarLabelFrente();
        SetarLabelChassi();
        SetarLabelMotor();
    }//GEN-LAST:event_lbllotePropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String lote = txtbuscalote.getText(); 
        String lote2 = txtbuscalote2.getText(); 
        String leilao = txtidleilao.getText();
        
        if(!lote2.equals("") && lote.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Lote inicial deve ser informado");
        }
        if(lote2.equals("") && !lote.equals(""))
        {
           BuscarFoto(modelo, lote, leilao);
        }else if(lote.equals("") && lote2.equals("")){
           BuscarFotosLeilao(modelo, leilao);
        }else 
           BuscarFotosIntervalo(modelo, lote, lote2, leilao);
           
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblchassiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblchassiMouseClicked
        
        String sql = "select * from fotos where (lote ="+lbllote.getText()+" and idleilao="+txtidleilao.getText()+") and (tipo='CH_' or tipo='CF_')";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            String caminhofinal = null;

            while (rs.next()) {
                caminhofinal = rs.getString(4);
            }

            ImageIcon iconchassi = new ImageIcon(caminhofinal);
            String tipo = "Chassi"; 
            frmverfoto.setVisible(true);
            frmverfoto.setarImagem(iconchassi, tipo);
            
            Conexao.getConnection().commit();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblchassiMouseClicked

    private void cbleilaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbleilaoItemStateChanged
         BuscarIdCidade(); 
    }//GEN-LAST:event_cbleilaoItemStateChanged

    private void lblmotorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmotorMouseClicked
        String sql = "select * from fotos where (lote ="+lbllote.getText()+" and idleilao="+txtidleilao.getText()+") and (tipo='MP_' or tipo='MF_')";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            String caminhofinal = null;

            while (rs.next()) {
                caminhofinal = rs.getString(4);
            }
            String tipo = "Motor"; 
            ImageIcon iconmotor = new ImageIcon(caminhofinal);
            frmverfoto.setVisible(true);
            frmverfoto.setarImagem(iconmotor, tipo);
            
            Conexao.getConnection().commit();
        } catch (Exception e) {
            //System.out.println("MOTOR: "+e);
        }
    }//GEN-LAST:event_lblmotorMouseClicked

    private void lbltraseiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbltraseiraMouseClicked
        String sql = "select * from fotos where lote ="+lbllote.getText()+" and idleilao="+txtidleilao.getText()+" and tipo='T_'";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            String caminhofinal = null;

            while (rs.next()) {
                caminhofinal = rs.getString(4);
            }
            String tipo = "Traseira"; 
            ImageIcon icontraseira = new ImageIcon(caminhofinal);
            lbltraseira.setIcon(new ImageIcon(icontraseira.getImage().getScaledInstance(lbltraseira.getWidth(), lbltraseira.getHeight(), Image.SCALE_DEFAULT)));
            frmverfoto.setVisible(true);
            frmverfoto.setarImagem(icontraseira, tipo);
            Conexao.getConnection().commit();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lbltraseiraMouseClicked

    private void lblfrenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblfrenteMouseClicked
       String sql = "select * from fotos where lote="+lbllote.getText()+" and idleilao="+txtidleilao.getText()+" and tipo='F'";
        
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            String caminhofinal = null;

            while (rs.next()) {
                caminhofinal = rs.getString(4);
            }
            String tipo = "Frente"; 
            ImageIcon iconfrente = new ImageIcon(caminhofinal);
            frmverfoto.setVisible(true);
            frmverfoto.setarImagem(iconfrente, tipo);
            
            Conexao.getConnection().commit();
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_lblfrenteMouseClicked

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
            java.util.logging.Logger.getLogger(VisualizaLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizaLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizaLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizaLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizaLote().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbleilao;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblchassi;
    private javax.swing.JLabel lblfrente;
    private javax.swing.JLabel lbllote;
    private javax.swing.JLabel lblmotor;
    private javax.swing.JLabel lbltotlot;
    private javax.swing.JLabel lbltraseira;
    private javax.swing.JTable tblote;
    private javax.swing.JLabel totalotes;
    private javax.swing.JTextField txtbuscalote;
    private javax.swing.JTextField txtbuscalote2;
    private javax.swing.JTextField txtidleilao;
    // End of variables declaration//GEN-END:variables
    
    public void SetarLabel()
    {
        int setar = tblote.getSelectedRow();
        lbllote.setText(tblote.getModel().getValueAt(setar,0).toString());
    }
    
    public void SetarLabelTraseira()
    {
        String sql = "select * from fotos where lote ="+lbllote.getText()+" and idleilao="+txtidleilao.getText()+" and tipo='T_'";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            String caminhofinal = null;

            while (rs.next()) {
                caminhofinal = rs.getString(4);
            }

            ImageIcon icontraseira = new ImageIcon(caminhofinal);
            lbltraseira.setIcon(new ImageIcon(icontraseira.getImage().getScaledInstance(lbltraseira.getWidth(), lbltraseira.getHeight(), Image.SCALE_DEFAULT)));

            Conexao.getConnection().commit();
        } catch (Exception e) {
        }
    }
    
    public void SetarLabelFrente()
    {
      
        String sql = "select * from fotos where lote="+lbllote.getText()+" and idleilao="+txtidleilao.getText()+" and tipo='F'";
        
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            String caminhofinal = null;

            while (rs.next()) {
                caminhofinal = rs.getString(4);
            }

            ImageIcon icontraseira = new ImageIcon(caminhofinal);
            lblfrente.setIcon(new ImageIcon(icontraseira.getImage().getScaledInstance(lblfrente.getWidth(), lblfrente.getHeight(), Image.SCALE_DEFAULT)));

            Conexao.getConnection().commit();
        } catch (Exception e) {
            
        }
    }
    
    public void SetarLabelChassi()
    {
        String sql = "select * from fotos where (lote ="+lbllote.getText()+" and idleilao="+txtidleilao.getText()+") and (tipo='CH_' or tipo='CF_')";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            String caminhofinal = null;

            while (rs.next()) {
                caminhofinal = rs.getString(4);
            }

            ImageIcon icontraseira = new ImageIcon(caminhofinal);
            lblchassi.setIcon(new ImageIcon(icontraseira.getImage().getScaledInstance(lblchassi.getWidth(), lblchassi.getHeight(), Image.SCALE_DEFAULT)));

            Conexao.getConnection().commit();
        } catch (Exception e) {
            
        }
    }
    
    public void SetarLabelMotor()
    {
        String sql = "select * from fotos where (lote ="+lbllote.getText()+" and idleilao="+txtidleilao.getText()+") and (tipo='MP_' or tipo='MF_')";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            String caminhofinal = null;

            while (rs.next()) {
                caminhofinal = rs.getString(4);
            }

            ImageIcon icontraseira = new ImageIcon(caminhofinal);
            lblmotor.setIcon(new ImageIcon(icontraseira.getImage().getScaledInstance(lblmotor.getWidth(), lblmotor.getHeight(), Image.SCALE_DEFAULT)));

            Conexao.getConnection().commit();
        } catch (Exception e) {
            //System.out.println("MOTOR: "+e);
        }
    }

    public void BuscarFoto(DefaultTableModel Modelo,String lote, String leilao)
    {     
        Modelo.setNumRows(0);
        String sql = "select * from lotes where idLeilao="+leilao+" and numeroLote="+lote+" order by lote asc";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Modelo.addRow(new Object[]{rs.getString("lote")});              
            }

            st.execute();
            Conexao.getConnection().commit();
            ContarLote(leilao, lote); 
        } catch (Exception e) {
            System.out.println(e);
        }   
    }
    
    public void ContarLote(String leilao, String lote)
    {
        String sql = "SELECT COUNT(DISTINCT lote) as c from fotos where lote="+lote+" and leilao="+leilao; 
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery(); 
            while(rs.next())
            {
                lbltotlot.setText(rs.getString("c"));
            }
        } catch (Exception e) {
        }
    }
    
    
    public void BuscarFotosLeilao(DefaultTableModel Modelo, String leilao)
    {     
        Modelo.setNumRows(0);
        String sql = "select DISTINCT lote from fotos where idleilao="+leilao+" order by lote asc";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Modelo.addRow(new Object[]{rs.getString("lote")});              
            }

            st.execute();
            Conexao.getConnection().commit();
            ContarLotesLeilao(leilao); 
        } catch (Exception e) {
            System.out.println(e);
        }   
    }
    
    public void ContarLotesLeilao(String leilao)
    {
        String sql = "SELECT COUNT(DISTINCT lote) as c from fotos where leilao="+leilao; 
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery(); 
            while(rs.next())
            {
                lbltotlot.setText(rs.getString("c"));
            }
        } catch (Exception e) {
        }
    }
    
    public void BuscarFotosIntervalo(DefaultTableModel Modelo, String lote,String lote2, String leilao)
    {     
        Modelo.setNumRows(0);
        String sql = "select distinct lote from fotos where lote between "+lote+" and "+lote2+" and leilao="+leilao+" order by lote asc"; 
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Modelo.addRow(new Object[]{rs.getString("lote")});              
            }

            st.execute();
            Conexao.getConnection().commit();
            ContarLotesIntervalo(lote, lote2, leilao);
        } catch (Exception e) {
            System.out.println(e);
        }   
    }
    
    public void ContarLotesIntervalo(String lote, String lote2, String leilao)
    {
        String sql = "SELECT COUNT(DISTINCT lote) as c from fotos where lote between "+lote+" and "+lote2+" and leilao="+leilao+" order by lote asc";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery(); 
            while(rs.next())
            {
                lbltotlot.setText(rs.getString("c"));
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
    
    public void BuscarIdCidade() {
        try {
            String sql = "select * from leiloes where descricao like '%" + cbleilao.getSelectedItem() + "%' ";
            PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                txtidleilao.setText(rs.getString(1));
            }
        } catch (Exception e) {
        }
    }
}
