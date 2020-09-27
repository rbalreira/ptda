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
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Cunha
 */
public class Tempoestac {
    Conexao connect = new Conexao();
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    public ArrayList<Tempoestac> test;
    private int codtempo;
    private String userid, userbi, usernif,matricula;
    private Date tempoinicio, tempofim, tempoocupado;
    
    
    public Tempoestac(){
        test = new ArrayList();
    }

    public int getCodtempo() {
        return codtempo;
    }

    public void setCodtempo(int codtempo) {
        this.codtempo = codtempo;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserbi() {
        return userbi;
    }

    public void setUserbi(String userbi) {
        this.userbi = userbi;
    }

    public String getUsernif() {
        return usernif;
    }

    public void setUsernif(String usernif) {
        this.usernif = usernif;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getTempoinicio() {
        return tempoinicio;
    }

    public void setTempoinicio(Date tempoinicio) {
        this.tempoinicio = tempoinicio;
    }

    public Date getTempofim() {
        return tempofim;
    }

    public void setTempofim(Date tempofim) {
        this.tempofim = tempofim;
    }

    public Date getTempoocupado() {
        return tempoocupado;
    }

    public void setTempoocupado(Date tempoocupado) {
        this.tempoocupado = tempoocupado;
    }
    
    /**
     * Método setter que armazena todos os dados da tabela tempoestacionado presente na base de dados
     * num ArrayList
     * @see Tempoestac
     * @throws SQLException 
     */
    public void testacionado() throws SQLException{
        String sql = "Select * from tempoestacionado";
        conn = connect.connect();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Tempoestac t = new Tempoestac();
            t.setCodtempo(rs.getInt("codtempo"));
            t.setUserid(rs.getString("utilizador_detalhesutilizador_userid"));
            t.setUserbi(rs.getString("utilizador_detalhesutilizador_bi"));
            t.setUsernif(rs.getString("utilizador_detalhesutilizador_nif"));
            t.setMatricula(rs.getString("veiculo_matricula"));
            t.setTempoocupado(rs.getTime("tempoocupado"));
            t.setTempoinicio(rs.getTimestamp("tempoinicio"));
            t.setTempofim(rs.getTimestamp("tempofim"));
            test.add(t);
        }
        conn.close();
    }
}
