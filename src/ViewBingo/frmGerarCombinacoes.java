/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewBingo;

import FabricaDeConexao.ConexaoFireBird;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.bean.Combinacoes;
import modelo.bean.GeradorDeCombinacoes;
import modelos.dao.TotalProbabilidadeDAO;
import modelos.dao.TotalProbabilidadesTextoDAO;

/**
 *
 * @author Pituba
 */
public class frmGerarCombinacoes extends javax.swing.JInternalFrame {
     
    public frmGerarCombinacoes() {
        initComponents();
        Dimension dimensao = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(((dimensao.width)-711)/2,
                               ((dimensao.height)-480)/2,
                               711,
                               311);
        this.setMaximizable(false);
        lblCarregando.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGeradordecombinacoes = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pgbGerarCombinacoes = new javax.swing.JProgressBar();
        lblCarregando = new javax.swing.JLabel();
        lblPercentualgerador = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();

        setTitle("Gerador de Combinações Loto Fácil");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/chips_98557(1).png"))); // NOI18N

        btnGeradordecombinacoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/chips_98557.png"))); // NOI18N
        btnGeradordecombinacoes.setText("Gerar Combinações");
        btnGeradordecombinacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeradordecombinacoesActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblCarregando.setForeground(new java.awt.Color(0, 0, 153));
        lblCarregando.setText("Carregando...");

        lblPercentualgerador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPercentualgerador.setForeground(new java.awt.Color(0, 0, 153));
        lblPercentualgerador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPercentualgerador.setText("0%");

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCarregando, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGeradordecombinacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pgbGerarCombinacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPercentualgerador, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(314, 314, 314))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(lblCarregando, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pgbGerarCombinacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPercentualgerador, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGeradordecombinacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnSair)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGeradordecombinacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeradordecombinacoesActionPerformed
                 GeradorDeCombinacoes gerandocombinacoes = new GeradorDeCombinacoes();
                 gerandocombinacoes.GerandoCombinacoes();
    }//GEN-LAST:event_btnGeradordecombinacoesActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGeradordecombinacoes;
    private javax.swing.JButton btnSair;
    public static javax.swing.JLabel lblCarregando;
    public static javax.swing.JLabel lblPercentualgerador;
    public static javax.swing.JProgressBar pgbGerarCombinacoes;
    // End of variables declaration//GEN-END:variables
}
