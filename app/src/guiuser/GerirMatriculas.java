/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiuser;

import checkdata.CheckData;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import userordinario.UserOrdinario;
import userordinario.Veiculo;

/**
 *
 * @author Balreira 17 Jan 2018
 * 
 */
public class GerirMatriculas extends javax.swing.JFrame {

    UserOrdinario u = new UserOrdinario();
    Registo r = new Registo();
    CheckData c = new CheckData();
    VerDados ver = new VerDados();
    private Login l;
    private String add2, add3, add4;
    private String M1, M2, M3, M4;
    private boolean error = false, done = false;
    ArrayList<Veiculo> veiculos;
    
    /**
     * 
     * @param l
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SQLException
     * @throws UnsupportedEncodingException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    public GerirMatriculas(Login l) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        initComponents();
        this.l = l;
        u.getVeiculos(this.l.getUs());
        veiculos = new ArrayList();
        addVeiculos();
        generateFields();
        disableFields();
    }
    
    private void addVeiculos(){
        for(Veiculo ve : u.veiculos) veiculos.add(ve);
    }
    
    private void disableFields(){
        Matricula1.setEditable(false); Marca1.setEditable(false); Modelo1.setEditable(false);
        Matricula2.setEditable(false); Marca2.setEditable(false); Modelo2.setEditable(false);
        Matricula3.setEditable(false); Marca3.setEditable(false); Modelo3.setEditable(false);
        Matricula4.setEditable(false); Marca4.setEditable(false); Modelo4.setEditable(false);
        Update.setEnabled(false);
        if(veiculos.size() == 4){
            Add2.setText("Modificar"); Add3.setText("Modificar"); Add4.setText("Modificar");
        }
        else{
            if(veiculos.size() == 3){
                Add3.setText("Modificar");
                Add2.setText("Modificar");
                Delete4.setEnabled(false);
            }else{
                if(veiculos.size() == 2){
                    Add2.setText("Modificar");
                    Add4.setEnabled(false);
                    Delete4.setEnabled(false); Delete3.setEnabled(false);
                }
                else{
                    Add3.setEnabled(false); Add4.setEnabled(false);
                    Delete2.setEnabled(false); Delete3.setEnabled(false); Delete4.setEnabled(false); 
                }
            }
        }
        add2 = Add2.getText(); add3 = Add3.getText(); add4 = Add4.getText();
    }
    
    private void generateFields() throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        if(veiculos.size() == 4){
            Matricula2.setText(veiculos.get(1).getMatricula()); Marca2.setText(veiculos.get(1).getMarca());
            Modelo2.setText(veiculos.get(1).getModelo());
            Matricula3.setText(veiculos.get(2).getMatricula()); Marca3.setText(veiculos.get(2).getMarca());
            Modelo3.setText(veiculos.get(2).getModelo());
            Matricula4.setText(veiculos.get(3).getMatricula()); Marca4.setText(veiculos.get(3).getMarca());
            Modelo4.setText(veiculos.get(3).getModelo());
        }
        else{
            if(veiculos.size() == 3){
                Matricula2.setText(veiculos.get(1).getMatricula()); Marca2.setText(veiculos.get(1).getMarca());
                Modelo2.setText(veiculos.get(1).getModelo());
                Matricula3.setText(veiculos.get(2).getMatricula()); Marca3.setText(veiculos.get(2).getMarca());
                Modelo3.setText(veiculos.get(2).getModelo());
            }
            else{
                if(veiculos.size() == 2){
                    Matricula2.setText(veiculos.get(1).getMatricula()); Marca2.setText(veiculos.get(1).getMarca());
                    Modelo2.setText(veiculos.get(1).getModelo());
                }
            }
        }
        Matricula1.setText(veiculos.get(0).getMatricula()); Marca1.setText(veiculos.get(0).getMarca());
        Modelo1.setText(veiculos.get(0).getModelo());
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
        Matricula1 = new javax.swing.JTextField();
        Add1 = new javax.swing.JButton();
        Add2 = new javax.swing.JButton();
        Add3 = new javax.swing.JButton();
        Marca3 = new javax.swing.JTextField();
        Add4 = new javax.swing.JButton();
        Matricula2 = new javax.swing.JTextField();
        Return = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Marca2 = new javax.swing.JTextField();
        Modelo1 = new javax.swing.JTextField();
        Marca1 = new javax.swing.JTextField();
        Modelo3 = new javax.swing.JTextField();
        Modelo2 = new javax.swing.JTextField();
        Modelo4 = new javax.swing.JTextField();
        Matricula3 = new javax.swing.JTextField();
        Marca4 = new javax.swing.JTextField();
        Matricula4 = new javax.swing.JTextField();
        Update = new javax.swing.JButton();
        Delete2 = new javax.swing.JButton();
        Delete3 = new javax.swing.JButton();
        Delete4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gerir Matrículas");

        Matricula1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Matricula1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Matricula1FocusLost(evt);
            }
        });
        Matricula1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Matricula1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Matricula1KeyReleased(evt);
            }
        });

        Add1.setText("Modificar");
        Add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add1ActionPerformed(evt);
            }
        });
        Add1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Add1KeyPressed(evt);
            }
        });

        Add2.setText("Adicionar");
        Add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add2ActionPerformed(evt);
            }
        });
        Add2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Add2KeyPressed(evt);
            }
        });

        Add3.setText("Adicionar");
        Add3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add3ActionPerformed(evt);
            }
        });
        Add3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Add3KeyPressed(evt);
            }
        });

        Marca3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Marca3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Marca3FocusLost(evt);
            }
        });
        Marca3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Marca3KeyPressed(evt);
            }
        });

        Add4.setText("Adicionar");
        Add4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add4ActionPerformed(evt);
            }
        });
        Add4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Add4KeyPressed(evt);
            }
        });

        Matricula2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Matricula2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Matricula2FocusLost(evt);
            }
        });
        Matricula2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Matricula2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Matricula2KeyReleased(evt);
            }
        });

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

        Logout.setText("Terminar sessão");
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

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Matrícula");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Marca");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Modelo");

        Marca2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Marca2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Marca2FocusLost(evt);
            }
        });
        Marca2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Marca2KeyPressed(evt);
            }
        });

        Modelo1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Modelo1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Modelo1FocusLost(evt);
            }
        });
        Modelo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Modelo1KeyPressed(evt);
            }
        });

        Marca1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Marca1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Marca1FocusLost(evt);
            }
        });
        Marca1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Marca1KeyPressed(evt);
            }
        });

        Modelo3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Modelo3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Modelo3FocusLost(evt);
            }
        });
        Modelo3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Modelo3KeyPressed(evt);
            }
        });

        Modelo2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Modelo2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Modelo2FocusLost(evt);
            }
        });
        Modelo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Modelo2KeyPressed(evt);
            }
        });

        Modelo4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Modelo4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Modelo4FocusLost(evt);
            }
        });
        Modelo4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Modelo4KeyPressed(evt);
            }
        });

        Matricula3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Matricula3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Matricula3FocusLost(evt);
            }
        });
        Matricula3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Matricula3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Matricula3KeyReleased(evt);
            }
        });

        Marca4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Marca4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Marca4FocusLost(evt);
            }
        });
        Marca4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Marca4KeyPressed(evt);
            }
        });

        Matricula4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Matricula4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Matricula4FocusLost(evt);
            }
        });
        Matricula4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Matricula4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Matricula4KeyReleased(evt);
            }
        });

        Update.setText("Atualizar");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        Update.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UpdateKeyPressed(evt);
            }
        });

        Delete2.setText("Eliminar");
        Delete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete2ActionPerformed(evt);
            }
        });
        Delete2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Delete2KeyPressed(evt);
            }
        });

        Delete3.setText("Eliminar");
        Delete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete3ActionPerformed(evt);
            }
        });
        Delete3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Delete3KeyPressed(evt);
            }
        });

        Delete4.setText("Eliminar");
        Delete4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete4ActionPerformed(evt);
            }
        });
        Delete4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Delete4KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Return)
                        .addGap(256, 256, 256)
                        .addComponent(Logout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Update)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Matricula1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(Matricula3)
                            .addComponent(Matricula2)
                            .addComponent(Matricula4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Marca2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Marca1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(Marca3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Marca4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Modelo4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Add4))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Modelo2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Add2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Modelo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Add1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(Modelo3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(Add3))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Delete2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Delete3)
                            .addComponent(Delete4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel2)
                        .addGap(204, 204, 204)
                        .addComponent(jLabel3)
                        .addGap(217, 217, 217)
                        .addComponent(jLabel4)))
                .addGap(28, 28, 28))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Logout, Return, Update});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Marca1, Matricula1, Modelo1});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Add1, Add2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Matricula1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Marca1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Modelo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add1))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Marca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add2)
                    .addComponent(Modelo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Matricula2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete2))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add3)
                    .addComponent(Modelo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Marca3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Matricula3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Modelo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add4)
                    .addComponent(Marca4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Matricula4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete4))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Update)
                    .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Return))
                .addGap(23, 23, 23))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Logout, Return, Update});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnActionPerformed
        VerPerfil ve = new VerPerfil(l);
        ve.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnActionPerformed

    private void ReturnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ReturnKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) Return.doClick();
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
        if(evt.getKeyCode() == KeyEvent.VK_RIGHT) Update.requestFocusInWindow();
        if(evt.getKeyCode() == KeyEvent.VK_UP) Add4.requestFocusInWindow();
    }//GEN-LAST:event_LogoutKeyPressed

    private void Matricula1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Matricula1FocusGained
        if(Matricula1.isEditable()) r.replaceText(evt, "AA-00-AA");
    }//GEN-LAST:event_Matricula1FocusGained

    private void Matricula1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Matricula1FocusLost
        JTextField m = Matricula1;
        if(m.isEditable()){
            r.checkFormatter(m, 8);
            if(!c.check_matricula(m.getText())) m.setForeground(Color.red);
            try {
                if(u.check_matricula(m.getText())) m.setForeground(Color.red);
            } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
                Logger.getLogger(Registo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Matricula1FocusLost

    private void Matricula1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Matricula1KeyPressed
        JTextField m = Matricula1;
        if(m.isEditable()){
            r.setColor(m);
            r.setFormatterM(evt, m);
            r.deleteText(evt, m);
        }
    }//GEN-LAST:event_Matricula1KeyPressed

    private void Matricula1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Matricula1KeyReleased
        if(Matricula1.isEditable()) r.requestFocus(Matricula1, Marca1, 8);
    }//GEN-LAST:event_Matricula1KeyReleased

    private void Marca1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Marca1FocusGained
        if(Marca1.isEditable()) r.replaceText(evt, "X");
    }//GEN-LAST:event_Marca1FocusGained

    private void Marca1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Marca1FocusLost
        if(Marca1.isEditable()) r.checkEmptyField(Marca1);
    }//GEN-LAST:event_Marca1FocusLost

    private void Marca1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Marca1KeyPressed
        r.setColor(Marca1);
    }//GEN-LAST:event_Marca1KeyPressed

    private void Modelo1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Modelo1FocusGained
        if(Modelo1.isEditable()) r.replaceText(evt, "Y");
    }//GEN-LAST:event_Modelo1FocusGained

    private void Modelo1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Modelo1FocusLost
        if(Modelo1.isEditable()) r.checkEmptyField(Modelo1);
    }//GEN-LAST:event_Modelo1FocusLost

    private void Modelo1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Modelo1KeyPressed
        r.setColor(Modelo1);
    }//GEN-LAST:event_Modelo1KeyPressed

    private void setColor(JTextField x, JTextField y, JTextField z){
        x.setBackground(Color.white); x.setForeground(Color.black);
        y.setBackground(Color.white); z.setBackground(Color.white);
    }
    
    private void enabledActionAdd1(boolean x){
        if(veiculos.size() == 4){
                Add3.setEnabled(x); Add4.setEnabled(x);
                Delete2.setEnabled(x); Delete3.setEnabled(x); Delete4.setEnabled(x);
        }
        else{
            if(veiculos.size() == 3){
                Add4.setEnabled(x); Add3.setEnabled(x);
                Delete3.setEnabled(x); Delete2.setEnabled(x);
            }
            else{
                if(veiculos.size() == 2){
                    Add3.setEnabled(x);
                    Delete2.setEnabled(x);
                }
            }
        }
        Add2.setEnabled(x);
    }
    
    private void Add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add1ActionPerformed
        Update.setEnabled(true);
        JTextField x = Matricula1, y = Marca1, z = Modelo1;
        JButton b = Add1;
        M1 = x.getText();
        if(b.getText().equals("Modificar")){
            b.setText("Cancelar");
            x.setEditable(true); y.setEditable(true); z.setEditable(true);
            enabledActionAdd1(false);
        }
        else{
            b.setText("Modificar");
            x.setText(veiculos.get(0).getMatricula()); y.setText(veiculos.get(0).getMarca());
            z.setText(veiculos.get(0).getModelo());
            x.setEditable(false); y.setEditable(false); z.setEditable(false);
            enabledActionAdd1(true);
            Update.setEnabled(false);
            setColor(x, y, z);
        }
    }//GEN-LAST:event_Add1ActionPerformed

    private void Add1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Add1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) Add1.doClick();
        if(evt.getKeyCode() == KeyEvent.VK_DOWN) Add2.requestFocusInWindow();
    }//GEN-LAST:event_Add1KeyPressed

    private void Matricula2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Matricula2FocusGained
        if(Matricula2.isEditable()) r.replaceText(evt, "AA-00-AA");
    }//GEN-LAST:event_Matricula2FocusGained

    private void Matricula2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Matricula2FocusLost
        JTextField m = Matricula2;
        if(m.isEditable()){
            r.checkFormatter(m, 8);
            if(!c.check_matricula(m.getText())) m.setForeground(Color.red);
            try {
                if(u.check_matricula(m.getText())) m.setForeground(Color.red);
            } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
                Logger.getLogger(Registo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Matricula2FocusLost

    private void Matricula2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Matricula2KeyPressed
        JTextField m = Matricula2;
        if(m.isEditable()){
            r.setColor(m);
            r.setFormatterM(evt, m);
            r.deleteText(evt, m);
        }
    }//GEN-LAST:event_Matricula2KeyPressed

    private void Matricula2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Matricula2KeyReleased
        r.requestFocus(Matricula2, Marca2, 8);
    }//GEN-LAST:event_Matricula2KeyReleased

    private void Marca2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Marca2FocusGained
        if(Marca2.isEditable()) r.replaceText(evt, "X");
    }//GEN-LAST:event_Marca2FocusGained

    private void Marca2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Marca2FocusLost
        if(Marca2.isEditable()) r.checkEmptyField(Marca2);
    }//GEN-LAST:event_Marca2FocusLost

    private void Marca2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Marca2KeyPressed
        r.setColor(Marca2);
    }//GEN-LAST:event_Marca2KeyPressed

    private void Modelo2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Modelo2FocusGained
        if(Modelo2.isEditable()) r.replaceText(evt, "Y");
    }//GEN-LAST:event_Modelo2FocusGained

    private void Modelo2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Modelo2FocusLost
        if(Modelo2.isEditable()) r.checkEmptyField(Modelo2);
    }//GEN-LAST:event_Modelo2FocusLost

    private void Modelo2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Modelo2KeyPressed
        r.setColor(Modelo2);
    }//GEN-LAST:event_Modelo2KeyPressed

    private void Matricula3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Matricula3FocusGained
        if(Matricula3.isEditable()) r.replaceText(evt, "AA-00-AA");
    }//GEN-LAST:event_Matricula3FocusGained

    private void Matricula3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Matricula3FocusLost
        JTextField m = Matricula3;
        if(m.isEditable()){
            r.checkFormatter(m, 8);
            if(!c.check_matricula(m.getText())) m.setForeground(Color.red);
            try {
                if(u.check_matricula(m.getText())) m.setForeground(Color.red);
            } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
                Logger.getLogger(Registo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Matricula3FocusLost

    private void Matricula3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Matricula3KeyPressed
        JTextField m = Matricula3;
        if(m.isEditable()){
            r.setColor(m);
            r.setFormatterM(evt, m);
            r.deleteText(evt, m);
        }
    }//GEN-LAST:event_Matricula3KeyPressed

    private void Matricula3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Matricula3KeyReleased
        r.requestFocus(Matricula3, Marca3, 8);
    }//GEN-LAST:event_Matricula3KeyReleased

    private void Marca3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Marca3FocusGained
        if(Marca3.isEditable()) r.replaceText(evt, "X");
    }//GEN-LAST:event_Marca3FocusGained

    private void Marca3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Marca3FocusLost
        if(Marca3.isEditable()) r.checkEmptyField(Marca3);
    }//GEN-LAST:event_Marca3FocusLost

    private void Marca3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Marca3KeyPressed
        r.setColor(Marca3);
    }//GEN-LAST:event_Marca3KeyPressed

    private void Modelo3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Modelo3FocusGained
        if(Modelo3.isEditable()) r.replaceText(evt, "Y");
    }//GEN-LAST:event_Modelo3FocusGained

    private void Modelo3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Modelo3FocusLost
        if(Modelo3.isEditable()) r.checkEmptyField(Modelo3);
    }//GEN-LAST:event_Modelo3FocusLost

    private void Modelo3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Modelo3KeyPressed
        r.setColor(Modelo3);
    }//GEN-LAST:event_Modelo3KeyPressed

    private void enabledActionAdd2(boolean x){
        if(Add2.getText().equals("Modificar")){
            if(veiculos.size() == 4){
                Add4.setEnabled(x); Add3.setEnabled(x);
                Delete2.setEnabled(x); Delete3.setEnabled(x); Delete4.setEnabled(x);
            }
            else{
                if(veiculos.size() == 3){
                    Add4.setEnabled(x); Add3.setEnabled(x);
                    Delete2.setEnabled(x); Delete3.setEnabled(x);
                }
                else{
                    if(veiculos.size() == 2){
                        Add3.setEnabled(x);
                        Delete2.setEnabled(x);
                    }
                }
            }
        }
        Add1.setEnabled(x);
    }
    
    private void Add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add2ActionPerformed
        Update.setEnabled(true);
        JTextField x = Matricula2, y = Marca2, z = Modelo2;
        JButton b = Add2;
        M2 = x.getText();
        if(!b.getText().equals("Cancelar")){
            enabledActionAdd2(false);
            b.setText("Cancelar");
            x.setEditable(true); y.setEditable(true); z.setEditable(true);
        }
        else{
            b.setText(add2);
            if(veiculos.size() >= 2){
                x.setText(veiculos.get(1).getMatricula()); y.setText(veiculos.get(1).getMarca());
                z.setText(veiculos.get(1).getModelo());
            }
            else{
                x.setText(""); y.setText(""); z.setText("");
            }
            x.setEditable(false); y.setEditable(false); z.setEditable(false);
            Update.setEnabled(false);
            setColor(x, y, z);
            enabledActionAdd2(true);
        }
    }//GEN-LAST:event_Add2ActionPerformed

    private void Add2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Add2KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) Add2.doClick();
        if(evt.getKeyCode() == KeyEvent.VK_UP) Add1.requestFocusInWindow();
        if(evt.getKeyCode() == KeyEvent.VK_DOWN && Add3.isEnabled()) Add3.requestFocusInWindow();
        if(evt.getKeyCode() == KeyEvent.VK_RIGHT && Delete2.isEnabled()) Delete2.requestFocusInWindow();
    }//GEN-LAST:event_Add2KeyPressed

    private void enabledActionAdd3(boolean x){
        if(Add3.getText().equals("Modificar")){
            if(veiculos.size() == 4){
                Add4.setEnabled(x);
                Delete4.setEnabled(x); Delete3.setEnabled(x);
            }
            else{
                if(veiculos.size() == 3){
                    Add4.setEnabled(x);
                    Delete3.setEnabled(x);
                }
            }
        }
        Add1.setEnabled(x); Add2.setEnabled(x); Delete2.setEnabled(x);
    }
    
    private void Add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add3ActionPerformed
        Update.setEnabled(true);
        JTextField x = Matricula3, y = Marca3, z = Modelo3;
        JButton b = Add3;
        M3 = x.getText();
        if(!b.getText().equals("Cancelar")){
            enabledActionAdd3(false);
            b.setText("Cancelar");
            x.setEditable(true); y.setEditable(true); z.setEditable(true);
        }
        else{
            b.setText(add3);
            if(veiculos.size() >= 3){
                x.setText(veiculos.get(2).getMatricula()); y.setText(veiculos.get(2).getMarca());
                z.setText(veiculos.get(2).getModelo());
            }
            else{
                x.setText(""); y.setText(""); z.setText("");
            }
            x.setEditable(false); y.setEditable(false); z.setEditable(false);
            Update.setEnabled(false);
            setColor(x, y, z);
            enabledActionAdd3(true);
        }
    }//GEN-LAST:event_Add3ActionPerformed

    private void Add3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Add3KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) Add3.doClick();
        if(evt.getKeyCode() == KeyEvent.VK_UP) Add2.requestFocusInWindow();
        if(evt.getKeyCode() == KeyEvent.VK_DOWN && Add4.isEnabled()) Add4.requestFocusInWindow();
        if(evt.getKeyCode() == KeyEvent.VK_RIGHT && Delete3.isEnabled()) Delete3.requestFocusInWindow();
    }//GEN-LAST:event_Add3KeyPressed

    private void Matricula4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Matricula4FocusGained
        if(Matricula4.isEditable()) r.replaceText(evt, "AA-00-AA");
    }//GEN-LAST:event_Matricula4FocusGained

    private void Matricula4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Matricula4FocusLost
        JTextField m = Matricula4;
        if(m.isEditable()){
            r.checkFormatter(m, 8);
            if(!c.check_matricula(m.getText())) m.setForeground(Color.red);
            try {
                if(u.check_matricula(m.getText())) m.setForeground(Color.red);
            } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
                Logger.getLogger(Registo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Matricula4FocusLost

    private void Matricula4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Matricula4KeyPressed
        JTextField m = Matricula4;
        if(m.isEditable()){
            r.setColor(m);
            r.setFormatterM(evt, m);
            r.deleteText(evt, m);
        }
    }//GEN-LAST:event_Matricula4KeyPressed

    private void Matricula4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Matricula4KeyReleased
        r.requestFocus(Matricula4, Marca4, 8);
    }//GEN-LAST:event_Matricula4KeyReleased

    private void Marca4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Marca4FocusGained
        if(Marca4.isEditable()) r.replaceText(evt, "X");
    }//GEN-LAST:event_Marca4FocusGained

    private void Marca4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Marca4FocusLost
        if(Marca4.isEditable()) r.checkEmptyField(Marca1);
    }//GEN-LAST:event_Marca4FocusLost

    private void Marca4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Marca4KeyPressed
        r.setColor(Marca4);
    }//GEN-LAST:event_Marca4KeyPressed

    private void Modelo4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Modelo4FocusGained
        if(Modelo4.isEditable()) r.replaceText(evt, "Y");
    }//GEN-LAST:event_Modelo4FocusGained

    private void Modelo4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Modelo4FocusLost
        if(Modelo4.isEditable()) r.checkEmptyField(Modelo4);
    }//GEN-LAST:event_Modelo4FocusLost

    private void Modelo4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Modelo4KeyPressed
        r.setColor(Modelo4);
    }//GEN-LAST:event_Modelo4KeyPressed

    private void enabledActionAdd4(boolean x){
        if(Add4.getText().equals("Modificar")) Delete4.setEnabled(x);
        Add1.setEnabled(x); Add2.setEnabled(x); Add3.setEnabled(x);
        Delete2.setEnabled(x); Delete3.setEnabled(x);
    }
    
    private void Add4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add4ActionPerformed
        Update.setEnabled(true);
        JTextField x = Matricula4, y = Marca4, z = Modelo4;
        JButton b = Add4;
        M4 = x.getText();
        if(!b.getText().equals("Cancelar")){
            enabledActionAdd4(false);
            b.setText("Cancelar");
            x.setEditable(true); y.setEditable(true); z.setEditable(true);
        }
        else{
            b.setText(add4);
            if(veiculos.size() == 4){
                x.setText(veiculos.get(3).getMatricula()); y.setText(veiculos.get(3).getMarca());
                z.setText(veiculos.get(3).getModelo());
            }
            else{
                x.setText(""); y.setText(""); z.setText("");
            }
            x.setEditable(false); y.setEditable(false); z.setEditable(false);
            Update.setEnabled(false);
            setColor(x, y, z);
            enabledActionAdd4(true);
        }
    }//GEN-LAST:event_Add4ActionPerformed

    private void Add4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Add4KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) Add4.doClick();
        if(evt.getKeyCode() == KeyEvent.VK_UP) Add3.requestFocusInWindow();
        if(evt.getKeyCode() == KeyEvent.VK_DOWN) Update.requestFocusInWindow();
        if(evt.getKeyCode() == KeyEvent.VK_RIGHT && Delete4.isEnabled()) Delete4.requestFocusInWindow();
    }//GEN-LAST:event_Add4KeyPressed

    private void showSameFieldMsg(){
        JOptionPane.showMessageDialog(null, "Não podem constar matrículas iguais!", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void showSuccessInsert(){
        JOptionPane.showMessageDialog(null, "O veículo foi registado com sucesso!","INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void showSuccessUpdate(){
        JOptionPane.showMessageDialog(null, "O veículo foi atualizado com sucesso!","INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void showDeleteMatr(){
        JOptionPane.showMessageDialog(null, "O veículo foi apagado com sucesso!","INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void showEmptyFields(){
        JOptionPane.showMessageDialog(null, "Existem campos vazios!","INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private boolean checkSameField(String matr){
        matr = matr.toUpperCase();
        for (Veiculo veiculo : u.veiculos)
            if(veiculo.getMatricula().equals(matr)) return true;
        return false;
    }
    
    private void insertMatricula(JTextField x, JTextField y, JTextField z, JButton add, JButton delete){
        Veiculo v;
        String m = x.getText().toUpperCase();
        if(checkGrayField(x, y, z)) showEmptyFields();
        else if(ver.checkUpdate(x) || ver.checkUpdate(y) || ver.checkUpdate(z)) ver.invalidUpdate();
        else{
            if(checkSameField(m)) showSameFieldMsg();
            else{
                try {
                    u.addMatricula(l.getUs(), m, y.getText(), z.getText());
                    v = new Veiculo();
                    v.setMatricula(m); v.setMarca(y.getText()); v.setModelo(z.getText());
                    veiculos.add(v);
                    add.setText("Modificar");
                    x.setText(m);
                    x.setEditable(false); y.setEditable(false); y.setEditable(false);
                    showSuccessInsert();
                    done = true;
                } catch (NoSuchAlgorithmException | InvalidKeySpecException | SQLException | UnsupportedEncodingException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
                    Logger.getLogger(GerirMatriculas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private void updateMatricula(int index, JTextField x, JTextField y, JTextField z, String tmp, JButton add, JButton delete){
        Veiculo v;
        String m = x.getText().toUpperCase();
        if(checkGrayField(x, y, z)) showEmptyFields();
        else if(ver.checkUpdate(x) || ver.checkUpdate(y) || ver.checkUpdate(z)) ver.invalidUpdate();
        else{
            if(checkSameField(m)) showSameFieldMsg();
            else{
                try {
                    u.updateMatricula(l.getUs(), tmp, m, Marca1.getText(), Modelo1.getText());
                    v = new Veiculo();
                    v.setMatricula(m); v.setMarca(y.getText()); v.setModelo(z.getText());
                    veiculos.set(index, v);
                    add.setText("Modificar");
                    x.setText(m);
                    x.setEditable(false); y.setEditable(false); y.setEditable(false);
                    showSuccessUpdate();
                    done = true;
                } catch (NoSuchAlgorithmException | InvalidKeySpecException | SQLException | UnsupportedEncodingException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
                    Logger.getLogger(GerirMatriculas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private boolean checkGrayField(JTextField x, JTextField y, JTextField z){
        return x.getForeground() == Color.gray || y.getForeground() == Color.gray || z.getForeground() == Color.gray;
    }
    
    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        if(Add1.getText().equals("Cancelar") && Add1.isEnabled()){
                String m = Matricula1.getText().toUpperCase();
                if(ver.checkUpdate(Matricula1) || ver.checkUpdate(Marca1) || ver.checkUpdate(Modelo1))
                    ver.invalidUpdate();
                else{
                    if(checkSameField(m)) showSameFieldMsg();
                    else{
                        try {
                            u.updateMatricula(l.getUs(), M1, m, Marca1.getText(), Modelo1.getText());
                            Add1.setText("Modificar");
                            enabledActionAdd1(true);
                            Matricula1.setText(m);
                            M1 = Matricula1.getText();
                            Matricula1.setEditable(false); Marca1.setEditable(false); Modelo1.setEditable(false);
                            showSuccessUpdate();
                        } catch (NoSuchAlgorithmException | InvalidKeySpecException | SQLException | UnsupportedEncodingException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
                            Logger.getLogger(GerirMatriculas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            else{
                if(add2.equals("Adicionar") && Add2.isEnabled()){
                    insertMatricula(Matricula2, Marca2, Modelo2, Add2, Delete2);
                    if(done){
                        enabledActionAdd2(true);
                        M2 = Matricula2.getText();
                        Add3.setEnabled(true);
                        add2 = Add2.getText();
                        done = false;
                    }
                }
                else{
                    if(add2.equals("Modificar") && Add2.isEnabled()){
                        updateMatricula(1, Matricula2, Marca2, Modelo2, M2, Add2, Delete2);
                        if(done){
                            enabledActionAdd2(true);
                            M2 = Matricula2.getText();
                            add2 = Add2.getText();
                            done = false;
                        }
                    }
                    else{
                        if(add3.equals("Adicionar") && Add3.isEnabled()){
                            insertMatricula(Matricula3, Marca3, Modelo3, Add3, Delete3);
                            M3 = Matricula3.getText();
                            if(done){
                                enabledActionAdd3(true);
                                Add4.setEnabled(true);
                                add3 = Add3.getText();
                                done = false;
                            }
                        }
                        else{
                            if(add3.equals("Modificar") && Add3.isEnabled()){
                                updateMatricula(2, Matricula3, Marca3, Modelo3, M3, Add3, Delete3);
                                if(done){
                                    enabledActionAdd3(true);
                                    M3 = Matricula3.getText();
                                    add3 = Add3.getText();
                                    done = false;
                                }
                            }
                            else{
                                if(add4.equals("Adicionar") && Add4.isEnabled()){
                                    insertMatricula(Matricula4, Marca4, Modelo4, Add4, Delete4);
                                    if(done){
                                        enabledActionAdd4(true);
                                        M4 = Matricula4.getText();
                                        add4 = Add4.getText();
                                        done = false;
                                    }
                                }
                                else{
                                    if(add4.equals("Modificar") && Add4.isEnabled()){
                                        updateMatricula(3, Matricula4, Marca4, Modelo4, M4, Add4, Delete4);
                                        if(done){
                                            enabledActionAdd4(true);
                                            M4 = Matricula4.getText();
                                            add4 = Add4.getText();
                                            done = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
    }//GEN-LAST:event_UpdateActionPerformed

    private void UpdateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UpdateKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) Update.doClick();
        if(evt.getKeyCode() == KeyEvent.VK_UP) Add4.requestFocusInWindow();
        if(evt.getKeyCode() == KeyEvent.VK_LEFT) Logout.requestFocusInWindow();
    }//GEN-LAST:event_UpdateKeyPressed

    private void deleteMatricula(JTextField x){
        int option = JOptionPane.showConfirmDialog(null, "Está prestes a eliminar o veículo cuja matrícula é a " + 
        x.getText() + ". Tem a certeza de que quer continuar?", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        if(option == JOptionPane.OK_OPTION){
            try {
                u.deleteMatricula(x.getText());
            } catch (SQLException | UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
                Logger.getLogger(GerirMatriculas.class.getName()).log(Level.SEVERE, null, ex);
                error = true;
            }
            if(!error) showDeleteMatr();
        }
    }
    
    private void Delete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete2ActionPerformed
        JTextField x = Matricula2, y = Marca2, z = Modelo2;
        deleteMatricula(x);
        if(veiculos.size() == 4){
            x.setText(Matricula3.getText()); y.setText(Marca3.getText()); z.setText(Modelo3.getText());
                Matricula3.setText(Matricula4.getText()); Marca3.setText(Marca4.getText()); Modelo3.setText(Modelo4.getText());
                Matricula4.setText(""); Marca4.setText(""); Modelo4.setText("");
                Add4.setText("Adicionar"); Add3.setEnabled(true); Add2.setEnabled(true);
                Delete3.setEnabled(true); Delete2.setEnabled(true); Delete4.setEnabled(false);
            }
            else{
                if(veiculos.size() == 3){
                    x.setText(Matricula3.getText()); y.setText(Marca3.getText()); z.setText(Modelo3.getText());
                    Matricula3.setText(""); Marca3.setText(""); Modelo3.setText("");
                    Add2.setEnabled(true); Add3.setText("Adicionar");
                    Delete3.setEnabled(false); Delete2.setEnabled(true); Add4.setEnabled(false);
                }
                else{
                    x.setText(""); y.setText(""); z.setText("");
                    Add3.setEnabled(false); Delete2.setEnabled(false);
                    Add2.setText("Adicionar");
                }
            }
            Add1.setEnabled(true);
            add2 = Add2.getText();
            veiculos.remove(1);
    }//GEN-LAST:event_Delete2ActionPerformed

    private void Delete2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Delete2KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) Delete2.doClick();
        if(evt.getKeyCode() == KeyEvent.VK_LEFT) Add2.requestFocusInWindow();
        if(evt.getKeyCode() == KeyEvent.VK_DOWN && Delete3.isEnabled()) Delete3.requestFocusInWindow();
    }//GEN-LAST:event_Delete2KeyPressed

    private void Delete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete3ActionPerformed
        JTextField x = Matricula3, y = Marca3, z = Modelo3;
            deleteMatricula(x);
            if(veiculos.size() == 4){
                x.setText(Matricula4.getText()); y.setText(Marca4.getText()); z.setText(Modelo4.getText());
                Matricula4.setText(""); Marca4.setText(""); Modelo4.setText("");
                Add3.setEnabled(true); Add4.setEnabled(true);
                Delete2.setEnabled(true); Delete3.setEnabled(true); Delete4.setEnabled(false);
                Add4.setText("Adicionar");
            }
            else{
                x.setText(""); y.setText(""); z.setText("");
                Add4.setEnabled(false);
                Delete3.setEnabled(false); Add3.setText("Adicionar");
            }
            Delete2.setEnabled(true);
            Add1.setEnabled(true);
            Add2.setEnabled(true);
            add3 = Add3.getText();
            veiculos.remove(2);
    }//GEN-LAST:event_Delete3ActionPerformed

    private void Delete3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Delete3KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) Delete3.doClick();
        if(evt.getKeyCode() == KeyEvent.VK_LEFT) Add3.requestFocusInWindow();
        if(evt.getKeyCode() == KeyEvent.VK_UP) Delete2.requestFocusInWindow();
        if(evt.getKeyCode() == KeyEvent.VK_DOWN && Delete4.isEnabled()) Delete4.requestFocusInWindow();
    }//GEN-LAST:event_Delete3KeyPressed

    private void Delete4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete4ActionPerformed
        JTextField x = Matricula4, y = Marca4, z = Modelo4;
        deleteMatricula(x);
        x.setText(""); y.setText(""); z.setText("");
        Delete4.setEnabled(false); Add4.setText("Adicionar");
        add4 = Add4.getText();
        veiculos.remove(3);
    }//GEN-LAST:event_Delete4ActionPerformed

    private void Delete4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Delete4KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) Delete4.doClick();
        if(evt.getKeyCode() == KeyEvent.VK_LEFT) Add4.requestFocusInWindow();
        if(evt.getKeyCode() == KeyEvent.VK_DOWN) Update.requestFocusInWindow();
        if(evt.getKeyCode() == KeyEvent.VK_UP) Delete3.requestFocusInWindow();
    }//GEN-LAST:event_Delete4KeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add1;
    private javax.swing.JButton Add2;
    private javax.swing.JButton Add3;
    private javax.swing.JButton Add4;
    private javax.swing.JButton Delete2;
    private javax.swing.JButton Delete3;
    private javax.swing.JButton Delete4;
    private javax.swing.JButton Logout;
    private javax.swing.JTextField Marca1;
    private javax.swing.JTextField Marca2;
    private javax.swing.JTextField Marca3;
    private javax.swing.JTextField Marca4;
    private javax.swing.JTextField Matricula1;
    private javax.swing.JTextField Matricula2;
    private javax.swing.JTextField Matricula3;
    private javax.swing.JTextField Matricula4;
    private javax.swing.JTextField Modelo1;
    private javax.swing.JTextField Modelo2;
    private javax.swing.JTextField Modelo3;
    private javax.swing.JTextField Modelo4;
    private javax.swing.JButton Return;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
