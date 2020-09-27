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
public class Generatemulta {
    Conexao connect = new Conexao();
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    public ArrayList<Generatemulta> multa;
    private String motivo, userid, usernif, matricula, userbi;
    private char metodopag;
    private int idmulta, numlugar, idest, codzona;
    private short tipopago;
    private float valor;
    private Date datainicio, datafim;

    public Generatemulta(){
        multa = new ArrayList();
    }
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public String getUserbi() {
        return userbi;
    }

    public void setUserbi(String userbi) {
        this.userbi = userbi;
    }

    public char getMetodopag() {
        return metodopag;
    }

    public void setMetodopag(char metodopag) {
        this.metodopag = metodopag;
    }

    public int getIdmulta() {
        return idmulta;
    }

    public void setIdmulta(int idmulta) {
        this.idmulta = idmulta;
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

    public int getCodzona() {
        return codzona;
    }

    public void setCodzona(int codzona) {
        this.codzona = codzona;
    }

    public short getTipopago() {
        return tipopago;
    }

    public void setTipopago(short tipopago) {
        this.tipopago = tipopago;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafim() {
        return datafim;
    }

    public void setDatafim(Date datafim) {
        this.datafim = datafim;
    }

    /**
     * Método setter que armazena todos os dados da tabela multa presente na base de dados
     * num ArrayList
     * @see Generatemulta
     * @throws SQLException 
     */
    public void dadosmulta() throws SQLException{
        String sql = "Select * from multa";
        conn = connect.connect();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Generatemulta t = new Generatemulta();
            t.setIdmulta(rs.getInt("idmulta"));
            t.setMotivo(rs.getString("motivo"));
            t.setValor(rs.getFloat("valor"));
            t.setMetodopag(rs.getString("metodopagamento").charAt(0));
            t.setTipopago(rs.getShort("tipopago"));
            t.setUserid(rs.getString("utilizador_detalhesutilizador_userid"));
            t.setUserbi(rs.getString("utilizador_detalhesutilizador_bi"));
            t.setUsernif(rs.getString("utilizador_detalhesutilizador_nif"));
            t.setMatricula(rs.getString("veiculo_matricula"));
            t.setNumlugar(rs.getInt("lugar_numlugar"));
            t.setIdest(rs.getInt("lugar_estacionamento_idest"));
            t.setCodzona(rs.getInt("zona_codzona"));
            t.setDatainicio(rs.getTimestamp("tempoinicio"));
            t.setDatafim(rs.getTimestamp("tempoatual"));
            multa.add(t);
        }
        conn.close();;
    }
}
