/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewBingo;

import java.awt.Image;
import java.awt.Graphics;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import modelo.bean.GraficoNivel;

/**
 *
 * @author Pituba
 */
public class frmMidBingo extends javax.swing.JFrame {

    /**
     * Creates new form frmMidBingo
     */
    File dotingraficlevelfile = new File("C:\\Meusbd\\Pontosnografico.txt");
    public frmMidBingo() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Imagens/chips_98557(1).png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnGerarCombinacoes = new javax.swing.JButton();
        btnAbreSalvar14e15 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagens/imagemlotofacil.jpg"));
        Image image = icon.getImage();
        dkpInicioBingo = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }

        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        btnGerarCombinacoes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGerarCombinacoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/chips_98557.png"))); // NOI18N
        btnGerarCombinacoes.setText("Gerar ");
        btnGerarCombinacoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGerarCombinacoes.setFocusable(false);
        btnGerarCombinacoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGerarCombinacoes.setMaximumSize(new java.awt.Dimension(47, 47));
        btnGerarCombinacoes.setMinimumSize(new java.awt.Dimension(47, 47));
        btnGerarCombinacoes.setPreferredSize(new java.awt.Dimension(47, 47));
        btnGerarCombinacoes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnGerarCombinacoes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGerarCombinacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarCombinacoesActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGerarCombinacoes);

        btnAbreSalvar14e15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAbreSalvar14e15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ark2.png"))); // NOI18N
        btnAbreSalvar14e15.setText("Inserir");
        btnAbreSalvar14e15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAbreSalvar14e15.setFocusable(false);
        btnAbreSalvar14e15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAbreSalvar14e15.setMaximumSize(new java.awt.Dimension(47, 47));
        btnAbreSalvar14e15.setMinimumSize(new java.awt.Dimension(47, 47));
        btnAbreSalvar14e15.setPreferredSize(new java.awt.Dimension(47, 47));
        btnAbreSalvar14e15.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAbreSalvar14e15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAbreSalvar14e15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbreSalvar14e15ActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAbreSalvar14e15);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-editar-relatório-gráfico-24.png"))); // NOI18N
        jButton1.setText("Gráfico");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMaximumSize(new java.awt.Dimension(47, 47));
        jButton1.setMinimumSize(new java.awt.Dimension(47, 47));
        jButton1.setPreferredSize(new java.awt.Dimension(47, 47));
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        javax.swing.GroupLayout dkpInicioBingoLayout = new javax.swing.GroupLayout(dkpInicioBingo);
        dkpInicioBingo.setLayout(dkpInicioBingoLayout);
        dkpInicioBingoLayout.setHorizontalGroup(
            dkpInicioBingoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        dkpInicioBingoLayout.setVerticalGroup(
            dkpInicioBingoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 709, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
            .addComponent(dkpInicioBingo)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dkpInicioBingo))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarCombinacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarCombinacoesActionPerformed
        frmGerarCombinacoes frmgerarcombinacoes = new frmGerarCombinacoes();
        dkpInicioBingo.add(frmgerarcombinacoes);
        frmgerarcombinacoes.setVisible(true);
        
    }//GEN-LAST:event_btnGerarCombinacoesActionPerformed

    private void btnAbreSalvar14e15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbreSalvar14e15ActionPerformed
        frmSalvarTrezeeQuatorzePontos frmsalvarquatorzeequinzepontos = new frmSalvarTrezeeQuatorzePontos();
        dkpInicioBingo.add(frmsalvarquatorzeequinzepontos);
        frmsalvarquatorzeequinzepontos.setVisible(true);
    }//GEN-LAST:event_btnAbreSalvar14e15ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        GraficoNivel graficonivel = new GraficoNivel();
        graficonivel.GraficoNivel(dotingraficlevelfile);
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmMidBingo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMidBingo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMidBingo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMidBingo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMidBingo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbreSalvar14e15;
    private javax.swing.JButton btnGerarCombinacoes;
    private javax.swing.JDesktopPane dkpInicioBingo;
    private javax.swing.JButton jButton1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}