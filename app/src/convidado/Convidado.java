/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convidado;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Cunha
 * @author Balreira 07 Jan 2019
 */
public class Convidado {

    Conexao connect = new Conexao();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    private String rua, codpostal;
    private long totallugares;
    public ArrayList<Convidado> parques;
    
    public Convidado(){
        parques = new ArrayList();
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public long getTotallugares() {
        return totallugares;
    }

    public void setTotallugares(long totallugares) {
        this.totallugares = totallugares;
    }

    /**
     * Método que obtém todos os estacionamentos da zona(norte, sul, este, 
     * oeste, centro) pretendida
     * @param tipoZona
     * @throws SQLException 
     */
    public void getEstsZona(char tipoZona) throws SQLException {
        String query = "SELECT * FROM getestszona (?);";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, Character.toString(tipoZona));
        rs = pstmt.executeQuery();
        
        while(rs.next()){
            Convidado c = new Convidado();
            c.setRua(rs.getString("rua"));
            c.setCodpostal(rs.getString("codpostal"));
            c.setTotallugares(rs.getLong("totallugares"));
            parques.add(c);
        }
        conn.close();
    }
    
    /**
     * Método para obter o preço ordinário dos estacionamentos das zonas
     * pretendidas
     * @param tipozona
     * @return
     * @throws SQLException 
     */
    public float getPrecoZona(char tipozona) throws SQLException{
        String query = "SELECT custoordinario FROM zona WHERE tipozona = ?;";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, Character.toString(tipozona));
        rs = pstmt.executeQuery();
        rs.next();
        return rs.getFloat(1);
    }
}
