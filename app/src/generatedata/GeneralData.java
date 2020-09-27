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
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author Balreira
 * @version 1.00, 01 Jan 2019
 */
public class GeneralData {
    Random r = new Random();
    CheckData check = new CheckData();
    HashData hash = new HashData();
    BufferedReader br;
    protected int index;
    
    public int getIndex(){
        return index;
    }
    
    protected String randomMorada() throws FileNotFoundException, IOException, UnsupportedEncodingException{
        FileInputStream fstream = new FileInputStream("random_data/moradas.txt");
        br = new BufferedReader(new InputStreamReader(fstream, "ISO-8859-1"));
        
        String[] strLine = br.readLine().split(",");
        int length = strLine.length - 1;
        index = r.nextInt(length - 0 + 1) + 0;
        return strLine[index];
    }
    
    protected void setCodpostais() throws FileNotFoundException, UnsupportedEncodingException{
        OutputStream os = new FileOutputStream("random_data/codpostais.txt");
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
        StringBuilder sb = new StringBuilder();
        String random = (r.nextInt(9999 - 1000 + 1) + 1000) + "-" + (r.nextInt(999 - 100 + 1) + 100);
        
        for(int i = 0; i < 47; i++){
            if(i == 46) sb.append(random);
            else sb.append(random).append(",");
            random = (r.nextInt(9999 - 1000 + 1) + 1000) + "-" + (r.nextInt(999 - 100 + 1) + 100);
        }
        
        pw.write(sb.toString());
        pw.close();
    }
    
    protected String getUserBi(int cod) throws FileNotFoundException, IOException{
        br = new BufferedReader(new FileReader("csv_files/detailsuser.csv"));
        
        String strLine;
        while((strLine = br.readLine()) != null){
            String[] data = strLine.split(",");
            if(Integer.parseInt(data[0]) == cod) return data[1];
        }
        return "";
    }
    
    protected String getUserNif(int cod) throws SQLException, FileNotFoundException, IOException{
        br = new BufferedReader(new FileReader("csv_files/detailsuser.csv"));
        
        String strLine;
        while((strLine = br.readLine()) != null){
            String[] data = strLine.split(",");
            if(Integer.parseInt(data[0]) == cod) return data[2];
        }
        return "";
    }
    
    protected String randomCodpostal() throws FileNotFoundException, UnsupportedEncodingException, IOException{
        FileInputStream fstream = new FileInputStream("random_data/codpostais.txt");
        br = new BufferedReader(new InputStreamReader(fstream));
        
        String[] strLine = br.readLine().split(",");
        return strLine[index];
    }
}