/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatedata;

import connection.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cunha
 */

public class GenerateOP {
    Conexao connect = new Conexao();
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    public ArrayList<GenerateOP> tabela;
    private String bi, nif, matricula;
    private int operacao, id, numlugar, idest, zona;
    private float valor;
    private char metodopag;
    private Date dataentr, datasaida;
    
    public GenerateOP(){
        tabela = new ArrayList();
    }

    public Date getDataentr() {
        return dataentr;
    }

    public void setDataentr(Date dataentr) {
        this.dataentr = dataentr;
    }

    public Date getDatasaida() {
        return datasaida;
    }
    
    public void setDatasaida(Date datasaida) {
        this.datasaida = datasaida;
    }
    
    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getOperacao() {
        return operacao;
    }

    public void setOperacao(int operacao) {
        this.operacao = operacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public char getMetodopag() {
        return metodopag;
    }

    public void setMetodopag(char metodopag) {
        this.metodopag = metodopag;
    }
    
    
     /**
     *
     * Método setter que armazena todos os dados da tabela ordempagamento presentes na base de dados
     * num ArrayList
     * @see GenerateOP
     * @throws SQLException 
     */
    public void ordempagamento() throws SQLException{
        String sql = "Select * from ordempagamento";
        conn = connect.connect();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            GenerateOP t = new GenerateOP();
            t.setBi(rs.getString("utilizador_detalhesutilizador_bi"));
            t.setNif(rs.getString("utilizador_detalhesutilizador_nif"));
            t.setMatricula(rs.getString("veiculo_matricula"));
            t.setId(rs.getInt("utilizador_detalhesutilizador_userid"));
            t.setMetodopag(rs.getString("metodopagamento").charAt(0));
            t.setOperacao(rs.getInt("numop"));
            t.setValor(rs.getFloat("valor"));
            t.setNumlugar(rs.getInt("lugar_numlugar"));
            t.setIdest(rs.getInt("lugar_estacionamento_idest"));
            t.setZona(rs.getInt("zona_codzona"));
            t.setDataentr(rs.getTimestamp("tempoinicio"));
            t.setDatasaida( rs.getTimestamp("tempoatual"));
            tabela.add(t);
        }
        conn.close();
    }
}
