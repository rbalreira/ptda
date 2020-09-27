/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatedata;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cunha
 */
public class Sairlugar {
    Matricula ma = new Matricula();
    Lugar lu = new Lugar();
    Conexao connect = new Conexao();
    Connection conn = null;
    Statement stmt= null;
    PreparedStatement pstmt= null;
    ResultSet rs = null;
    int x = 0;
    
    /**
     * Este método getter escolhe aleatóriamente um lugar ocupado
     * @see Sairlugar
     * @return
     * @throws SQLException 
     */
    public int numlugar() throws SQLException{
        
        String sql = "Select numlugar from lugar where estado = 1 ORDER BY RANDOM() LIMIT 1";
        conn = connect.connect();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        rs.next();
        return rs.getInt(1);
    }
    /**
     * Este método setter actualiza o estado do lugar anteriormente escolhido no método
     * 'numlugar' de ocupado para livre
     * @see Sairlugar
     * @param numlugar
     * @throws SQLException 
     */
    public void updatesaida(int numlugar) throws SQLException{
        
        String sql = "update lugar set estado = 0 where numlugar = ?";
        conn = connect.connect();
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, numlugar);
        pstmt.executeUpdate();
        conn.close();
    }
    
    /**
     * metodo main que simula a saída de um carro a cada 2 segundos
     * @see Sairlugar
     * @param args 
     */
    public static void main(String[] args) {
            Sairlugar n = new Sairlugar();
            for(int i = 0; i < 800; i++){
                try {
                    n.updatesaida(n.numlugar());
                    System.out.println(n.numlugar());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Sairlugar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Sairlugar.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    }
}
