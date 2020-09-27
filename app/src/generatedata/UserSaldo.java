/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatedata;

import checkdata.CheckData;
import hashdata.HashData;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Balreira
 * @version 1.00, 03 Jan 2019
 */
public class UserSaldo {
    
    private int userid;
    private String bi, nif, numcartaomb;
    private char metodopag;
    private float saldo;
    ArrayList<UserSaldo> usersaldo;
    GeneralData g = new GeneralData();
    CheckData check = new CheckData();
    HashData hash = new HashData();
    Random r = new Random();
    
    public UserSaldo(){
        usersaldo = new ArrayList();
    }
    
    private void generateUserSaldo() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, SQLException{
        for(int i = 0; i < 1000; i++){
            UserSaldo u = new UserSaldo();
            u.setUserid(i + 1); u.setBi(g.getUserBi(i + 1)); u.setNif(g.getUserNif(i + 1));
            u.setNumcartaomb(randomNumMB()); u.setSaldo(randomSaldo());
            u.setMetodopag(u.randomMetodoPagamento());
            usersaldo.add(u);
        }
    }
    
    public void generateTable() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, SQLException{
        generateUserSaldo();
        
        OutputStream os = new FileOutputStream("csv_files/usersaldo.csv");
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "ISO-8859-1"));
        StringBuilder sb = new StringBuilder();
        
        for(UserSaldo u : usersaldo){
           sb.append(u.getUserid()).append(",").append(u.getBi()).append(",").append(u.getNif()).append(",").append(u.getNumcartaomb()).append(",")
           .append(u.getSaldo()).append(",").append(u.getMetodopag()).append("\n");
        }
         
        pw.write(sb.toString());
        pw.close();
    }
    
    private String randomNumMB() throws NoSuchAlgorithmException, InvalidKeySpecException{
        String digits = "1234567890"; char[] array = digits.toCharArray();
        String num = Integer.toString(r.nextInt((9 - 1) + 1) + 1);
        for(int i = 0; i < 16; i++)
            num += array[(r.nextInt(((array.length - 1) - 0) + 1) + 0)];
        return hash.getHashData(num);
    }
    
  
    public float randomSaldo(){
        float num = r.nextFloat() * 2000;
        BigDecimal bd = new BigDecimal(num);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
    

    private char randomMetodoPagamento() throws FileNotFoundException, IOException{
        FileInputStream fstream = new FileInputStream("random_data/metodospagamento.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        
        String[] strLine = br.readLine().split(" ");
        int length = strLine.length - 1;
        return strLine[r.nextInt(length - 0 + 1) + 0].charAt(0);
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNumcartaomb() {
        return numcartaomb;
    }

    public void setNumcartaomb(String numcartaomb) {
        this.numcartaomb = numcartaomb;
    }

    public char getMetodopag() {
        return metodopag;
    }

    public void setMetodopag(char metodopag) {
        this.metodopag = metodopag;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    
    
}
