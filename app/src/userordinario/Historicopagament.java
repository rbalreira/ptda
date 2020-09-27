/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userordinario;

import connection.Conexao;
import hashdata.HashData;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
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
public class Historicopagament {
    Conexao connect = new Conexao();
    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    public ArrayList<Historicopagament> hist;
    private int userid;
    private float valor;
    private String nome, rua, codpostal, datainicio, tempoinicio, datafim, tempofim, telemovel, email;
    HashData h = new HashData();
    
    public Historicopagament(){
        hist = new ArrayList();
        
    }
    
    /**
     * Método setter que seleciona o historico de pagamento do utilizador e guarda-o
     * num ArrayList.
     * @param login
     * @throws SQLException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException 
     */
    public void getHistorico(String login) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException{
        String sql = "Select * from historicopagamento where telemovel = ? or email = ?";
        conn = connect.connect();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(2, login); pstmt.setString(1, h.getHashData(login));
        rs = pstmt.executeQuery();
        while(rs.next()){
            Historicopagament h = new Historicopagament();
            h.setUserid(rs.getInt("userid"));
            h.setNome(rs.getString("nome"));
            h.setEmail(rs.getString("email"));
            h.setTelemovel(rs.getString("telemovel"));
            h.setRua(rs.getString("rua"));
            h.setCodpostal(rs.getString("codpostal"));
            h.setValor(rs.getFloat("valor"));
            h.setDatainicio(rs.getString("datainicio"));
            h.setTempoinicio(rs.getString("tempoinicio"));
            h.setDatafim(rs.getString("datafim"));
            h.setTempofim(rs.getString("tempofim"));
            hist.add(h);
            conn.close();
        }
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(String datainicio) {
        this.datainicio = datainicio;
    }

    public String getTempoinicio() {
        return tempoinicio;
    }

    public void setTempoinicio(String tempoinicio) {
        this.tempoinicio = tempoinicio;
    }

    public String getDatafim() {
        return datafim;
    }

    public void setDatafim(String datafim) {
        this.datafim = datafim;
    }

    public String getTempofim() {
        return tempofim;
    }

    public void setTempofim(String tempofim) {
        this.tempofim = tempofim;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
