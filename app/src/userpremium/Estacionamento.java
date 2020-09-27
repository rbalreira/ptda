/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userpremium;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Cunha
 */
public class Estacionamento {
       
        Conexao connect = new Conexao();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Statement stmt = null;
        public ArrayList<Estacionamento> estacionamento;
        private String rua;
        private int numlugar, idest; 
        short estado;
        
        
        public Estacionamento(){
           estacionamento = new ArrayList(); 
        }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

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
        
        public void checklugareslivres(int idest) throws SQLException{
            String sql = "Select l.numlugar, e.idest, l.estado, e.rua from lugar l inner join estacionamento e on l.estacionamento_idest = e.idest";
            conn = connect.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            Estacionamento e;
            while(rs.next()){
                e = new Estacionamento();
                e.setNumlugar(rs.getInt("l.numlugar"));
                e.setIdest(rs.getInt("e.idest"));
                e.setRua(rs.getString("e.rua"));
                e.setEstado(rs.getShort("l.estado"));
                estacionamento.add(e);
            }
        }
        
        public void estacionar(String rua) throws SQLException{
            String sql = "Update lugar set estado = 1 where rua = ?";
            conn = connect.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, rua);
            pstmt.executeUpdate();
            conn.close();
        }
}
