/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiadmin;
import java.sql.*;

/**
 *
 * @author maria
 */
public class Admin {

     private final String url = "jdbc:postgresql://estga-dev.clients.ua.pt:5432/ptda-2018-gr4";
    private final String user = "ptda-2018-gr4";
    private final String password = "!BrZr7Ya3C";
    
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
    public void afluenciaLocal(){
        int count = 1;
        while(count <= 8){
            afluencialocal(count);
            count++;
        }
    }
    
    private void afluencialocal(int count){
        String query = "SELECT getafluencialocal("+count+")";
        try(Connection conn = this.connect()){
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while(result.next()){
                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void main(String[] args) {
        Admin adm = new Admin();
        adm.afluenciaLocal();
    }
    
}
