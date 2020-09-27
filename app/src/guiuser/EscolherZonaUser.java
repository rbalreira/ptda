/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiuser;

import java.awt.event.KeyEvent;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import userpremium.UserPremium;

/**
 *
 * @author danie
 */
public class EscolherZonaUser extends javax.swing.JFrame {

    private final Login l;
    UserPremium up = new UserPremium();
    
    public EscolherZonaUser(Login l) {
        initComponents();
        this.l = l;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        Norte = new javax.swing.JButton();
        Oeste = new javax.swing.JButton();
        Este = new javax.swing.JButton();
        Centro = new javax.swing.JButton();
        Sul = new javax.swing.JButton();
        Voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Zonas");

        Norte.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Norte.setText("Norte");
        Norte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NorteActionPerformed(evt);
            }
        });
        Norte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NorteKeyPressed(evt);
            }
        });

        Oeste.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Oeste.setText("Oeste");
        Oeste.setPreferredSize(new java.awt.Dimension(53, 25));
        Oeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OesteActionPerformed(evt);
            }
        });
        Oeste.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                OesteKeyPressed(evt);
            }
        });

        Este.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Este.setText("Este");
        Este.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EsteActionPerformed(evt);
            }
        });
        Este.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EsteKeyPressed(evt);
            }
        });

        Centro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Centro.setText("Centro");
        Centro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CentroActionPerformed(evt);
            }
        });
        Centro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CentroKeyPressed(evt);
            }
        });

        Sul.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Sul.setText("Sul");
        Sul.setBorderPainted(false);
        Sul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SulActionPerformed(evt);
            }
        });
        Sul.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SulKeyPressed(evt);
            }
        });

        Voltar.setText("Voltar");
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Voltar)
                                .addGap(143, 143, 143))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Oeste, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Norte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Sul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(Este, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addComponent(Norte)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Centro)
                    .addComponent(Este)
                    .addComponent(Oeste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(Sul)
                .addGap(34, 34, 34)
                .addComponent(Voltar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        try {
            MainPage mp = new MainPage(l);
            mp.setTitle();
            mp.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(EscolherZonaUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_VoltarActionPerformed

    private void CentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CentroActionPerformed
        try {
            if (up.checkPremium(l.getUs())) {
                VerParquesUser v = new VerParquesUser('c', l);
                v.setVisible(true);
                this.dispose();
            } else if (!up.checkPremium(l.getUs())) {
                VerParquesPremium p = new VerParquesPremium('c', l);
                p.setVisible(true);
                this.dispose();
            }
        } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(EscolherZonaUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CentroActionPerformed

    private void NorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NorteActionPerformed

        try {
            if (up.checkPremium(l.getUs())) {
                VerParquesUser v = new VerParquesUser('n', l);
                v.setVisible(true);
                this.dispose();
            } else if (!up.checkPremium(l.getUs())) {
                VerParquesPremium p = new VerParquesPremium('n', l);
                p.setVisible(true);
                this.dispose();
            }
        }catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(EscolherZonaUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_NorteActionPerformed

    private void SulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SulActionPerformed
        try{
            if (up.checkPremium(l.getUs())) {
                VerParquesUser v = new VerParquesUser('s', l);
                v.setVisible(true);
                this.dispose();
            } else if (!up.checkPremium(l.getUs())) {
                VerParquesPremium p = new VerParquesPremium('s', l);
                p.setVisible(true);
                this.dispose();
            }
        }catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(EscolherZonaUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SulActionPerformed

    private void EsteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EsteActionPerformed
        try{
            if (up.checkPremium(l.getUs())) {
                VerParquesUser v = new VerParquesUser('e', l);
                v.setVisible(true);
                this.dispose();
            } else if (!up.checkPremium(l.getUs())) {
                VerParquesPremium p = new VerParquesPremium('e', l);
                p.setVisible(true);
                this.dispose();
            }
        } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(EscolherZonaUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EsteActionPerformed

    private void OesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OesteActionPerformed
        try{
            if (up.checkPremium(l.getUs())) {
                VerParquesUser v = new VerParquesUser('o', l);
                v.setVisible(true);
                this.dispose();
            } else if (!up.checkPremium(l.getUs())) {
                VerParquesPremium p = new VerParquesPremium('o', l);
                p.setVisible(true);
                this.dispose();
            }
        } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(EscolherZonaUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_OesteActionPerformed

    private void CentroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CentroKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) Centro.doClick();
        if(evt.getKeyCode() == KeyEvent.VK_RIGHT) Este.requestFocusInWindow();
        if(evt.getKeyCode() == KeyEvent.VK_LEFT) Oeste.requestFocusInWindow();
        if(evt.getKeyCode() == KeyEvent.VK_UP) Norte.requestFocusInWindow();
        if(evt.getKeyCode() == KeyEvent.VK_DOWN) Sul.requestFocusInWindow();
    }//GEN-LAST:event_CentroKeyPressed

    private void SulKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SulKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) Sul.doClick();
        if(evt.getKeyCode() == KeyEvent.VK_UP) Centro.requestFocusInWindow();
    }//GEN-LAST:event_SulKeyPressed

    private void OesteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OesteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) Oeste.doClick();
        if(evt.getKeyCode() == KeyEvent.VK_RIGHT) Centro.requestFocusInWindow();
    }//GEN-LAST:event_OesteKeyPressed

    private void EsteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EsteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) Este.doClick();
        if(evt.getKeyCode() == KeyEvent.VK_LEFT) Centro.requestFocusInWindow();
    }//GEN-LAST:event_EsteKeyPressed

    private void NorteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NorteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) Norte.doClick();
        if(evt.getKeyCode() == KeyEvent.VK_DOWN) Centro.requestFocusInWindow();
    }//GEN-LAST:event_NorteKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Centro;
    private javax.swing.JButton Este;
    private javax.swing.JButton Norte;
    private javax.swing.JButton Oeste;
    private javax.swing.JButton Sul;
    private javax.swing.JButton Voltar;
    private javax.swing.JLabel jLabelTitulo;
    // End of variables declaration//GEN-END:variables
}