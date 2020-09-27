/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatedata;

import checkdata.CheckData;
import hashdata.HashData;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Balreira
 * @version 1.00, 01 Jan 2019
 */
public class User {
    
    private int userid;
    private String bi, nif, telemovel, pass;
    private short codtipo;
    ArrayList<User> users;
    GeneralData g = new GeneralData();
    CheckData check = new CheckData();
    HashData hash = new HashData();
    Random r = new Random();
    
    public User(){
        users = new ArrayList();
    }
    
    private void generateUsers() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, SQLException{
        for(int i = 0; i < 1000; i++){
            User u = new User();
            u.setUserid(i + 1); u.setBi(g.getUserBi(i + 1)); u.setNif(g.getUserNif(i + 1));
            u.setTelemovel(randomNumTelemovel()); u.setPass(randomPassword());
            u.setCodtipo(randomCodTipo());
            users.add(u);
        }
    }
    
    private String randomNumTelemovel() throws NoSuchAlgorithmException, InvalidKeySpecException{
        int num = 0;
        do{
            num = r.nextInt();
        }while(!check.check_telemovel(Integer.toString(num)));
        return hash.getHashData(Integer.toString(num));
    }

    private String randomPassword() throws NoSuchAlgorithmException, InvalidKeySpecException{
        String az = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz[~!@#$%^&*()_-]).";
        char[] abc = az.toCharArray();
        String password = "";
        int rlength = (r.nextInt(16 - 8 + 1) + 8);
        do{
            for(int i = 0; i < rlength; i++){
                password += abc[(r.nextInt((abc.length - 1) - 0 + 1) + 0)];
            }
        }while(check.password_strength(password) < 8);
        return hash.getHashData(password);
    }
    
    private short randomCodTipo(){
        return (short) (r.nextInt(1 - 0 + 1) + 0);
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

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public short getCodtipo() {
        return codtipo;
    }

    public void setCodtipo(short codtipo) {
        this.codtipo = codtipo;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    
    public void generateTable() throws SQLException, IOException, NoSuchAlgorithmException, InvalidKeySpecException{
        generateUsers();
        
        OutputStream os = new FileOutputStream("csv_files/user.csv");
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "ISO-8859-1"));
        StringBuilder sb = new StringBuilder();
        
        for(User u : users){
            sb.append(u.getUserid()).append(",").append(u.getBi()).append(",").append(u.getNif()).append(",")
            .append(u.getTelemovel()).append(",").append(u.getPass()).append(",").append(u.getCodtipo()).append("\n");
        }
        
        pw.write(sb.toString());
        pw.close();
    }
}
