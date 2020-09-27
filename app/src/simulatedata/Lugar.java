package simulatedata;



import connection.Conexao;
import java.sql.Connection;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cunha
 */
public class Lugar {
    
    Conexao connect = new Conexao();
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    int i;
    ArrayList<Lugar> lugar;
    int numlugar;
    int idest;
    short estado;

    public int getNumlugar() {
        return numlugar;
    }

    public void setNumlugar(int numlugar) {
        this.numlugar = numlugar;
    }

    public int getIdest() {
        return idest;
    }

    public void setIdest(int idest) {
        this.idest = idest;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }
    
    
    
    public Lugar(){
    lugar = new ArrayList();
}
    /** 
     * metodo setter.
     * Este metodo guarda todos os dados selecionados da base de dados no 
     * ArrayList criado
     * @see Lugar
     * @throws SQLException 
     */
    public void lugares() throws SQLException{
        
        String sql = "Select numlugar, \"estacionamento_idest\", estado from lugar";
        conn = connect.connect();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        Lugar u;
        while(rs.next()){
            u = new Lugar();
            u.setNumlugar(rs.getInt("numlugar"));
            u.setIdest(rs.getInt("estacionamento_idest"));
            u.setEstado(rs.getShort("estado"));
            lugar.add(u);
        }   
     
    } 
}
