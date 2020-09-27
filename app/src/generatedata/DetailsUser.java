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
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Balreira
 * @version 1.00, 03 Jan 2019
 */
public class DetailsUser {
    
    private String bi, nif, email, nome, morada, codpostal;
    private int userid;
    private LocalDate datanasc;
    ArrayList<DetailsUser> users;
    CheckData check = new CheckData();
    HashData hash = new HashData();
    Random r = new Random();
    GeneralData g = new GeneralData();
    BufferedReader br;
    
    public DetailsUser(){
        users = new ArrayList();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public LocalDate getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(LocalDate datanasc) {
        this.datanasc = datanasc;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    
    private void generateDetailsUser() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException{
        for(int i = 0; i < 1000; i++){
            DetailsUser u = new DetailsUser();
            u.setUserid(i + 1); u.setBi(randomBI()); u.setNif(randomNIF());
            u.setDatanasc(randomDateBirth()); u.setNome(randomNome()); u.setEmail(randomEmail());
            u.setMorada(g.randomMorada()); u.setCodpostal(g.randomCodpostal());
            users.add(u);
        }
        
        for(DetailsUser dAtual : users){
            for(DetailsUser dCheck : users){
                if(!dAtual.equals(dCheck)){
                    if(dAtual.getBi().equals(dCheck.getBi())){
                        do{
                            dAtual.setBi(randomBI());
                        }while(dAtual.getBi().equals(dCheck.getBi()));
                    }
                    if(dAtual.getNif().equals(dCheck.getNif())){
                        do{
                            dAtual.setNif(randomNIF());
                        }while(dAtual.getNif().equals(dCheck.getNif()));
                    }
                }
            }
        }
    }
    
    private String randomEmail() throws FileNotFoundException, IOException{
        FileInputStream fstream = new FileInputStream("random_data/emails.txt");
        br = new BufferedReader(new InputStreamReader(fstream));
        String x = nome.substring(0, 1).toLowerCase() + nome.substring(1, nome.length());
        String[] strLine = br.readLine().split(" ");
        int length = strLine.length - 1;
        return x + (r.nextInt(10000 - 1 + 1) + 1) + strLine[r.nextInt(length - 0 + 1) + 0];
    }
    

    private String randomBI() throws NoSuchAlgorithmException, InvalidKeySpecException{
        int num = 0;
        do{
            num = r.nextInt();
        }while(!check.check_BI(Integer.toString(num)));
        return hash.getHashData(Integer.toString(num));
    }
    

    private String randomNIF() throws NoSuchAlgorithmException, InvalidKeySpecException{
        int num = 0;
        do{
            num = r.nextInt();
        }while(!check.check_NIF(Integer.toString(num)));
        return hash.getHashData(Integer.toString(num));
    }
    

    private String randomNome() throws FileNotFoundException, IOException{
        FileInputStream fstream = new FileInputStream("random_data/nomes.txt");
        br = new BufferedReader(new InputStreamReader(fstream));
        
        String[] strLine = br.readLine().split(",");
        int length = strLine.length - 1;
        int random = r.nextInt(length - 0 + 1) + 0;
        if(random == 0){
            nome = strLine[random].substring(1, strLine[random].length());
        }
        else{
            nome = strLine[random];
        }
        return nome;
    }
    
 
    private LocalDate randomDateBirth(){
        LocalDate min = LocalDate.of(1940, 01, 01);
        LocalDate max = LocalDate.of(2000, 01, 01);
        long start = min.toEpochDay(), end = max.toEpochDay();
        long random = ThreadLocalRandom.current().nextLong(start, end);
        return LocalDate.ofEpochDay(random);
    }
    
    public void generateTable() throws FileNotFoundException, NoSuchAlgorithmException, InvalidKeySpecException, IOException{
        generateDetailsUser();
        
        OutputStream os = new FileOutputStream("csv_files/detailsuser.csv");
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "ISO-8859-1"));
        StringBuilder sb = new StringBuilder();
        
        for(DetailsUser d : users){
            sb.append(d.getUserid()).append(",").append(d.getBi()).append(",").append(d.getNif()).append(",")
            .append(d.getDatanasc()).append(",").append(d.getEmail()).append(",").append(d.getNome())
            .append(",").append(d.getMorada()).append(",").append(d.getCodpostal()).append("\n");
        }
        
        pw.write(sb.toString());
        pw.close();
    }
}