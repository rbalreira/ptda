package simulatedata;


import connection.Conexao;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cunha
 */
public class Matricula {
     
     Conexao connect = new Conexao();
     Connection conn = null;
     Statement stmt = null;
     ResultSet rs = null;
     ArrayList<String> matriculas;
     int i;
     
     public Matricula(){
         matriculas = new ArrayList();
     }
     /**
      * Este metodo setter guarda todos os dados selecionados da base de dados no 
      * ArrayList criado
      * @see Matricula
      * @throws SQLException
      * @throws FileNotFoundException 
      */
     public void matriculas() throws SQLException, FileNotFoundException{
         
        String sql = "Select matricula from veiculo";
        conn = connect.connect();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql) ;
        while (rs.next()) {
            matriculas.add(rs.getString("matricula"));
        }
        conn.close();
    }
     
}