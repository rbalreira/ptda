/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiuser;

import com.sun.glass.events.KeyEvent;
import connection.Conexao;
import convidado.Convidado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Balreira
 * @version 1.00, 07 Jan 2019
 */
public class VerParques extends javax.swing.JFrame {

    Conexao connect = new Conexao();
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Convidado guest = new Convidado();
 
    /**
     * Creates new form VerParques
     * @param tipozona
     * @throws java.sql.SQLException
     */
    public VerParques(char tipozona) throws SQLException {

        initComponents();
        setPrecoZona(tipozona);
        generateTable(tipozona);
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
        Parques = new javax.swing.JTable();
        Preco = new javax.swing.JLabel();
        Voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("jframe"); // NOI18N

        Parques.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Rua", "Código-postal", "Nº total de lugares"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Parques);

        Preco.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        Voltar.setText("Voltar");
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });
        Voltar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                VoltarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Preco, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(Preco, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(40, Short.MAX_VALUE)
                        .addComponent(Voltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 
     * @param evt 
     */
    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        EscolherZona z = new EscolherZona();
        z.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VoltarActionPerformed

    private void VoltarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VoltarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) Voltar.doClick();
    }//GEN-LAST:event_VoltarKeyPressed

    /**
     * 
     * @param tipozona
     * @throws SQLException 
     */
    private void setPrecoZona(char tipozona) throws SQLException{
        Preco.setText("Preço: " + guest.getPrecoZona(tipozona) + "€ p/hora");
    }
    
    /**
     * 
     * @param tipozona
     * @throws SQLException 
     */
    private void generateTable(char tipozona) throws SQLException{
        guest.getEstsZona(tipozona);
        DefaultTableModel model = (DefaultTableModel) Parques.getModel();
        model.setRowCount(0);
        for(Convidado c : guest.parques){
            model.addRow(new Object[]{
                c.getRua(),
                c.getCodpostal(),
                c.getTotallugares()
            });
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        Parques.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        Parques.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Parques;
    private javax.swing.JLabel Preco;
    private javax.swing.JButton Voltar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
