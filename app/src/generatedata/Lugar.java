/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatedata;

import connection.Conexao;
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
public class Lugar {
    
    private int codest;
    ArrayList<Lugar> lugares;
    Conexao connect = new Conexao();
    Random r = new Random();
    
    public Lugar(){
        lugares = new ArrayList();
    }

    public int getCodest() {
        return codest;
    }

    public void setCodest(int codest) {
        this.codest = codest;
    }
    
    private void generateLugares() throws SQLException, IOException{
        for(int i = 0; i < 800; i++){
            Lugar l = new Lugar();
            l.setCodest(randomCodEst());
            lugares.add(l);
        }
    }
    
    private int randomCodEst() throws SQLException, FileNotFoundException, IOException{
        FileInputStream fstream = new FileInputStream("csv_files/ests.csv");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        ArrayList<Integer> list = new ArrayList();
        
        String strLine;
        while((strLine = br.readLine()) != null){
            String[] data = strLine.split(",");
            list.add(Integer.parseInt(data[0]));
        }
        
        return list.get(r.nextInt(((list.size() - 1) - 0) + 1) + 0);
    }
    
    public void generateTable() throws SQLException, IOException{
        generateLugares();
        OutputStream os = new FileOutputStream("csv_files/lugares.csv");
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "ISO-8859-1"));
        StringBuilder sb = new StringBuilder();
        
        for(Lugar l : lugares){
            sb.append(l.getCodest()).append("|").append(0).append("\n");
        }
        
        pw.write(sb.toString());
        pw.close();
    }
}
