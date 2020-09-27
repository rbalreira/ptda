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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Balreira
 * @version 1.00, 03 Jan 2019
 */
public class Avaliacaoapp {
    
    private int userid, index;
    private String bi, nif, comentario;
    private short avaliacao;
    ArrayList<Avaliacaoapp> avaliacoes;
    GeneralData g = new GeneralData();
    CheckData check = new CheckData();
    HashData hash = new HashData();
    Random r = new Random();
    BufferedReader br;
    
    public Avaliacaoapp(){
        avaliacoes = new ArrayList();
    }
    
    private void generateAvaliacoes() throws UnsupportedEncodingException, IOException, SQLException{
        for(int i = 0; i < 400; i++){
            Avaliacaoapp a = new Avaliacaoapp();
            a.setUserid(i + 1); a.setBi(g.getUserBi(i + 1)); a.setNif(g.getUserNif(i + 1));
            a.setComentario(randomComentario()); a.setAvaliacao(randomAvaliacao());
            avaliacoes.add(a);
        }
    }
    
    public void generateTable() throws IOException, UnsupportedEncodingException, SQLException {
        generateAvaliacoes();
        
        OutputStream os = new FileOutputStream("csv_files/avaliacaoapp.csv");
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "ISO-8859-1"));
        StringBuilder sb = new StringBuilder();
        
        for(Avaliacaoapp a : avaliacoes){
            sb.append(a.getUserid()).append(",").append(a.getBi()).append(",").append(a.getNif()).append(",")
            .append(a.getComentario()).append(",").append(a.getAvaliacao()).append("\n");
        }
          
        pw.write(sb.toString());
        pw.close();
    }
    
    protected String randomComentario() throws FileNotFoundException, UnsupportedEncodingException, IOException{
        FileInputStream fstream = new FileInputStream("random_data/comentarios.txt");
        br = new BufferedReader(new InputStreamReader(fstream, "ISO-8859-1"));
        
        String[] strLine = br.readLine().split(",");
        int length = strLine.length - 1;
        index = r.nextInt(length - 0 + 1) + 0;
        return strLine[index];
    }
    
    protected short randomAvaliacao() throws FileNotFoundException, IOException{
        FileInputStream fstream = new FileInputStream("random_data/avaliacoes.txt");
        br = new BufferedReader(new InputStreamReader(fstream));
        
        String[] strLine = br.readLine().split(" ");
        return Short.parseShort(strLine[index]);
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public short getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(short avaliacao) {
        this.avaliacao = avaliacao;
    }

}
