/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userordinario;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author balre
 */
public class Ests {
    
    Conexao connect = new Conexao();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    private String rua, codpostal;
    private long totallugares, totallugareslivres, totallugaresocupados;
    public ArrayList<Ests> parques;
    
    public Ests(){
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
    
    public long getTotallugareslivres() {
        return totallugareslivres;
    }

    public void setTotallugareslivres(long totallugareslivres) {
        this.totallugareslivres = totallugareslivres;
    }

    public long getTotallugaresocupados() {
        return totallugaresocupados;
    }

    public void setTotallugaresocupados(long totallugaresocupados) {
        this.totallugaresocupados = totallugaresocupados;
    }
    
    /**
     * Método setter que armazena todos os dados da tabela afluencialocal
     * de acordo com a zona pretendida
     * @see Ests
     * @param tipoZona
     * @throws SQLException 
     */
    public void getEstsZona(char tipoZona) throws SQLException {
        String query = "SELECT rua, codpostal, totallugares, totallugareslivres, "
                + "totallugaresocupados FROM afluencialocal WHERE tipozona= ?;";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, Character.toString(tipoZona));
        rs = pstmt.executeQuery();
        
        while(rs.next()){
            Ests e = new Ests();
            e.setRua(rs.getString("rua"));
            e.setCodpostal(rs.getString("codpostal"));
            e.setTotallugares(rs.getLong("totallugares"));
            e.setTotallugareslivres(rs.getLong("totallugareslivres"));
            e.setTotallugaresocupados(rs.getLong("totallugaresocupados"));
            parques.add(e);
        }
        conn.close();
    }
}
