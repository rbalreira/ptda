/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatedata;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author Balreira
 * @version 1.00, 01 Jan 2019
 */
public class Zona {
    
    Random r = new Random();
    
    private float randomPrecoZona(){
        float num = r.nextFloat() * (10 - 5) + 5;
        BigDecimal bd = new BigDecimal(num);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
    
    public void generateZonas() throws SQLException, FileNotFoundException, UnsupportedEncodingException{
        float custoOrdinario, custoPremium;
        int count = 1;
        
        OutputStream os = new FileOutputStream("csv_files/zona.csv");
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "ISO-8859-1"));
        StringBuilder sb = new StringBuilder();
        
        custoOrdinario = randomPrecoZona();
        custoPremium = custoOrdinario - (r.nextInt(4 - 1) + 1);
        sb.append(count++).append(",").append('n').append(",").append(custoOrdinario).append(",").append(custoPremium)
        .append("\n");
        custoOrdinario = randomPrecoZona();
        custoPremium = custoOrdinario - (r.nextInt(4 - 1) + 1);
        sb.append(count++).append(",").append('s').append(",").append(custoOrdinario).append(",").append(custoPremium)
        .append("\n");
        custoOrdinario = randomPrecoZona();
        custoPremium = custoOrdinario - (r.nextInt(4 - 1) + 1);
        sb.append(count++).append(",").append('c').append(",").append(custoOrdinario).append(",").append(custoPremium)
        .append("\n");
        custoOrdinario = randomPrecoZona();
        custoPremium = custoOrdinario - (r.nextInt(4 - 1) + 1);
        sb.append(count++).append(",").append('e').append(",").append(custoOrdinario).append(",").append(custoPremium)
        .append("\n");
        custoOrdinario = randomPrecoZona();
        custoPremium = custoOrdinario - (r.nextInt(4 - 1) + 1);
        sb.append(count++).append(",").append('o').append(",").append(custoOrdinario).append(",").append(custoPremium);
        
        pw.write(sb.toString());
        pw.close();
    }
}