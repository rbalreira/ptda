/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiuser;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import userordinario.UserOrdinario;

/**
 *
 * @author balre
 */
public class AvaliarApp extends javax.swing.JFrame {

    private Login l;
    Registo r = new Registo();
    UserOrdinario u = new UserOrdinario();
    boolean comentou = false;
    
    /**
     * Creates new form AvaliarApp
     * @param l
     */
    public AvaliarApp(Login l) {
        this.l = l;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        Return = new javax.swing.JButton();
        Nota = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Comentario = new javax.swing.JTextArea();
        Submit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Classificar Aplicação");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Logout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Logout.setText("Terminar Sessão");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        Logout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LogoutKeyPressed(evt);
            }
        });

        Return.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Return.setText("Voltar");
        Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnActionPerformed(evt);
            }
        });
        Return.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ReturnKeyPressed(evt);
            }
        });

        Nota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        Nota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotaActionPerformed(evt);
            }
        });

        jLabel2.setText("Nota:");

        Comentario.setColumns(20);
        Comentario.setRows(5);
        Comentario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ComentarioFocusGained(evt);
            }
        });
        Comentario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComentarioKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Comentario);

        Submit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Submit.setText("Submeter");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });
        Submit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SubmitKeyPressed(evt);
            }
        });

        jLabel3.setText("Comentário:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Return)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Logout))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 70, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Submit)
                .addGap(212, 212, 212))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Logout, Return});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Submit)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Return))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Logout, Return});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NotaActionPerformed

    private void ComentarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ComentarioFocusGained
        JTextArea t = (JTextArea)evt.getSource();
        if(t.getText().length() == 0){
            t.setText("Comentário");
            t.setForeground(Color.GRAY);
        }
        t.selectAll();
    }//GEN-LAST:event_ComentarioFocusGained

    private void ComentarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComentarioKeyPressed
        Comentario.setBackground(Color.white);
        Comentario.setForeground(Color.black);
    }//GEN-LAST:event_ComentarioKeyPressed

    private void showMessage(){
        JOptionPane.showMessageDialog(null, "A avaliação foi submetida com sucesso! "
            + "Obrigado pela colaboração!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        VerPerfil v;
        try {
            int option;
            if(Comentario.getText().trim().isEmpty() || Comentario.getForeground() == Color.gray){
                option = JOptionPane.showConfirmDialog(null, "Está prestes a avaliar a aplicação com ausência "
                        + "de comentário. Tem a certeza de que quer continuar?", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
                if(option == JOptionPane.OK_OPTION){
                    u.avaliarApp(l.getUs(), Short.parseShort(Nota.getSelectedItem().toString()), Comentario.getText());
                    showMessage();
                    v = new VerPerfil(l);
                    v.setVisible(true);
                    comentou = true;
                    this.dispose();
                }
            }
            else{
                u.avaliarApp(l.getUs(), Short.parseShort(Nota.getSelectedItem().toString()), Comentario.getText());
                showMessage();
                v = new VerPerfil(l);
                v.setVisible(true);
                this.dispose();
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | SQLException ex) {
            Logger.getLogger(AvaliarApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_SubmitActionPerformed

    private void SubmitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SubmitKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) Submit.doClick();
        if(evt.getKeyCode() == KeyEvent.VK_LEFT) Return.requestFocusInWindow();
        if(evt.getKeyCode() == KeyEvent.VK_RIGHT) Logout.requestFocusInWindow();
    }//GEN-LAST:event_SubmitKeyPressed

    private void ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnActionPerformed
        VerPerfil v = new VerPerfil(l);
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnActionPerformed

    private void ReturnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ReturnKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) Return.doClick();
        if(evt.getKeyCode() == KeyEvent.VK_UP) Submit.requestFocusInWindow();
        if(evt.getKeyCode() == KeyEvent.VK_RIGHT) Logout.requestFocusInWindow();
    }//GEN-LAST:event_ReturnKeyPressed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        Login lo = new Login();
        lo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutActionPerformed

    private void LogoutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LogoutKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) Logout.doClick();
        if(evt.getKeyCode() == KeyEvent.VK_LEFT) Return.requestFocusInWindow();
        if(evt.getKeyCode() == KeyEvent.VK_UP) Submit.requestFocusInWindow();
    }//GEN-LAST:event_LogoutKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Comentario;
    private javax.swing.JButton Logout;
    private javax.swing.JComboBox<String> Nota;
    private javax.swing.JButton Return;
    private javax.swing.JButton Submit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
