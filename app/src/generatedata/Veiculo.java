/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatedata;

import checkdata.CheckData;
import encryptdata.EncryptData;
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
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author Balreira
 * @version 1.00, 03 Jan 2019
 */
public class Veiculo {
    
    private String matricula, marca, modelo, bi, nif;
    private int userid;
    ArrayList<Veiculo> veiculos;
    GeneralData g = new GeneralData();
    CheckData check = new CheckData();
    HashData hash = new HashData();
    EncryptData e = new EncryptData();
    Random r = new Random();
    
    public Veiculo(){
        veiculos = new ArrayList();
    }
    
    private void generateVeiculos() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, SQLException, UnsupportedEncodingException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
        for(int i = 0; i < 1000; i++){
            Veiculo v = new Veiculo();
            v.setUserid(i + 1); v.setBi(g.getUserBi(i + 1)); v.setNif(g.getUserNif(i + 1));
            v.setMatricula(randomMatricula()); v.setMarca(randomMarca());
            v.setModelo(randomModelo());
            veiculos.add(v);
        }
        
        for(Veiculo vAtual : veiculos){
            for(Veiculo vCheck : veiculos){
                if(!vAtual.equals(vCheck)){
                    if(vAtual.getMatricula().equals(vCheck.getMatricula())){
                        do{
                            vAtual.setMatricula(randomMatricula());
                        }while(vAtual.getMatricula().equals(vCheck.getMatricula()));
                    }
                }
            }
        }
    }
    
    public void generateTable() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, SQLException, UnsupportedEncodingException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        generateVeiculos();
        
        OutputStream os = new FileOutputStream("csv_files/veiculo.csv");
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "ISO-8859-1"));
        StringBuilder sb = new StringBuilder();
        
        for(Veiculo v : veiculos){
            sb.append(v.getMatricula()).append(",").append(v.getMarca()).append(",").append(v.getModelo())
            .append(",").append(v.getUserid()).append(",").append(v.getBi()).append(",").append(v.getNif())
            .append("\n");
        }
        
        pw.write(sb.toString());
        pw.close();
    }
    
    protected String randomMatricula() throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; char[] az = abc.toCharArray();
        String[] array = new String[4];
        int length = az.length - 1;
        char letter1 = az[r.nextInt(length - 0 + 1) + 0], letter2 = az[r.nextInt(length - 0 + 1) + 0];
        char letter3 = az[r.nextInt(length - 0 + 1) + 0], letter4 = az[r.nextInt(length - 0 + 1) + 0];
        int num1 = r.nextInt(9 - 0 + 1) + 0, num2 = r.nextInt(9 - 0 + 1) + 0;
        int num3 = r.nextInt(9 - 0 + 1) + 0, num4 = r.nextInt(9 - 0 + 1) + 0;
        
        array[0] = letter1 + "" + letter2 + "-" + num1 + "" + num2 + "-" + num3 + "" + num4;
        array[1] = num1 + "" + num2 + "-" + num3 + "" + num4 + "-" + letter1 + "" + letter2;
        array[2] = num1 + "" + num2 + "-" + letter1 + "" + letter2 + "-" + num3 + "" + num4;
        array[3] = letter1 + "" + letter2 + "-" + num1 + "" + num2 + "-" + letter3 + "" + letter4;
        return e.encryptData(array[r.nextInt(((array.length - 1) - 0 + 1) + 0)]);
    }
    

    protected String randomMarca() throws FileNotFoundException, IOException{
        FileInputStream fstream = new FileInputStream("random_data/marcas.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream, "ISO-8859-1"));
        
        String[] strLine = br.readLine().split(",");
        int length = strLine.length - 1;
        return strLine[(r.nextInt(length - 0) + 1) + 0];
    }

    protected String randomModelo() throws FileNotFoundException, UnsupportedEncodingException, IOException{
        FileInputStream fstream = new FileInputStream("random_data/modelos.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream, "ISO-8859-1"));
        
        String[] strLine = br.readLine().split(",");
        int length = strLine.length - 1;
        return strLine[(r.nextInt(length - 0) + 1) + 0];
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    
}
