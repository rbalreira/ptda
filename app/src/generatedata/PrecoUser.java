/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatedata;

import checkdata.CheckData;
import connection.Conexao;
import hashdata.HashData;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 *
 * @author Balreira
 * @version 1.00, 02 Jan 2019
 * 
 */
public class PrecoUser {
    
    Random r = new Random();
    CheckData check = new CheckData();
    HashData hash = new HashData();
    Conexao connect = new Conexao();
    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    GeneralData us = new GeneralData();
    
    protected void generatePrecoUser() throws SQLException{
        float preco = randomPrecoUser();
        conn = connect.connect();
        
        String query = "INSERT INTO precoutilizador VALUES(0,0,DEFAULT);"
                     + "INSERT INTO precoutilizador VALUES(1,?,DEFAULT);";
        
        pstmt = conn.prepareStatement(query);
        pstmt.setFloat(1, preco);
        
        pstmt.executeUpdate();
        conn.close();
    }
    
    protected float randomPrecoUser(){
        float num = r.nextFloat() * (10 - 4) + 4;
        BigDecimal bd = new BigDecimal(num);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
    
}
