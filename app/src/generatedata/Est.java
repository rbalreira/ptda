/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatedata;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Balreira
 * @version 1.00, 02 Jan 2019
 */
public class Est {
    
    private int idest, codzona;
    private String morada, codpostal;
    ArrayList<Est> ests;
    Random r = new Random();
    GeneralData g = new GeneralData();
    BufferedReader br;
    
    public Est(){
        ests = new ArrayList();
    }

    public int getIdest() {
        return idest;
    }

    public void setIdest(int idest) {
        this.idest = idest;
    }

    public int getCodzona() {
        return codzona;
    }

    public void setCodzona(int codzona) {
        this.codzona = codzona;
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
    
    private void generateEsts() throws IOException, SQLException{
        for(int i = 0; i < 100; i++){
            Est est = new Est();
            est.setIdest(i + 1); est.setMorada(g.randomMorada());
            est.setCodpostal(g.randomCodpostal()); est.setCodzona(randomCodZona());
            ests.add(est);
        }
    }
    
    private int randomCodZona() throws SQLException, FileNotFoundException, IOException{
        FileInputStream fstream = new FileInputStream("csv_files/zona.csv");
        br = new BufferedReader(new InputStreamReader(fstream));
        ArrayList<Integer> list = new ArrayList();
        
        String strLine;
        while((strLine = br.readLine()) != null){
            String[] data = strLine.split(",");
            list.add(Integer.parseInt(data[0]));
        }
        
        return list.get(r.nextInt(((list.size() - 1) - 0) + 1) + 0);
    }
    
    public void generateTable() throws IOException, SQLException{
        generateEsts();
        
        OutputStream os = new FileOutputStream("csv_files/ests.csv");
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "ISO-8859-1"));
        StringBuilder sb = new StringBuilder();
        
        for(Est e : ests){
            sb.append(e.getIdest()).append(",").append(e.getMorada()).append(",").append(e.getCodpostal())
            .append(",").append(e.getCodzona()).append("\n");
        }
        
        pw.write(sb.toString());
        pw.close();    
    }
}
